package com.readbook.service.impl;

import java.util.LinkedList;
import java.util.List;

import com.readbook.dao.ShopDao;
import com.readbook.dao.impl.ShopDaoImpl;
import com.readbook.entity.Shop;
import com.readbook.page.ShopPage;
import com.readbook.response.ResponseResult;
import com.readbook.service.ShopService;

/**
 * �ŵ�Serviceʵ����
 * @author ����
 */
public class ShopServiceImpl implements ShopService{

	/**�ŵ�DAO*/
	private ShopDao shopDao = new ShopDaoImpl();
	
	@Override
	public void save(Shop shop) {
		shopDao.addShop(shop);
	}

	@Override
	public void deleteById(Long id) {
		shopDao.deleteById(id);
	}

	@Override
	public void updateById(Shop shop) {
		shopDao.updateById(shop);
	}

	@Override
	public Shop queryById(Long id) {
		return shopDao.selectById(id);
	}

	@Override
	public List<Shop> queryAll() {
		return shopDao.selectAll();
	}

	@Override
	public ResponseResult queryPageData(ShopPage page) {
		//������ѯ��¼������sql
		String totalSQL = "select count(*) as count from t_shop ";
		//������ѯ��¼��sql
		String selectSQL = "select "+selectFields()+" from t_shop ";
		//��װwhere����
		StringBuilder whereSQL = new StringBuilder("where 1=1 ");
		List<Object> args = new LinkedList<Object>();
		String shopName = page.getShopName();
		if(shopName != null && !"".equals(shopName.trim())){
			whereSQL.append(" and shop_name = ? ");
			args.add(shopName);
		}
		//��װlimit
		String limit = " limit " + page.getStartIndex() + "," + page.getLimit();
		//��ѯ��������
		Long total = shopDao.selectTotal(totalSQL + whereSQL.toString(),args.toArray());
		//��ѯ���ݼ�¼
		List<Shop> datas = shopDao.selectPageData(selectSQL + whereSQL.toString() + limit,args.toArray());
		return ResponseResult.ok(datas,total);
	}
	
	private String selectFields(){
		return "id,shop_name as shopName,address";
	}
}
