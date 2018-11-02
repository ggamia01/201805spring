package kr.or.ddit.user.web;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.ddit.hello.HelloController;
import kr.or.ddit.user.model.UserVo;

@RequestMapping("/user")
@Controller
public class UserController {
	private Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@RequestMapping("/logInView")
	public String login() {
		return "logIn/logIn";
	}
	
	@RequestMapping(value="/logInProcess",method=RequestMethod.POST)
	public String vo(HttpServletRequest request) {
		
		String userId = request.getParameter("userId");
		String pass = request.getParameter("pass");
		
		if(userId.equals("brown") && pass.equals("brownpass")) {
			return "main";
		}else {
			return "logIn/logIn";
		}
		
		
	}
}
