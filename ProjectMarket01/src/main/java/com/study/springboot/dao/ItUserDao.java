package com.study.springboot.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.study.springboot.dto.NoticeListDto;
import com.study.springboot.dto.UserDto;
import com.study.springboot.dto.UserInfoDto;
import com.study.springboot.dto.UserUpdateDto;

@Mapper
public interface ItUserDao {
//	public List<UserDto> userList();
	public UserDto userSelect(String c_id);
	public int join(Map<String, String> member_info);
	public List<NoticeListDto> modifyContent_view(String bId);
	public int updateInfo(Map<String, String> map);
	public int checkId(@Param("member_id")String member_id);
	public int checkNick(@Param("member_nickname")String memeber_nickname);
	public String checkPwd(@Param("member_id")String member_id);
	public int updatePwd(@Param("member_pw")String new_member_pw,@Param("member_id") String member_id);
	public List<UserUpdateDto> myPageInfo(@Param("member_id")String member_id);
	public String getNickname(@Param("member_id")String member_id);
}
