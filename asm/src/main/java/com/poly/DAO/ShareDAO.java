package com.poly.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.poly.entity.Share;
import com.poly.entity.User;
import com.poly.utils.JpaUtil;

public class ShareDAO extends onlineDAO<Share,Long>{
	private EntityManager em = JpaUtil.getEntityManager();

	@Override
	public void insert(Share entity) {
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
	public void update(Share entity) {
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
			Share entity = em.find(Share.class, key);
			em.remove(entity);
			em.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			em.getTransaction().rollback();
			}
		
	}

	@Override
	public List<Share> selectAll() {
		String jpql = "SELECT o FROM Share o";
		// TODO Auto-generated method stub
		TypedQuery<Share> query = em.createQuery(jpql,Share.class);
		return query.getResultList();
	}

	@Override
	public Share selectById(Long key) {
		// TODO Auto-generated method stub
		return null;
	}

}
