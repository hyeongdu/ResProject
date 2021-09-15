package com.study.springboot.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.study.springboot.dto.AGoodButtonDto;
import com.study.springboot.dto.ARestaurantListDto;
import com.study.springboot.dto.AReviewDto;

@Mapper
public interface ARestaurantDao {
	ArrayList<ARestaurantListDto> restaurantList();
	ArrayList<ARestaurantListDto> timeorderSelect();
	ArrayList<ARestaurantListDto> searchSelect(@Param("searchword")String searchword);
	int noCheckReservation(@Param("r_rsvnumber")String r_rsvnumber);
	int checkReservation(@Param("r_rsvnumber")String r_rsvnumber);
	ArrayList<ARestaurantListDto> getrestaurantInfo(String mnumber, String storename);
	public String getMenuListDao(String mnumber, String storename);
	public int checkLikeDao(@Param("memeber_id")String c_id, @Param("r_name")String r_name, @Param("m_number")String m_number);
	public int doLikeDao(@Param("memeber_id")String c_id, @Param("r_name")String r_name, @Param("m_number")String m_number);
	public int undoLikeDao(@Param("memeber_id")String c_id, @Param("r_name")String r_name, @Param("m_number")String m_number);
	ArrayList<AGoodButtonDto> getLikeListDao(@Param("member_id")String member_id);
	ARestaurantListDto selectLikeListDao(String m_number, String r_name);
//	===========주말지하
	ArrayList<AReviewDto> getReviewListDao(@Param("m_number")String m_number, @Param("r_name")String r_name);
	public int countReviewDao(@Param("m_number")String m_number, @Param("r_name")String r_name);
	public List<String> getReviewGrade(@Param("m_number")String m_number,@Param("r_name") String r_name);

}
