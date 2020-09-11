package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Res.ResDAO;
import Res.ResVO;

public class ResListController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<ResVO> list = ResDAO.getInstance().selectAll(null);
		
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("/Res/resAll.jsp").forward(request, response);
	}

}
