package com.readbook.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.readbook.dao.BookCaseDao;
import com.readbook.entity.BookCase;
import com.readbook.utils.BeanUtil;
import com.readbook.utils.JDBCUtils;

/**
 * 书柜DAO实现类
 * @author 张敏
 */
public class BookCaseDaoImpl implements BookCaseDao {

	@Override
	public Long addBookCase(BookCase bookCase) {
		String sql = "insert into t_book_case(number,shop_id) value(?,?);";
		return JDBCUtils.doSave(sql,bookCase.getNumber(), bookCase.getShopId());
	}

	@Override
	public void deleteById(Long id) {
		String sql = "delete from t_book_case where id = ?;";
		JDBCUtils.doUpdate(sql, id);
	}

	@Override
	public void updateById(BookCase bookCase) {
		StringBuilder sql = new StringBuilder("update t_book_case set id = ?");
		List<Object> args = new ArrayList<Object>();
		Long id = bookCase.getId();
		args.add(id);
		String number = bookCase.getNumber();
		if(number != null && !"".equals(number.trim())){
			sql.append(",number = ?");
			args.add(number);
		}
		Long shopId = bookCase.getShopId();
		if(shopId != null && shopId > 0){
			sql.append(",shop_id = ?");
			args.add(shopId);
		}
		sql.append(" where id = ?;");
		args.add(id);
		JDBCUtils.doUpdate(sql.toString(), args.toArray());
	}

	@Override
	public BookCase selectById(Long id) {
		String sql = "select id,number,shop_id as shopId,shop_name as shopName from v_book_case where id = ?;";
		List<Map<String,Object>> results = JDBCUtils.doQuery(sql, id);
		if(results != null && !results.isEmpty()){
			return BeanUtil.populate(results.get(0), BookCase.class);
		}
		return null;
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
	public List<BookCase> selectPageData(String sql, Object... objs) {
		return BeanUtil.populate(JDBCUtils.doQuery(sql, objs), BookCase.class);
	}

	@Override
	public List<BookCase> selectData(String sql, Object... objs) {
		return BeanUtil.populate(JDBCUtils.doQuery(sql, objs), BookCase.class);
	}
}
