package com.bitlabs.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import com.bitlabs.dao.Dao;
import com.bitlabs.dao.DaoImpl;
import com.bitlabs.model.Student;

@WebServlet(value={"/viewAll","/reqDelete","/updateForm"})
public class AdminController extends HttpServlet {
    Dao dao=null;
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
		dao=new DaoImpl();
		String path=req.getServletPath();
		RequestDispatcher rd=null;
		if(path.equals("/viewAll")) {
			
			List<Student> stds=dao.viewAllStudents();
			rd=req.getRequestDispatcher("Home.jsp");
			req.setAttribute("msg", "viewall");
			req.setAttribute("students", stds);
			rd.include(req, res);
		}
		else if(path.equals("/reqDelete")) {
			
			boolean b=dao.deleteStudent(Integer.parseInt(req.getParameter("id").trim()));
			if(b) {
				res.sendRedirect("viewAll");
			}
		}
		else if(path.equals("/updateForm")) {
			Student std=dao.getById(Integer.parseInt(req.getParameter("id").trim()));
			rd=req.getRequestDispatcher("Home.jsp");
			req.setAttribute("student", std);
			req.setAttribute("msg", "updateform");
			rd.include(req, res);
		}
	}
}
