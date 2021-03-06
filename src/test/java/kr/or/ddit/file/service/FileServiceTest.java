package kr.or.ddit.file.service;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.or.ddit.file.dao.FileDaoInf;
import kr.or.ddit.file.model.FileVo;
import kr.or.ddit.test.ServiceDaoTestConfig;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations= {"classpath:kr/or/ddit/config/spring/root-context.xml"})
public class FileServiceTest extends ServiceDaoTestConfig{

	@Resource(name="fileService")
	private FileServiceInf fileService;
	
	/**
	* Method : insertFileTest
	* 작성자 : ASUS
	* 변경이력 :
	* Method 설명 : 파일정보 입력 테스트
	*/
	@Test
	public void insertFileServiceTest() {
		/***Given***/
		FileVo fileVo = new FileVo();
		fileVo.setFile_name("30a000f1-c4e7-47ad-bba5-d5532074a1d8.png");
		fileVo.setOrg_file_name("sally.png");
		fileVo.setFile_path("C:\\ddit\\A_TeachingMaterial\\6.JspSrpgin\\upload");
		fileVo.setFile_ext(".png");
		
		/***When***/
		int insertCnt = fileService.insertFile(fileVo);
		
		/***Then***/
		assertEquals(1, insertCnt);
	}
}
