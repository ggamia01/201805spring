package kr.or.ddit.user.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class UserVoValidator implements Validator{

	private Logger logger = LoggerFactory.getLogger(UserVoValidator.class);
	
	//메소드 인자로 들어온 clazz 객체가 UserVo로부터 생성가능한지 여부를 판단
	@Override
	public boolean supports(Class<?> clazz) {
		return UserVo.class.isAssignableFrom(clazz);
	}

	//실제검증로직(값이 비어 있는지, 글자수 제한, 정규식, 핸드폰번호 포맷팅적용)
	@Override
	public void validate(Object target, Errors errors) {
		//validation 대상 객체
		//target-->useVo
		UserVo userVo = (UserVo)target;
		
		//사용자 아이디 공백 체크
		if(userVo.getUserId() == null || userVo.getUserId().equals("")) {
			logger.debug("validate userId");
			errors.rejectValue("userId", "required");
		}
		
		//이름 공백 체크
		if(userVo.getName() ==null || userVo.getName().equals("")) {
			logger.debug("validate name");
			errors.rejectValue("name", "required");
		}
		
		//pass 길이가 5보다 작으면 error:lengthNotEnough
		if(userVo.getPass() ==null || userVo.getPass().length()<5) {
			logger.debug("validate pass");
			errors.rejectValue("pass", "lengthNotEnough");
		}
		
	}

}
