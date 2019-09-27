package member.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberDTO {
	private String name;
	private String id;
	private String pwd;
	private String email1; 
	private String email2;
	private int birthYear; 
	private int birthMonth;
	private int birthDay;
}
