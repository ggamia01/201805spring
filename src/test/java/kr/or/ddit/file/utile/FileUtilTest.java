/**
 * 
 */
package kr.or.ddit.file.utile;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;

import org.junit.Test;
import org.slf4j.Logger;

/**
* GetFileExtTest.java
*
* @author ASUS
* @version 1.0
* @see
*
* <pre>
* << 개정이력(Modification Information) >>
*
* 수정자 수정내용
* ------ ------------------------
* ASUS 최초 생성
*
* </pre>
*/
//테스트 코드를 운영코드보다 먼저 작성하는 방법
//Test Driven Development(TDD)
public class FileUtilTest {
	
	/**
	* Method : GetFileExtTest
	* 작성자 : ASUS
	* 변경이력 :
	* Method 설명 :파일 확장자 추출(확장자가 있는 경우)
	*/
	@Test
	public void GetFileExtTest() {
		/***Given***/
		String fileName="sally.png";
		/***When***/
		FileUtil fileUtil = new FileUtil();
		String ext = fileUtil.getFileExt(fileName);
		
		
		/***Then***/
		assertEquals(".png", ext);
	}
	
	/**
	* Method : GetFileExtTest
	* 작성자 : ASUS
	* 변경이력 :
	* Method 설명 :파일 확장자 추출(확장자가 없는 경우)
	*/
	@Test
	public void GetFileExtNTest() {
		/***Given***/
		String fileName="sally";
		/***When***/
		FileUtil fileUtil = new FileUtil();
		String ext = fileUtil.getFileExt(fileName);
		
		
		/***Then***/
		assertEquals("  ", ext);
	}

	/**
	* Method : GetFileExtTestMultiDot
	* 작성자 : ASUS
	* 변경이력 :
	* Method 설명 :파일 확장자 추출(확장자가 있는 경우)
	*/
	@Test
	public void GetFileExtTestMultiDot() {
		/***Given***/
		String fileName="sally.brown.png";
		/***When***/
		FileUtil fileUtil = new FileUtil();
		String ext = fileUtil.getFileExt(fileName);
		
		
		/***Then***/
		assertEquals(".png", ext);
	}
}
