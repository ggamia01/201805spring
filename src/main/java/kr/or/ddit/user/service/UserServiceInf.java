package kr.or.ddit.user.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.util.model.PageVo;

public interface UserServiceInf {
	public List<UserVo> getJspUser();
	
	public UserVo selectUser(String userId);
	
	public UserVo selectUser(UserVo userVo);

	public Map<String, Object>  selectUserPageList(PageVo pageVo);
	
	public int insertUser(UserVo userVo); 
	
	public int deleteUser(String userId);  
	
	/** 
	 * Method : updatdUser
	 * 작성자 : ASUS
	 * 변경이력 : 
	 * @param userId
	 * @return 
	 * Method 설명 : 사용자 상세 정보 수정
	 */
	public int updateUser(UserVo userVo);
}
