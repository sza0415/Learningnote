package org.user.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.sza.entity.Student;
import org.sza.service.impl.StudentServiceImpl;
import org.user.service.IStudentService;

@WebServlet("/addstudent")
public class AddStudentServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		int sno = Integer.parseInt(req.getParameter("sno"));
		String sname = req.getParameter("sname");
		int sage = Integer.parseInt(req.getParameter("sage"));
		String saddress = req.getParameter("saddress");
		Student stu = new Student(sno,sname,sage,saddress);
		
		// 采用多态 接口
		IStudentService stuService = new StudentServiceImpl();

		boolean result = stuService.addStudent(stu);
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=UTF-8");
		if (result) {
			resp.sendRedirect("queryall");
		}else {
			resp.sendRedirect("queryall");
		}


	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}


}
