package com.study.springboot.service;

import java.util.List;
import java.util.Map;
import com.study.springboot.dto.NoticeDto;
import com.study.springboot.dto.NoticeListDto;
import com.study.springboot.dto.PageInfoDto;
import com.study.springboot.dto.UserDto;

public interface IProjectService {

//	public List<UserDto> list();
	public int join(Map<String, String> map);
	public int updateInfo(Map<String, String> map);
	public int checkId(String member_id);
	public int checkNick(String member_nickname);
	public String checkPwd(String member_id);
	public int updatePwd(String new_member_pw, String member_id);
	public UserDto userSelect(String c_id);
	public List<NoticeDto> noticeList(int curPage);
	public List<NoticeDto> searchNoticeList(int curPage, String category, String content);
	public List<PageInfoDto> noticeCount(int curPage);
	public List<PageInfoDto> searchNoticeCount(int curPage, String category, String content);
	public int noticeTitleCount();
	public List<NoticeDto> searchReject(String sPlace);
	public List<NoticeDto> searchRequest(String sPlace);

}
