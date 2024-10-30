package board.bean;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BoardDTO {
	private int seq;
	private String id;
	private String name;
	private String email;
	private String subject;
	private String content;
	private int ref;
	private int lev;
	private int step;
	private int pseq;
	private int reply;
	private int hit;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy.MM.dd HH:mm", timezone = "Asia/Seoul")
	private Date logtime;
}
