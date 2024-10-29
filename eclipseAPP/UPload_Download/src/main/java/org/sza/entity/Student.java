package org.sza.entity;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class Student implements HttpSessionBindingListener {

	private String name;
	
    public Student(String name) {
		this.name = name;
	}
    public Student() {
    	
    }
	public void valueBound(HttpSessionBindingEvent arg0)  { 
         System.out.println("Student类对象" + "被添加到了session");
    }
    public void valueUnbound(HttpSessionBindingEvent arg0)  { 
    	System.out.println("Student类对象" + "被从session中删除了");
    }	
}
