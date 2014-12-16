package com.main.library;

import com.database.library.Database;
import java.sql.*;

public class MainProgram {
	public static void main(String[] args) {
		// 尝试连接mysql中的数据库。
		Database.instance().connectDB();
		
	}
}
