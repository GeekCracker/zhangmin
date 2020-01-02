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
			//��������
			Class.forName(driver);
			//��������
			connection = DriverManager.getConnection(url,username,password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection ;
	}
	
	/**
	 * ��ȡ���ݿ����ݵķ���
	 * @param sql ����һ��sql���
	 * @param objects ����һ�����в����Ķ�̬����
	 * @return ���ز�ѯ�������ݽ������
	 */
	public static List<Map<String,Object>> doQuery(String sql,Object...objects){
		//����һ��������ݿ����ݵ�list��������
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		//����һ��map��ֵ��ӳ��
		Map<String,Object> map = null;
		//����һ�����ݿ�����
		Connection connection = null;
		//����һ��sql���Ĵ���ʽ����
		PreparedStatement preparedStatement = null;
		//����һ�����������
		ResultSet resultSet = null;
		//����һ�������Ԫ���ݶ���
		ResultSetMetaData resultSetMetaData = null;
		
		try {
			//��ȡ����
			connection = getConnection ();
			//��ȡ����sql���Ķ���
			preparedStatement = connection.prepareStatement(sql);
			//��sql�����ע�봫�����Ķ�̬����
			for(int i = 1;i<=objects.length;i++){
				preparedStatement.setObject(i, objects[i-1]);
			}
			//ִ��sql����ȡ���ݽ����
			resultSet = preparedStatement.executeQuery();
			//ͨ�����ݽ���������ȡԪ���ݶ���
			resultSetMetaData = resultSet.getMetaData();
			//��ȡ���ݿ�������
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
	 * �������ݿ�ķ���
	 * @param sql ����һ��sql���
	 * @param objects ����һ�����ж�̬����������
	 * @return �����Ƿ���³ɹ�
	 */
	public static int doUpdate(String sql,Object...objects){
		//����һ�����ݿ�����
		Connection connection = null;
		//����һ������sql��䷽ʽ�Ķ���
		PreparedStatement preparedStatement = null;
		try {
			//��ȡ���ݿ�����
			connection = getConnection();
			//��ȡԤ����SQL����
			preparedStatement=connection.prepareStatement(sql);
			//��sql�����ע�붯̬����
			for(int i = 0;i<objects.length;i++){
				preparedStatement.setObject(i+1,objects[i]);
			}
			//����sql���,������Ӱ�������
			return preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			close(connection,preparedStatement,null);
		}
		return 0;
	}
	
	/**
	 * ������ݼ�¼�ķ���
	 * @param sql ����һ��sql���
	 * @param objects ����һ�����ж�̬����������
	 * @return ��������ID
	 */
	public static long doSave(String sql,Object...objects){
		//����һ�����ݿ�����
		Connection connection = null;
		//����һ������sql��䷽ʽ�Ķ���
		PreparedStatement preparedStatement = null;
		try {
			//��ȡ���ݿ�����
			connection = getConnection();
			//��ȡԤ����SQL����
			preparedStatement=connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			//��sql�����ע�붯̬����
			for(int i = 0;i<objects.length;i++){
				preparedStatement.setObject(i+1,objects[i]);
			}
			//����sql���,������Ӱ�������
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
	 * �ر����ݿ�ķ���
	 * @param connection ����һ�����ݿ�����
	 * @param statement ����һ��sql��䴦�����
	 * @param resultSet ����һ�����ݽ��������
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
