package com.database.library;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.*;

/*
 * 数据库类，
 * 用于连接本机上的mysql中的数据库，及对mysql中的数据库进行增删改查的操作，
 * 由于项目起来后数据库是唯一的，所以这里写成单例模式。
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

	// 使用内部类来实现单例，实现了lazy且是线程安全的
	private static class SingletonHolder {
		private static Database dbInstance = new Database();
	}
	
	private Database() {
		// 需要用到的属性都已经初始化了，这里就不用再做什么操作了
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
