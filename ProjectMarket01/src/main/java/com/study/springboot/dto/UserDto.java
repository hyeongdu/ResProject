package com.study.springboot.dto;

import java.sql.Timestamp;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class UserDto {
	private int member_number;
	@NotNull(message="이름을 확인해주세요.")
	@NotEmpty(message="이름을 확인해주세요.")
	@Size(min=2, max=15, message="이름은 2자 이상으로 해주세요.")
	private String member_name;
	@NotNull(message="아이디를 확인해주세요.")
	@NotEmpty(message="아이디를 확인해주세요.")
	@Size(min=6, max=15, message="아이디는 6~15자로 해주세요.")
	private String member_id;
	@NotNull(message="비밀번호를 확인해주세요.")
	@NotEmpty(message="비밀번호를 확인해주세요.")
	@Size(min=6, max=15, message="비밀번호는 6~15자로 해주세요..")
	private String member_pw;
	@NotNull(message="핸드폰번호를 확인해주세요.")
	@NotEmpty(message="핸드폰번호를 확인해주세요.")
	private String member_phone1;
	@NotNull(message="핸드폰번호를 확인해주세요.")
	@NotEmpty(message="핸드폰번호를 확인해주세요.")
	private String member_phone2;
	@NotNull(message="핸드폰번호를 확인해주세요.")
	@NotEmpty(message="핸드폰번호를 확인해주세요.")
	private String member_phone3;
	private String member_phone;
	@NotNull(message="이메일을 확인해주세요.")
	@NotEmpty(message="이메일을 확인해주세요.")
	private String member_email_id;
	@NotNull(message="이메일을 확인해주세요.")
	@NotEmpty(message="이메일을 확인해주세요.")
	private String member_email_url;
	private String member_email;
	@NotNull(message="닉네임을 확인해주세요.")
	@NotEmpty(message="닉네임을 확인해주세요.")
	@Size(min=2, max=15, message="닉네임은 6~15자로 해주세요.")
	private String member_nickname;
	private Timestamp member_date;
	private String authority;
	private int member_enabled;
}
