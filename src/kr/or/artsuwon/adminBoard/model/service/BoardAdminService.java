package kr.or.artsuwon.adminBoard.model.service;

import kr.or.artsuwon.adminBoard.model.vo.Notice;
import kr.or.artsuwon.csBoard.vo.csBoard;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

public interface BoardAdminService {


    // 글목록보기
    HashMap<String, Object> selectAllPostList(int currentPage);

    //게시글보기
    Notice selectOneContent(int noticeNo);

    //게시글 수정
    int updatePost(Notice notice);

    //게시글작성
    int insertPost(Notice notice);

    int searchNoticeNo(Notice notice);

    //게시글찾기
    int deletePost(int noticeNo);

    HashMap<String, Object> selectSearchPost(int currentPage, String keyword, String type);
    
  //체크박스 게시글 삭제
  	int deleteAdminPost(String[] boardNoValues);

  	int insertFileUpload(Notice notice);

	Notice selectFileInfo(int noticeNo);

	int listUp(int noticeNo);
	
	int increaseNotice(int noticeNo);

	HashMap<String,Object> CsAllList(int currentPage);
}
