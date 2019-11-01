package com.biz.memo.mybatis.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.biz.memo.persistence.MemoDTO;

public interface MemoDao {
	
	public List<MemoDTO> selectAll();
	public MemoDTO findById(long id);
	public List<MemoDTO> findByAuth(String m_auth);
	public List<MemoDTO> findByDate(@Param("m_date1") String m_date1, @Param("m_date2") String m_date2);
	public List<MemoDTO> findBySubject(String m_subject);
	public List<MemoDTO> findByText(String m_text);
	public String maxId();
	
	public int insert(MemoDTO memoDTO);
	public int update(MemoDTO memoDTO);
	public int delete(long id);

}
