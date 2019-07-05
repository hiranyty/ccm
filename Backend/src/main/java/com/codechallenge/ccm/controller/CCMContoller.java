package com.codechallenge.ccm.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codechallenge.ccm.service.CCMService;
import com.codechallenge.ccm.vo.CCMMaxProfitVo;
import com.codechallenge.ccm.vo.CCMVo;

@RestController
@RequestMapping("v1")
public class CCMContoller {

	Logger logger = LogManager.getLogger(CCMContoller.class);

	@Autowired
	private CCMService ccmservice;

	@GetMapping("/test")
	public String displayTest() {
		logger.info("Test");
		return "test1";
	}

    @CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/cryptos/{code}")
	public CCMVo loadcurrencyDetails(@PathVariable String code) {
		logger.info("Laoding currnecy info " + code);
		CCMVo ccmVo = ccmservice.loadCryptoInfo(code);
		return ccmVo;
	}

    @CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/maxprofit/{code}")
	public CCMMaxProfitVo processMaxProfit(@PathVariable String code) {
		logger.info("Processing max profit" + code);
		CCMMaxProfitVo ccmaxProfitVo = ccmservice.processMaxProfit(code);
		return ccmaxProfitVo;
	}

}
