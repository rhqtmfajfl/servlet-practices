package com.poscoict.guestbook.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.poscoict.guestbook.vo.guestbookVo;


public class guestbookDao {
	
	public boolean delete(int no,String password) {

		boolean result = false;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
//		String password = request.getParameter("") 
		
		try {
			
			conn = getConnection();			
		
			//3. SQL 준비
			String sql = "delete from guestbook where no = " + no + " and password = " + password ;
			pstmt = conn.prepareStatement(sql); // 
			
			//4. 바인딩(binding)
//			pstmt.setString(1, vo.getName());  //vo의 get으로 부터 first ㅜ믇 을 가져온다.
//			pstmt.setString(2, vo.getPassword());
//			pstmt.setString(3, vo.getMessage());

			//5. SQL 실행
			//update 된 수 바노한
//			int count =  pstmt.executeUpdate();
//			result = count==1; //count가 1인지
			 result = pstmt.executeUpdate() == 1;
		
		}  catch (SQLException e) {
			System.out.print("error : " + e);
		} finally {
			// 자원 정리
			try {
				if(rs != null) {
					rs.close();
				}
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public int countAll() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			conn = getConnection();		
		
			//3. SQL 준비
			String sql = "select no from emaillist ";
			pstmt = conn.prepareStatement(sql); // 
			
			//4. 바인딩(binding)
			
			//5. SQL 실행
			rs = pstmt.executeQuery();
		
			while(rs.next()) {
				Long no = rs.getLong(1);
			
				
				guestbookVo vo = new guestbookVo();
				vo.setNo(no);
		
				
//				result.add(vo);
			}
		} catch (SQLException e) {
			System.out.print("error : " + e);
		} finally {
			// 자원 정리
			try {
				if(rs != null) {
					rs.close();
				}
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
//		return result;
		return 0;
	}
	public List<guestbookVo> findAll() {  //EmaillistDaoTest에서 사용하기 위한 findAll() 함수 생성
		// 반환 타입은 List의 EmaillistVo이다.
		List<guestbookVo> result = new ArrayList<>(); //ArrayList 생성
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			conn = getConnection();		
		
			//3. SQL 준비
			String sql = "select no, name, password, date_format(reg_date, '%Y/%m/%d %H%i%s') as reg_date, message from guestbook order by no desc";
			pstmt = conn.prepareStatement(sql); // 
			
			//4. 바인딩(binding)
			
			//5. SQL 실행
			rs = pstmt.executeQuery();
		
			while(rs.next()) {
				Long no = rs.getLong(1);
				String name = rs.getString(2);
				String password = rs.getString(3);
				String reg_date = rs.getString(4);
				String message = rs.getString(5);
				
				guestbookVo vo = new guestbookVo();
				vo.setNo(no);
				vo.setName(name);
				vo.setPassword(password);
				vo.setDate(reg_date);
				vo.setMessage(message);
				
//				vo.setEmail(email);
				
				result.add(vo);
			}
		} catch (SQLException e) {
			System.out.print("error : " + e);
		} finally {
			// 자원 정리
			try {
				if(rs != null) {
					rs.close();
				}
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}

	
	public boolean insert(guestbookVo vo) {

		boolean result = false;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			conn = getConnection();			
		
			//3. SQL 준비
			String sql = "insert into guestbook values(null,?, ?, ?, now())";
			pstmt = conn.prepareStatement(sql); // 
			
			//4. 바인딩(binding)
			pstmt.setString(1, vo.getName());  //vo의 get으로 부터 first ㅜ믇 을 가져온다.
			pstmt.setString(2, vo.getPassword());
			pstmt.setString(3, vo.getMessage());

			//5. SQL 실행
			//update 된 수 바노한
//			int count =  pstmt.executeUpdate();
//			result = count==1; //count가 1인지
			 result = pstmt.executeUpdate() == 1;
		
		}  catch (SQLException e) {
			System.out.print("error : " + e);
		} finally {
			// 자원 정리
			try {
				if(rs != null) {
					rs.close();
				}
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	private Connection getConnection() throws SQLException{
		// connection 만들어서 리턴
		// 나중에  아이디와 비번이 바뀌면 이 부분만 고쳐 주면 된다.
		
		// CONNECTION
		
		Connection conn = null;
		
		try {
			//1. JDBC 드라이버 로딩
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//2. 연결하기
			String url = "jdbc:mysql://localhost:3306/webdb?characterEncoding=UTF-8&serverTimezone=UTC";
			conn = DriverManager.getConnection(url, "webdb", "webdb");
		} catch(ClassNotFoundException e) {
			System.out.print("드라이버 로딩 실패 : " + e);

		}
		// SQLException을 쓰고 싶지 않기 때문에 이 에러 발생시 throws 로 SQL 던져 준다. 
		//좋은 건 아닌데 자신이 처리할 EXCEPTION을 밖으로 던져 버리기 때문에 전혀 GET CONNETCION과 상관 없는데 스파게티가 된다
		// THROWS는 논리적 구조를 이해하는데 어려울 수 있다.
		// THROWS 회피 하면 않좋지만 여기서는 코드가 깔끔해지고 이익이 있다.
//		catch(SQLException e) {
//			System.out.println("error" + e);
//		}
		
		return conn;
	}

}
