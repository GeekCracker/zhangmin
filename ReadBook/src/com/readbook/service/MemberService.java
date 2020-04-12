package com.readbook.service;

import com.readbook.entity.Member;
import com.readbook.page.MemberPage;
import com.readbook.response.ResponseResult;

public interface MemberService {

	/**
	 * ��ӻ�Ա
	 * @param book ������Ҫ��ӵĻ�Ա
	 * @return ��������ID
	 */
	Long save(Member member);
	
	/**
	 * ����IDɾ����Ա
	 * @param id �����ԱID
	 */
	void deleteById(Long id);

	/**
	 * ����ID�޸Ļ�Ա
	 * @param book ������Ҫ�޸ĵĻ�Ա
	 */
	void updateById(Member member);
	
	/**
	 * ����ID��ѯ��Ա
	 * @param id �����ԱID
	 * @return ���ػ�Ա��Ϣ
	 */
	Member queryById(Long id);

	/**
	 * ��ȡ��Ա��ҳ����
	 * @param page �����ҳ��������
	 * @return ���ط�ҳ����
	 */
	ResponseResult queryPageData(MemberPage page);
}
