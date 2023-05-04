package com.poly.Servlet;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.poly.DAO.VideoDAO;
import com.poly.entity.Video;

/**
 * Servlet implementation class VideoManagerServlet
 */

@WebServlet({ "/video/index", "/video/create", "/video/update", "/video/delete", "/video/edit/*" })
@MultipartConfig()
public class VideoManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		VideoDAO dao = new VideoDAO();
		if (uri.contains("create")) {
			this.doCreate(req, resp);
		} else if (uri.contains("update")) {
			this.doUpdate(req, resp);
		} else if (uri.contains("delete")) {
			this.doDelete(req, resp);
		} else if (uri.contains("edit")) {
			this.doEdit(req, resp);
		}else if(uri.contains("index")){
			List<Video> list = dao.selectAll();
			
			req.setAttribute("videos", list);
			
			req.getRequestDispatcher("/views/admin/ManageVideo.jsp").forward(req, resp);
		}
	}

	protected void doCreate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String method = req.getMethod();
			VideoDAO dao = new VideoDAO();
			String message = "";
			if(method.equalsIgnoreCase("POST")) {
				File dir = new File(req.getServletContext().getRealPath("/files"));
				if(!dir.exists()) {
					dir.mkdirs();
				}
				Part photo = req.getPart("photo_file");
				File photoFile = new File(dir,photo.getSubmittedFileName());
				System.out.println(photoFile.getName());
				String poster = "img/" + photoFile.getName();
				String id = req.getParameter("videoid");
				String title = req.getParameter("title");
				Boolean active = Boolean.parseBoolean(req.getParameter("status"));
				System.out.println(active);
				String des = req.getParameter("description");
				Video v = new Video(id,title,poster,0,des,active);
				dao.insert(v);
				List<Video> list = dao.selectAll();
				message= "Tạo video thành công";
				req.setAttribute("videos", list);
				req.setAttribute("message", message);
			}
			req.getRequestDispatcher("/views/admin/ManageVideo.jsp").forward(req, resp);


	}

	protected void doUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String method = req.getMethod();
		VideoDAO dao = new VideoDAO();
		String message = "";
		if(method.equalsIgnoreCase("POST")) {
			File dir = new File(req.getServletContext().getRealPath("/files"));
			if(!dir.exists()) {
				dir.mkdirs();
			}
			Part photo = req.getPart("photo_file");
			File photoFile = new File(dir,photo.getSubmittedFileName());
			String poster = "";
			System.out.println(photoFile.getName());
			if(photoFile.getName().equals("files")) {
				poster = req.getParameter("image");
			}else {				
			poster = "img/"+ photoFile.getName();
			}
			System.out.println(poster);
			String id = req.getParameter("videoid");
			String title = req.getParameter("title");
			Boolean active = Boolean.parseBoolean(req.getParameter("status"));
			System.out.println(active);
			String des = req.getParameter("description");
			Video v = new Video(id,title,poster,0,des,active);
			dao.update(v);
			List<Video> list = dao.selectAll();
			message= "Update video thành công";
			req.setAttribute("videos", list);
			req.setAttribute("message", message);
		}
		req.getRequestDispatcher("/views/admin/ManageVideo.jsp").forward(req, resp);

	}

	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String method = req.getMethod();
		VideoDAO dao = new VideoDAO();
		String message = "";
		if(method.equalsIgnoreCase("POST")) {
			String id = req.getParameter("videoid");
			dao.delete(id);
			List<Video> list = dao.selectAll();
			message= "Xóa video thành công";
			req.setAttribute("videos", list);
			req.setAttribute("message", message);
		}
		req.getRequestDispatcher("/views/admin/ManageVideo.jsp").forward(req, resp);

	}

	protected void doEdit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		String id = uri.substring(uri.lastIndexOf("/") + 1);
		VideoDAO dao = new VideoDAO();
		Video video = dao.selectById(id);
		List<Video> list = dao.selectAll();
		req.setAttribute("img", video.getPoster());
		req.setAttribute("videos", list);
		req.setAttribute("video", video);
		req.setAttribute("disabled", "readonly");
		req.getRequestDispatcher("/views/admin/ManageVideo.jsp").forward(req, resp);

	}
}
