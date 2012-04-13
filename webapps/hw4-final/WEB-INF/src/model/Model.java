/*  
This file: Model.java
Programmer: Hsueh-Hao Chang (hsuehhac@andrew.cmu.edu)
Course/Section: 15-637 Web Application Development
Assignment: Homework 4
Description: This class is used to encapsulate 
BookmarkDAO and UserDAO
Last Modified: 2/28/2011
Compiler: JavaSE 1.6
*/

package model;

import java.io.File;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

import org.mybeans.dao.DAOException;
import org.mybeans.factory.BeanTable;

public class Model {
	private BookmarkDAO bookmarkDAO;
	private UserDAO  userDAO;

	public Model(ServletConfig config) throws ServletException {
		try {
			String csvDirStr = config.getInitParameter("csvDir");
			if (csvDirStr != null && csvDirStr.length() > 0) {
				File csvDir = new File(csvDirStr);
				BeanTable.useCSVFiles(csvDir);
			} else {
				String jdbcDriver = config.getInitParameter("jdbcDriverName");
				String jdbcURL    = config.getInitParameter("jdbcURL");
				BeanTable.useJDBC(jdbcDriver,jdbcURL);
			}
			
			userDAO  = new UserDAO();
			bookmarkDAO = new BookmarkDAO();
		} catch (DAOException e) {
			throw new ServletException(e);
		}
	}
	
	public BookmarkDAO getBookmarkDAO() { return bookmarkDAO; }
	public UserDAO  getUserDAO()  { return userDAO;  }
}
