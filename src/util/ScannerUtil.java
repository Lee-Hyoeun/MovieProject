package util;

import java.util.Scanner;


public class ScannerUtil {
	
	 
    //1. �Է½� �Է� �ȳ� ���� ����� �����
    //   printMessage()
    private static void printMessage(String message) {
        System.out.println(message);
        System.out.println("> ");
    }
    
    //2. int �Է��� ����� nextInt()
    public static int nextInt(Scanner scanner, String message) {
        printMessage(message);
        return scanner.nextInt();
    }
    
    //3. Ư�� ������ int�Է��� ����� nextInt()
    public static int nextInt(Scanner scanner, String message, int min, int max) {
        int num = nextInt(scanner, message);
        
        while( !(num>=min && num<=max)) {
            System.out.println("======================");
            System.out.println("�߸� �Է��ϼ̽��ϴ�.");
            System.out.println("======================");
            num = nextInt(scanner, message);
        }
        
        return num;
    }
    
    
    //4. ��ĳ�� ���۸޸� ���׸� ���������� �ذ��ϴ�
    //   nextLine()
    public static String nextLine(Scanner scanner, String message) {
        printMessage(message);
        String temp = scanner.nextLine();
        
        //String Ŭ���� ������ isEmpty() �޼ҵ��
        //�ش� ������ ����� ���� �ƹ��͵� ������ true,
        //���� ������ false�� �����Ѵ�.
        if(temp.isEmpty()) { //temp�� ����,�����̽� �� �ƹ��ų� �� ������ true, ��null�̸� false�� ����
            temp = scanner.nextLine();
        }
        
        return temp;
    
    }

}
