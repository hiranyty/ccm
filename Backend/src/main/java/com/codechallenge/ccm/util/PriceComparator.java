package com.codechallenge.ccm.util;

import java.util.Comparator;

import com.codechallenge.ccm.vo.CCMDetailVo;

public class PriceComparator implements Comparator<CCMDetailVo> {

	@Override
	public int compare(CCMDetailVo c1, CCMDetailVo c2) {
		
		if (c1.getPrice() > c2.getPrice()){
            return 1;
        }
        if (c1.getPrice() < c2.getPrice()){
            return -1;
        }
        else{
            return 0;
        }
	}

}
