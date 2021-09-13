package com.study.springboot.dto;

import java.sql.Timestamp;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class UserUpdateDto {
	private String member_number;
	private String member_id;
	private String member_name;
	@NotNull(message="핸드폰번호를 확인해주세요.")
	@NotEmpty(message="핸드폰번호를 확인해주세요.")
	private String member_phone1;
	@NotNull(message="핸드폰번호를 확인해주세요.")
	@NotEmpty(message="핸드폰번호를 확인해주세요.")
	private String member_phone2;
	@NotNull(message="핸드폰번호를 확인해주세요.")
	@NotEmpty(message="핸드폰번호를 확인해주세요.")
	private String member_phone3;
	@NotNull(message="이메일을 확인해주세요.")
	@NotEmpty(message="이메일을 확인해주세요.")
	private String member_email;
	@NotNull(message="닉네임을 확인해주세요.")
	@NotEmpty(message="닉네임을 확인해주세요.")
	@Size(min=2, max=15, message="닉네임은 6~15자로 해주세요.")
	private String member_nickname;
	private String member_phone;

}
