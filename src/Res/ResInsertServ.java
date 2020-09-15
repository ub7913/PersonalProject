package Res;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import common.FileRenamePolicy;

@MultipartConfig( location = "c:/upload",
				  maxRequestSize = 1024*1024*10 )
@WebServlet("/ResInsertServ")
public class ResInsertServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String name = request.getParameter("name");
		String tel = request.getParameter("tel");
		String address = request.getParameter("address");
		String filename = request.getParameter("filename");
		
		ResVO res = new ResVO();
		res.setTitle(title);
		res.setContent(content);
		res.setName(name);
		res.setTel(tel);
		res.setAddress(address);
		res.setFilename(filename);
		
		//파일이름가져오기
		Part part = request.getPart("filename");
		String fileName = getFileName(part);//원래 파일이름을 가져옴
		String path = request.getServletContext().getRealPath("/images");
		System.out.println(path);
		//파일명 중복체크
		File renameFile = FileRenamePolicy.rename(new File(path, fileName));
		part.write(path + "/" + renameFile.getName());
		res.setFilename(renameFile.getName());
		
		//3. 파일명이 수정된 VO를 가지고 dao를 실행(등록)
		int r = ResDAO.getInstance().insert(res);
		
		request.setAttribute("cnt", r);
		
		request.getRequestDispatcher("/Res/resInsertOutput.jsp").forward(request, response);
	}
	
	private String getFileName(Part part) throws UnsupportedEncodingException {
		for (String cd : part.getHeader("Content-Disposition").split(";")) {
			if (cd.trim().startsWith("filename")) {
				return cd.substring(cd.indexOf('=') + 1).trim()
						.replace("\"", "");
			}
		}
		return null;
	}

}
