package com.kh.websocket.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MulticastViewServlet
 */
//@WebServlet("/multiView.do")
public class MulticastViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// 현재 열려있는 채팅방의 명칭
	public static ArrayList<String> roomList;
       
    public MulticastViewServlet() { }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		// 방의 리스트를 서버 내의 
		// 모두가 공유하기 위해서
		ServletContext application
		 = request.getServletContext();
		
		// 기존에 있던 방의 리스트를 받아온다
		roomList 
		 = (ArrayList<String>)application.getAttribute("roomList");
		
		System.out.println(roomList);
		
		if(roomList == null || roomList.isEmpty()){
			roomList = new ArrayList<String>();
			
			roomList.add("room1");
			roomList.add("room2");
			roomList.add("room3");
			
			application.setAttribute("roomList", roomList);
			System.out.println(roomList);
		}
		
		if(!roomList.isEmpty()) 
			response.sendRedirect("views/multicast.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}












