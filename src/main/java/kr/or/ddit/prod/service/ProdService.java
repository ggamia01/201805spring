package kr.or.ddit.prod.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import kr.or.ddit.prod.dao.ProdDao;
import kr.or.ddit.prod.model.ProdVo;
import kr.or.ddit.user.dao.UserDao;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.util.model.PageVo;

@Service
public class ProdService implements ProdServiceInf {

	ProdDao prodDao = new ProdDao();
	
	@Override
	public List<ProdVo> getProdList() {
		// TODO Auto-generated method stub
		return prodDao.getProdList();
	}

	@Override
	public ProdVo selectProd(String prodId) {
		// TODO Auto-generated method stub
		return prodDao.selectProd(prodId);
	}

	@Override
	public Map<String, Object> selectProdPageList(PageVo pageVo) {
		
		//페이지에 해당하는 유저 리스트(1~10건 사이)
		List<ProdVo> prodList =  prodDao.selectProdPageList(pageVo);
		
		//페이지 내비게이션을 위한 전체 유저 리스트 조회
		int totalProdCnt = prodDao.getProdCnt();
		
		//결과를 담는 map
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("prodList", prodList);
		resultMap.put("pageCnt", (int)Math.ceil((double)totalProdCnt/pageVo.getPageSize()));
		return resultMap;
	}



}
