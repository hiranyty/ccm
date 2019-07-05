package com.codechallenge.ccm;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.codechallenge.ccm.service.CCMService;
import com.codechallenge.ccm.vo.CCMDetailVo;
import com.codechallenge.ccm.vo.CCMMaxProfitVo;
import com.codechallenge.ccm.vo.CCMVo;

@RunWith(SpringRunner.class)
@WebMvcTest
public class CCMContollerTest {

	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private CCMService ccmService;

	@Test
	public void loadcurrencyDetails_ShouldReturn_CCMVo_For_BTC() throws Exception {

		CCMVo mockCCMVo = new CCMVo();
		mockCCMVo.setCurrency("BTC");
		CCMDetailVo mockCCMDetailVo = new CCMDetailVo();
		mockCCMDetailVo.setPrice(34.98);
		mockCCMDetailVo.setTradeTime("9:15 AM");
		List<CCMDetailVo> mockQuoteList = new ArrayList<>();
		mockQuoteList.add(mockCCMDetailVo);
		mockCCMVo.setQuotes(mockQuoteList);

		Mockito.when(ccmService.loadCryptoInfo("BTC")).thenReturn(mockCCMVo);
		mockMvc.perform(MockMvcRequestBuilders.get("/v1/cryptos/BTC").contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("currency").value("BTC")).andExpect(jsonPath("$.quotes[0].price").value("34.98"));

	}

	@Test
	public void loadcurrencyDetails_ShouldReturn_CCMVo_For_ETH() throws Exception {

		CCMVo mockCCMVo = new CCMVo();
		mockCCMVo.setCurrency("ETH");
		CCMDetailVo mockCCMDetailVo = new CCMDetailVo();
		mockCCMDetailVo.setPrice(1.45);
		mockCCMDetailVo.setTradeTime("09:00 AM");
		List<CCMDetailVo> mockQuoteList = new ArrayList<>();
		mockQuoteList.add(mockCCMDetailVo);
		mockCCMVo.setQuotes(mockQuoteList);

		Mockito.when(ccmService.loadCryptoInfo("ETH")).thenReturn(mockCCMVo);
		mockMvc.perform(MockMvcRequestBuilders.get("/v1/cryptos/ETH").contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("currency").value("ETH")).andExpect(jsonPath("$.quotes[0].price").value("1.45"));

	}

	@Test
	public void processMaxProfit_ShouldReturn_MaxProfit_For_BTC() throws Exception {

		CCMMaxProfitVo mockCCMMaxProfitVo = new CCMMaxProfitVo();
		mockCCMMaxProfitVo.setCode("BTC");
		mockCCMMaxProfitVo.setBuyTime("09:15 AM");
		mockCCMMaxProfitVo.setBuyValue("34.98");
		mockCCMMaxProfitVo.setSellTime("12:30 PM");
		mockCCMMaxProfitVo.setSellValue("37.01");
		mockCCMMaxProfitVo.setMaxProfit("2.03");

		Mockito.when(ccmService.processMaxProfit("BTC")).thenReturn(mockCCMMaxProfitVo);
		mockMvc.perform(MockMvcRequestBuilders.get("/v1/maxprofit/BTC").contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("maxProfit").value("2.03")).andExpect(jsonPath("buyValue").value("34.98"))
				.andExpect(jsonPath("buyTime").value("09:15 AM")).andExpect(jsonPath("sellValue").value("37.01"))
				.andExpect(jsonPath("sellTime").value("12:30 PM"));

	}

	@Test
	public void processMaxProfit_ShouldReturn_MaxProfit_For_LTC() throws Exception {

		CCMMaxProfitVo mockCCMMaxProfitVo = new CCMMaxProfitVo();
		mockCCMMaxProfitVo.setCode("LTC");
		mockCCMMaxProfitVo.setBuyTime("09:30 AM");
		mockCCMMaxProfitVo.setBuyValue("14.32");
		mockCCMMaxProfitVo.setSellTime("12:45 PM");
		mockCCMMaxProfitVo.setSellValue("15.03");
		mockCCMMaxProfitVo.setMaxProfit("0.71");

		Mockito.when(ccmService.processMaxProfit("LTC")).thenReturn(mockCCMMaxProfitVo);
		mockMvc.perform(MockMvcRequestBuilders.get("/v1/maxprofit/LTC").contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("maxProfit").value("0.71")).andExpect(jsonPath("buyValue").value("14.32"))
				.andExpect(jsonPath("buyTime").value("09:30 AM")).andExpect(jsonPath("sellValue").value("15.03"))
				.andExpect(jsonPath("sellTime").value("12:45 PM"));

	}

}
