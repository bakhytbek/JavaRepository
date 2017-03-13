package main;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

public class Test {

	public static void main(String[] args) {

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@10.0.2.15:1521:ORCL1";
			Connection con = DriverManager.getConnection(url, "DB", "1");
			System.out.println("Connected to database");

			String command = "{call DB.PKG_ACCOUNT.TRANSFER_BALANCE(?,?)}";
			CallableStatement cstmt = con.prepareCall(command);
			
			int account_id = 1;
			double money = 50.50d;
			
			cstmt.setInt(1, account_id);
			cstmt.setDouble(2, money);
			
			cstmt.execute();
			System.out.println("Money successfully transfered.");
			cstmt.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

