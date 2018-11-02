package kr.or.ddit.lotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Lotto {
	private int maxNum;
	private int collectNm;
	private int count;
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getMaxNum() {
		return maxNum;
	}
	public void setMaxNum(int maxNum) {
		this.maxNum = maxNum;
	}
	public int getCollectNm() {
		return collectNm;
	}
	public void setCollectNm(int collectNm) {
		this.collectNm = collectNm;
	}
	
	public Set<Integer> selectNm(int collectNm) {
		
		Set<Integer> lotto=new HashSet<Integer>();
		
//		for(int j=1;j<=count;j++) {
//			for(int i=0;i<=collectNm;i++) {
//				int num = (int) (Math.random() * (maxNum+1)) + 1;
//				lotto.add(num);
//			}
//			System.out.println(j+"회 lotto : "+lotto);
//			lotto.removeAll(lotto);
//		}
		for(int i=1;i<=count;i++) {
			while(lotto.size()<collectNm) {
				int num = (int) (Math.random() * (maxNum)) + 1;
				lotto.add(num);
			}
			System.out.println(i+"회 lotto : "+lotto);
			lotto.removeAll(lotto);
		}

		
		
		return lotto;
	}
	
}