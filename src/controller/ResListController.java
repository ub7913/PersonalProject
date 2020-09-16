package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Res.ResDAO;
import Res.ResVO;
import common.Paging;

public class ResListController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ResDAO dao = new ResDAO();
		
		//파라미터 받기
		String p = request.getParameter("p");
		String name = request.getParameter("name");
		
		//유효성 체크
		int page = 1;
		if(p != null) {
			page = Integer.parseInt(p);
		}
		Paging paging = new Paging();
		paging.setPageUnit(3);//한페이지에 보일 건수
		paging.setPageSize(5);//페이지 번호수
		paging.setPage(page);
		
		//VO에 담기
		ResVO res = new ResVO();
		res.setName(name);
		
		paging.setTotalRecord(dao.count(res));
		res.setFirst(paging.getFirst());
		res.setLast(paging.getLast());
		
		//전체조회 실행
		List<ResVO> list = ResDAO.getInstance().selectAll(res);
		
		request.setAttribute("list", list);
		request.setAttribute("paging", paging);
		
		request.getRequestDispatcher("/Res/resAll.jsp").forward(request, response);
	}

}
