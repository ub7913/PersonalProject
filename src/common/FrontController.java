package common;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import resController.ResDeleteController;
import resController.ResFilenameDownloadCon;
import resController.ResInsertController;
import resController.ResListController;
import resController.ResSearchController;
import resController.ResSearchPageController;
import resController.ResSelectController;
import resController.ResUpdateController;
import reviewController.ReviewInsertController;
import reviewController.ReviewListController;

@MultipartConfig
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
		list.put("/resSelect.do", new ResSelectController());
		list.put("/resSearchPage.do", new ResSearchPageController());
		list.put("/resSearch.do", new ResSearchController());
		list.put("/resDelete.do", new ResDeleteController());
		list.put("/resList.do", new ResListController());
		list.put("/resFilenameDownload.do", new ResFilenameDownloadCon());
		
		//review
		list.put("/reviewInsert.do", new ReviewInsertController());
		list.put("/reviewList.do", new ReviewListController());
		
	}
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding(charset);
		String uri = request.getRequestURI();
		String contextPath = request.getContextPath(); 
		String path = uri.substring(contextPath.length()); 
		Controller subController = list.get(path);
		
		System.out.println("uri: "+uri);
		System.out.println("contextPath: " + contextPath);
		System.out.println("path: " + path);
		
		subController.execute(request, response);
	}
	
}
