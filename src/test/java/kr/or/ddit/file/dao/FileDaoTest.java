package kr.or.ddit.file.dao;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.or.ddit.file.model.FileVo;
import kr.or.ddit.test.ServiceDaoTestConfig;


//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations= {"classpath:kr/or/ddit/config/spring/root-context.xml"})
public class FileDaoTest extends ServiceDaoTestConfig{

	@Resource(name="fileDao")
	private FileDaoInf fileDao;
	
	/**
	* Method : insertFileTest
	* 작성자 : ASUS
	* 변경이력 :
	* Method 설명 : 파일정보 입력 테스트
	*/
	@Test(timeout=5000)//timeout --> 시간제한 5초안에 완료되어야 success
	public void insertFileTest() {
		/***Given***/
		FileVo fileVo = new FileVo();
		fileVo.setFile_name("30a000f1-c4e7-47ad-bba5-d5532074a1d8.png");
		fileVo.setOrg_file_name("sally.png");
		fileVo.setFile_path("C:\\ddit\\A_TeachingMaterial\\6.JspSrpgin\\upload");
		fileVo.setFile_ext(".png");
		
		/***When***/
		int insertCnt = fileDao.insertFile(fileVo);
		
		/***Then***/
		assertEquals(1, insertCnt);
	}

}
