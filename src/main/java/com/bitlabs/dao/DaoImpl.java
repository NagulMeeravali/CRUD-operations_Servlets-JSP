package com.bitlabs.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bitlabs.model.Student;

public class DaoImpl implements Dao {

	Connection con=null;
	public DaoImpl() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db2","root","root");
          
		} catch (Exception e) {

			System.out.println(e);
		}
		
	}
	
	public int addStudentDetails(Student std) {
		int i=0;
		try {
			PreparedStatement pstmt=con.prepareStatement("insert into Student values(?,?,?,?,?,?,?)");
		                     pstmt.setString(1, std.getFname());
		                     pstmt.setString(2, std.getLname());
		                     pstmt.setString(3, std.getEmail());
		                     pstmt.setString(4, std.getGender());
		                     pstmt.setLong(5, std.getMobile());
		                     pstmt.setString(6, std.getPassword());
		                     pstmt.setInt(7, std.getSid());
		                     i=pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
		}
		
		return i;
	}

	public String login(Student std) {
		String uname=null;
		try {
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select fname,email,password from student where email='"+std.getEmail()+"'and password='"+std.getPassword()+"'");
			if(rs.next()) {
				uname=rs.getString(1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return uname;
	}

	public List<Student> viewAllStudents(){
		   List<Student> std=new ArrayList<Student>();    
		try {
		     Statement stmt=con.createStatement();
		     ResultSet rs=stmt.executeQuery("select * from student");
		     while(rs.next()) {
		       Student s=new Student();
		       
		       s.setFname(rs.getString(1));
		       s.setLname(rs.getString(2));
		       s.setEmail(rs.getString(3));
		       s.setGender(rs.getString(4));
		       s.setMobile(rs.getLong(5));
		       s.setPassword(rs.getString(6));
		       s.setSid(rs.getInt(7));
		       std.add(s);
		     }
		    }
		    catch(Exception e) {
		    	System.out.println(e);
		    }
		return std;
	}

	public boolean deleteStudent(int parseInt) {
		boolean b=false;
		try {
			Statement stmt=con.createStatement();
			int i=stmt.executeUpdate("delete from student where sid='"+parseInt+"'");
			if(i>0) {
				b=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return b;
	}

	public Student getById(int parseInt) {
		Student s=new Student();  
		try {
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from student where sid='"+parseInt+"'");
		    if(rs.next()) {   
			
		       s.setFname(rs.getString(1));
		       s.setLname(rs.getString(2));
		       s.setEmail(rs.getString(3));
		       s.setGender(rs.getString(4));
		       s.setMobile(rs.getLong(5));
		       s.setSid(rs.getInt(6));
		    }
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return s;
	}
    
}
