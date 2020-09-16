package reviewController;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Res.ResVO;
import common.Controller;
import common.Paging;
import reveiw.ReviewDAO;
import reveiw.ReviewVO;

public class ReviewListController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ReviewDAO dao = new ReviewDAO();
		
		String p = request.getParameter("p");
		
		//유효성 체크
		int page = 1;
		if(p != null) {
			page = Integer.parseInt(p);
		}
		Paging paging = new Paging();
		paging.setPageUnit(5);//한페이지에 보일 건수
		paging.setPageSize(5);//페이지 번호수
		paging.setPage(page);
		
		ReviewVO rev = new ReviewVO();
		
		paging.setTotalRecord(dao.count(rev));
		rev.setFirst(paging.getFirst());
		rev.setLast(paging.getLast());
		
		ArrayList<ReviewVO> list = ReviewDAO.getInstance().selectAll(rev);
		
		request.setAttribute("list", list);
		request.setAttribute("paging", paging);
		
		request.getRequestDispatcher("/Res/resSelect.jsp").forward(request, response);
	}

}
