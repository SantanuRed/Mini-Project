package com.cg.oirs.service;

import java.util.List;

import com.cg.oirs.dao.IInternalRecruitmentDao;
import com.cg.oirs.dao.InternalRecruitmentDaoImpl;
import com.cg.oirs.dto.User;
import com.cg.oirs.exception.InternalRecruitmentException;

public class InternalRecruitmentServiceImpl implements
		IInternalRecruitmentService {
	IInternalRecruitmentDao iird = new InternalRecruitmentDaoImpl();
	@Override
	public String addUser(User user) throws InternalRecruitmentException {
		return iird.addUser(user);
	}

	@Override
	public int validateUser(User user) throws InternalRecruitmentException {
		return iird.validateUser(user);
	}

	@Override
	public List<User> showUser(String user_id)
			throws InternalRecruitmentException {
		return iird.showUser(user_id);
	}

	@Override
	public String deleteUser(String user_id)
			throws InternalRecruitmentException {
		return iird.deleteUser(user_id);
	}

}
