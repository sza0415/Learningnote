package org.user.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.sza.service.impl.StudentServiceImpl;
import org.user.service.IStudentService;


@WebServlet("/deletestudent")
public class DeleteStudentServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// 删除
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");

		// 接受前端传来的学号
		int sno = Integer.parseInt(request.getParameter("sno"));

		IStudentService stuService = new StudentServiceImpl();

		boolean result = stuService.deleteStudentBySno(sno);
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		if (result) {
			// response.getWriter().println("删除成功");
			request.getRequestDispatcher("queryall").forward(request, response);
		}else {
			// response.getWriter().println("删除失败");
			request.getRequestDispatcher("queryall").forward(request, response);
		}
	}


	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
