package com.web.freeboard.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.web.freeboard.service.FreeBoardService;
import com.web.freeboard.util.PagingUtill;
import com.web.freeboard.vo.FreeBoardVo;

@CrossOrigin
@RestController
public class FreeBoardController {
	
	@Autowired
	FreeBoardService freeBoardService;
	
	@RequestMapping(value = "view")
	public List<FreeBoardVo> getMainList( PagingUtill pageUt
										, @RequestParam(defaultValue="") String dateStart 
										, @RequestParam(defaultValue="") String dateEnd
										, @RequestParam(value="nowPage",required = false)String nowPage
										, @RequestParam(value="cntPerPage",required = false)String cntPerPage){
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		resultMap.put("dateStart", dateStart);
		resultMap.put("nowPage", nowPage);
		resultMap.put("cntPerPage", cntPerPage);
		
		freeBoardService.countBoard(resultMap);
		resultMap.put("listCon", freeBoardService.mainList(resultMap));
		System.out.println("page = "+resultMap);
		return freeBoardService.mainList(resultMap);
	}
	
	@RequestMapping(value = "detail/{num}",method = RequestMethod.GET)
	public Map<String, Object> detailBoard( @PathVariable("num") String num){
		
		return freeBoardService.detailBoard(Integer.parseInt(num));
	}
	
	@RequestMapping(value = "insert",method = RequestMethod.POST)
	public void insertBoard(@RequestBody Map<String, Object> list){
		
		freeBoardService.insertBoard(list);
	}
	
	@RequestMapping(value = "delete/{num}",method = RequestMethod.GET)
	public void deleteBoard( @PathVariable("num") String num){

		freeBoardService.deleteBoard(Integer.parseInt(num));
	}
	
	@RequestMapping(value = "update",method = RequestMethod.POST)
	public void updateBoard(@RequestBody Map<String, Object> list){
		System.out.println(list);
		freeBoardService.updateBoard(list);
		
	}
} 