package org.sza.service.impl;

import java.util.List;

import org.sza.dao.IStudentDAO;
import org.sza.dao.impl.StudentDAOImpl;
import org.sza.entity.Student;
import org.user.service.IStudentService;

// 业务逻辑层，逻辑性的增删改查

public class StudentServiceImpl implements IStudentService{
	IStudentDAO stuDAO = new StudentDAOImpl();


	// 增 ==> isExistbysno + addStudent
	public boolean addStudent(Student stu) {

		if (!stuDAO.isExistbysno(stu.getSno())) {
			stuDAO.addStudent(stu);
			return true;
		}else {
			System.out.println("此人已存在！");
			return false;
		}
	}

	@Override
	public int getTotalCount() {
		return stuDAO.getTotalCount();
	}

	@Override
	public List<Student> queryStudentsByPage(int currentPage, int pageSize) {
		return stuDAO.queryStudentsByPage(currentPage, pageSize);
	}

	// 删
	public boolean deleteStudentBySno(int sno) {

		if (stuDAO.isExistbysno(sno)) {
			return stuDAO.deleteStudentBysno(sno);
		}else {
			System.out.println("此人不存在");
			return false;
		}
	}

	// 改
	public boolean updateStudentBySno(int sno,Student stu) {

		if (stuDAO.isExistbysno(sno)) {

			return stuDAO.updateStudentBySno(sno, stu);
		}
		return false;
	}

	// 根据学号查询
	public Student queryStudentbysno(int sno) {
		return stuDAO.queryUserBysno(sno);
	}

	// 查询所有人
	public List<Student> queryAll(){
		return stuDAO.queryAll();
	}

}
