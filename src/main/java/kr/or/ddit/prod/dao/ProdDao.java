package kr.or.ddit.prod.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import kr.or.ddit.config.db.SqlFactoryBuilder;
import kr.or.ddit.prod.model.ProdVo;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.util.model.PageVo;

@Repository
public class ProdDao implements ProdDaoInf {

	@Override
	public List<ProdVo> getProdList() {
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session =  factory.openSession();
		List<ProdVo> prodList = session.selectList("jspuser.prodList");
		session.close();
		return prodList;
	}

	@Override
	public ProdVo selectProd(String prodId) {
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session =  factory.openSession();
		ProdVo prodVo = session.selectOne("jspuser.selectProd",prodId);
		session.close();
		
		return prodVo;
	}

	@Override
	public List<ProdVo> selectProdPageList(PageVo pageVo) {
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session =  factory.openSession();
		List<ProdVo> prodList = session.selectList("jspuser.selectProdPageList",pageVo);
		session.close();
		return prodList;
	}

	@Override
	public int getProdCnt() {
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session =  factory.openSession();
		int totalProdCnt = session.selectOne("jspuser.getProdCnt");
		session.close();
		
		return totalProdCnt;
	}


}
