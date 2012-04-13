/*  
This file: BookmarkDAO.java
Programmer: Hsueh-Hao Chang (hsuehhac@andrew.cmu.edu)
Course/Section: 15-637 Web Application Development
Assignment: Homework 4
Description: The DAO processes the transactions with 
the bookmark database - hsuehhac_bookmark
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
import org.mybeans.factory.MatchArg;
import org.mybeans.factory.RollbackException;
import org.mybeans.factory.Transaction;

import databeans.BookmarkBean;
import databeans.UserBean;

public class BookmarkDAO {
	private BeanFactory<BookmarkBean> factory;
	
	public BookmarkDAO() throws DAOException {
		try {
	        // Get a BeanTable to create the "photo" table
	        BeanTable<BookmarkBean> bookmarkTable = BeanTable.getInstance(BookmarkBean.class,"hsuehhac_bookmark");
	        
	        if (!bookmarkTable.exists()) bookmarkTable.create("bookmarkId");
	        
	        // Long running web apps need to clean up idle database connections.
	        // So we can tell each BeanTable to clean them up.  (You would only notice
	        // a problem after leaving your web app running for several hours.)
	        bookmarkTable.setIdleConnectionCleanup(true);
	
	        // Get a BeanFactory which the actions will use to read and write
	        // rows of the "photo" table
	        factory = bookmarkTable.getFactory();
		} catch (BeanFactoryException e) {
			throw new DAOException(e);
		}
	}

	public void create(BookmarkBean newBookmark) throws DAOException {
		try {
			Transaction.begin();
			
			BookmarkBean dbBookmark = factory.create();
			newBookmark.setClickCount(0);
			factory.copyInto(newBookmark,dbBookmark);
			
			Transaction.commit();
		} catch (RollbackException e) {
			throw new DAOException(e);
		} finally {
			if (Transaction.isActive()) Transaction.rollback();
		}
	}

	public void create(String url, String comment, int userId) throws DAOException {
        try {
        	Transaction.begin();
			BookmarkBean dbBookmark = factory.create();
			dbBookmark.setClickCount(0);
			dbBookmark.setUrl(url);
			dbBookmark.setComment(comment);
			dbBookmark.setUserId(userId);
			
			Transaction.commit();
		} catch (RollbackException e) {
			throw new DAOException(e);
		} finally {
			if (Transaction.isActive()) Transaction.rollback();
		}
	} 
			
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
	
	public void delete(int bookmarkId, int userId) throws DAOException {
		try {
			Transaction.begin();
    		BookmarkBean p = factory.lookup(bookmarkId);

    		if (p == null) {
				throw new DAOException("Bookmark does not exist: id="+bookmarkId);
    		}

    		if (userId != p.getUserId()) {
				throw new DAOException("This Bookmark not owned by you");
    		}
			factory.delete(bookmarkId);
			
			Transaction.commit();
		} catch (RollbackException e) {
			throw new DAOException(e);
		} finally {
			if (Transaction.isActive()) Transaction.rollback();
		}
	}
	
	public BookmarkBean[] getBookmarks(int userId) throws DAOException {
		try {
			BookmarkBean[] list = factory.match(MatchArg.equals("userId",userId));
			Arrays.sort(list);
			return list;
		} catch (RollbackException e) {
			throw new DAOException(e);
		}
	}
	
	public BookmarkBean lookup(int bookmarkId) throws DAOException {
		try {
			return factory.lookup(bookmarkId);
		} catch (RollbackException e) {
			throw new DAOException(e);
		}
	}
	
	public int updateClickCount(int bmid) throws DAOException {
		BookmarkBean bm;
		int count;
		try {
			Transaction.begin();
			bm = factory.lookup(bmid);
			count = bm.getClickCount()+1;
			bm.setClickCount(count);
			Transaction.commit();
			return count;
		} catch (RollbackException e) {
			throw new DAOException(e);
		} finally {
			if (Transaction.isActive()) Transaction.rollback();
		}		
	}
	
    public BookmarkBean[] lookupUrl(int userid, String url) throws DAOException {
		try {
			return factory.match(MatchArg.equals("userId", userid),MatchArg.equals("url", url));
		} catch (RollbackException e) {
			throw new DAOException(e);
		}
	}
}
