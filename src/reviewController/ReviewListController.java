package reviewController;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Res.ResVO;
import controller.Controller;
import reveiw.ReviewDAO;
import reveiw.ReviewVO;

public class ReviewListController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ReviewVO rev = new ReviewVO();
		
		ArrayList<ReviewVO> list = ReviewDAO.getInstance().selectAll(rev);
		
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("/Res/resSelect.jsp").forward(request, response);
	}

}
