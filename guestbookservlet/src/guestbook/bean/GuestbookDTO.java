package guestbook.bean;

import lombok.Data;

@Data
public class GuestbookDTO {
	private int seq; 
	private String name;
	private String email;
	private String homepage;
	private String subject; 
	private String content;
	private String logtime;
	
	public GuestbookDTO() {
	}
	public GuestbookDTO(int seq, String name, String email, String homepage, String subject, String content,
			String logtime) {
		this.seq = seq;
		this.name = name;
		this.email = email;
		this.homepage = homepage;
		this.subject = subject;
		this.content = content;
		this.logtime = logtime;
	}	
	
	
}
