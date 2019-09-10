package user.action;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import user.bean.UserDTO;
import user.dao.UserDAO;

public class UserInsertAction implements UserAction {

	@Override
	public void execute() {
		//데이터 받기 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		UserDTO userDTO = new UserDTO();
		try {
			System.out.print("이름 입력: ");
			String name = br.readLine();
			System.out.print("아이디 입력: ");
			String id = br.readLine();
			System.out.print("비밀번호 입력: ");
			String pwd = br.readLine();
			
			userDTO.setName(name);
			userDTO.setId(id);
			userDTO.setPwd(pwd);

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//db
		UserDAO.getInstance().write(userDTO);
		
		//응답
		System.out.println("데이터를 저장하였습니다. ");
	}
	
}
