package kr.or.ddit.prod.dao;

import java.util.List;

import kr.or.ddit.prod.model.ProdVo;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.util.model.PageVo;

public interface ProdDaoInf {
	public List<ProdVo> getProdList();
	
	public ProdVo selectProd(String prodId);
	
	
	public List<ProdVo> selectProdPageList(PageVo pageVo);
	
	/** 
	 * Method : getProdCnt
	 * 작성자 : ASUS
	 * 변경이력 : 
	 * @return 
	 * Method 설명 : 제품전체 건수 조회
	 */
	public int getProdCnt();


}
