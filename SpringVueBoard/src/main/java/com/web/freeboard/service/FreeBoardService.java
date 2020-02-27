package com.web.freeboard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.freeboard.dao.FreeBoardDao;

@Service
public class FreeBoardService {
	@Autowired
	private FreeBoardDao freeBoardDao;
	
	public List<String> freeBoardList() {
		 
		return freeBoardDao.freeBoardList();
	}
}
