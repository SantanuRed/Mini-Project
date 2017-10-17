package com.cg.oirs.service;

import java.util.List;

import com.cg.oirs.dto.User;
import com.cg.oirs.exception.InternalRecruitmentException;

public interface IInternalRecruitmentService {
	String addUser(User user) throws InternalRecruitmentException;
	int validateUser(User user) throws InternalRecruitmentException;
	List<User> showUser(String user_id) throws InternalRecruitmentException;
	String deleteUser(String user_id) throws InternalRecruitmentException;

}
