package kr.or.ddit.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import jdk.nashorn.internal.ir.annotations.Ignore;

@RunWith(SpringJUnit4ClassRunner.class)

//controller의 경우 service 스프링 빈을 주입받기 때문에
//service,dao에 대한 설정파일도 필요하다
@ContextConfiguration(locations= {"classpath:kr/or/ddit/config/spring/root-context.xml",
		"classpath:kr/or/ddit/config/spring/servlet-context.xml"})
//스프링 컨테이너를 웹 기반에서 활용가능한 webApplicationContext로 생성
@WebAppConfiguration	
public class ControllerTestConfig {

	//webApplicationsContext ==> mockMvc(dispatcherServlet)생성을 위해 필요
	@Autowired
	protected WebApplicationContext context;
	protected MockMvc mockMvc;
	
	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}
	
	@Ignore
	@Test
	public void test() {
		
	}

}
