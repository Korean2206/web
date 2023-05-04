package com.poly.Servlet;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.poly.DAO.ShareDAO;
import com.poly.DAO.UserDAO;
import com.poly.entity.Report;
import com.poly.entity.ReportUser;
import com.poly.entity.Share;
import com.poly.entity.User;
import com.poly.utils.JpaUtil;

/**
 * Servlet implementation class ReportServlet
 */
@WebServlet({"/favoritevideo","/favoriteuser","/sharefriend"})
public class ReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EntityManager em = JpaUtil.getEntityManager();

	@Override
		protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			// TODO Auto-generated method stub
			String uri = req.getRequestURI();
			if(uri.contains("favoritevideo")) {
				String jpql = "SELECT NEW Report(o.video.title,count(o),max(o.likeDate),min(o.likeDate)) FROM Favorite o GROUP BY o.video.title";
				TypedQuery<Report> query = em.createQuery(jpql,Report.class);
				List<Report> listr = query.getResultList();
				Query nativeQuery = em.createNativeQuery("select u.id,u.fullname,u.email,f.likeDate from Users u join Favorites f on f.userId = u.ID where f.videoId in (select id from Videos where title Like  CONCAT('%',?1,'%'))");
				nativeQuery.setParameter(1, " ");
				List<Object[]> listu =  nativeQuery.getResultList();
				Query naQuery = em.createNativeQuery("select u.fullname ,u.email as 'sender', s.email as'recep',s.shareDate from Shares s join Users u on u.ID = s.userId where s.videoId in ( select id from Videos where title like CONCAT('%',?2,'%'))");
				naQuery.setParameter(2, " ");
				List<Object[]> listf =  naQuery.getResultList();
				req.setAttribute("videos", listr);
				req.setAttribute("users", listu);
				req.setAttribute("shares", listf);
				req.getRequestDispatcher("/views/admin/Report.jsp").forward(req, resp);
			}else if (uri.contains("favoriteuser")) {
				doFavorite(req, resp);
			}else if (uri.contains("sharefriend")) {
				doShare(req, resp);
			}
		}
    
	protected void doShare(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		String method = request.getMethod();
		if(method.equalsIgnoreCase("POST")) {
			String favorite = request.getParameter("fUser");

			String share = request.getParameter("share");
			String jpql = "SELECT NEW Report(o.video.title,count(o),max(o.likeDate),min(o.likeDate)) FROM Favorite o GROUP BY o.video.title";
			TypedQuery<Report> query = em.createQuery(jpql,Report.class);
			List<Report> listr = query.getResultList();
			Query nativeQuery = em.createNativeQuery("select u.id,u.fullname,u.email,f.likeDate from Users u join Favorites f on f.userId = u.ID where f.videoId in (select id from Videos where title Like  CONCAT('%',?1,'%'))");
			nativeQuery.setParameter(1, favorite);
			List<Object[]> listu =  nativeQuery.getResultList();
			Query naQuery = em.createNativeQuery("select u.fullname ,u.email as 'sender', s.email as'recep',s.shareDate from Shares s join Users u on u.ID = s.userId where s.videoId in ( select id from Videos where title like CONCAT('%',?2,'%'))");
			naQuery.setParameter(2, share);
			List<Object[]> listf =  naQuery.getResultList();
			request.setAttribute("videos", listr);
			request.setAttribute("users", listu);
			request.setAttribute("shares", listf);
			request.getRequestDispatcher("/views/admin/Report.jsp").forward(request, response);
		}
		
	}

	
	protected void doFavorite(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getMethod();
		if(method.equalsIgnoreCase("POST")) {
			String share = request.getParameter("share");
			String favorite = request.getParameter("fUser");
			String jpql = "SELECT NEW Report(o.video.title,count(o),max(o.likeDate),min(o.likeDate)) FROM Favorite o GROUP BY o.video.title";
			TypedQuery<Report> query = em.createQuery(jpql,Report.class);
			List<Report> listr = query.getResultList();
			Query nativeQuery = em.createNativeQuery("select u.id,u.fullname,u.email,f.likeDate from Users u join Favorites f on f.userId = u.ID where f.videoId in (select id from Videos where title Like  CONCAT('%',?1,'%'))");
			nativeQuery.setParameter(1, favorite);
			List<Object[]> listu =  nativeQuery.getResultList();
			Query naQuery = em.createNativeQuery("select u.fullname ,u.email as 'sender', s.email as'recep',s.shareDate from Shares s join Users u on u.ID = s.userId where s.videoId in ( select id from Videos where title like CONCAT('%',?2,'%'))");
			naQuery.setParameter(2, share);
			List<Object[]> listf =  naQuery.getResultList();
			request.setAttribute("videos", listr);
			request.setAttribute("users", listu);
			request.setAttribute("shares", listf);
			request.getRequestDispatcher("/views/admin/Report.jsp").forward(request, response);
		}

	}

}
