package controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gdata.util.AuthenticationException;
import com.google.gdata.util.ServiceException;

public class SettingAction extends Action {

	public String getName() {
		return "setting.do";
	}

	public String perform(HttpServletRequest request) {
		return "setting.jsp";
	}
}

