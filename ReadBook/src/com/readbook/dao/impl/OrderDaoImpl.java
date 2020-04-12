package com.readbook.dao.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.readbook.dao.OrderDao;
import com.readbook.entity.Order;
import com.readbook.utils.BeanUtil;
import com.readbook.utils.JDBCUtils;

public class OrderDaoImpl implements OrderDao{

	@Override
	public Long save(Order order) {
		String sql = "insert into t_order(order_code,member_id,member_code,shop_id,shop_name,book_case_id,book_case_number,book_id,book_number,book_name,author,price,pay_amount,pay_time,state,create_time) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
		return JDBCUtils.doSave(sql, order.getOrderCode(),order.getMemberId(),order.getMemberCode(),order.getShopId(),order.getShopName(),order.getBookCaseId(),order.getBookCaseNumber(),order.getBookId(),order.getBookNumber(),order.getBookName(),order.getAuthor(),order.getPrice(),order.getPayAmount(),order.getPayTime(),order.getState(),order.getCreateTime());
	}

	@Override
	public void deleteById(Long id) {
		String sql = "delete from t_order where id = ?;";
		JDBCUtils.doUpdate(sql, id);
	}

	@Override
	public void updateById(Order order) {
		StringBuilder sql = new StringBuilder("update t_order set id = ? ");
		List<Object> args = new LinkedList<Object>();
		args.add(order.getId());
		String orderCode = order.getOrderCode();
		if(orderCode != null && !"".equals(orderCode)){
			sql.append(",order_code = ?");
			args.add(orderCode);
		}
		Long memberId = order.getMemberId();
		if(memberId != null && memberId > 0){
			sql.append(",member_id = ?");
			args.add(memberId);
		}
		String memberCode = order.getMemberCode();
		if(memberCode != null && !"".equals(memberCode)){
			sql.append(",member_code = ?");
			args.add(memberCode);
		}
		Long shopId = order.getShopId();
		if(shopId != null && shopId > 0){
			sql.append(",shop_id = ?");
			args.add(shopId);
		}
		String shopName = order.getShopName();
		if(shopName != null && !"".equals(shopName)){
			sql.append(",shop_name = ?");
			args.add(shopName);
		}
		Long bookCaseId = order.getBookCaseId();
		if(bookCaseId != null && bookCaseId > 0){
			sql.append(",book_case_id = ?");
			args.add(bookCaseId);
		}
		String bookCaseNumber = order.getBookCaseNumber();
		if(bookCaseNumber != null && !"".equals(bookCaseNumber)){
			sql.append(",book_case_number = ?");
			args.add(bookCaseNumber);
		}
		Long bookId = order.getBookId();
		if(bookId != null && bookId > 0){
			sql.append(",book_id = ?");
			args.add(bookId);
		}
		String bookNumber = order.getBookNumber();
		if(bookNumber != null && !"".equals(bookNumber)){
			sql.append(",book_number = ?");
			args.add(bookNumber);
		}
		String bookName = order.getBookName();
		if(bookName != null && !"".equals(bookName)){
			sql.append(",book_name = ?");
			args.add(bookName);
		}
		String author = order.getAuthor();
		if(author != null && !"".equals(author)){
			sql.append(",author = ?");
			args.add(author);
		}
		BigDecimal price = order.getPrice();
		if(price != null){
			sql.append(",price = ?");
			args.add(price);
		}
		BigDecimal payAmount = order.getPayAmount();
		if(payAmount != null){
			sql.append(",pay_amount = ?");
			args.add(payAmount);
		}
		Date payTime = order.getPayTime();
		if(payTime != null){
			sql.append(",pay_time = ?");
			args.add(payTime);
		}
		Integer state = order.getState();
		if(state != null){
			sql.append(",state = ?");
			args.add(state);
		}
		Date createTime = order.getCreateTime();
		if(createTime != null){
			sql.append(",create_time = ?");
			args.add(createTime);
		}
		sql.append(" where id = ?");
		args.add(order.getId());
		JDBCUtils.doUpdate(sql.toString(), args.toArray());
	}

	@Override
	public Order queryById(Long id) {
		String sql = "select order_code orderCode,member_id memberId,member_code memberCode,shop_id shopId,shop_name shopName,book_case_id bookCaseId,book_case_number bookCaseNumber,book_id bookId,book_number bookNumber,book_name bookName,author,price,pay_amount payAmount,pay_time payTime,state,create_time createTime from t_order where id = ?";
		List<Map<String,Object>> results = JDBCUtils.doQuery(sql, id);
		if(results != null && !results.isEmpty()){
			return BeanUtil.populate(results.get(0), Order.class);
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
	public List<Order> selectPageData(String sql, Object... objs) {
		List<Map<String,Object>> results = JDBCUtils.doQuery(sql, objs);
		return BeanUtil.populate(results, Order.class);
	}
	
}
