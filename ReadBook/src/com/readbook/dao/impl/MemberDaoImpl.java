package com.readbook.dao.impl;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.readbook.dao.MemberDao;
import com.readbook.entity.Member;
import com.readbook.utils.BeanUtil;
import com.readbook.utils.JDBCUtils;

public class MemberDaoImpl implements MemberDao{

	@Override
	public Long save(Member member) {
		String sql = "insert into t_member(member_code,name,nick_name,phone,password,sex,age,head_image,create_time) values (?,?,?,?,?,?,?,?,?)";
		long id = JDBCUtils.doSave(sql,member.getMemberCode(),member.getNickName(),member.getPhone(),member.getPassword(),member.getSex(),member.getAge(),member.getHeadImage(),member.getCreateTime());;
		member.setId(id);
		return id;
	}

	@Override
	public void deleteById(Long id) {
		String sql = "delete from t_member where id = ?;";
		JDBCUtils.doUpdate(sql, id);
	}

	@Override
	public void updateById(Member member) {
		StringBuilder sql = new StringBuilder("update t_member set id = ? ");
		List<Object> args = new LinkedList<Object>();
		args.add(member.getId());
		String memberCode = member.getMemberCode();
		if(memberCode != null && !"".equals(memberCode)){
			sql.append(",member_code = ?");
			args.add(memberCode);
		}
		String name = member.getName();
		if(name != null && !"".equals(name)){
			sql.append(",name = ?");
			args.add(name);
		}
		String nickName = member.getNickName();
		if(nickName != null && !"".equals(nickName)){
			sql.append(",nick_name = ?");
			args.add(nickName);
		}
		String phone = member.getPhone();
		if(phone != null && !"".equals(phone)){
			sql.append(",phone = ?");
			args.add(phone);
		}
		String password = member.getPassword();
		if(password != null && !"".equals(password)){
			sql.append(",password = ?");
			args.add(password);
		}
		String sex = member.getSex();
		if(sex != null && !"".equals(sex)){
			sql.append(",sex = ?");
			args.add(sex);
		}
		Integer age = member.getAge();
		if(age != null && age > 0){
			sql.append(",age = ?");
			args.add(age);
		}
		String headImage = member.getHeadImage();
		if(headImage != null && !"".equals(headImage)){
			sql.append(",head_image = ?");
			args.add(headImage);
		}
		Date createTime = member.getCreateTime();
		if(createTime != null){
			sql.append(",create_time = ?");
			args.add(createTime);
		}
		sql.append(" where id = ?");
		args.add(member.getId());
		JDBCUtils.doUpdate(sql.toString(), args.toArray());
	}

	
	@Override
	public Member queryById(Long id) {
		String sql = "select id,member_code memberCode,name,nick_name nickName,phone,password,sex,age,head_image headImage,create_time createTime from t_member where id = ?";
		List<Map<String,Object>> results = JDBCUtils.doQuery(sql, id);
		if(results != null && !results.isEmpty()){
			return BeanUtil.populate(results.get(0), Member.class);
		}
		return null;
	}

	@Override
	public List<Member> selectAll() {
		String sql = "select id,member_code memberCode,name,nick_name nickName,phone,password,sex,age,head_image headImage,create_time createTime from t_member";
		return BeanUtil.populate(JDBCUtils.doQuery(sql),Member.class);
	}

	@Override
	public Long selectTotal(String sql, Object... objs) {
		List<Map<String,Object>> results = JDBCUtils.doQuery(sql,objs);
		if(results != null && !results.isEmpty()){
			Map<String,Object> map = results.get(0);
			Object count = map.get("count");
			if(count != null){
				return (Long)map.get("count") ;
			}
		}
		return 0l;
	}

	@Override
	public List<Member> selectPageData(String sql, Object... objs) {
		List<Map<String,Object>> results = JDBCUtils.doQuery(sql, objs);
		return BeanUtil.populate(results, Member.class);
	}
}
