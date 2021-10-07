package model;

/*
 * 회원관리 클래스
 */

public class MemberDTO {
	//필드
	private int id;				//회원번호
	private String username;	//아이디
	private String password;	//비밀번호
	private String nickname;	//닉네임
	private int grade;			//등급(1.사용자 2.평론가 3.관리자)
	
//	private final int GRADE_USER = 1;
//	private final int GRADE_EVAL = 2;
//	private final int GRADE_MANAGER = 3;
	
	//메소드
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	
	
	public boolean equals(Object o) {
        if (o instanceof MemberDTO) {
            MemberDTO m = (MemberDTO) o;
            if (id == m.id) {
                return true;
            }
        }

        return false;
    }


	

}
