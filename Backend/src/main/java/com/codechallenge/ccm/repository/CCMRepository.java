package com.codechallenge.ccm.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codechallenge.ccm.entity.CCMEntity;


@Repository
public interface CCMRepository extends CrudRepository<CCMEntity, Long> {
	
	List<CCMEntity> findByCurrencyOrderByTradeTimeAsc(String currency);

}
