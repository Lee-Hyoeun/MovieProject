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

	// ȸ������ �޼ҵ�
	private void register() {
		String message;
		message = new String("����Ͻ� ���̵� �Է����ּ���.");
		String username = ScannerUtil.nextLine(scanner, message);
		while (memberController.validateUsername(username)) {
			System.out.println("�ش� ���̵�� ����Ͻ� �� �����ϴ�.");
			message = new String("����Ͻ� ���̵� ���Է��ϼ���. X�� �Է½� �ڷΰ��� �մϴ�.");
			username = ScannerUtil.nextLine(scanner, message);
			if (username.equalsIgnoreCase("X")) {
				break;
			}
		}

		if (!username.equalsIgnoreCase("X")) {
			message = new String("����Ͻ� ��й�ȣ�� �Է����ּ���.");
			String password = ScannerUtil.nextLine(scanner, message);

			message = new String("����Ͻ� �г����� �Է����ּ���.");
			String nickname = ScannerUtil.nextLine(scanner, message);

//			message = new String("�̿��Ͻô� ����� ���ڷ� �Է��ּ���.\n1.����� 2.��а� 3.������");
//			int grade = ScannerUtil.nextInt(scanner, message);
//			while (grade > 3 || grade < 1) {
//				System.out.println("���õ� ��޸� �Է°����մϴ�.");
//				grade = ScannerUtil.nextInt(scanner, message);
//			}
			System.out.println("******���εǾ����ϴ�******\n   �α��� �� �̿����ּ���." + "\n*********************");

			MemberDTO m = new MemberDTO();

			m.setUsername(username);
			m.setPassword(password);
			m.setNickname(nickname);
//			m.setGrade(grade);

			memberController.insert(m);
		}
	}

	// �α��� �޼ҵ�
	private void logIn() {
		String message;

		message = new String("ID�� �Է����ּ���.");
		String username = ScannerUtil.nextLine(scanner, message);

		message = new String("PW�� �Է����ּ���.");
		String password = ScannerUtil.nextLine(scanner, message);

		while (memberController.auth(username, password) == null) {
			System.out.println("�߸��� ID Ȥ�� PW �Դϴ�.");
			message = new String("ID�� ���Է��ϼ���. X�� �Է½� �ڷΰ��� �մϴ�.");
			username = ScannerUtil.nextLine(scanner, message);

			if (username.equalsIgnoreCase("X")) {
				break;
			}

			message = new String("PW�� �Է����ּ���.");
			password = ScannerUtil.nextLine(scanner, message);
		}

		logIn = memberController.auth(username, password);
	}

	// ���� ùȭ��
	public void showIndex() {
		System.out.println("*******************************");
		System.out.println(" �� ��ȭŽ�� ���α׷��� ȸ������ ��˴ϴ�.\n" + "  ���� �湮�� ȸ������ �Ŀ� �̿�ٶ��ϴ�.");
		System.out.println("*******************************");
		String message = new String("1.�α���  2.ȸ������  3.���α׷� ����");
		while (true) {
			int userChoice = ScannerUtil.nextInt(scanner, message, 1, 3);
			
			if (userChoice == 1) {
				// �α��� �޼ҵ� ������, �α��� �����̸� ��޺� showMain()����
				logIn();

				if (logIn != null) {
					// boardViewer.setLogIn(logIn);
					
					showMain();
				}

			} else if (userChoice == 2) {
				// ȸ������ �޼ҵ� ����
				register();

			} else if (userChoice == 3) {
				// ���α׷� ����
				System.out.println("������ּż� �����մϴ�.");
				scanner.close();
				break;
			}

		}
	}
	
	// ȸ�� ����� �Ķ���ͷ� �Է¹޾Ƽ�
	// �ش� ȸ���� ��޸� ����ϴ� �޼ҵ� 
	public void printGrade(int grade) {	
		memberController.GradeOne(grade).getGrade();
	}

	// �α��� ������ ��޺��� ������ showMain()
	private void showMain() {
		String message = new String("�̿��Ͻ÷��� ����� �������ּ���.\n1.���� 2.��а� 3.������");
		int grade = ScannerUtil.nextInt(scanner, message);
		while (grade > 3 || grade < 1) {
			System.out.println("���õ� ��޸� �Է°����մϴ�.");
			grade = ScannerUtil.nextInt(scanner, message);
		}
		//��� ��� insert
		MemberDTO m = new MemberDTO();
		m.setGrade(grade);
		memberController.insert(m);

		while (true) {
			if (grade == GRADE_USER) {
				System.out.println("���Բ��� �����ϼ̽��ϴ�. �̿��Ͻ� ���񽺸� �������ּ���.");
				showUserMenu();

			} else if (grade == GRADE_EVAL) {
				System.out.println("��а��Բ��� �����ϼ̽��ϴ�. �̿��Ͻ� ���񽺸� �������ּ���.");
				showEvalMenu();

			} else if (grade == GRADE_MANAGER) {
				System.out.println("�����ڴԲ��� �����ϼ̽��ϴ�. �̿��Ͻ� ���񽺸� �������ּ���.");
				showManagerMenu();
			}

			if (logIn == null) {
				break;
			}
		}

	}

	// �Ϲݻ���� ��� �޴�
	private void showUserMenu() {
		String message = new String("1.��ȭ��Ϻ���  2.�����Ϻ���  3.����������  4.�α׾ƿ�"); // ��ȭ��Ϻ��⿡��
		int userChoice = ScannerUtil.nextInt(scanner, message, 1, 4);

		while (true) {
			if (userChoice == 1) {
				// �Ϲݻ���� ��ȭ��� ���⸸ �޼ҵ� ����

			} else if (userChoice == 2) {
				// �Ϲݻ���� ������ ���⸸ �޼ҵ� ����

			} else if (userChoice == 3) {
				// ������������ �޼ҵ� ����

			} else if (userChoice == 4) {
				// �α׾ƿ�
				System.out.println("���������� �α׾ƿ� �ϼ̽��ϴ�.");
				logIn = null;
				// boardViewer.setLogIn(null);
			}

			if (logIn == null) {
				break;
			}
		}
	}

	// ������а� ��� �޴�
	private void showEvalMenu() {
		String message = new String("1.��ȭ��Ϻ���  2.�����Ϻ���  3.����������  4.�α׾ƿ�"); // ��ȭ��Ϻ��⿡��
		int userChoice = ScannerUtil.nextInt(scanner, message, 1, 4);

		while (true) {
			if (userChoice == 1) {
				// �Ϲݻ���� ��ȭ��� ���⸸ �޼ҵ� ����

			} else if (userChoice == 2) {
				// �Ϲݻ���� ������ ���⸸ �޼ҵ� ����

			} else if (userChoice == 3) {
				// ������������ �޼ҵ� ����

			} else if (userChoice == 4) {
				// �α׾ƿ�
				System.out.println("���������� �α׾ƿ� �ϼ̽��ϴ�.");
				logIn = null;
				// boardViewer.setLogIn(null);
			}

			if (logIn == null) {
				break;
			}
		}
	}

	// �ְ������ ��� �޴�
	private void showManagerMenu() {
		String message = new String("1.��ȭ��Ϻ���  2.�����Ϻ���  3.����������  4.�α׾ƿ�"); // ��ȭ��Ϻ��⿡��
		int userChoice = ScannerUtil.nextInt(scanner, message, 1, 4);

		while (true) {
			if (userChoice == 1) {
				// �Ϲݻ���� ��ȭ��� ���⸸ �޼ҵ� ����
				

			} else if (userChoice == 2) {
				// �Ϲݻ���� ������ ���⸸ �޼ҵ� ����

			} else if (userChoice == 3) {
				// ������������ �޼ҵ� ����
				showMine();

			} else if (userChoice == 4) {
				// �α׾ƿ�
				System.out.println("���������� �α׾ƿ� �ϼ̽��ϴ�.");
				logIn = null;
				// boardViewer.setLogIn(null);
			}

			if (logIn == null) {
				break;
			}
		}
	}
	
	
	// 3.���������� �����Է�
	private void showMine() {
		 String message = new String("1.������ ���� 2. ȸ��Ż�� 3. �ڷ� ����");
	        while (true) {
	            printOne(logIn.getId());
	            int userChoice = ScannerUtil.nextInt(scanner, message, 1, 3);
	            if (userChoice == 1) {
	                // ������ ���� �޼ҵ� ����
	                update(logIn.getId());

	            } else if (userChoice == 2) {
	                // ������ Ż�� �޼ҵ� ����
	                delete(logIn.getId());

	            } else if (userChoice == 3) {
	                break;
	            }

	            if (logIn == null) {
	                break;
	            }
	        }
	}
	
	
	// 3.���������� - �⺻ȭ��
    private void printOne(int id) {
        MemberDTO m = memberController.selectOne(id);
        System.out.println("ȸ�� ��ȣ: " + m.getId());
        System.out.println("ȸ�� ���: " + m.getGrade());
        System.out.println("���� ���̵�: " + m.getUsername());
        System.out.println("���� �г���: " + m.getNickname());
    }
    
    // 3.���������� -> 1.������ ����
    private void update(int id) {
    	String message;

        message = new String("���ο� ��й�ȣ�� �Է����ּ���.");
        String password = ScannerUtil.nextLine(scanner, message);
        message = new String("���ο� �г����� �Է����ּ���.");
        String nickname = ScannerUtil.nextLine(scanner, message);
        
        message = new String("������ �����Ͻðڽ��ϱ�? Y/N");
        String yesNo = ScannerUtil.nextLine(scanner, message);
        if (yesNo.equalsIgnoreCase("Y")) {
            message = new String("���� ��й�ȣ�� �Է����ּ���.");
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
    
    // 3.���������� -> 2.������ ����
    private void delete(int id) {
        String message = new String("������ Ż���Ͻðڽ��ϱ�? Y/N");
        String yesNo = ScannerUtil.nextLine(scanner, message);

        if (yesNo.equalsIgnoreCase("Y")) {
            message = new String("��й�ȣ�� �Է����ּ���.");
            String password = ScannerUtil.nextLine(scanner, message);

            if (memberController.auth(logIn.getUsername(), password) != null) {
                memberController.delete(id);
                //boardViewer.deleteByWriterId(id);
                logIn = null;
            }
        }
    }
    
	
}

