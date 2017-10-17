package com.cg.oirs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.cg.oirs.dto.User;
import com.cg.oirs.exception.InternalRecruitmentException;

public class InternalRecruitmentDaoImpl implements IInternalRecruitmentDao {
	static String ADD_USER_QUERY="INSERT INTO USERS VALUES(?,?,?)";
	static String VALIDATE_USER_QUERY="SELECT COUNT(*) FROM USERS WHERE user_id=? AND password=? AND role=?";
	static String DELETE_USER_QUERY="DELETE FROM users WHERE user_id=?";
	static String SHOW_ADMIN_USER_QUERY="SELECT user_id,password,role FROM users where user_id !=?";
	
	
	static String SEQUENCE_RM_QUERY="SELECT rm_seq.NEXTVAL FROM DUAL";
	static String SEQUENCE_ADMIN_QUERY="SELECT admin_seq.NEXTVAL FROM DUAL";
	static String SEQUENCE_RME_QUERY="SELECT rme_seq.NEXTVAL FROM DUAL";
	
	Connection conn;
	@Override
	
	public String addUser(User user ) throws InternalRecruitmentException {
		conn = DBUtil.getConnection();
		user.setUser_id(generateId(user));
		try {
			PreparedStatement pst = conn.prepareStatement(ADD_USER_QUERY);
			pst.setString(1, user.getUser_id());
			pst.setString(2, user.getPassword());
			pst.setString(3, user.getRole());
			pst.executeUpdate();
		} catch (SQLException e) {
			throw new InternalRecruitmentException("Problem in inserting Users "+e.getMessage());
		}
		return user.getUser_id();
	}

	@Override
	public int validateUser(User user) throws InternalRecruitmentException {
		conn= DBUtil.getConnection();
		try {
			PreparedStatement pst = conn.prepareStatement(VALIDATE_USER_QUERY);
			pst.setString(1, user.getUser_id());
			pst.setString(2, user.getPassword());
			pst.setString(3, user.getRole());
			ResultSet rst = pst.executeQuery();
			rst.next();
			System.out.println(rst.getString(1));
			return rst.getInt(1);
			
		} catch (SQLException e) {
			throw new InternalRecruitmentException("Problem in validating user "+e.getMessage());
		}
		
	}
	
	private int generateSequence(String query) throws InternalRecruitmentException {
		conn = DBUtil.getConnection();
		try {
			Statement st = conn.createStatement();
			ResultSet rst = st.executeQuery(query);
			rst.next();
			return rst.getInt(1);
		} catch (SQLException e) {
			throw new InternalRecruitmentException("Problem in generating sequence "+e.getMessage());
		}
		
	}
	
	private String generateId(User user) throws InternalRecruitmentException{
		String id="";
		int buff;
		switch(user.getRole()){
			case "Admin":
				buff = generateSequence(SEQUENCE_ADMIN_QUERY);
				if(buff<10){
					id = "AD0"+buff;
				}else{
					id = "AD"+buff;
				}
				break;
			case "RM":
				buff = generateSequence(SEQUENCE_RM_QUERY);
				if(buff<10){
					id = "RM0"+buff;
				}else{
					id = "RM"+buff;
				}
				break;
			case "RME":
				buff = generateSequence(SEQUENCE_RME_QUERY);
				if(buff<10){
					id = "RE0"+buff;
				}else{
					id = "RE"+buff;
				}
				break;
		}
		return id;
	}

	@Override
	public String deleteUser(String user_id)
			throws InternalRecruitmentException {
		conn = DBUtil.getConnection();
		try {
			PreparedStatement pst = conn.prepareStatement(DELETE_USER_QUERY);
			pst.setString(1, user_id);
			pst.executeQuery();
		} catch (SQLException e) {
			throw new InternalRecruitmentException("Problem in deleting user "+e.getMessage());
		}
		return user_id;
	}

	@Override
	public List<User> showUser(String user_id)
			throws InternalRecruitmentException {
		conn = DBUtil.getConnection();
		List<User> ulist = new ArrayList<User>();
		try {
			PreparedStatement pst = conn.prepareStatement(SHOW_ADMIN_USER_QUERY);
			pst.setString(1, user_id);
			ResultSet rst = pst.executeQuery();
			while(rst.next()){
				User u = new User();
				u.setUser_id(rst.getString(1));
				u.setPassword(rst.getString(2));
				u.setRole(rst.getString(3));
				ulist.add(u);
			}
		} catch (SQLException e) {
			throw new InternalRecruitmentException("Problem in generating list "+e.getMessage());
		}
		return ulist;
	}
	
}
