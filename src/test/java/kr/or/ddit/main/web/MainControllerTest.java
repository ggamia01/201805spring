package kr.or.ddit.main.web;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ddit.test.ControllerTestConfig;

public class MainControllerTest extends ControllerTestConfig{

	private Logger logger = LoggerFactory.getLogger("MainTest.class");
	
	@Test
	public void mainTest() throws Exception {
		/***Given***/
		
		
		/***When***/
		MvcResult mvcresult =  mockMvc.perform(get("/main")).andReturn();
		ModelAndView mav = mvcresult.getModelAndView();
		
		/***Then***/
		assertEquals("main", mav.getViewName());
	}

}
