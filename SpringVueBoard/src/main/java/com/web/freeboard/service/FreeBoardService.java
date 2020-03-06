package com.web.freeboard.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.web.freeboard.dao.FreeBoardDao;
import com.web.freeboard.util.PagingUtill;
import com.web.freeboard.vo.FreeBoardVo;

@Service
public class FreeBoardService {
	@Autowired
	private FreeBoardDao freeBoardDao;
	
	public int countBoard(Map<String, Object> resultMap) {
		 
		String nowPage = (String)resultMap.get("nowPage");
		String cntPerPage = (String)resultMap.get("cntPerPage");
		int total = freeBoardDao.countBoard(resultMap);
		
		if (nowPage == null && cntPerPage == null) {
			nowPage = "1";
			cntPerPage = "10";
		} else if (nowPage == null) {
			nowPage = "1";
		} else if (cntPerPage == null) { 
			cntPerPage = "10";
		}
		
		PagingUtill pageUt = new PagingUtill(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));
		resultMap.put("page",pageUt);
		resultMap.put("paging", pageUt);
		
		return total;
	}
	
	public List<FreeBoardVo> mainList(Map<String, Object> resultMap) {
		
		return freeBoardDao.mainList(resultMap);
	}
	
	public Map<String, Object> detailBoard(int num) {
		 
		return freeBoardDao.detailBoard(num);
	}
	
	public void insertBoard(Map<String, Object> list) {
		 
		freeBoardDao.insertBoard(list);
	}
	
	public void updateBoard(Map<String, Object> list) {
		 
		freeBoardDao.updateBoard(list);
	}
	
	public int deleteBoard(int num) {
		 
		return freeBoardDao.deleteBoard(num);
	}
}
