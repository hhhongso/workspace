package user.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import user.action.UserAction;
import user.action.UserDeleteAction;
import user.action.UserInsertAction;
import user.action.UserSelectAction;
import user.action.UserUpdateAction;

public class UserMain {
	
	public void menu() {
		//Scanner scan = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		UserAction userAction = null;
		while(true) {
			System.out.println("*****************");
			System.out.println("1. 입력");
			System.out.println("2. 출력");
			System.out.println("3. 수정");
			System.out.println("4. 삭제");
			System.out.println("5. 끝");
			System.out.println("*****************");
			System.out.print("번호 입력: ");

			// map에 key, value=object(java class) 넣기 
			//UserAction userAction = (UserAction) map.get(key);
			
			try {
				int choice = Integer.parseInt(br.readLine());
				if(choice == 1) {
					userAction = new UserInsertAction();
					
				} else if (choice == 2) {
					userAction = new UserSelectAction();
				} else if (choice == 3) {
					userAction = new UserUpdateAction();
				} else if (choice == 4) {
					userAction = new UserDeleteAction();
				} else if (choice == 5) {
					break;
				} else {
					System.out.println("1~5 사이의 번호를 입력해주세요. ");
					continue;
				}	
				
				userAction.execute();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}//while
		
		System.out.println("바이바이! ");
		System.exit(0);
		
	}
	
	public static void main(String[] args) {
		UserMain userMain = new UserMain();
		userMain.menu();
	}

}
