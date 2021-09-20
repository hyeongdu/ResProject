package com.study.springboot.service;

import java.util.Map;

public interface IAndroidReservationService {
	public String getRsvMemInfo(String member_id);
	public int insertReservationInfo(Map<String, Object> map);
	public String getRsvInfo(String r_rsvnumber);
}
