package com.cg.oirs.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.cg.oirs.exception.InternalRecruitmentException;

public class DBUtil {
	private static Connection conn;
	public static Connection getConnection() throws InternalRecruitmentException {
		if(conn == null){
			try {
				InitialContext ic = new InitialContext();
				DataSource ds = (DataSource) ic.lookup("java:/jdbc/OracleDS");
				conn = ds.getConnection();
			}catch (SQLException e) {
				throw new InternalRecruitmentException("Problem in obtaining connection "+ e.getMessage());
			}catch(NamingException e) {
				throw new InternalRecruitmentException("Datasource not found..");
			}
		}
		return conn;
	}
}	

