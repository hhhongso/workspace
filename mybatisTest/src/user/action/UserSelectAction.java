package user.action;

import java.util.List;

import user.bean.UserDTO;
import user.dao.UserDAO;

public class UserSelectAction implements UserAction {

	@Override
	public void execute() {
		//db
		List<UserDTO> list = UserDAO.getInstance().getList();
		System.out.println("이름 \t 아이디 \t 비밀번호");

		//응답
		for (UserDTO userDTO : list) {
			System.out.println(userDTO.getName() + "\t" + userDTO.getId() + "\t" + userDTO.getPwd());
		}
		
	}

}
