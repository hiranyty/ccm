package com.codechallenge.ccm;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.codechallenge.ccm.entity.CCMEntity;
import com.codechallenge.ccm.repository.CCMRepository;
import com.codechallenge.ccm.service.CCMService;
import com.codechallenge.ccm.vo.CCMMaxProfitVo;
import com.codechallenge.ccm.vo.CCMVo;

@RunWith(SpringRunner.class)
public class CCMServiceTest {

	@TestConfiguration
	static class TestConfig {

		@Bean
		public CCMService ccmService() {
			return new CCMService();
		}
	}

	@Autowired
	private CCMService ccmService;

	@MockBean
	private CCMRepository ccmRepository;

	@Test
	public void loadCryptoInfo_Service_ShouldReturen_CCMvo_For_BTC() {
		Mockito.when(ccmRepository.findByCurrencyOrderByTradeTimeAsc("BTC")).thenReturn(getCCMEntityList());

		CCMVo ccmVo = ccmService.loadCryptoInfo("BTC");
		assertThat(ccmVo.getCurrency()).isEqualTo("BTC");

	}
	
	@Test
	public void processMaxProfit_Service_ShouldReturen_MaxProfit_For_BTC() {
		Mockito.when(ccmRepository.findByCurrencyOrderByTradeTimeAsc("BTC")).thenReturn(getCCMEntityList());

		CCMMaxProfitVo ccmMaxProfitVo = ccmService.processMaxProfit("BTC");
		assertThat(ccmMaxProfitVo.getMaxProfit()).isEqualTo("2.03");

	}

	private List<CCMEntity> getCCMEntityList() {
		List<CCMEntity> ccmEntities = new ArrayList<CCMEntity>();
		CCMEntity ccmEntity = new CCMEntity();
		ccmEntity.setId(1L);
		ccmEntity.setCurrency("BTC");
		ccmEntity.setPrice(34.98);
		ccmEntity.setTradeDate(LocalDate.now());
		ccmEntity.setTradeTime(LocalTime.parse("09:15"));
		ccmEntities.add(ccmEntity);
		CCMEntity ccmEntity1 = new CCMEntity();
		ccmEntity1.setId(2L);
		ccmEntity1.setCurrency("BTC");
		ccmEntity1.setPrice(36.13);
		ccmEntity1.setTradeDate(LocalDate.now());
		ccmEntity1.setTradeTime(LocalTime.parse("10:45"));
		ccmEntities.add(ccmEntity1);
		CCMEntity ccmEntity2 = new CCMEntity();
		ccmEntity2.setId(3L);
		ccmEntity2.setCurrency("BTC");
		ccmEntity2.setPrice(37.01);
		ccmEntity2.setTradeDate(LocalDate.now());
		ccmEntity2.setTradeTime(LocalTime.parse("12:30"));
		ccmEntities.add(ccmEntity2);
		
		return ccmEntities;
	}

	@Test
	public void loadCryptoInfo_Service_ShouldReturen_CCMvo_For_LTC() {
		Mockito.when(ccmRepository.findByCurrencyOrderByTradeTimeAsc("LTC")).thenReturn(getCCMEntityListLTC());

		CCMVo ccmVoETH = ccmService.loadCryptoInfo("LTC");
		assertThat(ccmVoETH.getCurrency()).isEqualTo("LTC");

	}
	
	@Test
	public void processMaxProfit_Service_ShouldReturen_MaxProfit_For_LTC() {
		Mockito.when(ccmRepository.findByCurrencyOrderByTradeTimeAsc("LTC")).thenReturn(getCCMEntityListLTC());

		CCMMaxProfitVo ccmMaxProfitVo = ccmService.processMaxProfit("LTC");
		assertThat(ccmMaxProfitVo.getMaxProfit()).isEqualTo("0.71");

	}


	private List<CCMEntity> getCCMEntityListLTC() {
		List<CCMEntity> ccmEntities2 = new ArrayList<CCMEntity>();
		CCMEntity ccmEntity3 = new CCMEntity();
		ccmEntity3.setId(1L);
		ccmEntity3.setCurrency("LTC");
		ccmEntity3.setPrice(14.32);
		ccmEntity3.setTradeDate(LocalDate.now());
		ccmEntity3.setTradeTime(LocalTime.parse("09:30"));
		ccmEntities2.add(ccmEntity3);
		CCMEntity ccmEntity4 = new CCMEntity();
		ccmEntity4.setId(2L);
		ccmEntity4.setCurrency("LTC");
		ccmEntity4.setPrice(14.87);
		ccmEntity4.setTradeDate(LocalDate.now());
		ccmEntity4.setTradeTime(LocalTime.parse("11:15"));
		ccmEntities2.add(ccmEntity4);
		CCMEntity ccmEntity5 = new CCMEntity();
		ccmEntity5.setId(3L);
		ccmEntity5.setCurrency("LTC");
		ccmEntity5.setPrice(15.03);
		ccmEntity5.setTradeDate(LocalDate.now());
		ccmEntity5.setTradeTime(LocalTime.parse("12:45"));
		ccmEntities2.add(ccmEntity5);

		return ccmEntities2;
	}
	
	

	/*private List<CCMEntity> getCCMEntityListETH() {
		List<CCMEntity> ccmEntities = new ArrayList<CCMEntity>();
		CCMEntity ccmEntity = new CCMEntity();
		ccmEntity.setId(1L);
		ccmEntity.setCurrency("ETH");
		ccmEntity.setPrice(1.45);
		ccmEntity.setTradeDate(LocalDate.now());
		ccmEntity.setTradeTime(LocalTime.now());
		ccmEntities.add(ccmEntity);

		return ccmEntities;
	}*/
	
	

}
