package com.cg.oirs.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cg.oirs.dto.User;
import com.cg.oirs.exception.InternalRecruitmentException;
import com.cg.oirs.service.IInternalRecruitmentService;
import com.cg.oirs.service.InternalRecruitmentServiceImpl;

/**
 * Servlet implementation class UserValidate
 */
@WebServlet(urlPatterns={"/UserValidate","/admin_add_user","/admin_remove","/delete_user"})
public class InternalRecruitmentSystemController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String target="";
		HttpSession sess;
		String show="";
		IInternalRecruitmentService iirs = new InternalRecruitmentServiceImpl();
		String url = request.getServletPath();
	
		switch(url){
			case "/UserValidate":
				User user = new User();
				sess = request.getSession(true);
				user.setUser_id(request.getParameter("user_id"));
				user.setPassword(request.getParameter("password"));
				user.setRole(request.getParameter("role"));
			try {
				if(iirs.validateUser(user)==1){
					sess.setAttribute("user_id", request.getParameter("user_id"));
					target="Admin.jsp";
				}
				else{
					target="error.jsp";
				}
			} catch (InternalRecruitmentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				break;
			
			case "/admin_add_user":
				user = new User();
				sess = request.getSession(false);
				user.setUser_id(request.getParameter("user_id"));
				user.setPassword(request.getParameter("password"));
				user.setRole(request.getParameter("role"));
				
			try {
				show="Sucessfully added "+iirs.addUser(user); 
				sess.setAttribute("show", show);
				target="success.jsp";
			} catch (InternalRecruitmentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
				break;
			case "/admin_remove":
				sess = request.getSession(false);
			try {
				sess.setAttribute("ulist", iirs.showUser(request.getParameter("user_id")));
				target="admin_remove_user.jsp";
			} catch (InternalRecruitmentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				break;
				
			case "/delete_user":
				sess = request.getSession(false);
			try {
				show="Sucessfully deleted "+ iirs.deleteUser(request.getParameter("user_id"));
				sess.setAttribute("show", show);
				target="success.jsp";
			} catch (InternalRecruitmentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
				break;
		}
		
		RequestDispatcher disp = request.getRequestDispatcher(target);
		disp.forward(request, response);
	}

}
