package com.web.freeboard.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.web.freeboard.vo.FreeBoardVo;

@Repository
public class FreeBoardDao {
	@Autowired SqlSessionTemplate sqlSessionTemplate;
	
	public int countBoard(Map<String, Object> resultMap){

		return sqlSessionTemplate.selectOne("freeMapper.countBoard",resultMap);
	}
	
	public List<FreeBoardVo> mainList(Map<String, Object> resultMap){

		return sqlSessionTemplate.selectList("freeMapper.mainList",resultMap);
	}
	
	public void insertBoard(Map<String, Object> list){

		sqlSessionTemplate.insert("freeMapper.insertBoard",list);
	}
	
	public void updateBoard(Map<String, Object> list){

		sqlSessionTemplate.update("freeMapper.updateBoard",list);
	}
	
	public int deleteBoard(int num){

		return sqlSessionTemplate.delete("freeMapper.deleteBoard",num);
	}
	
	public Map<String, Object> detailBoard(int num){

		return sqlSessionTemplate.selectOne("freeMapper.detailBoard",num);
	}
}
