package com.readbook.service.impl;

import java.util.LinkedList;
import java.util.List;

import com.readbook.dao.MemberDao;
import com.readbook.dao.impl.MemberDaoImpl;
import com.readbook.entity.Member;
import com.readbook.page.MemberPage;
import com.readbook.response.ResponseResult;
import com.readbook.service.MemberService;

public class MemberServiceImpl implements MemberService{

	private MemberDao memberDao = new MemberDaoImpl();
	
	
	@Override
	public Long save(Member member) {
		return memberDao.save(member);
	}

	@Override
	public void deleteById(Long id) {
		memberDao.deleteById(id);
	}

	@Override
	public void updateById(Member member) {
		memberDao.updateById(member);
	}

	@Override
	public Member queryById(Long id) {
		return memberDao.queryById(id);
	}

	@Override
	public ResponseResult queryPageData(MemberPage page) {
		//������ѯ��¼������sql
		String totalSQL = "select count(*) as count from t_member ";
		//������ѯ��¼��sql
		String selectSQL = "select "+selectFields()+" from t_member ";
		//��װwhere����
		StringBuilder whereSQL = new StringBuilder("where 1=1 ");
		List<Object> args = new LinkedList<Object>();
		String memberCode = page.getMemberCode();
		if(memberCode != null && !"".equals(memberCode.trim())){
			whereSQL.append(" and member_code like ? ");
			args.add("%"+memberCode+"%");
		}
		String name = page.getName();
		if(name != null && !"".equals(name)){
			whereSQL.append(" and name like ? ");
			args.add("%"+name+"%");
		}
		String nickName = page.getNickName();
		if(nickName != null && !"".equals(nickName)){
			whereSQL.append(" and nick_name like ? ");
			args.add("%"+nickName+"%");
		}
		String phone = page.getPhone();
		if(phone != null && !"".equals(phone)){
			whereSQL.append(" and phone like ? ");
			args.add("%"+phone+"%");
		}
		//��װlimit
		String limit = " limit " + page.getStartIndex() + "," + page.getLimit();
		//��ѯ��������
		Long total = memberDao.selectTotal(totalSQL + whereSQL.toString(),args.toArray());
		//��ѯ���ݼ�¼
		List<Member> datas = memberDao.selectPageData(selectSQL + whereSQL.toString() + limit,args.toArray());
		return ResponseResult.ok(datas,total);
	}
	
	private String selectFields(){
		return "id,member_code memberCode,name,nick_name nickName,phone,password,sex,age,head_image headImage,create_time createTime";
	}
}
