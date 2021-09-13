package com.study.springboot.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.study.springboot.dto.NoticeDto;
import com.study.springboot.dto.NoticeListDto;
import com.study.springboot.dto.SirenListDto;
import com.study.springboot.dto.TokenDto;
import com.study.springboot.dto.UserInfoDto;

@Mapper
public interface ItNoticeDao {
	public List<NoticeDto> noticeList (int nStart, int nEnd);
	public List<NoticeDto> searchNoticeList (int nStart, int nEnd, String category, String content);
	public List<NoticeListDto> noticeTitle();
	public List<NoticeListDto> content_view(@Param("noticeboard_number")String noticeboard_number);
	public List<NoticeDto> searchReject(String sPlace);
	public List<NoticeDto> searchRequest(String sPlace);
	public List<TokenDto> tokenList();
	public int noticeHit(@Param("noticeboard_hit")String noticeboard_hit, @Param("noticeboard_number")String noticeboard_number);
	public int noticeCount();
	public int searchNoticeCount(String category, String content);
	public int bookedCount();
	public int noticeTitleCount();
	public NoticeDto noticeView(String c_id);
	public  int modifyContent_view(Map<String, String> map);
	public List<NoticeListDto> noticelistDao(@Param("startPage")int nStart,@Param("endPage") int nEnd);
	public int noticeWrite(Map<String, String> map);
	public int noticeListCount();
	public List<SirenListDto> sirenlistDao();
	public int deleteNotice(@Param("noticeboard_number")String noticeboard_number);
}
