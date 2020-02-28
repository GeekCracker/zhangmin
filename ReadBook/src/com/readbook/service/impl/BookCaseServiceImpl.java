package com.readbook.service.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.readbook.dao.BookCaseDao;
import com.readbook.dao.impl.BookCaseDaoImpl;
import com.readbook.entity.BookCase;
import com.readbook.page.BookCasePage;
import com.readbook.response.ResponseResult;
import com.readbook.service.BookCaseService;

/**
 * ���Serviceʵ��
 * @author ����
 *
 */
public class BookCaseServiceImpl implements BookCaseService{

	private BookCaseDao bookCaseDao = new BookCaseDaoImpl();
	
	@Override
	public Long save(BookCase bookCase) {
		return bookCaseDao.addBookCase(bookCase);
	}

	@Override
	public void deleteById(Long id) {
		bookCaseDao.deleteById(id);
	}

	@Override
	public void updateById(BookCase bookCase) {
		bookCaseDao.updateById(bookCase);
	}

	@Override
	public BookCase queryById(Long id) {
		return bookCaseDao.selectById(id);
	}

	@Override
	public ResponseResult queryPageData(BookCasePage page) {
		//������ѯ��¼������sql
		String totalSQL = "select count(*) as count from t_book_case ";
		//������ѯ��¼��sql
		String selectSQL = "select "+selectFields()+" from v_book_case ";
		
		//��װwhere����
		StringBuilder whereSQL = new StringBuilder("where 1=1 ");
		List<Object> args = new LinkedList<Object>();
		String number = page.getNumber();
		if(number != null && !"".equals(number.trim())){
			whereSQL.append(" and number like ? ");
			args.add(number+"%");
		}
		Long shopId = page.getShopId();
		if(shopId != null && shopId > 0){
			whereSQL.append(" and shop_id = ? ");
			args.add(shopId);
		}
		//��װlimit
		String limit = " limit " + page.getStartIndex() + "," + page.getLimit();
		//��ѯ��������
		Long total = bookCaseDao.selectTotal(totalSQL + whereSQL.toString(),args.toArray());
		//��ѯ���ݼ�¼
		List<BookCase> datas = bookCaseDao.selectPageData(selectSQL + whereSQL.toString() + limit, args.toArray());
		return ResponseResult.ok(datas,total);
	}

	@Override
	public List<BookCase> queryData(Map<String, Object> param) {
		StringBuilder sql = new  StringBuilder();
		sql.append("select ");
		sql.append(selectFields());
		sql.append(" from v_book_case where 1=1 ");
		
		List<Object> args = new LinkedList<Object>();
		if(param != null){
			if(param.containsKey("shopId")){
				sql.append(" and shop_id = ? ");
				args.add(param.get("shopId"));
			}
		}
		return bookCaseDao.selectData(sql.toString(),args.toArray());
	}
	
	private String selectFields(){
		return "id,number,shop_id as shopId,shop_name as shopName";
	}
}
