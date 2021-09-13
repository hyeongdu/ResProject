package com.study.springboot.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.springboot.dao.ItNoticeDao;
import com.study.springboot.dao.ItUserDao;
import com.study.springboot.dto.NoticeListDto;
import com.study.springboot.dto.SirenListDto;
import com.study.springboot.dto.TokenDto;
import com.study.springboot.dto.UserDto;
import com.study.springboot.dto.UserInfoDto;
import com.study.springboot.dto.UserUpdateDto;

@Service
public class AdminService implements IAdminService{
	@Autowired
	ItNoticeDao notice_dao;
	@Autowired
	ItUserDao user_dao;
	
	public List<NoticeListDto> noticeList(int nPage){
		int listCount = 5;	// 한 페이지당 보여줄 게시물 수
		int nStart = (nPage -1) * listCount + 1;
		int nEnd = (nPage -1) * listCount + listCount;
		System.out.println("Service:  noticelist");
		List<NoticeListDto> list=notice_dao.noticelistDao(nStart, nEnd);

		return list;
	}
	public List<NoticeListDto> noticeTitle(){
		System.out.println("Service:  noticeTitle");
		List<NoticeListDto> list=notice_dao.noticeTitle();
		System.out.println(list.toString());
		return list;
	}
	public List<UserUpdateDto> myPageInfo(String member_id){
		List<UserUpdateDto> list=user_dao.myPageInfo(member_id);
		return list;
	}
	
	public List<TokenDto> tokenList(){
		System.out.println("Service:  TokenList");
		List<TokenDto> list=notice_dao.tokenList();
		return list;
	}
	public List<NoticeListDto> content_view(String noticeboard_number){
		System.out.println("Service:  content_view");
		List<NoticeListDto> list=notice_dao.content_view(noticeboard_number);
		int hit = list.get(0).getNoticeboard_hit() + 1;
		notice_dao.noticeHit(String.valueOf(hit),String.valueOf(list.get(0).getNoticeboard_number()));
		System.out.println(list.toString());
		return list;
	}
	public int noticeListCount() {
		System.out.println("service: noticelistcount");
		return notice_dao.noticeListCount();
	}
	//공지사항 입력
	@Override
	public int noticeWrite(Map<String, String> map) {
		
		int nResult = notice_dao.noticeWrite(map);
		System.out.println("noticeWrite : " + nResult);
		
		return nResult;
	}
	@Override
	public int modifyContent_view(Map<String, String> map) {
		
		int nResult = notice_dao.modifyContent_view(map);
		System.out.println("modifyContent_view : " + nResult);
		
		return nResult;
	}
	@Override
	public int deleteNotice(String noticeboard_number) {
		
		int nResult = notice_dao.deleteNotice(noticeboard_number);
		return nResult;
	}
	public String getUserNickname(String member_id) {
		String nickname=user_dao.getNickname(member_id);
		System.out.println("get nickname: "+nickname);
		return nickname;
	}
	
	//사이렌리스트 가져오기
	public List<SirenListDto> sirenList(){
		System.out.println("Serivce: sirenLIst");
		List<SirenListDto> sirenlist=notice_dao.sirenlistDao();
		System.out.println("sirenlist: "+sirenlist);
		return sirenlist;
	}
}
