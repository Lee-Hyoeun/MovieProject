package model;

/*
 * ȸ������ Ŭ����
 */

public class MemberDTO {
	//�ʵ�
	private int id;				//ȸ����ȣ
	private String username;	//���̵�
	private String password;	//��й�ȣ
	private String nickname;	//�г���
	private int grade;			//���(1.����� 2.��а� 3.������)
	
//	private final int GRADE_USER = 1;
//	private final int GRADE_EVAL = 2;
//	private final int GRADE_MANAGER = 3;
	
	//�޼ҵ�
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
