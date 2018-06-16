//package com.jeff.learn.hellospringboot;
//
//import java.math.BigInteger;
//import java.util.Set;
//
//import javax.annotation.Resource;
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//
//import org.springframework.stereotype.Repository;
//
//@Repository
//public class PlayerInfoDao {
//
//	@PersistenceContext
//	private EntityManager entityManager;
//	
//	
//	BigInteger savePlayers(Set<PlayerInfo> players) {
//		players.forEach(e -> entityManager.persist(e));
//		return (BigInteger) entityManager.createNativeQuery("select last_insert_id()").getResultList().get(0);
//	}
//	
//	BigInteger getLastId() {
//		return (BigInteger) entityManager.createNativeQuery("select last_insert_id()").getResultList().get(0);
//	}
//}
