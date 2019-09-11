package user.action;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import user.bean.UserDTO;
import user.dao.UserDAO;

public class UserUpdateAction implements UserAction {

	@Override
	public void execute() {
		// 데이터 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("아이디 입력: ");
		String id = null;
		try {
			id = br.readLine();
			
			// db
			UserDTO userDTO = UserDAO.getInstance().getUser(id);

			if (userDTO != null) {
				System.out.print("변경할 이름 입력: ");
				String name = br.readLine();
				System.out.print("변경할 비밀번호 입력: ");
				String pwd = br.readLine();
				
//				userDTO.setName(name);
//				userDTO.setId(id);
//				userDTO.setPwd(pwd);
				Map<String, String> map = new HashMap<String, String>();
				map.put("name", name);
				map.put("id", id);
				map.put("pwd", pwd);
				
				UserDAO.getInstance().update(map);
				System.out.println(id + "의 데이터를 수정하였습니다.");
				
				System.out.println("이름 \t 아이디 \t 비밀번호");
				userDTO = UserDAO.getInstance().getUser(id);
				System.out.println(userDTO.getName() + "\t" + userDTO.getId() + "\t" + userDTO.getPwd());
			
			}else {
				System.out.println("찾는 아이디가 없습니다. ");
				return;
			}
			
	
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
