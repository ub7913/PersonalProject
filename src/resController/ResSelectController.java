package resController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Res.ResDAO;
import Res.ResVO;
import common.Controller;

public class ResSelectController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ResVO resVO = new ResVO();
		int no = Integer.parseInt(request.getParameter("no"));
		resVO.setNo(no);
		
		ResDAO dao = new ResDAO();
		ResVO res = dao.selectOne(resVO);
		
		request.setAttribute("res", res);
		
		request.getRequestDispatcher("/Res/resSelect.jsp").forward(request, response);
		//web프로젝트에서 forward보낼때 경로는 폴더명 없었는데, frontController를 쓰는 프로젝트는 jsp파일 앞에 폴더명 씀.. 왜?
	}

}
