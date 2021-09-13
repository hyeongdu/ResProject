package com.study.springboot.dto;

import java.sql.Timestamp;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;
@Data
public class NoticeListDto {
	private int noticeboard_number;
	private String noticeboard_nickname;
	@NotNull(message="title is null")
	@NotEmpty(message="title is null")
	private String noticeboard_title;
	@NotEmpty(message="content is null")
	@NotNull(message="content is null")
	private String noticeboard_content;
	private Timestamp noticeboard_date;
	private String noticeboard_filename;
	private String noticeboard_oriFilename;
	private int noticeboard_hit;
	private int noticeboard_group;
	private int noticeboard_step;
	private int noticeboard_indent;

}
