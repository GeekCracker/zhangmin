package com.readbook.dao;

import java.util.List;

import com.readbook.entity.Member;

public interface MemberDao {

	/**
	 * ��ӻ�Ա
	 * @param member ������Ҫ��ӵĻ�Ա
	 */
	Long save(Member member);
	
	/**
	 * ����IDɾ����Ա
	 * @param id ��ԱID
	 */
	void deleteById(Long id);
	
	/**
	 * ����ID�޸Ļ�Ա
	 * @param member ������Ҫ�޸ĵĻ�Ա
	 */
	void updateById(Member member);
	
	/**
	 * ����ID��ȡ��Ա
	 * @param id �����ԱID
	 * @return ���ػ�Ա��Ϣ
	 */
	Member queryById(Long id);
	
	/**
	 * ��ȡ���л�Ա
	 * @return �������л�Ա
	 */
	List<Member> selectAll();
	
	/**
	 * ��ѯ��������
	 * @param sql ����sql���
	 * @param objs �����ѯ����
	 * @return ������������
	 */
	Long selectTotal(String sql,Object... objs);
	
	/**
	 * ��ȡ��Ա��ҳ����
	 * @param sql ����sql
	 * @param objs �����ѯ����
	 * @return ���ػ�Ա��ҳ����
	 */
	List<Member> selectPageData(String sql,Object... objs);
}
