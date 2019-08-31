package exam.bean;

import lombok.Data;

@Data
public class DataDTO {
//페이지 넘어갈 때마다 값을 싣어가야 함 => DTO에 담자 
	private int x;
	private int y;
}
