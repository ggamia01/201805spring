package kr.or.ddit.user.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import kr.or.ddit.user.dao.UserDao;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.util.model.PageVo;

@Service
public class UserService implements UserServiceInf {

	UserDao userDao = new UserDao();
	

	@Override
	public List<UserVo> getJspUser() {
		// TODO Auto-generated method stub
		return userDao.getJspUser();
	}

	@Override
	public UserVo selectUser(String userId) {
		// TODO Auto-generated method stub
		return userDao.selectUser(userId);
	}

	@Override
	public UserVo selectUser(UserVo userVo) {
		// TODO Auto-generated method stub
		return userDao.selectUser(userVo);
	}

	/** 
	 * Method : selectUserPageList
	 * 작성자 : ASUS
	 * 변경이력 : 
	 * @param pageVo
	 * @return 
	 * Method 설명 : 사용자 페이징 조회
	 * alt+shift+j
	 */
	@Override
	public Map<String, Object> selectUserPageList(PageVo pageVo) {
		
		UserDao userDao = new UserDao();
		//페이지에 해당하는 유저 리스트(1~10건 사이)
		List<UserVo> userList =  userDao.selectUserPageList(pageVo);
		
		//페이지 내비게이션을 위한 전체 유저 리스트 조회
		int totalUserCnt = userDao.getUserCnt();
		
		//결과를 담는 map
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("userList", userList);
		resultMap.put("pageCnt", (int)Math.ceil((double)totalUserCnt/pageVo.getPageSize()));
		return resultMap;
	}
	
	/** 
	 * Method : insertUser
	 * 작성자 : ASUS
	 * 변경이력 : 
	 * @param userVo
	 * @return 
	 * Method 설명 : 사용자 등록
	 */
	@Override
	public int insertUser(UserVo userVo) {
		// TODO Auto-generated method stub
		return userDao.insertUser(userVo);
	}

	/** 
	 * Method : deleteUser
	 * 작성자 : ASUS
	 * 변경이력 : 
	 * @param userId
	 * @return 
	 * Method 설명 : 사용자 삭제
	 */
	@Override
	public int deleteUser(String userId) {
		// TODO Auto-generated method stub
		return userDao.deleteUser(userId);
	}

	/** 
	 * Method : updatdUser
	 * 작성자 : ASUS
	 * 변경이력 : 
	 * @param userId
	 * @return 
	 * Method 설명 : 사용자 상세 정보 수정
	 */
	@Override
	public int updateUser(UserVo userVo) {
		// TODO Auto-generated method stub
		return userDao.updateUser(userVo);
	}


}
