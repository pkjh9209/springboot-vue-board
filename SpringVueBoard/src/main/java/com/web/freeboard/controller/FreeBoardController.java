package com.web.freeboard.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.web.freeboard.service.FreeBoardService;

@RestController
public class FreeBoardController {
	
	@Autowired
	FreeBoardService freeBoardService;
	
	@RequestMapping(value = "list/{title}", method = RequestMethod.GET)
	public Map<String, Object> get( @PathVariable("title") String title) {
		
		Map<String, Object> resultMap = new HashMap<String,Object>();
		resultMap.put("list", freeBoardService.freeBoardList(title));
		
		return resultMap;
	}
	
} 