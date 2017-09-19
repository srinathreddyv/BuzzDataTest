package com.buzzdata.domain;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.postgresql.Driver;

public class DBConnection {

	
	static String url = "jdbc:postgresql://dqhquwuevviamz:754ba439a5c42ebbed7121a8a66d8b93758902160dff2b327920856dd60453c0@ec2-184-73-189-221.compute-1.amazonaws.com:5432/d1u4tboc6cb9";
	
	public static Connection getConnection() throws URISyntaxException, SQLException, ClassNotFoundException {
	    
		Class.forName("org.postgresql.Driver");
		String dbUrl = System.getenv("JDBC_DATABASE_URL");
		return DriverManager.getConnection(dbUrl);
	}
}
