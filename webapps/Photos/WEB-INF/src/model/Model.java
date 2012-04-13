package model;

import java.io.File;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

import org.mybeans.dao.DAOException;
import org.mybeans.factory.BeanTable;

public class Model {
	private PhotoDAO photoDAO;
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
			photoDAO = new PhotoDAO();
		} catch (DAOException e) {
			throw new ServletException(e);
		}
	}
	
	public PhotoDAO getPhotoDAO() { return photoDAO; }
	public UserDAO  getUserDAO()  { return userDAO;  }
}
