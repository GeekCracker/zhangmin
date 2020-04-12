package com.readbook.service;

import com.readbook.entity.Member;
import com.readbook.page.MemberPage;
import com.readbook.response.ResponseResult;

public interface MemberService {

	/**
	 * 添加会员
	 * @param book 传入需要添加的会员
	 * @return 返回主键ID
	 */
	Long save(Member member);
	
	/**
	 * 根据ID删除会员
	 * @param id 传入会员ID
	 */
	void deleteById(Long id);

	/**
	 * 根据ID修改会员
	 * @param book 传入需要修改的会员
	 */
	void updateById(Member member);
	
	/**
	 * 根据ID查询会员
	 * @param id 传入会员ID
	 * @return 返回会员信息
	 */
	Member queryById(Long id);

	/**
	 * 获取会员分页数据
	 * @param page 传入分页条件参数
	 * @return 返回分页数据
	 */
	ResponseResult queryPageData(MemberPage page);
}
