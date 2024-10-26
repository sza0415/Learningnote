package org.sza.dao;

import java.util.List;

import org.sza.entity.Student;

public interface IStudentDAO {
	// 根据学号判断学生是否存在
		public boolean isExistbysno(int sno);

		// 查询全部学生
		public List<Student> queryAll() ;


		// 根据姓名查询TODO

		// 根据学号 查询学生
		public Student queryUserBysno(int sno);

		// 改 将学号=3 的人的信息改为  xx , xx , xx
		// 把sno学号的信息改为 参数student的信息
		public boolean updateStudentBySno(int sno,Student student);


		// 根据学号删除学生
		public boolean deleteStudentBysno(int sno);


		public boolean addStudent(Student stu);
		
		// 查询综述
		public int getTotalCount();
		
		// 查询当前页的数据集合
		// currentPage：当前页（页码） pageSize：页面大小（每页显示的数据）
		public List<Student> queryStudentsByPage(int currentPage,int pageSize);
}
