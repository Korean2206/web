package com.poly.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.poly.entity.Favorite;
import com.poly.entity.User;
import com.poly.entity.Video;
import com.poly.utils.JpaUtil;

public class FavoriteDAO extends onlineDAO<Favorite,Long> {

	private EntityManager em = JpaUtil.getEntityManager();
	@Override
	public void insert(Favorite entity) {
		try {
			em.getTransaction().begin();
			em.persist(entity);
			em.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			em.getTransaction().rollback();
			}
	}

	@Override
	public void update(Favorite entity) {
		// TODO Auto-generated method stub
		try {
			em.getTransaction().begin();
			em.merge(entity);
			em.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			em.getTransaction().rollback();
			}
	}

	@Override
	public void delete(Long key) {
		// TODO Auto-generated method stub
		try {
			em.getTransaction().begin();
			Favorite entity = em.find(Favorite.class, key);
			em.remove(entity);
			em.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			em.getTransaction().rollback();
			}
	}

	@Override
	public List<Favorite> selectAll() {
		String jpql = "SELECT DISTINCT o FROM Favorite o";
		TypedQuery<Favorite> query = em.createQuery(jpql,Favorite.class);
		return query.getResultList();
	}

	@Override
	public Favorite selectById(Long key) {
		// TODO Auto-generated method stub
		return null;
	}
	public Favorite selectByVideoID(String id) {
		String jpql = "SELECT o FROM Favorite o WHERE o.video.id LIKE :key ";
		TypedQuery<Favorite> query = em.createQuery(jpql,Favorite.class);
		query.setParameter("key", id);
		return query.getSingleResult();
	}
	public Favorite selectUnLike(String videoID, String userID) {
		String jpql = "SELECT o FROM Favorite o WHERE o.video.id LIKE :vid AND o.user.id LIKE :uid";
		TypedQuery<Favorite> query = em.createQuery(jpql,Favorite.class);
		query.setParameter("vid", videoID);
		query.setParameter("uid", userID);
		return query.getSingleResult();
	}

}
