package test;

import java.sql.*;

public class Database {

	Connection connection = null;

	public void connect () {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			String host = "ora-labos.labos.polymtl.ca";
			String port = "2001";
			String service = "labos";
			String dbUrl = "jdbc:oracle:thin:@"+host+":"+port+":"+service;
			String username = "INF3710-153-30";
			String password = "EX6Z6B";
			connection = DriverManager.getConnection(dbUrl, username, password);
		}
		catch(SQLException se) {
			se.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	public Statement getStatement () {
		Statement stmt = null;
		try {
			stmt = connection.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return stmt;
	}

	public void closeStatement (Statement stmt) {
		try {
		   if(stmt != null) {
			   stmt.close();
		   }
		}
		catch(SQLException se) {
			se.printStackTrace();
		}
	}

	public void closeConnection () {
		try {
		   if(connection != null) {
			   connection.close();
		   }
		}
		catch(SQLException se) {
		   se.printStackTrace();
		}
	}

	public ResultSet executeSelect (Statement stmt, String sql) {
		ResultSet rs = null;
		try {
			rs = stmt.executeQuery(sql);
		}
		catch(SQLException se) {
			   se.printStackTrace();
		}
		return rs;
	}

	public int executeSql (Statement stmt, String sql) {
		int resp = 0;
		try {
			resp = stmt.executeUpdate(sql);
		}
		catch(SQLException se) {
			   se.printStackTrace();
		}
		return resp;
	}
	
	public void commit(){
		try {
			connection.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}	
	}
}
