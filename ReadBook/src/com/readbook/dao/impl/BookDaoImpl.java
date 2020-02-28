package com.readbook.dao.impl;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.readbook.dao.BookDao;
import com.readbook.entity.Book;
import com.readbook.utils.BeanUtil;
import com.readbook.utils.JDBCUtils;

/**
 * 书籍dao实现
 * @author 张敏
 */
public class BookDaoImpl implements BookDao{

	@Override
	public Long save(Book book) {
		String sql = "insert into t_book(number,book_name,author,shop_id,book_case_id,price) value(?,?,?,?,?);";
		return JDBCUtils.doSave(sql,book.getNumber(),book.getBookName(),book.getAuthor(),book.getShopId(),book.getBookCaseId(),book.getPrice());
	}

	@Override
	public void deleteById(Long id) {
		String sql = "delete from t_book where id = ?;";
		JDBCUtils.doUpdate(sql, id);
	}

	@Override
	public void updateById(Book book) {
		StringBuilder sql = new StringBuilder("update t_book set id = ? ");
		List<Object> args = new LinkedList<Object>();
		args.add(book.getId());
		String number = book.getNumber();
		if(number != null && !"".equals(number)){
			sql.append(",number");
			args.add(number);
		}
		String bookName = book.getBookName();
		if(bookName != null && !"".equals(bookName)){
			sql.append(",book_name = ?");
			args.add(bookName);
		}
		String author = book.getAuthor();
		if(author != null && !"".equals(author)){
			sql.append(",author = ?");
			args.add(author);
		}
		Long shopId = book.getShopId();
		if(shopId != null && shopId > 0){
			sql.append(",shop_id = ?");
			args.add(shopId);
		}
		Long bookCaseId = book.getBookCaseId();
		if(bookCaseId != null && bookCaseId > 0){
			sql.append(",book_case_id = ?");
			args.add(bookCaseId);
		}
		BigDecimal price = book.getPrice();
		if(price != null){
			sql.append(",price = ?");
			args.add(price);
		}
		sql.append(" where id = ?");
		args.add(book.getId());
		JDBCUtils.doUpdate(sql.toString(), args.toArray());
	}

	@Override
	public Book queryById(Long id) {
		String sql = "select id,number,book_name as bookName,author,shop_id as shopId,shop_name as shopName,book_case_id as bookCaseId,price where id = ?;";
		List<Map<String,Object>> results = JDBCUtils.doQuery(sql, id);
		if(results != null && !results.isEmpty()){
			return BeanUtil.populate(results.get(0),Book.class);
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
	public List<Book> selectPageData(String sql,Object...objs) {
		List<Map<String,Object>> results = JDBCUtils.doQuery(sql, objs);
		return BeanUtil.populate(results, Book.class);
	}
}
