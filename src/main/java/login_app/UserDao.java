package login_app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;




public class UserDao {
	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;
	private EntityTransaction entityTransaction;

	private EntityManager getManager() {
		entityManagerFactory = Persistence.createEntityManagerFactory("student");
		return entityManagerFactory.createEntityManager();
	}

	public void saveUser(User user) {
		entityManager = getManager();
		entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(user);
		entityTransaction.commit();
	}

	public User getUserById(int id) {
		entityManager = getManager();
		return entityManager.find(User.class, id);
	}
	public List<User> getAllUser() {
		entityManager = getManager();
		Query query=entityManager.createQuery("select c from User c");
		return query.getResultList();
	}
	public void updateUser(User user) {
		entityManager = getManager();
		entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.merge(user);
			entityTransaction.commit();
		
	}
	public User validateUser(String email, String pass )
	{
		entityManager = getManager();
		Query query=entityManager.createQuery("select u from User u where u.email=?1 and u.password=?2");
		query.setParameter(1, email);
		query.setParameter(2, pass);
		List<User> user=query.getResultList();
		System.out.println(user);
		if(user !=null && user.size()>0) {
			return user.get(0);
		}
		else {
			return null;
		}
	}
	public boolean delete(int id) {
		entityManager = getManager(); 
		entityTransaction = entityManager.getTransaction();
		User user=entityManager.find(User.class, id);
		if(user!=null) {
			entityTransaction.begin();
			entityManager.remove(user);
			entityTransaction.commit();
			return true;
		}
		else {
			return false;
		}
	}

}
