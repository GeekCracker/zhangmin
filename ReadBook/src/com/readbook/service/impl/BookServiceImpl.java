package com.readbook.service.impl;

import java.util.LinkedList;
import java.util.List;

import com.readbook.dao.BookDao;
import com.readbook.dao.impl.BookDaoImpl;
import com.readbook.entity.Book;
import com.readbook.page.BookPage;
import com.readbook.response.ResponseResult;
import com.readbook.service.BookService;

/**
 * �鼮Serviceʵ��
 * @author ����
 */
public class BookServiceImpl implements BookService{

	private BookDao bookDao = new BookDaoImpl();
	
	@Override
	public Long save(Book book) {
		return bookDao.save(book);
	}

	@Override
	public void deleteById(Long id) {
		bookDao.deleteById(id);
	}

	@Override
	public void updateById(Book book) {
		bookDao.updateById(book);
	}

	@Override
	public Book queryById(Long id) {
		return bookDao.queryById(id);
	}

	@Override
	public ResponseResult queryPageData(BookPage page) {
		//������ѯ��¼������sql
		String totalSQL = "select count(*) as count from t_book ";
		//������ѯ��¼��sql
		String selectSQL = "select "+selectFields()+" from v_book ";
		
		//��װwhere����
		StringBuilder whereSQL = new StringBuilder("where 1=1 ");
		List<Object> args = new LinkedList<Object>();
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
		String number = page.getNumber();
		if(number != null && !"".equals(number.trim())){
			whereSQL.append(" and number = ? ");
			args.add(number);
		}
		String bookName = page.getBookName();
		if(bookName != null && !"".equals(bookName.trim())){
			whereSQL.append(" and book_name like ? ");
			args.add("%"+bookName+"%");
		}
		String author = page.getAuthor();
		if(author != null && !"".equals(author.trim())){
			whereSQL.append(" and author = ? ");
			args.add(author);
		}
		//��װlimit
		String limit = " limit " + page.getStartIndex() + "," + page.getLimit();
		//��ѯ��������
		Long total = bookDao.selectTotal(totalSQL + whereSQL.toString(),args.toArray());
		//��ѯ���ݼ�¼
		List<Book> datas = bookDao.selectPageData(selectSQL + whereSQL.toString() + limit, args.toArray());
		return ResponseResult.ok(datas,total);
	}
	
	private String selectFields(){
		return "id,shop_id as shopId,shop_name as shopName,book_case_id as bookCaseId,book_case_number as bookCaseNumber,book_name as bookName,number,author,price";
	}
}
