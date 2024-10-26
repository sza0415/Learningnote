package org.sza.entity;

import java.util.ArrayList;
import java.util.List;

public class Page {
	/*
	在分页显示的前提下，显示数据的jsp需要那些数据：
		当前页 currentpage
		页面大小 pagesize
		当前页的数据集合 students
		总数据 totalcount
		总页数 totalpage 共 xx条数据 3/10
		-->新建Page类，用于封装以上五个字段
		
	 totalpage = totalcount % pagesize == 0 ? totalcount / pagesize : totalcount /pagesize + 1
	 
	*/
	private int currentpage;
	private int pagesize;
	private List<Student> students = new ArrayList<Student>();
	private int totalcount;
	private int totalpage;
	
	public Page(int currentpage, int pagesize, List<Student> students, int totalcount, int totalpage) {
		
		this.currentpage = currentpage;
		this.pagesize = pagesize;
		this.students = students;
		this.totalcount = totalcount;
		this.totalpage = totalpage;
	}

	public Page() {
		super();
	}

	public int getCurrentpage() {
		return currentpage;
	}

	public void setCurrentpage(int currentpage) {
		this.currentpage = currentpage;
	}

	public int getPagesize() {
		return pagesize;
	}

	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
		this.totalpage = totalcount % pagesize == 0 ? totalcount / pagesize : totalcount /pagesize + 1;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public int getTotalcount() {
		return totalcount;
	}

	public void setTotalcount(int totalcount) {
		this.totalcount = totalcount;
	}


	public int getTotalpage() {
		return totalpage;
	}
/*totalpage应该为设置了pagesize后自动计算而不是手动赋值
 * */
//	public void setTotalpage(int totalpage) {
//		this.totalpage = totalpage;
//	}
	
}
