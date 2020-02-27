package com.web.freeboard.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class FreeBoardDao {
	@Autowired SqlSessionTemplate sqlSessionTemplate;
	
	public List<String> freeBoardList(){
		return sqlSessionTemplate.selectList("freeMapper.freeBoardList");
	}
}
