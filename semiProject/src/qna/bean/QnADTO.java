package qna.bean;

import lombok.Data;

@Data
public class QnADTO {
	private int seq; 
	private String id; 
	private String name; 
	private String subject; 
	private String content; 
	
	private int ref;
	private int lev;
	private int step;
	private int pseq; 
	private int reply; 
	
	private int hit; 
	private String logtime; 
}
