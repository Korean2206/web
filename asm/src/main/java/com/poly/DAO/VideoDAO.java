package com.poly.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.poly.entity.Report;
import com.poly.entity.User;
import com.poly.entity.Video;
import com.poly.utils.JpaUtil;

public class VideoDAO extends onlineDAO<Video,String> {
	private EntityManager em = JpaUtil.getEntityManager();

	@Override
	public void insert(Video entity) {
		// TODO Auto-generated method stub
		try {
			em.getTransaction().begin();
			em.persist(entity);
			em.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			em.getTransaction().rollback();
			}
	}

	@Override
	public void update(Video entity) {
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
	public void delete(String key) {
		// TODO Auto-generated method stub
		try {
			em.getTransaction().begin();
			Video entity = em.find(Video.class, key);
			em.remove(entity);
			em.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			em.getTransaction().rollback();
			}
	}

	@Override
	public List<Video> selectAll() {
		// TODO Auto-generated method stub
		String jpql = "SELECT DISTINCT o FROM Video o";
		TypedQuery<Video> query = em.createQuery(jpql,Video.class);
		return query.getResultList();
	}

	@Override
	public Video selectById(String key) {
		Video entity = em.find(Video.class, key);
		return entity;
	}
	public List<Video> selectTop5() {
		Query query = em.createNamedQuery("Report.random5");
		return query.getResultList();
	}
	
	
}
