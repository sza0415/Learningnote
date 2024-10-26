package org.user.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.sza.entity.Student;
import org.sza.service.impl.StudentServiceImpl;
import org.user.service.IStudentService;

/**
 * Servlet implementation class QueryAll
 */
@WebServlet("/queryall")
public class QueryAll extends HttpServlet {
	private static final long serialVersionUID = 1L;


	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");



		IStudentService stuService = new StudentServiceImpl();
		List<Student> result = stuService.queryAll();
		request.setAttribute("students", result);


		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
