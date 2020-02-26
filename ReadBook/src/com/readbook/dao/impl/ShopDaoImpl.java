package com.readbook.dao.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.readbook.dao.ShopDao;
import com.readbook.entity.Shop;
import com.readbook.utils.BeanUtil;
import com.readbook.utils.JDBCUtils;

public class ShopDaoImpl implements ShopDao{

	@Override
	public Long addShop(Shop shop) {
		String sql = "insert into t_shop(shop_name,address) value(?,?);";
		return JDBCUtils.doSave(sql, shop.getShopName(),shop.getAddress());
	}

	@Override
	public void deleteById(Long id) {
		String sql = "delete from t_shop where id = ?;";
		JDBCUtils.doUpdate(sql, id);
	}

	@Override
	public void updateById(Shop shop) {
		StringBuilder sql = new StringBuilder("update t_shop set id = ? ");	
		List<Object> args = new LinkedList<Object>();
		args.add(shop.getId());
		String shopName = shop.getShopName();
		if(shopName != null && !"".equals(shopName.trim())){
			sql.append(",shop_name = ?");
			args.add(shopName);
		}
		String address = shop.getAddress();
		if(address != null && !"".equals(address.trim())){
			sql.append(",address = ?");
			args.add(address);
		}
		sql.append(" where id =?");
		args.add(shop.getId());
		JDBCUtils.doUpdate(sql.toString(),args.toArray());
	}

	@Override
	public Shop selectById(Long id) {
		String sql = "select id,shop_name as shopName,address from t_shop where id = ?;";
		List<Map<String,Object>> results = JDBCUtils.doQuery(sql, id);
		if(results != null && !results.isEmpty()){
			return BeanUtil.populate(results.get(0), Shop.class);
		}
		return null;
	}

	@Override
	public List<Shop> selectAll() {
		String sql = "select id,shop_name as shopName,address from t_shop";
		return BeanUtil.populate(JDBCUtils.doQuery(sql), Shop.class);
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
	public List<Shop> selectPageData(String sql, Object... objs) {
		return BeanUtil.populate(JDBCUtils.doQuery(sql, objs), Shop.class);
	}
}
