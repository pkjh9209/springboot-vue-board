package com.web.freeboard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.web.freeboard.service.FreeBoardService;

@Controller
public class FreeBoardController {
	
	@Autowired
	FreeBoardService freeBoardService;
	
	@RequestMapping(value = "/list")
	public String freeBoardList() {
		System.out.println(freeBoardService.freeBoardList());
		return "sibal";
	}
	
}
