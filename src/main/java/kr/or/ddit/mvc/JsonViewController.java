package kr.or.ddit.mvc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

@Controller
public class JsonViewController {
	
	@ModelAttribute
	public void modelAttribute(Model model) {
		List<String> rangers = new ArrayList<String>();
		rangers.add("brown");
		rangers.add("cony");
		rangers.add("sally");
		
		model.addAttribute("rangers", rangers);
	}
	
	//json 응답을 생성하는 url요청
	//레인저스 정보를 json으로 응답을 생성
	@RequestMapping("/rangersJsonView")
	public String rangersJsonView() {
		//아래와 같이 직접 작성해야 할 문자열을
		//"{rangers : [{name:'cony',id:'rabbit'},{name:'brown',id:'bear'}]}"
		//컬렉션, object정보를 json문자열로 생성
		
//		List<String> rangers = new ArrayList<String>();
//		rangers.add("brown");
//		rangers.add("cony");
//		rangers.add("sally");
//		
//		model.addAttribute("rangers", rangers);
		
		//json을 생성하는 view
		return "jsonView";
		//<bean id="jsonView" class="org.springframework.web.servlet.view.json.MappingJackson2JsonView"/>
		
		//controller에서 리턴하는 viewName(jsonView)를 처리하기 위해
		//처리해줄 viewResolver를 우선순위에 따라서 
		//1.beanNameViewResolver를 통해 view를 생성하려고 시도하게 됨
		//2.jsonView라고 하는 이름의 빈이 있는지를 확인 ==> 존재
		//3.해당  viewName과 동일한 이름의 빈이 있으므로 
		// internalResourceViewResolver까지 가지 않고 beanNameViewResolver에서 처리하게 됨
		
		//만약 viewName이 "hello"인 경우라면
		//처리해줄 viewResolver를 우선순위에 따라서 
		//1.beanNameViewResolver를 통해 view를 생성하려고 시도하게 됨
		//2.jsonView라고 하는 이름의 빈이 있는지를 확인 ==> 존재하지 않음
		//	<bean id="hello"...이런 ㄹ빈이 있는지
		//3.다음 우선 순위인 internalResourceView가 처리하게 됨
		//	internalResourceView는 해당 리소스(hello.jsp)가 있는지 여부를 상관하지 않고
		//	prefix,suffix를 무조건 반영하여 forward를 실행
		//	그렇기 때문에 오타, 혹은 존재하지 않는 파일(jsp)을 리턴하게 되면
		//	에러가 발생함
		//	그런 이유로 internalResourceViewResolver는 viewResolver 설정시 우선순위를 최하위로 둔다
		
	}
	
	@RequestMapping("/rangersJsonViewObj")
	public View ragersJsonViewObj() {
		
		//json 생성을 담당하는 view
		return new MappingJackson2JsonView();
	}

}
