package com.study.springboot.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import com.study.springboot.dto.UserInfoDto;
import com.study.springboot.dto.UserUpdateDto;
@Mapper
public interface IGetUserInfoDao {
	public ArrayList<UserUpdateDto> getUserinfo(String c_id);
}
