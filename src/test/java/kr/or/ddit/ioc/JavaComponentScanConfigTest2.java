package kr.or.ddit.ioc;
import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.or.ddit.board.dao.BoardDaoInf;
import kr.or.ddit.board.service.BoardServiceInf;
import kr.or.ddit.ioc.JavaConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={JavaComponentScanConfig.class})
public class JavaComponentScanConfigTest2 {

	@Resource(name="boardDao")
	private BoardDaoInf boardDao;
	
	@Resource(name="boardService")
	private BoardServiceInf boardService;
	
	/**
	* Method : javaConfigBeanTest
	* 작성자 : ASUS
	* 변경이력 :
	* Method 설명 :javaConfig를 통해 스프링 빈이 정상적으로 생성되었는지 테스트
	*/
	@Test
	public void javaConfigBeanTest() {
		/***Given***/
		
		/***When***/

		/***Then***/
		assertNotNull(boardDao);
		assertNotNull(boardService);
	}

}
