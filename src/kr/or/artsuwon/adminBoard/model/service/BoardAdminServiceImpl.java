package kr.or.artsuwon.adminBoard.model.service;

import kr.or.artsuwon.adminBoard.model.dao.BoardAdminDAO;
import kr.or.artsuwon.adminBoard.model.vo.CsBoard;
import kr.or.artsuwon.adminBoard.model.vo.Notice;
import kr.or.artsuwon.common.JDBCTemplate;
import kr.or.artsuwon.csBoard.vo.csBoard;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

public class BoardAdminServiceImpl implements BoardAdminService {
    private BoardAdminDAO bDAO = new BoardAdminDAO();


    @Override
	public HashMap<String,Object> selectAllPostList(int currentPage) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int recordCountPerPage = 10;
		
		ArrayList<Notice> list = bDAO.selectAllPostPageList(conn, currentPage, recordCountPerPage);
		
		int naviCountPerPage = 5; 
		
		String pageNavi = bDAO.getPageNavi(conn,naviCountPerPage,recordCountPerPage,currentPage);
		
		JDBCTemplate.close(conn);
		
		
		HashMap<String,Object> hm = new HashMap<String,Object>();
		
		hm.put("list",list);
		hm.put("pageNavi", pageNavi);
			
		
		return hm;
	}



	@Override
	public Notice selectOneContent(int noticeNo) {
		Connection conn = JDBCTemplate.getConnection();
		Notice notice = bDAO.selectOneContent(conn, noticeNo);
		JDBCTemplate.close(conn);
		return notice;
		
		
	}



	@Override
	public int updatePost(Notice notice) {
		Connection conn = JDBCTemplate.getConnection();
		int result = bDAO.updatePost(conn,notice);
		if(result>0)JDBCTemplate.commit(conn);
		else JDBCTemplate.rollback(conn);
		JDBCTemplate.close(conn);
		return result;
	}



	@Override
	public int insertPost(Notice notice) {
		Connection conn = JDBCTemplate.getConnection();
		int result = bDAO.insertPost(conn,notice);
		if(result>0)JDBCTemplate.commit(conn);
		else JDBCTemplate.close(conn);
		return result;
	}



	@Override
	public int searchNoticeNo(Notice notice) {
		Connection conn = JDBCTemplate.getConnection();
		 int noticeNo = bDAO.searchNoticeNo(conn,notice);
		 JDBCTemplate.close(conn);
		return noticeNo;
	}



	@Override
	public int deletePost(int noticeNo) {
		Connection conn = JDBCTemplate.getConnection();
		int result =  bDAO.deletePost(conn,noticeNo);
		if(result>0)JDBCTemplate.commit(conn);
		else JDBCTemplate.rollback(conn);
		JDBCTemplate.close(conn);
		return result;
	}



	@Override
	public HashMap<String, Object> selectSearchPost(int currentPage, String keyword, String type) {
		Connection conn = JDBCTemplate.getConnection();
		
		int recordCountPerPage = 10;
		
		ArrayList<Notice> list = bDAO.selectSearchPostList(conn,currentPage,recordCountPerPage,keyword,type);
		
		/*System.out.println(keyword);
		System.out.println(type);*/
		
		int naviCountPerPage = 5; 
		
		String pageNavi = bDAO.getSearchPageNavi(conn,naviCountPerPage,recordCountPerPage,currentPage, keyword,type);
		
		//DB연결해제
		JDBCTemplate.close(conn);
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		map.put("list", list);
		map.put("pageNavi", pageNavi);
		
		return map;
	}



	@Override
	public int deleteAdminPost(String[] noticeNoValues) {
		Connection conn = JDBCTemplate.getConnection();
		int result = bDAO.deleteAdminPost(conn,noticeNoValues);
		if(result==noticeNoValues.length)JDBCTemplate.commit(conn);
		else JDBCTemplate.rollback(conn);
		JDBCTemplate.close(conn);
		return result;
	}



	@Override
	public int insertFileUpload(Notice notice) {
		Connection conn = JDBCTemplate.getConnection();
		int result = bDAO.uploadFile(conn,notice);
		if(result>0) JDBCTemplate.commit(conn);
		else JDBCTemplate.rollback(conn);
		JDBCTemplate.close(conn);
		return result;
		
	}



	@Override
	public Notice selectFileInfo(int noticeNo) {
		Connection conn = JDBCTemplate.getConnection();
		Notice fd = bDAO.selectFileInfo(conn,noticeNo);
		JDBCTemplate.close(conn);
		return fd;
	}



	@Override
	public int listUp(int noticeNo) {
		Connection conn = JDBCTemplate.getConnection();
		int result = bDAO.listUp(conn,noticeNo);
		if(result==noticeNo)JDBCTemplate.commit(conn);
		else JDBCTemplate.rollback(conn);
		JDBCTemplate.close(conn);
		return result;
		
	}



	@Override
	public int increaseNotice(int noticeNo) {
		Connection conn = JDBCTemplate.getConnection();
		int result = bDAO.increaseNotice(conn,noticeNo);
		if(result>0)JDBCTemplate.commit(conn);
		else JDBCTemplate.rollback(conn);
		JDBCTemplate.close(conn);
		return result;
		
	}



	@Override
	public HashMap<String,Object> CsAllList(int currentPage) {
		Connection conn = JDBCTemplate.getConnection();
		
		int recordCountPerPage = 10;
		
		ArrayList<csBoard> list = bDAO.CsAllList(conn, currentPage, recordCountPerPage);
		
		int naviCountPerPage = 5;
	
		String pageNavi = bDAO.getPageNavi(conn,naviCountPerPage,recordCountPerPage,currentPage);
		
		JDBCTemplate.close(conn);
		
		
		HashMap<String,Object> hm = new HashMap<String,Object>();
		
		hm.put("list",list);
		hm.put("pageNavi", pageNavi);
			
		
		return hm;
	}





}
