package com.poscoict.guestbook.dao.test;


import java.util.List;


import com.poscoict.guestbook.dao.guestbookDao;
import com.poscoict.guestbook.vo.guestbookVo;

public class guestbookDaoTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		guestInsert();
		testFindAll();
		countAll();
		testdelete();
	}

	private static void testdelete() {
//		String no = request.getParameter("no");
//		guestbookVo vo = new guestbookVo();
		boolean result = new guestbookDao().delete(null, null);
		
	}

	private static void countAll() {
		// TODO Auto-generated method stub
		List<guestbookVo> list = new guestbookDao().findAll(); //ㄷ

		
	}

	private static void guestInsert() {
		guestbookVo vo = new guestbookVo();  //vo insert

//		vo.setName("홍");
//		vo.setPassword("1234");
//		vo.setMessage("hi");
		
		boolean result = new guestbookDao().insert(vo);
		System.out.println(result ? "success" : "fail");
	}
	
	private static void testFindAll() {
		List<guestbookVo> list = new guestbookDao().findAll(); //ㄷ
		for(guestbookVo vo : list) {
			System.out.println(vo);
		}
		
	}
}
