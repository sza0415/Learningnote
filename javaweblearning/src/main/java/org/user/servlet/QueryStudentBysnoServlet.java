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

/**
 * Servlet implementation class QueryStudentBysnoServlet
 */
@WebServlet("/querystudentbysno")
public class QueryStudentBysnoServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");


		int sno = Integer.parseInt( request.getParameter("sno") );


		IStudentService stuService = new StudentServiceImpl();
		Student result = stuService.queryStudentbysno(sno);
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");

		request.setAttribute("student", result);
		request.getRequestDispatcher("studentinfo.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
