package kr.or.ddit.lotto;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Test;

public class LottoTest {

	@Test
	public void lottoTest() {
		/***Given***/
		Lotto lotto = new Lotto();
		lotto.setMaxNum(45);
		lotto.setCollectNm(6);
		lotto.setCount(8);
		
		
		/***When***/
		Set<Integer> lottoNm = lotto.selectNm(lotto.getCollectNm());
		/***Then***/
		assertNotNull(lottoNm);
//		assertEquals(6, lottoNm.size());
	}

}
