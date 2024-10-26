package org.user.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.sza.entity.Page;
import org.sza.entity.Student;
import org.sza.service.impl.StudentServiceImpl;
import org.user.service.IStudentService;

import oracle.net.aso.c;

/**
 * Servlet implementation class QueryStudentsBypage
 */
@WebServlet("/querystudentsbypage")
public class QueryStudentsBypage extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IStudentService stuServcice = new StudentServiceImpl();
		request.setCharacterEncoding("utf-8");
		
		// 总数据条数
		int totalcount = stuServcice.getTotalCount();
		
		// 当前页码
		String cPage = request.getParameter("currentpage");
		if (cPage == null)cPage = "1";
		int currentpage = Integer.parseInt(cPage);

		
		int pagesize = 3;
		List<Student> students = stuServcice.queryStudentsByPage(currentpage, pagesize);
		
		// 将分页所需的5个字段，封装到Page对象当中
		Page page = new Page(); 
		page.setCurrentpage(currentpage);
		page.setTotalcount(totalcount);
		page.setPagesize(pagesize);
		page.setStudents(students);
		
		
		request.setAttribute("page",page);
		
		request.getRequestDispatcher("index2.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
