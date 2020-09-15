package Res;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import common.ConnectionManager;

public class ResDAO {

	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	static ResDAO instance;
	public static ResDAO getInstance() {
		if(instance==null)
			instance=new ResDAO();
			return instance;
	}
	
	//삽입
		public int insert(ResVO resVO) {
			int r=0;
			try {
				//1. DB 연결
				conn = ConnectionManager.getConnnect();
				//2. sql 구문 실행
				String sql="insert into res (no, title, content, name, tel, address, regdate, filename) "
						+ "values (res_seq.nextval, ?, ?, ?, ?, ?, sysdate, ?)";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, resVO.getTitle());
				pstmt.setString(2, resVO.getContent());
				pstmt.setString(3, resVO.getName());
				pstmt.setString(4, resVO.getTel());
				pstmt.setString(5, resVO.getAddress());
				pstmt.setString(6, resVO.getFilename());
				r = pstmt.executeUpdate();
				//3. 결과처리
				System.out.println(r + " 건이 처리됨");
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				//4. 연결해제(오라클 서버에 접속 할 수 있는 세션수는 제한 적이기 때문에 연결 해제를 하지 않으면 다음에 연결 못하는 상황이 일어 날수 있기 때문에 각 실행후 연결 해제 필요)
				ConnectionManager.close(conn);
			}	
			return r;
		}
		
		//수정
		public void update(ResVO resVO) {
			try {
				conn = ConnectionManager.getConnnect();
				String sql = "update res set content = ? where no = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, resVO.getContent());
				pstmt.setInt(2, resVO.getNo());
				int r = pstmt.executeUpdate();
				System.out.println(r + " 건이 수정됨");
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				ConnectionManager.close(null, pstmt, conn);
			}
		}
		
		//삭제
		public void delete(ResVO resVO) {
			try {
				conn = ConnectionManager.getConnnect();
				String sql = "delete res where no = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, resVO.getNo());
				int r = pstmt.executeUpdate();
				System.out.println(r + " 건이 삭제됨");
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				ConnectionManager.close(null, pstmt, conn);
			}
		}
	
	

		
	public ArrayList<ResVO> selectAll(ResVO res) {
		ResVO resultVO = null;
		ResultSet rs = null;
		ArrayList<ResVO> list = new ArrayList<ResVO>();//리턴값을 저장할 변수 저장
		try {
			conn = ConnectionManager.getConnnect();
			String sql = "SELECT no, title, content, name, tel, address, regdate, filename"
					+ " FROM res"
					+ " ORDER BY no";
			pstmt=conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				resultVO = new ResVO();
				resultVO.setNo(rs.getInt("no"));
				resultVO.setTitle(rs.getString("title"));
				resultVO.setContent(rs.getString("content"));
				resultVO.setName(rs.getString("name"));
				resultVO.setTel(rs.getString("tel"));
				resultVO.setAddress(rs.getString("address"));
				resultVO.setRegdate(rs.getString("regdate"));
				resultVO.setFilename(rs.getString("filename"));
				list.add(resultVO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.close(rs, pstmt, conn);
		}
		return list;	
	}
	
	public ResVO selectOne(ResVO res) {
		ResVO resultVO = null;
		ResultSet rs = null;
		try {
			conn = ConnectionManager.getConnnect();
			String sql = "SELECT no, title, content, name, tel, address, regdate, filename"
					+ " FROM res"
					+ " WHERE no = ?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, res.getNo());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				resultVO = new ResVO();
				resultVO.setNo(rs.getInt(1));
				resultVO.setTitle(rs.getString("title"));
				resultVO.setContent(rs.getString("content"));
				resultVO.setName(rs.getString("name"));
				resultVO.setTel(rs.getString("tel"));
				resultVO.setAddress(rs.getString("address"));
				resultVO.setRegdate(rs.getString("regdate"));
				resultVO.setFilename(rs.getString("filename"));
			} else {
				System.out.println("no data");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.close(rs, pstmt, conn);//rs를 try안에서 선언하면 지역 변수 이기 때문에 try안에서만 사용 됨 , 그러니까 변수를 try밖으로 빼주고 초기값 null을 주면 에러없이 사용 가능
		}
		return resultVO;
	}
}
