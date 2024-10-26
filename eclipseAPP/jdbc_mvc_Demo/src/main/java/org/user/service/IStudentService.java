package org.user.service;

import java.util.List;


import org.sza.entity.Student;

public interface IStudentService {
	


	// 增 ==> isExistbysno + addStudent
	public boolean addStudent(Student stu);

	// 删
	public boolean deleteStudentBySno(int sno);

	// 改
	public boolean updateStudentBySno(int sno,Student stu);

	// 根据学号查询
	public Student queryStudentbysno(int sno) ;

	// 查询所有人
	public List<Student> queryAll();
	
	public int getTotalCount();
	
	public List<Student> queryStudentsByPage(int currentPage,int pageSize);
}
