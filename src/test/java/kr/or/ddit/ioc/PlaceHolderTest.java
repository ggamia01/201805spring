package kr.or.ddit.ioc;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:kr/or/ddit/ioc/application-context-placeholder.xml"})
public class PlaceHolderTest {

	@Resource(name="placeHolder")
	
	private PlaceHolder placeHolder;

	@Test
	public void placeHolerTest() {
		/***Given***/
		
		
		/***When***/
		String user = placeHolder.getUser();
		String password = placeHolder.getPassword();
		String driver = placeHolder.getDriver();
		String url = placeHolder.getUrl();
		
		/***Then***/
		assertEquals("song", user);
		assertEquals("java", password);
		assertEquals("oracle.jdbc.driver.OracleDriver", driver);
		assertEquals("jdbc:oracle:thin:@localhost:1521:xe", url);
		
	}

}
