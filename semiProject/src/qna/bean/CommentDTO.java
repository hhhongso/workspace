package qna.bean;

import lombok.Data;

@Data
public class CommentDTO {
	private int bseq; 
	private int seq; 
	private String id; 
	private String name;
	private String content; 
	
	private int ref;
	private int lev;
	private int step;
	private int pseq; 
	private int reply; 
	 
	private String logtime; 
}
