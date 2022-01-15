package com.poscoict.guestbook.dao.test;

import java.util.List;

import com.poscoict.guestbook.dao.guestbookDao;
import com.poscoict.guestbook.vo.guestbookVo;

public class guestbookDaoTest {

	public static void main(String[] args) {
//		testInsert();
		testFindAll();
//		testdelete(6,"1234");
//		testcount();
	}

	private static void testcount() {
		// TODO Auto-generated method stub
		guestbookVo vo = new guestbookVo();
		
		
	}

	private static void testInsert() {
		guestbookVo vo = new guestbookVo();  //vo insert
//		vo.setFirstName("홍");
//		vo.setLastName("길동");
//		vo.setEmail("gilldong@gmail.com");
		
		vo.setName("홍");
		vo.setPassword("1234");
		vo.setMessage("gilldong@gmail.com");
		boolean result = new guestbookDao().insert(vo);
		System.out.println(result ? "success" : "fail");
	}
	
	private static void testdelete(int i, String password) {
		guestbookVo vo = new guestbookVo();  //vo insert
//		vo.setFirstName("홍");
//		vo.setLastName("길동");
//		vo.setEmail("gilldong@gmail.com");
		
//		vo.setName("홍");
//		vo.setPassword("1234");
//		vo.setMessage("gilldong@gmail.com");
		boolean result = new guestbookDao().delete(i, password);
		System.out.println(result ? "success" : "fail");
	}

	private static void testFindAll() {
		List<guestbookVo> list = new guestbookDao().findAll(); //ㄷ
		for(guestbookVo vo : list) {
			System.out.println(vo);
		}
		
	}
}