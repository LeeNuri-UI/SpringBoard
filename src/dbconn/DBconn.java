package dbconn;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBconn {
	//연결 객체 생성
	
	private Connection conn = null;
	private String coninfo = "jdbc:oracle:thin:@127.0.0.1:1524:null";
	private String idinfo = "system";
	private String pwdinfo = "1111";
	
	public Connection getConnect() {
			
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(coninfo, idinfo, pwdinfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return conn;
	}
}
