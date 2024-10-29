/*Context_Session_RequestListener.java
 * 
 * */

package org.sza.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class Context_Session_RequestListener implements ServletContextListener, HttpSessionListener, ServletRequestListener{

	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		
		System.out.println("requestDestroyed" + sre.getServletRequest());
	}

	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		System.out.println("requestInitialized" + sre.getServletRequest());
	}

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("sessionCreated" + se.getSession());
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("sessionDestroyed" + se.getSession());
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("contextDestroyed" + sce.getServletContext());
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("contextInitialized" + sce.getServletContext());
	}
	

}
