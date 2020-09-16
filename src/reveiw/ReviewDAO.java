package reveiw;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Res.ResVO;
import common.ConnectionManager;

public class ReviewDAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	static ReviewDAO instance;
	public static ReviewDAO getInstance() {
		if(instance==null)
			instance=new ReviewDAO();
			return instance;
	}
	
		//삽입
		public int insert(ReviewVO ReviewVO) { //메소드 안에 변수를 담을게 많으면 VO클래스를 만드는 것이 효율적이다.
			int r = 0;
			try {
				//1. DB 연결
				conn = ConnectionManager.getConnnect();
				//2. sql 구문 실행
				String sql="insert into review (no,poster,content,regdate) "
						+ "values (review_seq.nextval, ?, ?, sysdate)";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, ReviewVO.getPoster());
				pstmt.setString(2, ReviewVO.getContent());
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
		
		
		public ArrayList<ReviewVO> selectAll(ReviewVO rev) {
			ReviewVO resultVO = null;
			ResultSet rs = null;
			ArrayList<ReviewVO> list = new ArrayList<ReviewVO>();//리턴값을 저장할 변수 저장
			try {
				conn = ConnectionManager.getConnnect();
				
				String sql = "select a.*     from( select b.* , rownum rn    from("
						+ "select *"
						+ " FROM review"
						+ " ORDER BY no"
						+ " ) b )a where rn between ? and ?";
				pstmt=conn.prepareStatement(sql);
				pstmt.setInt(1, rev.getFirst());
				pstmt.setInt(2, rev.getLast());
				rs = pstmt.executeQuery();
				while(rs.next()) {
					resultVO = new ReviewVO();
					resultVO.setNo(rs.getInt("no"));
					resultVO.setPoster(rs.getString("poster"));
					resultVO.setContent(rs.getString("content"));
					resultVO.setRegdate(rs.getString("regdate"));
					list.add(resultVO);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				ConnectionManager.close(rs, pstmt, conn);
			}
			return list;	
		}
		
		public int count(ReviewVO reviewVO) {
			int cnt = 0;
			try {
				conn = ConnectionManager.getConnnect();
				String sql = "select count(*) from res";
				pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
				rs.next();
				cnt = rs.getInt(1);
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				ConnectionManager.close(conn);
			}
			return cnt;
		}
}
