package user.action;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import user.dao.UserDAO;

public class UserDeleteAction implements UserAction {

	@Override
	public void execute() {
		//데이터 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("아이디 입력: ");
		String id = null;
		try {
			id = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//db
		int cnt = UserDAO.getInstance().delete(id);
		
		if(cnt != 0) System.out.println(id + "의 데이터를 삭제하였습니다. ");
		else System.out.println("찾는 아이디가 없습니다. ");
		
	}

}
