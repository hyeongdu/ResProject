package com.study.springboot.dao;

import java.util.ArrayList;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.study.springboot.dto.ACustomerListDto;
import com.study.springboot.dto.AReservationDto;
import com.study.springboot.dto.ARestaurantListDto;
import com.study.springboot.dto.AReviewListDto;
import com.study.springboot.dto.ASirenDto;

@Mapper
public interface AMembershipDao {
	public int getJoinResult(Map<String, String> map);
	public int getLoginResult(@Param("member_id")String member_id, @Param("member_pw")String member_pw);
	ArrayList<AReservationDto> getCustomerResList(@Param("memeber_id")String memeber_id);
	ArrayList<AReservationDto> getReservationList(String r_name);
	ArrayList<ACustomerListDto> getMyInfo(String c_id);
	ArrayList<ACustomerListDto> getMyProfile(@Param("memeber_id")String member_id);
	public int setUpdateMyProfile(Map<String, String> map);
	public int androidCheckId(@Param("member_id")String member_id);
	public int androidCheckNickName(@Param("member_nickname")String member_nickname);
	ArrayList<AReviewListDto> getMyReview(@Param("member_id")String memeber_id);
	ArrayList<ARestaurantListDto> getrestaurantInfoMg(String m_id);
	public int setStoreUpdate(Map<String, String> map);
	public int setUpdateNickname(String nickname, String c_id);
	ArrayList<ACustomerListDto> searchR_name(@Param("member_id")String member_id);
	ArrayList<ASirenDto> getCustomersirenList(String c_id);

}
