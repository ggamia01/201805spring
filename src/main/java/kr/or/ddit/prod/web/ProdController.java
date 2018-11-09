package kr.or.ddit.prod.web;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.prod.model.ProdVo;
import kr.or.ddit.prod.service.ProdServiceInf;
import kr.or.ddit.util.model.PageVo;

@RequestMapping("/prod")
@Controller
public class ProdController {

	Logger logger = LoggerFactory.getLogger(ProdController.class);
	
	@Resource(name="prodService")
	ProdServiceInf prodService;
	
	@RequestMapping("/prodList")
	public String prodList(PageVo pageVo,Model model) {
		
		 //페이지 리스트
	      Map<String, Object> resultMap = prodService.selectProdPageList(pageVo);
	      List<PageVo> prodpageList = (List<PageVo>) resultMap.get("prodList");
	      
	      model.addAllAttributes(resultMap);
	      model.addAttribute("prodpageList", prodpageList);
		return "prod/prodPagingList";
	}
	
	@RequestMapping("prodDetail")
	public String prodDetail(@RequestParam("prodId")String prodId,Model model) {
		
		ProdVo prodVo = prodService.selectProd(prodId);
		
		model.addAttribute("prodVo", prodVo);
		
		return "/prod/prodDetail";
	}
}
