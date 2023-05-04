package com.poly.Servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.poly.DAO.FavoriteDAO;
import com.poly.DAO.VideoDAO;
import com.poly.entity.Favorite;
import com.poly.entity.User;
import com.poly.entity.Video;
import com.poly.utils.Auth;

/**
 * Servlet implementation class DetailServlet
 */
@WebServlet("/home/detail/*")
public class DetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		if (uri.contains("detail")) {
			String id = uri.substring(uri.lastIndexOf("=") + 1);
			VideoDAO dao = new VideoDAO();
			Video video = dao.selectById(id);
			int views = video.getViews() + 1;
			video.setViews(views);
			dao.update(video);
			List<Video> list = dao.selectTop5();
			request.setAttribute("videos", list);
			request.setAttribute("video", video);
		}
		request.getRequestDispatcher("/views/khachHang/Detail.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Auth.user = (User) request.getSession().getAttribute("user");
		if (Auth.user == null) {
			request.getRequestDispatcher("/views/khachHang/Home.jsp").forward(request, response);

		} else {
			String id = request.getParameter("like");
			FavoriteDAO daof = new FavoriteDAO();
			VideoDAO dao = new VideoDAO();
			Video video = dao.selectById(id);
			Favorite f;
			int i = -1;
			if (video != null) {
				for (Favorite ff : daof.selectAll()) {
					if (ff.getUser().getId().equals(Auth.user.getId()) && ff.getVideo().getId().equals(video.getId())) {
						i++;
					}
				}
			}
			if (i == -1) {
				f = new Favorite(Auth.user, video, new Date());
				daof.insert(f);
			}
			List<Favorite> fs = daof.selectAll();
			List<Video> list = new ArrayList<Video>();
			for (Favorite ff : fs) {
				if (ff.getUser().getId().equals(Auth.user.getId())) {
					list.add(ff.getVideo());
				}
			}
			request.setAttribute("videos", list);
		}
		request.getRequestDispatcher("/views/khachHang/Favorite.jsp").forward(request, response);
	}
}
