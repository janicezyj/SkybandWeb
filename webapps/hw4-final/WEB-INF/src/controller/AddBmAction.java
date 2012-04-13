/*  
This file: AddBmAction.java
Programmer: Hsueh-Hao Chang (hsuehhac@andrew.cmu.edu)
Course/Section: 15-637 Web Application Development
Assignment: Homework 4
Description: used to add bookmark into database
Last Modified: 2/28/2011
Compiler: JavaSE 1.6
*/

package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import model.Model;
import model.BookmarkDAO;
import model.UserDAO;

import org.mybeans.dao.DAOException;
import org.mybeans.form.FormBeanException;
import org.mybeans.form.FormBeanFactory;

import databeans.BookmarkBean;
import databeans.UserBean;
import formbeans.BookmarkForm;


/*
 * Uploads a file from the user.  If successful, sets the "userList"
 * and "photoList" request attributes, creates a new Photo bean with the
 * image, and forward (back to) manage.jsp.
 * 
 * Note that to upload a file, the multipart encoding type is used
 * in the HTML form.  This needs to be specially parsed.  The FormBeanFactory
 * can do this, but to do it, the FormBeanFactory uses the Jakarta Commons FileUpload
 * package (org.apache.commons.fileupload).
 * These classes are in the commons-fileupload-x.x.jar file in the webapp's
 * WEB-INF/lib directory.  See the User Guide on
 * http://jakarta.apache.org/commons/fileupload for details.
 */
public class AddBmAction extends Action {
	private FormBeanFactory<BookmarkForm> formBeanFactory = FormBeanFactory.getInstance(BookmarkForm.class);

	private BookmarkDAO bookmarkDAO;
	private UserDAO  userDAO;
	
	public AddBmAction(Model model) {
    	bookmarkDAO = model.getBookmarkDAO();
    	userDAO  = model.getUserDAO();
	}

	public String getName() { return "addbm.do"; }

    public String perform(HttpServletRequest request) {
        // Set up the errors list
        List<String> errors = new ArrayList<String>();
        request.setAttribute("errors",errors);
        
		try {
            // Set up user list for nav bar
			request.setAttribute("userList",userDAO.getUsers());

			UserBean user = (UserBean) request.getSession(false).getAttribute("user");
        	BookmarkBean[] bookmarkList = bookmarkDAO.getBookmarks(user.getId());
	        request.setAttribute("bookmarkList",bookmarkList);

			BookmarkForm form = formBeanFactory.create(request);
	        errors.addAll(form.getValidationErrors());
	        if (errors.size() > 0) return "error.jsp";

			BookmarkBean bookmark = new BookmarkBean();  // id & position will be set when created
			String url = form.getUrl();
			int userId = user.getId();
			
   			if (bookmarkDAO.lookupUrl(userId, url).length!=0){
   				errors.add("Cannot add duplicate websites");
   				return "error.jsp";
   			}
   			
    		if (!url.startsWith("http://"))
    			url = "http://" + url;
    		
			bookmark.setUrl(fixBadChars(url));
			bookmark.setComment(fixBadChars(form.getComment()));
			bookmark.setUserId(userId);
			bookmarkDAO.create(bookmark);

			// Update photoList (there's now one more on the list)
        	BookmarkBean[] newBookmarkList = bookmarkDAO.getBookmarks(userId);
	        request.setAttribute("bookmarkList",newBookmarkList);
	        return "manage.jsp";
	 	} catch (DAOException e) {
			errors.add(e.getMessage());
			return "manage.jsp";
	 	} catch (FormBeanException e) {
			errors.add(e.getMessage());
			return "manage.jsp";
		}
    }
    
    private String fixBadChars(String s) {
		if (s == null || s.length() == 0) return s;
		
		Pattern p = Pattern.compile("[<>\"&]");
        Matcher m = p.matcher(s);
        StringBuffer b = null;
        while (m.find()) {
            if (b == null) b = new StringBuffer();
            switch (s.charAt(m.start())) {
                case '<':  m.appendReplacement(b,"&lt;");
                           break;
                case '>':  m.appendReplacement(b,"&gt;");
                           break;
                case '&':  m.appendReplacement(b,"&amp;");
                		   break;
                case '"':  m.appendReplacement(b,"&quot;");
                           break;
                default:   m.appendReplacement(b,"&#"+((int)s.charAt(m.start()))+';');
            }
        }
        
        if (b == null) return s;
        m.appendTail(b);
        return b.toString();
    }
    
}
