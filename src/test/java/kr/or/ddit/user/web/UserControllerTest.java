package kr.or.ddit.user.web;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ddit.user.model.UserVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:kr/or/ddit/config/spring/servlet-context.xml"})
@WebAppConfiguration	//스프링 컨테이너를 web기반 컨테이너로 생성
public class UserControllerTest {

	@Autowired
	private WebApplicationContext ctx;
	
	private MockMvc mockMvc;
	
	//test메소드 시작전 준비작업을 실행하는 메소드
	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}
	
	/**
	* Method : loginViewTest
	* 작성자 : ASUS
	* 변경이력 :
	* Method 설명 :loginView test
	 * @throws Exception 
	*/
	@Test
	public void loginViewTest() throws Exception {
		/***Given***/
		
		/***When***/
		MvcResult mvcResult = mockMvc.perform(get("/user/logInView")).andReturn();
		ModelAndView mav = mvcResult.getModelAndView();
		
		/***Then***/
		//veiwName
		assertEquals("logIn/logIn", mav.getViewName());
	}

	/**
	* Method : loginProcessTest
	* 작성자 : ASUS
	* 변경이력 :
	* Method 설명 : loginProcess test
	 * @throws Exception 
	*/
	@Test
	public void loginProcessSuccessTest() throws Exception {
		/***Given***/
		
		/***When***/
		MvcResult mvcResult = mockMvc.perform(post("/user/logInProcess").param("userId", "brown")
				.param("pass", "brownpass")).andReturn();
		ModelAndView mav = mvcResult.getModelAndView();
		
		String viewName = mav.getViewName();
		

		/***Then***/
		assertEquals("main", viewName);
	}
	
	@Test
	public void loginProcessFailTest() throws Exception {
		/***Given***/
		
		/***When***/
		MvcResult mvcResult = mockMvc.perform(post("/user/logInProcess").param("userId", "browm")
				.param("pass", "brownpass")).andReturn();
		ModelAndView mav = mvcResult.getModelAndView();
		
		String viewName = mav.getViewName();
		

		/***Then***/
		assertEquals("logIn/logIn", viewName);
	}
}
