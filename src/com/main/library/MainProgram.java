package com.main.library;

import com.database.library.Database;
import java.sql.*;

public class MainProgram {
	public static void main(String[] args) {
		// ��������mysql�е����ݿ⡣
		Database.instance().connectDB();
		
	}
}
