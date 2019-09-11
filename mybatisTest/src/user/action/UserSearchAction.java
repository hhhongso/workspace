package user.action;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import user.bean.UserDTO;
import user.dao.UserDAO;

public class UserSearchAction implements UserAction {

	@Override
	public void execute() {
		//1.이름 검색
		//2.아이디 검색
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		System.out.println("1. 이름으로 검색  2. 아이디로 검색");
		
		String key=null,  value=null; 
		try {
			int choice = Integer.parseInt(br.readLine());
			
			if(choice == 1) {
				key = "name";
				System.out.print("검색할 이름 입력: ");
				value = br.readLine();
			} else if(choice == 2) {
				key = "id";
				System.out.print("검색할 아이디 입력: ");
				value = br.readLine();
			} else {
				System.out.println("잘못 입력하셨습니다. ");
			}
			
			Map<String, String> map = new HashMap<String, String>();
			map.put("key", key);
			map.put("value", value);
			
			List<UserDTO> list = UserDAO.getInstance().search(map);
			
			System.out.println("이름 \t 아이디");
			for (UserDTO userDTO : list) {
				System.out.println(userDTO.getName() + "\t" + userDTO.getId());
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
