package com.study.springboot.service;

import java.util.List;
import java.util.Map;

import com.study.springboot.dto.NoticeListDto;
import com.study.springboot.dto.SirenListDto;
import com.study.springboot.dto.TokenDto;
import com.study.springboot.dto.UserDto;
import com.study.springboot.dto.UserInfoDto;
import com.study.springboot.dto.UserUpdateDto;

public interface IAdminService {
	public List<NoticeListDto> noticeList(int noticeboard_list);
	public List<NoticeListDto> noticeTitle();
	public List<TokenDto> tokenList();
	public List<NoticeListDto> content_view(String noticeboard_number);
	public List<UserUpdateDto> myPageInfo(String member_id);
	public int modifyContent_view(Map<String, String> map);
	public int noticeWrite(Map<String, String> map);
	public String getUserNickname(String member_id);
	public int noticeListCount(); 
	public List<SirenListDto> sirenList();
	public int deleteNotice(String notice_number);
}
