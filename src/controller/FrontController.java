package controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FrontController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	String charset = null;
	HashMap<String, Controller> list = null;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		charset = config.getInitParameter("charset");
		list = new HashMap<String, Controller>();
		list.put("/resInsert.do", new ResInsertController());
		list.put("/resUpdate.do", new ResUpdateController());
		list.put("/resSearchPage.do", new ResSearchPageController());
		list.put("/resSearch.do", new ResSearchController());
		list.put("/resDelete.do", new ResDeleteController());
		list.put("/resList.do", new ResListController());
	}
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding(charset);
		String uri = request.getRequestURI();
		String contextPath = request.getContextPath(); 
		String path = uri.substring(contextPath.length()); 
		Controller subController = list.get(path);
		subController.execute(request, response);
	}
	
}
