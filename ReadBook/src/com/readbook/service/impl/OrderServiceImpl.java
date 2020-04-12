package com.readbook.service.impl;

import java.util.LinkedList;
import java.util.List;

import com.readbook.dao.OrderDao;
import com.readbook.dao.impl.OrderDaoImpl;
import com.readbook.entity.Order;
import com.readbook.page.OrderPage;
import com.readbook.response.ResponseResult;
import com.readbook.service.OrderService;

public class OrderServiceImpl implements OrderService{

	private OrderDao orderDao = new OrderDaoImpl();
	
	@Override
	public Long save(Order order) {
		return orderDao.save(order);
	}

	@Override
	public void deleteById(Long id) {
		orderDao.deleteById(id);
	}

	@Override
	public void updateById(Order order) {
		orderDao.updateById(order);
	}

	@Override
	public Order queryById(Long id) {
		return orderDao.queryById(id);
	}

	@Override
	public ResponseResult queryPageData(OrderPage page) {
		//声明查询记录总数的sql
		String totalSQL = "select count(*) as count from t_order ";
		//声明查询记录的sql
		String selectSQL = "select "+selectFields()+" from t_order ";
		//组装where条件
		StringBuilder whereSQL = new StringBuilder("where 1=1 ");
		List<Object> args = new LinkedList<Object>();
		String orderCode = page.getOrderCode();
		if(orderCode != null && !"".equals(orderCode)){
			whereSQL.append(" and order_code like ? ");
			args.add("%"+orderCode+"%");
		}
		Long shopId = page.getShopId();
		if(shopId != null && shopId > 0){
			whereSQL.append(" and shop_id = ? ");
			args.add(shopId);
		}
		Long bookCaseId = page.getBookCaseId();
		if(bookCaseId != null && bookCaseId > 0){
			whereSQL.append(" and book_case_id = ? ");
			args.add(bookCaseId);
		}
		String bookNumber = page.getBookNumber();
		if(bookNumber != null && !"".equals(bookNumber)){
			whereSQL.append(" and book_number like ? ");
			args.add("%"+bookNumber+"%");
		}
		String bookName = page.getBookName();
		if(bookName != null && !"".equals(bookName)){
			whereSQL.append(" and book_name like ? ");
			args.add("%"+bookName+"%");
		}
		String memberCode = page.getMemberCode();
		if(memberCode != null && !"".equals(memberCode)){
			whereSQL.append(" and member_code like ? ");
			args.add("%"+memberCode+"%");
		}
		String phone = page.getPhone();
		if(phone != null && !"".equals(phone)){
			whereSQL.append(" and phone like ? ");
			args.add("%"+phone+"%");
		}
		//组装limit
		String limit = " limit " + page.getStartIndex() + "," + page.getLimit();
		//查询数据总数
		Long total = orderDao.selectTotal(totalSQL + whereSQL.toString(),args.toArray());
		//查询数据记录
		List<Order> datas = orderDao.selectPageData(selectSQL + whereSQL.toString() + limit,args.toArray());
		return ResponseResult.ok(datas,total);
	}
	
	private String selectFields(){
		return "id,order_code orderCode,member_id memberId,member_code memberCode,shop_id shopId,shop_name shopName,book_case_id bookCaseId,book_case_number bookCaseNumber,book_id bookId,book_number bookNumber,book_name bookName,author,price,pay_amount payAmount,pay_time payTime,state,create_time createTime";
	}
}
