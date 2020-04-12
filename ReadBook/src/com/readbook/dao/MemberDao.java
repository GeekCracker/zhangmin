package com.readbook.dao;

import java.util.List;

import com.readbook.entity.Member;

public interface MemberDao {

	/**
	 * 添加会员
	 * @param member 传入需要添加的会员
	 */
	Long save(Member member);
	
	/**
	 * 根据ID删除会员
	 * @param id 会员ID
	 */
	void deleteById(Long id);
	
	/**
	 * 根据ID修改会员
	 * @param member 传入需要修改的会员
	 */
	void updateById(Member member);
	
	/**
	 * 根据ID获取会员
	 * @param id 传入会员ID
	 * @return 返回会员信息
	 */
	Member queryById(Long id);
	
	/**
	 * 获取所有会员
	 * @return 返回所有会员
	 */
	List<Member> selectAll();
	
	/**
	 * 查询数据总数
	 * @param sql 传入sql语句
	 * @param objs 传入查询条件
	 * @return 返回数据总数
	 */
	Long selectTotal(String sql,Object... objs);
	
	/**
	 * 获取会员分页数据
	 * @param sql 传入sql
	 * @param objs 传入查询条件
	 * @return 返回会员分页数据
	 */
	List<Member> selectPageData(String sql,Object... objs);
}
