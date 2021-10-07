package controller;
/*
 * 회원 가입을 한 회원을 제어 합니다.
 * 
 */
import java.util.ArrayList;

import model.MemberDTO;

public class MemberController {
	private ArrayList<MemberDTO> list;
	private int nextId;

	
	// 생성자
	public MemberController() {
		list = new ArrayList<>();
		nextId = 1;		
	}
	
	
	//deepCopy(MemberDTO m)
	public MemberDTO deepCopy(MemberDTO m) {
		MemberDTO temp = new MemberDTO();
		
		temp.setId(m.getId());
		temp.setUsername(new String(m.getUsername()));
		temp.setNickname(new String(m.getNickname()));
		temp.setGrade(m.getGrade());

		return temp;
	}
	
	
	// insert(MemberDTO m)
	public void insert(MemberDTO m) {
		m.setId(nextId++);
		
		list.add(m);
	}
	
	// update(MemberDTO m)
	public void update(MemberDTO m) {
		int index = list.indexOf(m);
		list.set(index, m);
	}
	
	// delete(int id)
	public void delete(int id) {
		MemberDTO m = new MemberDTO();
		m.setId(id);
		
		list.remove(m);
	}
	
		//selectOne(int id)
	public MemberDTO selectOne(int id) {
		for(MemberDTO m : list) {
			if (m.getId() == id) {
				return deepCopy(m);
			}
		}
		
		return null;
	}
	
	
	public MemberDTO GradeOne(int grade) {
		for(MemberDTO m : list) {
			if(m.getGrade() == grade) {
				return deepCopy(m);
			} 
		}
		return null;
	}
	
	
	// validateUsername(String username)
	// 아이디 중복제거
    public boolean validateUsername(String username) {
        if (username.equalsIgnoreCase("X")) {
            return true;
        }

        for (MemberDTO m : list) {
            if (m.getUsername().equalsIgnoreCase(username)) {
                return true;
            }
        }

        return false;
    }

    // auth(String username, String password)
    public MemberDTO auth(String username, String password) {
        for (MemberDTO m : list) {
            if (m.getUsername().equalsIgnoreCase(username) && m.getPassword().equals(password)) {
                return deepCopy(m);
            }
        }

        return null;
    }
	

	
}
