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

	// ���� ùȭ��
	public void showIndex() {
		System.out.println("*******************************");
		System.out.println(" �� ��ȭŽ�� ���α׷��� ȸ������ ��˴ϴ�.\n" + "  ���� �湮�� ȸ������ �Ŀ� �̿�ٶ��ϴ�.");
		System.out.println("*******************************");
		String message = new String("1.�α���  2.ȸ������  3.���α׷� ����");
		while (true) {
			int userChoice = ScannerUtil.nextInt(scanner, message, 1, 3);

			if (userChoice == 1) {
				// �α��� �޼ҵ� ������, �α��� �����̸� showMenu()����
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

			message = new String("�̿��Ͻô� ����� ���ڷ� �Է��ּ���.\n1.����� 2.��а� 3.������");
			int grade = ScannerUtil.nextInt(scanner, message);
		    while(grade > 3 || grade < 1) {
				System.out.println("���õ� ��޸� �Է°����մϴ�.");
				grade = ScannerUtil.nextInt(scanner, message);
			} 
				System.out.println("******���εǾ����ϴ�******\n   �α��� �� �̿����ּ���."
						+ "\n*********************");


			MemberDTO m = new MemberDTO();

			m.setUsername(username);
			m.setPassword(password);
			m.setNickname(nickname);
			m.setGrade(grade);

			memberController.insert(m);
		}
	}
	

	// �α��� ������ ������ showMain()
	private void showMain() {
		System.out.println("�������^^ ��޿� ���� �̿� �����մϴ�.");
		String message = new String("1.�����  2.��а�  3.������  4.�α׾ƿ�");

		while (true) {
			int userChoice = ScannerUtil.nextInt(scanner, message, 1, 4);

		}

	}

}
