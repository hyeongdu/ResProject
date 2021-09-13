package com.study.springboot.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.springboot.dao.ItGoodsDao;
import com.study.springboot.dao.ItNoticeDao;
import com.study.springboot.dao.ItReplyDao;
import com.study.springboot.dao.ItUserDao;
import com.study.springboot.dto.GoodsDto;
import com.study.springboot.dto.NoticeDto;
import com.study.springboot.dto.NoticeListDto;
import com.study.springboot.dto.PageInfoDto;
import com.study.springboot.dto.ReplyDto;
import com.study.springboot.dto.UserDto;

@Service
public class ProjectService implements IProjectService {
	
	@Autowired
	ItUserDao user_dao;
	
	@Autowired
	ItNoticeDao notice_dao;
	
	@Autowired
	ItGoodsDao good_dao;
	
	@Autowired
	ItReplyDao reply_dao;

	@Override
	public UserDto userSelect(String c_id) {
		return user_dao.userSelect(c_id);
	}
	
	@Override
	public int join(Map<String, String> member_info) {
		
		int nResult = user_dao.join(member_info);
		return nResult;
	}
	
	public List<NoticeListDto> modifyContent_view(String bId){
		System.out.println("Service:  modifyContent_view");
		List<NoticeListDto> list=user_dao.modifyContent_view(bId);
		System.out.println(list.toString());
		return list;
	}
	
	@Override
	public int updateInfo(Map<String, String> map) {
		
		int nResult = user_dao.updateInfo(map);
		return nResult;
	}
	
	@Override
	public int checkId(String member_id) {
		
		int nResult = user_dao.checkId(member_id);
		System.out.println(member_id);
		return nResult;
	}
	
	@Override
	public int checkNick(String memeber_nickname) {
		
		int nResult = user_dao.checkNick(memeber_nickname);
		return nResult;
	}
	@Override
	public String checkPwd(String member_id) {
		
		String nResult = user_dao.checkPwd(member_id);
		return nResult;
	}
	@Override
	public int updatePwd(String new_member_pw, String member_id) {
		
		int nResult = user_dao.updatePwd(new_member_pw, member_id);
		return nResult;
	}
	

	@Override
	public List<NoticeDto> noticeList(int curPage) {
		int listCount = 5;	// 한 페이지당 보여줄 게시물 수
		int nStart = (curPage -1) * listCount + 1;
		int nEnd = (curPage -1) * listCount + listCount;
		System.out.println("Service:  noticelist");
		List<NoticeDto> list=notice_dao.noticeList(nStart, nEnd);
		return list;
	}
	
	@Override
	public List<NoticeDto> searchNoticeList(int curPage, String category, String content) {
		int listCount = 5;	// 한 페이지당 보여줄 게시물 수
		int nStart = (curPage -1) * listCount + 1;
		int nEnd = (curPage -1) * listCount + listCount;
		System.out.println("Service:  searchNoticeList");
		List<NoticeDto> list=notice_dao.searchNoticeList(nStart, nEnd, category, content);
		System.out.println(list);
		return list;
	}
	
	@Override
	public List<NoticeDto> searchReject(String sPlace) {
		return notice_dao.searchReject(sPlace);
	}
	
	@Override
	public List<NoticeDto> searchRequest(String sPlace) {
		return notice_dao.searchRequest(sPlace);
	}
	
	@Override
	public List<PageInfoDto> noticeCount(int curPage) {
		int nTotalCount = notice_dao.noticeCount();// 총 게시물 수 
		System.out.println("총 게시물 수  noticeCount : " + nTotalCount);
		int listCount = 5;	// 한 페이지당 보여줄 게시물 수
		int pageCount = 3; // 하다넹 보여줄 페이지 수
		
		int totalPage = nTotalCount / listCount;
		if(nTotalCount % listCount > 0)
			totalPage++;
		//현재 페이지
		int myCurPage = curPage;
		if(myCurPage > totalPage)
			myCurPage = totalPage;
		if(myCurPage < 1)
			myCurPage = 1;
		
		//시작 페이지
		int startPage = ((myCurPage - 1) / pageCount) * pageCount + 1;
		
		//끝 페이지
		int endPage = startPage + pageCount -1;
		if(endPage > totalPage)
			endPage = totalPage;
		List<PageInfoDto> listPage = new ArrayList<PageInfoDto>();
		PageInfoDto pageInfo = new PageInfoDto(nTotalCount,listCount,totalPage
								,curPage, pageCount, startPage, endPage);
		listPage.add(0, pageInfo);

		
		
	
		System.out.println("listPage : " + listPage);
		return listPage;
	}
	
	@Override
	public List<PageInfoDto> searchNoticeCount(int curPage, String category, String content) {
		
		int nTotalCount = notice_dao.searchNoticeCount(category, content);// 총 게시물 수 
		System.out.println("총 게시물 수  : " + nTotalCount);
		int listCount = 5;	// 한 페이지당 보여줄 게시물 수
		int pageCount = 2; //   보여줄 페이지 수
		
		int totalPage = nTotalCount / listCount;
		if(nTotalCount % listCount > 0)
			totalPage++;
		//현재 페이지
		int myCurPage = curPage;
		if(myCurPage > totalPage)
			myCurPage = totalPage;
		if(myCurPage < 1)
			myCurPage = 1;
		
		//시작 페이지
		int startPage = ((myCurPage - 1) / pageCount) * pageCount + 1;
		
		//끝 페이지
		int endPage = startPage + pageCount -1;
		if(endPage > totalPage)
			endPage = totalPage;
		List<PageInfoDto> listPage = new ArrayList<PageInfoDto>();
		PageInfoDto pageInfo = new PageInfoDto(nTotalCount,listCount,totalPage
								,curPage, pageCount, startPage, endPage);
		listPage.add(0, pageInfo);

		
		
	
		System.out.println("listPage : " + listPage);
		return listPage;
	}
	
	@Override
	public int noticeTitleCount() {
		int nTotalCount = notice_dao.noticeTitleCount();
		return nTotalCount;
	}
	
	@Override
	public NoticeDto noticeView(String c_id) {
		return notice_dao.noticeView(c_id);
	}
	
	@Override
	public int goodsArticleCount() {
		return good_dao.goodsArticleCount();
	}
	
	@Override
	public List<GoodsDto> goodsList(Map<String, Integer> map) {
		return good_dao.goodsList(map);
	}
	
	@Override
	public int articleCount() {
		return good_dao.articleCount();
	}
	
	@Override
	public GoodsDto goodsView(String id) {
		return good_dao.goodsView(id);
	}
	
	@Override
	public int writeGoods(Map<String, String> map) {
		
		int nResult = good_dao.writeGoods(map);
		return nResult;
	}
	
	@Override
	public List<ReplyDto> replyView_N(String nId) {
		System.out.println(nId);
		return reply_dao.replyView_N(nId);
	}
	
	@Override
	public int writeReply(Map<String, String> map) {
		
		int nResult = reply_dao.writeReply(map);
		return nResult;
	}
	
	@Override
	public int deleteReply(String sid) {
		int nResult = reply_dao.deleteReply(sid);
		return nResult;
	}



}
