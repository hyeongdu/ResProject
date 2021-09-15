package com.study.springboot.service;

import java.util.Map;

public interface IAndroidRestaurantService {
	public String restaurantList();
	public String getrecentList();
	public String checkReservation(String r_rsvnumber);
	public String noCheckReservation(String r_rsvnumber);
	public String getsearchList(String searchword);
	public String getMenuList(String mnumber, String storename);
	public String getRestaurantInfo(String mnumber, String storename);
	public int checkLike(String m_number, String r_name, String c_id);
	public int doLike(String m_number, String r_name, String c_id);
	public int undoLike(String m_number, String r_name, String c_id);
	public String getLikeList(String member_id);
	public String getReviewList(String m_number, String r_name);

	public int getJoinResult(Map<String, String> map);
	public int getLoginResult(String member_id, String member_pw);
	public int androidCheckId(String member_id);
	public int androidCheckNickName(String member_nickname);
	public String getCustomerResList(String memeber_id);
	public String getReservationList(String memeber_id);
	public String getMyInfo(String c_id);
	public String getMyProfile(String member_id);
	public String getModifyData(String memeber_id);
	public int setUpdateMyProfile(Map<String, String> map);
	public String getMyReview(String memeber_id);
	public String getRestaurantInfoMg(String m_id);
	public int setStoreUpdate(Map<String, String> map);
	public int setUpdateNickname(String nickname, String c_id);
	
	public String getCustomerSiren(String c_id);

}
