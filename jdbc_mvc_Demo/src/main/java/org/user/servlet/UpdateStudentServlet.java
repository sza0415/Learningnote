package org.user.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.sza.dao.IStudentDAO;
import org.sza.entity.Student;
import org.sza.service.impl.StudentServiceImpl;
import org.user.service.IStudentService;

/**
 * Servlet implementation class UpdateStudentServlet
 */
@WebServlet("/updatestudent")
public class UpdateStudentServlet extends HttpServlet {


	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		// 获取修改人的学号

		int sno = Integer.parseInt( request.getParameter("sno") );

		// 获取修改后的内容
		String sname = request.getParameter("sname");
		int sage = Integer.parseInt(request.getParameter("sage"));
		String saddress = request.getParameter("saddress");

		// 封装修改后的内容

		Student stu = new Student(sno,sname,sage,saddress);

		IStudentService stuService = new StudentServiceImpl();
		boolean result = stuService.updateStudentBySno(sno, stu);
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");

		if (result) {
			// response.getWriter().println("修改成功");
			response.sendRedirect("queryall");
		}else {
			response.sendRedirect("queryall");
		}

	}


	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
