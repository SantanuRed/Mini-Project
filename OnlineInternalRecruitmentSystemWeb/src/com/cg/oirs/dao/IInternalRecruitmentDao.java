package com.cg.oirs.dao;

import java.util.List;

import com.cg.oirs.dto.User;
import com.cg.oirs.exception.InternalRecruitmentException;

public interface IInternalRecruitmentDao {
	String addUser(User user) throws InternalRecruitmentException;
	int validateUser(User user) throws InternalRecruitmentException;
	String deleteUser(String user_id) throws InternalRecruitmentException;
	List<User> showUser(String user_id) throws InternalRecruitmentException;
}
