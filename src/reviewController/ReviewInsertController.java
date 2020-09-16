package reviewController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Controller;
import reveiw.ReviewDAO;
import reveiw.ReviewVO;

public class ReviewInsertController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String poster = request.getParameter("poster");
		String content = request.getParameter("content");
		
		ReviewVO rev = new ReviewVO();
		rev.setPoster(poster);
		rev.setContent(content);
		
		int r = ReviewDAO.getInstance().insert(rev);
		System.out.println(r+"건이 실행됨");
		
		request.setAttribute("cnt", r);
		
		response.sendRedirect("reviewList.do");
		//request.getRequestDispatcher("/review/reviewList.do").forward(request, response);
		
	}

}
