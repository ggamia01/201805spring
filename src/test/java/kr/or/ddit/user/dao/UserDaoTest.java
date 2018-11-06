package kr.or.ddit.user.dao;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.annotation.Resource;

import kr.or.ddit.test.ControllerTestConfig;
import kr.or.ddit.test.ServiceDaoTestConfig;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.util.model.PageVo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.web.bind.annotation.RequestMapping;

public class UserDaoTest extends ServiceDaoTestConfig{

	@Resource(name="userDao")
	private UserDaoInf userDao ;
	private final String TEST_USER_ID ="songTest";
	
	@Before
	public void setUp(){
//		jspDao = new UserDao();
		userDao.deleteUser(TEST_USER_ID);
	}
	//테스트 메소드명명 규칙(회사 마다 다름)
	//운영코드 메소드 이름 +  Test
	//getTemp + Test : getTempTest
	@Test
	public void getJspUserTest() {
		/***Given : 주어진 상황***/
		

		/***When : 어떤 동작 수행(메소드 호출)***/
		List<UserVo> list = userDao.getJspUser();
		System.out.println("list: "+list);
		
		int listSize = list.size();
		System.out.println(listSize);
		//select 'X' as result from dual
		//result : X
		
		/***Then : 결과가 어떠해야하는지 정의***/
		assertEquals(108, list.size());
		
	}
	
	@Test
	public void selectUserTest() {
		/***Given : 주어진 상황***/

		/***When : 어떤 동작 수행(메소드 호출)***/
		UserVo userVo = userDao.selectUser("brown");
		System.out.println("userVo: "+userVo);
		
		//select 'X' as result from dual
		//result : X
		
		/***Then : 결과가 어떠해야하는지 정의***/
		assertNotNull(userVo);
		assertEquals("brown", userVo.getUserId());
		assertEquals("브라운", userVo.getName());
		
	}

	@Test
	public void selectUserTestByVoTest() {
		/***Given : 주어진 상황***/

		/***When : 어떤 동작 수행(메소드 호출)***/
		UserVo userVo = new UserVo();
		userVo.setUserId("brown");
		
				
		System.out.println("userVo: "+userVo);
		
		UserVo userVo1 = userDao.selectUser(userVo);
		//select 'X' as result from dual
		//result : X
		
		/***Then : 결과가 어떠해야하는지 정의***/
		assertNotNull(userVo1);
		assertEquals("brown", userVo1.getUserId());
		assertEquals("브라운", userVo1.getName());
		
	}

	
	@Test
	public void selectUserPageListTest() {
		/***Given : 주어진 상황***/
		PageVo pageVo = new PageVo();
		pageVo.setPage(1);
		pageVo.setPageSize(10);

		/***When : 어떤 동작 수행(메소드 호출)***/
		List<UserVo> userList = userDao.selectUserPageList(pageVo);
				
		System.out.println("pageVo: "+pageVo);
		
		
		/***Then : 결과가 어떠해야하는지 정의***/
		assertNotNull(pageVo);
		assertEquals(10, userList.size());
		
	}

	@Test
	public void getUserCntTest(){
		/***Given***/
		

		/***When***/
		int totalUserCnt = userDao.getUserCnt();
		
		/***Then***/
		assertEquals(108, totalUserCnt);
	}
	
	@Test
	public void insertUserTest(){
		/***Given***/
		//userVo준비
		UserVo userVo = new UserVo();
		userVo.setUserId(TEST_USER_ID);
		userVo.setName("브라운");
		userVo.setPass("pass1234");
		userVo.setAddr1("대전시");
		userVo.setAddr2("상세주소");
		userVo.setZipcd("34940");
		GregorianCalendar gc = new GregorianCalendar(2018,7,8);
		userVo.setBirth(new Date(gc.getTimeInMillis()));
		userVo.setEmail("newUser@gamil.com");
		userVo.setTel("123123");
//		userVo.setProfile("/path/sally.png");
		

		/***When***/
		//userDao.inserUser()
		int userVoCnt = userDao.insertUser(userVo);
				
		/***Then***/
		//입력건수 비교
		assertEquals(1, userVoCnt);
	}
	
//	@Test
//	public void deleteUserTest(){
//		/***Given***/
//		UserVo userVo = new UserVo();
//		userVo.setUserId("songTest");
//		String userId = userVo.getUserId();
//
//		/***When***/
//		int deleteCnt = jspDao.deleteUser(userId);
//
//		/***Then***/
//		assertEquals(1, deleteCnt);
//	}
}
