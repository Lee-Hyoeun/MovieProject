package viewer;

import java.util.Scanner;

import controller.MemberController;
import model.MemberDTO;
import util.ScannerUtil;

public class MemberViewer {
	private Scanner scanner;
	private MemberDTO logIn;
	private MemberController memberController;

	private final int GRADE_USER = 1;
	private final int GRADE_EVAL = 2;
	private final int GRADE_MANAGER = 3;

	public MemberViewer() {
		memberController = new MemberController();
		scanner = new Scanner(System.in);
		logIn = null;
		int GRADE;
		
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

//			message = new String("이용하시는 등급을 숫자로 입력주세요.\n1.사용자 2.평론가 3.관리자");
//			int grade = ScannerUtil.nextInt(scanner, message);
//			while (grade > 3 || grade < 1) {
//				System.out.println("제시된 등급만 입력가능합니다.");
//				grade = ScannerUtil.nextInt(scanner, message);
//			}
			System.out.println("******승인되었습니다******\n   로그인 후 이용해주세요." + "\n*********************");

			MemberDTO m = new MemberDTO();

			m.setUsername(username);
			m.setPassword(password);
			m.setNickname(nickname);
//			m.setGrade(grade);

			memberController.insert(m);
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

	// 제일 첫화면
	public void showIndex() {
		System.out.println("*******************************");
		System.out.println(" 본 영화탐색 프로그램은 회원제로 운영됩니다.\n" + "  최초 방문시 회원가입 후에 이용바랍니다.");
		System.out.println("*******************************");
		String message = new String("1.로그인  2.회원가입  3.프로그램 종료");
		while (true) {
			int userChoice = ScannerUtil.nextInt(scanner, message, 1, 3);
			
			if (userChoice == 1) {
				// 로그인 메소드 실행후, 로그인 성공이면 등급별 showMain()실행
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
	
	// 회원 등급을 파라미터로 입력받아서
	// 해당 회원의 등급만 출력하는 메소드 
	public void printGrade(int grade) {	
		memberController.GradeOne(grade).getGrade();
	}

	// 로그인 성공시 등급별로 보여줄 showMain()
	private void showMain() {
		String message = new String("이용하시려는 등급을 선택해주세요.\n1.고객님 2.평론가 3.관리자");
		int grade = ScannerUtil.nextInt(scanner, message);
		while (grade > 3 || grade < 1) {
			System.out.println("제시된 등급만 입력가능합니다.");
			grade = ScannerUtil.nextInt(scanner, message);
		}
		//멤버 등급 insert
		MemberDTO m = new MemberDTO();
		m.setGrade(grade);
		memberController.insert(m);

		while (true) {
			if (grade == GRADE_USER) {
				System.out.println("고객님께서 입장하셨습니다. 이용하실 서비스를 선택해주세요.");
				showUserMenu();

			} else if (grade == GRADE_EVAL) {
				System.out.println("평론가님께서 입장하셨습니다. 이용하실 서비스를 선택해주세요.");
				showEvalMenu();

			} else if (grade == GRADE_MANAGER) {
				System.out.println("관리자님께서 입장하셨습니다. 이용하실 서비스를 선택해주세요.");
				showManagerMenu();
			}

			if (logIn == null) {
				break;
			}
		}

	}

	// 일반사용자 등급 메뉴
	private void showUserMenu() {
		String message = new String("1.영화목록보기  2.극장목록보기  3.내정보보기  4.로그아웃"); // 영화목록보기에서
		int userChoice = ScannerUtil.nextInt(scanner, message, 1, 4);

		while (true) {
			if (userChoice == 1) {
				// 일반사용자 영화목록 보기만 메소드 실행

			} else if (userChoice == 2) {
				// 일반사용자 극장목록 보기만 메소드 실행

			} else if (userChoice == 3) {
				// 내정보보보기 메소드 실행

			} else if (userChoice == 4) {
				// 로그아웃
				System.out.println("성공적으로 로그아웃 하셨습니다.");
				logIn = null;
				// boardViewer.setLogIn(null);
			}

			if (logIn == null) {
				break;
			}
		}
	}

	// 전문평론가 등급 메뉴
	private void showEvalMenu() {
		String message = new String("1.영화목록보기  2.극장목록보기  3.내정보보기  4.로그아웃"); // 영화목록보기에서
		int userChoice = ScannerUtil.nextInt(scanner, message, 1, 4);

		while (true) {
			if (userChoice == 1) {
				// 일반사용자 영화목록 보기만 메소드 실행

			} else if (userChoice == 2) {
				// 일반사용자 극장목록 보기만 메소드 실행

			} else if (userChoice == 3) {
				// 내정보보보기 메소드 실행

			} else if (userChoice == 4) {
				// 로그아웃
				System.out.println("성공적으로 로그아웃 하셨습니다.");
				logIn = null;
				// boardViewer.setLogIn(null);
			}

			if (logIn == null) {
				break;
			}
		}
	}

	// 최고관리자 등급 메뉴
	private void showManagerMenu() {
		String message = new String("1.영화목록보기  2.극장목록보기  3.내정보보기  4.로그아웃"); // 영화목록보기에서
		int userChoice = ScannerUtil.nextInt(scanner, message, 1, 4);

		while (true) {
			if (userChoice == 1) {
				// 일반사용자 영화목록 보기만 메소드 실행
				

			} else if (userChoice == 2) {
				// 일반사용자 극장목록 보기만 메소드 실행

			} else if (userChoice == 3) {
				// 내정보보보기 메소드 실행
				showMine();

			} else if (userChoice == 4) {
				// 로그아웃
				System.out.println("성공적으로 로그아웃 하셨습니다.");
				logIn = null;
				// boardViewer.setLogIn(null);
			}

			if (logIn == null) {
				break;
			}
		}
	}
	
	
	// 3.내정보보기 공통입력
	private void showMine() {
		 String message = new String("1.내정보 수정 2. 회원탈퇴 3. 뒤로 가기");
	        while (true) {
	            printOne(logIn.getId());
	            int userChoice = ScannerUtil.nextInt(scanner, message, 1, 3);
	            if (userChoice == 1) {
	                // 내정보 수정 메소드 실행
	                update(logIn.getId());

	            } else if (userChoice == 2) {
	                // 내정보 탈퇴 메소드 실행
	                delete(logIn.getId());

	            } else if (userChoice == 3) {
	                break;
	            }

	            if (logIn == null) {
	                break;
	            }
	        }
	}
	
	
	// 3.내정보보기 - 기본화면
    private void printOne(int id) {
        MemberDTO m = memberController.selectOne(id);
        System.out.println("회원 번호: " + m.getId());
        System.out.println("회원 등급: " + m.getGrade());
        System.out.println("마이 아이디: " + m.getUsername());
        System.out.println("마이 닉네임: " + m.getNickname());
    }
    
    // 3.내정보보기 -> 1.내정보 수정
    private void update(int id) {
    	String message;

        message = new String("새로운 비밀번호를 입력해주세요.");
        String password = ScannerUtil.nextLine(scanner, message);
        message = new String("새로운 닉네임을 입력해주세요.");
        String nickname = ScannerUtil.nextLine(scanner, message);
        
        message = new String("정말로 수정하시겠습니까? Y/N");
        String yesNo = ScannerUtil.nextLine(scanner, message);
        if (yesNo.equalsIgnoreCase("Y")) {
            message = new String("기존 비밀번호를 입력해주세요.");
            String oldPassowrd = ScannerUtil.nextLine(scanner, message);
            if (memberController.auth(logIn.getUsername(), oldPassowrd) != null) {
                MemberDTO m = new MemberDTO();
                m.setId(logIn.getId());
                m.setUsername(logIn.getUsername());
                m.setPassword(password);
                m.setNickname(nickname);

                memberController.update(m);
            }
        }
    }
    
    // 3.내정보보기 -> 2.내정보 삭제
    private void delete(int id) {
        String message = new String("정말로 탈퇴하시겠습니까? Y/N");
        String yesNo = ScannerUtil.nextLine(scanner, message);

        if (yesNo.equalsIgnoreCase("Y")) {
            message = new String("비밀번호를 입력해주세요.");
            String password = ScannerUtil.nextLine(scanner, message);

            if (memberController.auth(logIn.getUsername(), password) != null) {
                memberController.delete(id);
                //boardViewer.deleteByWriterId(id);
                logIn = null;
            }
        }
    }
    
	
}

