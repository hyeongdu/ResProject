package com.study.springboot.dao;

import java.util.ArrayList;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.study.springboot.dto.ACustomerListDto;
import com.study.springboot.dto.AReservationDto;
@Mapper
public interface AReservationDao {
	public int insertRsvDao(Map<String, Object> map);
	ArrayList<ACustomerListDto> getRsvMemInfoDao(@Param("member_id")String member_id);
	ArrayList<AReservationDto> getRsvInfoDao(@Param("r_rsvnumber")String r_rsvnumber);
}
