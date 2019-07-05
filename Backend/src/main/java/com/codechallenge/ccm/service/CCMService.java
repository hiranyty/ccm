package com.codechallenge.ccm.service;

import java.text.DecimalFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codechallenge.ccm.entity.CCMEntity;
import com.codechallenge.ccm.repository.CCMRepository;
import com.codechallenge.ccm.vo.CCMDetailVo;
import com.codechallenge.ccm.vo.CCMMaxProfitVo;
import com.codechallenge.ccm.vo.CCMVo;

@Service
public class CCMService {
	
	Logger logger = LogManager.getLogger(CCMService.class);
	
	@Autowired
	private CCMRepository ccmrepository;

	private static DecimalFormat df2 =  new DecimalFormat("#.##");
	
	public CCMVo loadCryptoInfo(String code) {
		
		List<CCMEntity> quotes = ccmrepository.findByCurrencyOrderByTradeTimeAsc(code);
		CCMVo ccmVO = new CCMVo();
		ccmVO.setCurrency(quotes.get(0).getCurrency());
		ccmVO.setTradeDate(quotes.get(0).getTradeDate());
		
		List<CCMDetailVo> quoteList = new ArrayList<>();		
		quotes.forEach( quote -> {
			CCMDetailVo ccmDetailsVo= new CCMDetailVo ();
			ccmDetailsVo.setPrice(quote.getPrice());
			DateTimeFormatter timeFormatter = DateTimeFormatter
		            .ofPattern("hh:mm a");
			LocalTime timewithampm = quote.getTradeTime();
			ccmDetailsVo.setTradeTime(timeFormatter.format(timewithampm));
			quoteList.add(ccmDetailsVo);		
		});
		ccmVO.setQuotes(quoteList);		
		return ccmVO;
   }
	
	public CCMMaxProfitVo processMaxProfit (String code) {
		
		CCMMaxProfitVo ccmMaxProfitVo = new CCMMaxProfitVo();
		CCMVo ccmVo = loadCryptoInfo(code);
		List<CCMDetailVo> quotesList = ccmVo.getQuotes();	
		ccmMaxProfitVo.setCode(code);
		int i,j;
		double maxProfit = quotesList.get(1).getPrice() - quotesList.get(0).getPrice();
		logger.info("Max Profit" + maxProfit);
		
		for (i = 0; i < quotesList.size() ; i++) {
			for (j = i + 1; j < quotesList.size(); j++) {
				if (quotesList.get(j).getPrice() - quotesList.get(i).getPrice() >= maxProfit) {
					maxProfit = quotesList.get(j).getPrice() - quotesList.get(i).getPrice();
			        logger.info("Max  Profit : " + maxProfit);
         			ccmMaxProfitVo.setMaxProfit(df2.format(maxProfit));
					logger.info(" Buy Price  : " + quotesList.get(i).getPrice());
					ccmMaxProfitVo.setBuyValue(df2.format(quotesList.get(i).getPrice()));    
					logger.info("Buy Time :" + quotesList.get(i).getTradeTime());
					ccmMaxProfitVo.setBuyTime(String.valueOf(quotesList.get(i).getTradeTime()));
					logger.info("Sell Price" + quotesList.get(j).getPrice());
					ccmMaxProfitVo.setSellValue(df2.format(quotesList.get(j).getPrice()));
					logger.info("Sell Time" + quotesList.get(j).getTradeTime());
					ccmMaxProfitVo.setSellTime(String.valueOf(quotesList.get(j).getTradeTime()));
				}
			}
		}
		return ccmMaxProfitVo;
	}	
}


