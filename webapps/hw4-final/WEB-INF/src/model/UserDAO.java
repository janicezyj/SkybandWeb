/*  
This file: UserDAO.java
Programmer: Hsueh-Hao Chang (hsuehhac@andrew.cmu.edu)
Course/Section: 15-637 Web Application Development
Assignment: Homework 4
Description: The DAO processes the transactions with 
the user database - hsuehhac_user
Last Modified: 2/28/2011
Compiler: JavaSE 1.6
*/

package model;

import java.util.Arrays;

import org.mybeans.dao.DAOException;
import org.mybeans.factory.BeanFactory;
import org.mybeans.factory.BeanFactoryException;
import org.mybeans.factory.BeanTable;
import org.mybeans.factory.DuplicateKeyException;
import org.mybeans.factory.RollbackException;
import org.mybeans.factory.Transaction;

import databeans.UserBean;


public class UserDAO {
	private BeanFactory<UserBean> factory;
	
	public UserDAO() throws DAOException {
		try {
			// Get a BeanTable so we can create the "user" table
	        BeanTable<UserBean> userTable = BeanTable.getInstance(UserBean.class,"hsuehhac_user");
	        
	        if (!userTable.exists()) userTable.create("email");
	        
	        // Long running web apps need to clean up idle database connections.
	        // So we can tell each BeanTable to clean them up.  (You would only notice
	        // a problem after leaving your web app running for several hours.)
	        userTable.setIdleConnectionCleanup(true);
	
	        // Get a BeanFactory which the actions will use to read and write rows of the "user" table
	        factory = userTable.getFactory();
		} catch (BeanFactoryException e) {
			throw new DAOException(e);
		}
	}
	
	public void create(UserBean user) throws DAOException {
        try {
        	Transaction.begin();
			UserBean dbUser = factory.create(user.getEmail());
			user.setId(factory.getBeanCount()+1);
			factory.copyInto(user,dbUser);
			
			Transaction.commit();
		} catch (DuplicateKeyException e) {
			throw new DAOException("The email: "+user.getEmail()+" already exists");
		} catch (RollbackException e) {
			throw new DAOException(e);
		} finally {
			if (Transaction.isActive()) Transaction.rollback();
		}
	}
	
	public void create(String email, String firstName, String lastName, String password) throws DAOException {
        try {
        	Transaction.begin();
			UserBean dbUser = factory.create(email);
			dbUser.setId(factory.getBeanCount()+1);
			dbUser.setFirstName(firstName);
			dbUser.setLastName(lastName);
			dbUser.setPassword(password);
			
			Transaction.commit();
		} catch (DuplicateKeyException e) {
			throw new DAOException("The email: "+ email+" already exists");
		} catch (RollbackException e) {
			throw new DAOException(e);
		} finally {
			if (Transaction.isActive()) Transaction.rollback();
		}
	}
	
	public UserBean lookup(String email) throws DAOException {
		try {
			return factory.lookup(email);
		} catch (RollbackException e) {
			throw new DAOException(e);
		}
	}
	
	protected BeanFactory<UserBean> getFactory() { return factory; }
	
	public boolean isEmpty() throws DAOException{
		try {
			if (factory.getBeanCount()==0)
				return true;
			else
				return false;
		} catch (RollbackException e) {
			throw new DAOException(e);
		} finally {
			if (Transaction.isActive()) Transaction.rollback();
		}
	}
	
	public UserBean[] getUsers() throws DAOException {
		try {
			UserBean[] users = factory.match();
			Arrays.sort(users);  // We want them sorted by last and first names (as per User.compareTo());
			return users;
		} catch (RollbackException e) {
			throw new DAOException(e);
		}
	}
	
	public void setPassword(String email, String password) throws DAOException {
        try {
        	Transaction.begin();
			UserBean dbUser = factory.lookup(email);
			
			if (dbUser == null) {
				throw new DAOException("Email: "+email+" no longer exists");
			}
			
			dbUser.setPassword(password);
			Transaction.commit();
		} catch (RollbackException e) {
			throw new DAOException(e);
		} finally {
			if (Transaction.isActive()) Transaction.rollback();
		}
	}
}
