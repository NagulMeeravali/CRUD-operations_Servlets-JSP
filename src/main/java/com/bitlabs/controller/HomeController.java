package com.bitlabs.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bitlabs.dao.Dao;
import com.bitlabs.dao.DaoImpl;
import com.bitlabs.model.Student;

@WebServlet(value={"/loginForm","/regForm","/signUp","/login"})
public class HomeController extends HttpServlet {
	Dao dao=null;
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
		
		String path=req.getServletPath();
		RequestDispatcher rd=null;
		if(path.equals("/loginForm")) {
			
			rd=req.getRequestDispatcher("index.jsp");
			req.setAttribute("msg", "login");
			rd.include(req, res);
		}
		else if(path.equals("/regForm")) {
			
			rd=req.getRequestDispatcher("index.jsp");
			req.setAttribute("msg", "register");
			rd.include(req, res);
		}
		
	}
	
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
		dao=new DaoImpl();
		String path=req.getServletPath();
		RequestDispatcher rd=null;
		Student std=null;
		if(path.equals("/signUp")) {
			 std=new Student();
			std.setFname(req.getParameter("fname"));
			std.setLname(req.getParameter("lname"));
			std.setEmail(req.getParameter("email"));
			std.setMobile(Long.parseLong(req.getParameter("mobile")));
			std.setGender(req.getParameter("g"));
			std.setPassword(req.getParameter("pwd"));
			std.setSid(Integer.parseInt(req.getParameter("sid")));
			int i=dao.addStudentDetails(std);
			if(i>0) {
				rd=req.getRequestDispatcher("index.jsp");
				req.setAttribute("msg", "register");
				req.setAttribute("msg1", "Record inserted successfully");
				rd.include(req, res);
			}
			else {
				rd=req.getRequestDispatcher("index.jsp");
				req.setAttribute("msg", "register");
				req.setAttribute("msg1", "Failed.....");
				rd.include(req, res);
			}
		}
		else if(path.equals("/login")) {
			std=new Student();
			std.setEmail(req.getParameter("email"));
			std.setPassword(req.getParameter("pwd"));
			String uname=dao.login(std);
			if(uname!=null) {
				HttpSession session=req.getSession();
				rd=req.getRequestDispatcher("Home.jsp");
				session.setAttribute("u", uname);
				rd.forward(req, res);
			}
			else {
				
			}
			
		}
		
	}

}
