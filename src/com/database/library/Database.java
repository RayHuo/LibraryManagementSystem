package com.database.library;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.*;

/*
 * ���ݿ��࣬
 * �������ӱ����ϵ�mysql�е����ݿ⣬����mysql�е����ݿ������ɾ�Ĳ�Ĳ�����
 * ������Ŀ���������ݿ���Ψһ�ģ���������д�ɵ���ģʽ��
 */
public class Database {
	// Message for connecting database "Students" in mysql.
	// It is a driver name, can find it in "mysql-connector-java-5.1.18-bin.jar"
	private final String driverName = "com.mysql.jdbc.Driver";
	// localhost is the host name of own computer, the same as 127.0.0.1, and 3306 is port for mysql, libraryTest is the database name.
	private final String mysqlDB = "jdbc:mysql://localhost:3306/libraryTest";
	private final String mysqlUserName = "root";	// user name for mysql in this computer
	private final String mysqlPassword = "1";		// password for mysql in this computer
	
	private Connection connection = null;
	private PreparedStatement pstmt = null;

	// ʹ���ڲ�����ʵ�ֵ�����ʵ����lazy�����̰߳�ȫ��
	private static class SingletonHolder {
		private static Database dbInstance = new Database();
	}
	
	private Database() {
		// ��Ҫ�õ������Զ��Ѿ���ʼ���ˣ�����Ͳ�������ʲô������
	}
	
	public static Database instance() {
		return SingletonHolder.dbInstance;
	}
	
	public void connectDB() {
		try {
			Class.forName(driverName).newInstance();
			connection = DriverManager.getConnection(mysqlDB, mysqlUserName, mysqlPassword);
			System.out.println("Connection Done!");
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Connection failed : " + e.getMessage());
		}
	}
}
