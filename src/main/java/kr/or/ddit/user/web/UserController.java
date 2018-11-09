package kr.or.ddit.user.web;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.annotation.Resources;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.hello.HelloController;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.UserServiceInf;
import kr.or.ddit.util.model.PageVo;

@RequestMapping("/user")
@Controller
public class UserController {
	private Logger logger = LoggerFactory.getLogger(UserController.class);
	@Resource(name="userService")
	private UserServiceInf userService;
	
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
	
	/**
	* Method : userAllList
	* 작성자 : ASUS
	* 변경이력 :
	* @return
	* Method 설명 :사용자 전체 조회
	*/
	@RequestMapping("/userAllList")
	public String userAllList(Model model) {
		
		//userService 사용자 전체 정보 조회
		List<UserVo> userList = userService.getJspUser();
		
		model.addAttribute("userList", userList);
		
		return "user/userAllList";
	}
	
	@RequestMapping("userPageList")
	public String userPageList(Model model, PageVo pageVo) {
		
		//spring 컨테이너로부터 bean을 주입받기때문에 new 연산자를 통해 생성할 필요없음 

		//conrtroller method 매개변수로 선언
		/*PageVo pageVo = new PageVo();
	    pageVo.setPage(Integer.parseInt((request.getParameter("page"))));
		pageVo.setPageSize(Integer.parseInt((request.getParameter("pageSize"))));*/
		
		 //페이지 리스트
	    /*  Map<String, Object> resultMap = userService.selectUserPageList(pageVo);
	      List<UserVo> pageList = (List<UserVo>) resultMap.get("userList");
	      
	      //페이지 건수
	      int pageCnt = (int) resultMap.get("pageCnt");
	      
	      //request 객체에 저장
	      request.setAttribute("pageList", pageList);
	      request.setAttribute("pageCnt", pageCnt);*/
		
		Map<String, Object> resultMap = userService.selectUserPageList(pageVo);
		model.addAllAttributes(resultMap);
		
		return "user/userPageList";
	}
	
	@RequestMapping("/userDetail")
	public String userDetail(@RequestParam("userId")String userId,Model model) {
		
		//@RequestParam 어노테이션을 통해 설정
		UserVo userVo = userService.selectUser(userId);
		
		model.addAttribute("userVo", userVo);
		
		return "user/userDetail";
	}
	
	@RequestMapping(value="/userForm",method= {RequestMethod.GET})
	public String userFormView() {
		
		
		return "/user/userForm";
	}
	
	@RequestMapping(value="/userForm",method= {RequestMethod.POST})
	public String userForm(@RequestPart("profilePic")MultipartFile part,
			HttpServletRequest request,UserVo userVo) {
		
		
		
		
		try {
			if(part.getSize()>0) {
				String path = request.getServletContext().getRealPath("/profile");
				String fileName = part.getOriginalFilename();
				part.transferTo(new File(path + File.separator + fileName));
				userVo.setProfile("/profile/"+fileName);
				
			}
		} catch (IllegalStateException | IOException e) {
			
			e.printStackTrace();
		}
		
		int insertCnt = userService.insertUser(userVo);
		
		return "redirect:/user/userPageList?page=1&pageSize=10";
	}
	
	@RequestMapping(value="/userUpdate",method= {RequestMethod.GET})
	public String userUpdate(@RequestParam("userId")String userId,
			Model model) {
		
		UserVo userVo = userService.selectUser(userId);
		
		model.addAttribute("userVo", userVo);
		
		return "/user/userUpdate";
	}
	
	@RequestMapping(value="/userUpdate",method= {RequestMethod.POST})
	public String userUpdate(@RequestPart("profilePic")MultipartFile part,
			HttpServletRequest request,UserVo userVo) {
		
		
		try {
			if(part.getSize()>0) {
				String path = request.getServletContext().getRealPath("/profile");
				String fileName = part.getOriginalFilename();
				

				String profile;
				if(fileName.equals("")){
					profile = null;
				}else{
					profile ="/profile/"+fileName;
				
					part.transferTo(new File(path + File.separator + fileName));
					userVo.setProfile("/profile/"+fileName);
				}
				
			}
		} catch (IllegalStateException | IOException e) {
			
			e.printStackTrace();
		}

		int insertCnt = userService.updateUser(userVo);
		
		return "redirect:/user/userPageList?page=1&pageSize=10";
	}
}
