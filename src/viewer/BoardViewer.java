package viewer;

import java.util.Scanner;

import model.MemberDTO;

public class BoardViewer {
    private Scanner scanner;
    
    private MemberDTO logIn;
    private MemberViewer memberViewer;
    
    
    
    private final String DATE_FORMAT_STRING = new String("yy/M/d H:m:s");
    
    
    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
       // replyViewer.setScanner(scanner);
    }
    
    public void setLogIn(MemberDTO logIn) {
        this.logIn = logIn;
       // replyViewer.setLogIn(logIn);
    }
    

    public void setMemberViewer(MemberViewer memberViewer) {
        this.memberViewer = memberViewer;
       // replyViewer.setMemberViewer(memberViewer);

    }

    

}

