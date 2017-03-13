package main;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Test {

	private static Logger logger = LogManager.getLogger(Test.class.getName());
	
	public static void main(String[] args) {

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@10.0.2.15:1521:ORCL1";
			Connection con = DriverManager.getConnection(url, "DB", "1");
			logger.info("******* Connected to database (to Oracle10). *******");
			

			String command = "{call DB.PKG_ACCOUNT.TRANSFER_BALANCE(?,?)}";
			CallableStatement cstmt = con.prepareCall(command);
			
			int account_id = 1;
			double money = 50.5d;
			
			cstmt.setInt(1, account_id);
			cstmt.setDouble(2, money);
			
			cstmt.execute();
			logger.info("Money successfully transfered.");
			con.close();

		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}
}

