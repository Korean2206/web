package com.poly.Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.poly.DAO.UserDAO;
import com.poly.DAO.VideoDAO;
import com.poly.entity.User;
import com.poly.entity.Video;
import com.poly.utils.Auth;

/**
 * Servlet implementation class VideoManagerServlet
 */
@WebServlet({ "/user/index", "/user/update", "/user/delete", "/user/edit/*" })
public class UserManageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uri = req.getRequestURI();
		if (uri.contains("index")) {
			UserDAO dao = new UserDAO();
			List<User> list = dao.selectAll();
			req.setAttribute("count", list.size());
			req.setAttribute("users", list);
			req.getRequestDispatcher("/views/admin/ManageUser.jsp").forward(req, resp);
		} else if (uri.contains("update")) {
			doUpdate(req, resp);
		} else if (uri.contains("delete")) {
			doDelete(req, resp);
		} else if (uri.contains("edit")) {
			doEdit(req, resp);
		}
	}

	protected void doUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String method = req.getMethod();
		String message = "";
		Auth.user = (User) req.getSession().getAttribute("user");
		if (Auth.isLogin()) {
			if (method.equalsIgnoreCase("POST")) {
				String username = req.getParameter("username");
				String fullname = req.getParameter("fullname");
				String password = req.getParameter("password");
				String email = req.getParameter("email");
				UserDAO dao = new UserDAO();
				User user = dao.selectById(username);
				user.setFullname(fullname);
				user.setPassword(password);
				user.setEmail(email);
				if (Auth.isAdmin()) {
					dao.update(user);
					message = "Update thành công";
					List<User> list = dao.selectAll();
					req.setAttribute("count", list.size());
					req.setAttribute("users", list);
				} else {
					message = "Bạn phải là admin";
				}
			}
		} else {
			message = "bạn cần phải đăng nhập";
		}
		req.setAttribute("message", message);
		req.getRequestDispatcher("/views/admin/ManageUser.jsp").forward(req, resp);

	}

	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String method = req.getMethod();
		String message = "";
		Auth.user = (User) req.getSession().getAttribute("user");
		if (Auth.isLogin()) {
			if (method.equalsIgnoreCase("POST")) {
				String username = req.getParameter("username");
				UserDAO dao = new UserDAO();
				if (Auth.isAdmin()) {
					dao.delete(username);
					message = "Xóa thành công";
					List<User> list = dao.selectAll();
					req.setAttribute("count", list.size());
					req.setAttribute("users", list);
				} else {
					message = "Bạn phải là admin";
				}
			}
		} else {
			message = "bạn cần phải đăng nhập";
		}
		req.setAttribute("message", message);
		req.getRequestDispatcher("/views/admin/ManageUser.jsp").forward(req, resp);
	}

	protected void doEdit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		String id = uri.substring(uri.lastIndexOf("/") + 1);
		UserDAO dao = new UserDAO();
		User user = dao.selectById(id);
		List<User> list = dao.selectAll();
		req.setAttribute("count", list.size());
		req.setAttribute("users", list);
		req.setAttribute("user", user);
		req.setAttribute("disabled", "readonly");
		req.getRequestDispatcher("/views/admin/ManageUser.jsp").forward(req, resp);

	}
}
