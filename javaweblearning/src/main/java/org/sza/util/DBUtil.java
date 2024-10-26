package org.sza.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


// 通用的数据库操作
public class DBUtil {
	
	private static String URL = "jdbc:oracle:thin:@localhost:1521:orcl";
	private static String USERNAME = "sza";
	private static String PWD = "sza0415";

	
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.OracleDriver");

		return DriverManager.getConnection(URL,USERNAME,PWD);
	}
	public static PreparedStatement createPreparedStatement(Connection conn, String sql,Object[] params) throws ClassNotFoundException, SQLException {
		
		
		PreparedStatement ppstm = conn.prepareStatement(sql);

		if (params!=null) {
			for (int i=0;i<params.length;i++) {
				ppstm.setObject(i+1, params[i]);
			}
		}
		return ppstm;
	}
	public static void closeAll(ResultSet rs,Statement stmt,Connection conn) {
		try {
			if (rs!=null) {
				rs.close();
			}
			if (stmt!=null) {
				stmt.close();
			}
			if (conn!=null) {
				conn.close();
			}
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
	}
	// 通用增删改 
	public static boolean executeUpdate(String sql, Object[] params) {
		Connection conn = null;
		PreparedStatement ppstm = null;
		int count = -1;
		try {
			
		 	conn = getConnection();
			
			ppstm = createPreparedStatement(conn,sql,params);

			count = ppstm.executeUpdate();

			if (count > 0) {
				return true;
			}return false;

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally {
			closeAll(null, ppstm, conn);
		}
	}
	
	// 查询总数
	public static int getTotalCount(String sql) { // select count(*) from student;
		int count = -1;
		Connection conn = null;
		PreparedStatement ppstm = null;
		ResultSet res = null;
		try {
			conn = getConnection();
			ppstm = createPreparedStatement(conn, sql, null);
			res = ppstm.executeQuery();
			if (res.next()) {
				count = res.getInt(1);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeAll(res, ppstm, conn);
		}
		return count;
	}
	
	
	// 通用的查
	
}
