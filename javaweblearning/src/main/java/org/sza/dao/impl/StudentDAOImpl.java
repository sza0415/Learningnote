package org.sza.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.rmi.CORBA.Util;

import org.sza.dao.IStudentDAO;
import org.sza.entity.Student;
import org.sza.util.DBUtil;




// 数据访问层，原子性的 增删改查
public class StudentDAOImpl implements IStudentDAO{

	private String URL = "jdbc:oracle:thin:@localhost:1521:orcl";
	private String USERNAME = "sza";
	private String PWD = "sza0415";
	@Override
	public boolean isExistbysno(int sno) {
		return queryUserBysno(sno)==null? false:true;
	}
	
	
	
	@Override
	public int getTotalCount() {
		String sql = "select count(1) from student";
		return DBUtil.getTotalCount(sql);
	}



	@Override
	public List<Student> queryStudentsByPage(int currentPage, int pageSize) {
		Student stu = null;
		Connection conn = null;
		PreparedStatement ppstm = null;
		ResultSet res = null;
		List<Student> students = new ArrayList<Student>();
		/*
		 * SELECT *
				FROM (
				    SELECT *
				    FROM (
				        SELECT rownum r, t.*
				        FROM (
				            SELECT s.*
				            FROM student s
				            ORDER BY sno ASC
				        ) t
				        WHERE rownum <= 1 -- 这里假设使用命名参数，你也可以使用问号作为位置参数
				    )
				    WHERE r >=3
				);
		 * 
		 * */
		String sql = "select * from "
					+ "( select rownum r,t.* from "
					+ " (select s.* from student s order by sno asc) t"
					+ " where rownum<=?"
					+ ")"
					+ "where r>=?"
					;
		Object[] params = {currentPage*pageSize,(currentPage-1)*pageSize+1};
		
		
		try {
			conn = DBUtil.getConnection();
			ppstm = DBUtil.createPreparedStatement(conn, sql, params);
			res = ppstm.executeQuery();
			while(res.next()) {
				int sno_ = res.getInt("sno");
				String sname_ = res.getString("sname");
				int sage_ = res.getInt("sage");
				String saddress_ = res.getString("saddress");
				stu = new Student(sno_,sname_,sage_,saddress_);
				students.add(stu);
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}catch (SQLException e) {
			e.printStackTrace();
			return null;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			DBUtil.closeAll(res, ppstm, conn);
		}
		return students;
	}



	@Override
	public Student queryUserBysno(int sno) {
		Student stu = null;
		Connection conn = null;
		PreparedStatement ppstm = null;
		ResultSet res = null;
		String sql = "select * from student where sno = ?";
		Object[] params = {sno};
		try {
			conn = DBUtil.getConnection();
			ppstm = DBUtil.createPreparedStatement(conn, sql, params);

			res = ppstm.executeQuery();

			if (res.next()) {
				int sno_ = res.getInt("sno");
				String sname_ = res.getString("sname");
				int sage_ = res.getInt("sage");
				String saddress_ = res.getString("saddress");
				stu = new Student(sno_,sname_,sage_,saddress_);
			}
			return stu;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return stu;
		} catch (SQLException e) {
			e.printStackTrace();
			return stu;
		}catch (Exception e) {
			e.printStackTrace();
			return stu;
		}finally {
			DBUtil.closeAll(res, ppstm, conn);
		}
	}
	@Override
	public boolean updateStudentBySno(int sno, Student student) {
		String sql = "update student set sname = ?, sage = ? , saddress = ?  where sno = ?";
		Object[] params = {student.getSname(),student.getSage(),student.getSaddress(),sno};
		return DBUtil.executeUpdate(sql, params);
	}
	@Override
	public boolean deleteStudentBysno(int sno) {
		String sql = "delete from student where sno = ?";
		Object[] params = {sno};
		return DBUtil.executeUpdate(sql, params);
	}
	@Override
	public boolean addStudent(Student stu) {
		
		String sql = "insert into student(sno,sname,sage,saddress) values(?,?,?,?)";
		Object[] params = {stu.getSno(),stu.getSname(),stu.getSage(),stu.getSaddress()};
		return DBUtil.executeUpdate(sql, params);

	}
	
	@Override
	public List<Student> queryAll()  {
		List<Student> Students =  new ArrayList<>();
		Student stu = null;
		
		String sql = "select * from student";
		Connection conn = null;
		PreparedStatement ppstm =null;
		ResultSet res = null; 

		
		try {
			conn = DBUtil.getConnection();
			ppstm = DBUtil.createPreparedStatement(conn, sql, null);
			res = ppstm.executeQuery();
			while(res.next()) {
				int sno_ = res.getInt("sno");
				String sname_ = res.getString("sname");
				int sage_ = res.getInt("sage");
				String saddress_ = res.getString("saddress");
				stu = new Student(sno_,sname_,sage_,saddress_);
				Students.add(stu);
				
			}
			return Students;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			DBUtil.closeAll(res, ppstm, conn);
		}
			
	}

	



}
