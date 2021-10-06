package viewer;

import java.util.Scanner;

import controller.MemberController;
import model.MemberDTO;
import util.ScannerUtil;

public class MemberViewer {
	private Scanner scanner;
	private MemberDTO logIn;
	private MemberController memberController;

	public MemberViewer() {
		memberController = new MemberController();
		scanner = new Scanner(System.in);
		logIn = null;

	}

	// 제일 첫화면
	public void showIndex() {
		System.out.println("*******************************");
		System.out.println(" 본 영화탐색 프로그램은 회원제로 운영됩니다.\n" + "  최초 방문시 회원가입 후에 이용바랍니다.");
		System.out.println("*******************************");
		String message = new String("1.로그인  2.회원가입  3.프로그램 종료");
		while (true) {
			int userChoice = ScannerUtil.nextInt(scanner, message, 1, 3);

			if (userChoice == 1) {
				// 로그인 메소드 실행후, 로그인 성공이면 showMenu()실행
				logIn();

				if (logIn != null) {
					// boardViewer.setLogIn(logIn);
					showMain();
				}

			} else if (userChoice == 2) {
				// 회원가입 메소드 실행
				register();

			} else if (userChoice == 3) {
				// 프로그램 종료
				System.out.println("사용해주셔서 감사합니다.");
				scanner.close();
				break;
			}

		}
	}

	// 로그인 메소드
	private void logIn() {
		String message;

		message = new String("ID를 입력해주세요.");
		String username = ScannerUtil.nextLine(scanner, message);

		message = new String("PW를 입력해주세요.");
		String password = ScannerUtil.nextLine(scanner, message);

		while (memberController.auth(username, password) == null) {
			System.out.println("잘못된 ID 혹은 PW 입니다.");
			message = new String("ID를 재입력하세요. X를 입력시 뒤로가기 합니다.");
			username = ScannerUtil.nextLine(scanner, message);

			if (username.equalsIgnoreCase("X")) {
				break;
			}

			message = new String("PW를 입력해주세요.");
			password = ScannerUtil.nextLine(scanner, message);
		}

		logIn = memberController.auth(username, password);
	}

	// 회원가입 메소드
	private void register() {
		String message;
		message = new String("사용하실 아이디를 입력해주세요.");
		String username = ScannerUtil.nextLine(scanner, message);
		while (memberController.validateUsername(username)) {
			System.out.println("해당 아이디는 사용하실 수 없습니다.");
			message = new String("사용하실 아이디를 재입력하세요. X를 입력시 뒤로가기 합니다.");
			username = ScannerUtil.nextLine(scanner, message);
			if (username.equalsIgnoreCase("X")) {
				break;
			}
		}

		if (!username.equalsIgnoreCase("X")) {
			message = new String("사용하실 비밀번호를 입력해주세요.");
			String password = ScannerUtil.nextLine(scanner, message);

			message = new String("사용하실 닉네임을 입력해주세요.");
			String nickname = ScannerUtil.nextLine(scanner, message);

			message = new String("이용하시는 등급을 숫자로 입력주세요.\n1.사용자 2.평론가 3.관리자");
			int grade = ScannerUtil.nextInt(scanner, message);
		    while(grade > 3 || grade < 1) {
				System.out.println("제시된 등급만 입력가능합니다.");
				grade = ScannerUtil.nextInt(scanner, message);
			} 
				System.out.println("******승인되었습니다******\n   로그인 후 이용해주세요."
						+ "\n*********************");


			MemberDTO m = new MemberDTO();

			m.setUsername(username);
			m.setPassword(password);
			m.setNickname(nickname);
			m.setGrade(grade);

			memberController.insert(m);
		}
	}
	

	// 로그인 성공시 보여줄 showMain()
	private void showMain() {
		System.out.println("어서오세요^^ 등급에 따라 이용 가능합니다.");
		String message = new String("1.사용자  2.평론가  3.관리자  4.로그아웃");

		while (true) {
			int userChoice = ScannerUtil.nextInt(scanner, message, 1, 4);

		}

	}

}
