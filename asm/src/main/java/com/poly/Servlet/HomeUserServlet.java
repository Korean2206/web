package com.poly.Servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.poly.DAO.FavoriteDAO;
import com.poly.DAO.VideoDAO;
import com.poly.entity.Favorite;
import com.poly.entity.Video;
import com.poly.utils.Auth;

/**
 * Servlet implementation class HomeUserServlet
 */
@WebServlet("/home")
public class HomeUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getMethod();
		System.out.println(method);
		VideoDAO dao = new VideoDAO();
		FavoriteDAO daof = new FavoriteDAO();
		List<Video> list = dao.selectAll();
		List<Video> listA = new ArrayList<Video>();
		for(Video v : list) {
			if(v.getActive()) {
				listA.add(v);
			}
		}
		
		request.setAttribute("videos", listA);
		request.getRequestDispatcher("/views/khachHang/Home.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/views/khachHang/Home.jsp").forward(request, response);

	}

}
