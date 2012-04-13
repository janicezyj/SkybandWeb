package controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mybeans.dao.DAOException;
import org.mybeans.form.FormBeanException;
import org.mybeans.form.FormBeanFactory;

import com.google.gdata.util.AuthenticationException;
import com.google.gdata.util.ServiceException;

public class ClickObjectAction extends Action {

	public String getName() {
		return "clickobject.do";
	}

	public String perform(HttpServletRequest request) {

		HttpSession session = request.getSession();
		ArrayList<String[]> table = (ArrayList<String[]>) session.getAttribute("table");
		int objectid = Integer.parseInt((String)request.getParameter("objectid"));
		session.setAttribute("objectid", objectid);
		String[] objectinfo = table.get(objectid);
		session.setAttribute("objectinfo", objectinfo);
			return "objectview.jsp";
	}
}

