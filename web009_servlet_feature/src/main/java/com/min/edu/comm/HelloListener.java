package com.min.edu.comm;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


//TODO 031 Application에서 요청되는 전체를 처리하기 위한 ServletContextListener
//만약 session을 처리하고 싶다면 ServletSessionListener 사용
public class HelloListener implements ServletContextListener {


    public void contextDestroyed(ServletContextEvent sce)  { 
       System.out.println("~~~~~~~애플리케이션 종료~~~~~~~~");
       
    }

    public void contextInitialized(ServletContextEvent sce)  { 
    	 System.out.println("#########애플리케이션 시작########");
    	 ServletContext context=sce.getServletContext();
    	 System.out.println("애플리케이션 서버 정보"+context.getServerInfo());
    }
	
}
