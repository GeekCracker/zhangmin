package com.readbook.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBCUtils {

	private static final String driver = "com.mysql.jdbc.Driver";
	private static final String url="jdbc:mysql://111.231.111.161:3306/read_book?useUnicode=true&characterEncoding=utf8&autoReconnect=true&useSSL=true";
	private static final String username = "zhangsan";
	private static final String password = "zhangsan666";
	
	private static Connection getConnection(){
		Connection connection = null;
		try {
			//加载驱动
			Class.forName(driver);
			//创建连接
			connection = DriverManager.getConnection(url,username,password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection ;
	}
	
	/**
	 * 获取数据库数据的方法
	 * @param sql 传入一个sql语句
	 * @param objects 传入一个含有参数的动态数组
	 * @return 返回查询到的数据结果集合
	 */
	public static List<Map<String,Object>> doQuery(String sql,Object...objects){
		//创建一个存放数据库数据的list集合容器
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		//声明一个map键值对映射
		Map<String,Object> map = null;
		//声明一个数据库连接
		Connection connection = null;
		//声明一个sql语句的处理方式对象
		PreparedStatement preparedStatement = null;
		//声明一个结果集对象
		ResultSet resultSet = null;
		//声明一个结果集元数据对象
		ResultSetMetaData resultSetMetaData = null;
		
		try {
			//获取连接
			connection = getConnection ();
			//获取处理sql语句的对象
			preparedStatement = connection.prepareStatement(sql);
			//向sql语句中注入传进来的动态参数
			for(int i = 1;i<=objects.length;i++){
				preparedStatement.setObject(i, objects[i-1]);
			}
			//执行sql语句获取数据结果集
			resultSet = preparedStatement.executeQuery();
			//通过数据结果集对象获取元数据对象
			resultSetMetaData = resultSet.getMetaData();
			//获取数据库表的列数
			int cols = resultSetMetaData.getColumnCount();
			while(resultSet.next()){
				map = new HashMap<String,Object>();
				for(int i = 1;i<=cols;i++){
					map.put(resultSetMetaData.getColumnLabel(i), resultSet.getObject(i));
				}
				list.add(map);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(connection,preparedStatement,resultSet);
		}
		return list;
	}
	/**
	 * 更新数据库的方法
	 * @param sql 传入一个sql语句
	 * @param objects 传入一个含有动态参数的数据
	 * @return 返回是否更新成功
	 */
	public static int doUpdate(String sql,Object...objects){
		//声明一个数据库连接
		Connection connection = null;
		//声明一个处理sql语句方式的对象
		PreparedStatement preparedStatement = null;
		try {
			//获取数据库连接
			connection = getConnection();
			//获取预处理SQL对象
			preparedStatement=connection.prepareStatement(sql);
			//向sql语句中注入动态参数
			for(int i = 0;i<objects.length;i++){
				preparedStatement.setObject(i+1,objects[i]);
			}
			//处理sql语句,返回受影响的行数
			return preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			close(connection,preparedStatement,null);
		}
		return 0;
	}
	
	/**
	 * 添加数据记录的方法
	 * @param sql 传入一个sql语句
	 * @param objects 传入一个含有动态参数的数据
	 * @return 返回主键ID
	 */
	public static long doSave(String sql,Object...objects){
		//声明一个数据库连接
		Connection connection = null;
		//声明一个处理sql语句方式的对象
		PreparedStatement preparedStatement = null;
		try {
			//获取数据库连接
			connection = getConnection();
			//获取预处理SQL对象
			preparedStatement=connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			//向sql语句中注入动态参数
			for(int i = 0;i<objects.length;i++){
				preparedStatement.setObject(i+1,objects[i]);
			}
			//处理sql语句,返回受影响的行数
			preparedStatement.executeUpdate();
			ResultSet resultSet = preparedStatement.getGeneratedKeys();
			if(resultSet.next()){
				return resultSet.getLong(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			close(connection,preparedStatement,null);
		}
		return 0;
	}
	
	/**
	 * 关闭数据库的方法
	 * @param connection 传入一个数据库连接
	 * @param statement 传入一个sql语句处理对象
	 * @param resultSet 传入一个数据结果集对象
	 */
	private static void close(Connection connection,Statement statement,ResultSet resultSet){
		try {
			if(resultSet != null){
				resultSet.close();
			}
			if(statement != null){
				statement.close();
			}
			if(connection != null){
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
