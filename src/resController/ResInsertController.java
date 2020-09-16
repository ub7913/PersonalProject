package resController;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Res.ResDAO;
import Res.ResVO;
import common.Controller;

public class ResInsertController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String name = request.getParameter("name");
		String tel = request.getParameter("tel");
		String address = request.getParameter("address");
		
		ResVO res = new ResVO();
		res.setTitle(title);
		res.setContent(content);
		res.setName(name);
		res.setTel(tel);
		res.setAddress(address);
		
		int r = ResDAO.getInstance().insert(res);
		
		request.setAttribute("cnt", r);
		
		request.getRequestDispatcher("/Res/resInsertOutput.jsp").forward(request, response);

	}

}
