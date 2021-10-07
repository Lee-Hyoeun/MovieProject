package model;

/*
 * 극장관리 클래스
 */

public class TheaterDTO {
	private int id;				//극장 번호
	private String theatername;	//극장 이름
	private String theaterplace;//극장 위치
	private String theaternum;	//극장 전화번호
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTheatername() {
		return theatername;
	}
	public void setTheatername(String theatername) {
		this.theatername = theatername;
	}
	public String getTheaterplace() {
		return theaterplace;
	}
	public void setTheaterplace(String theaterplace) {
		this.theaterplace = theaterplace;
	}
	public String getTheaternum() {
		return theaternum;
	}
	public void setTheaternum(String theaternum) {
		this.theaternum = theaternum;
		
	}
	
	
	
	public boolean equals(Object o) {
        if (o instanceof TheaterDTO) {
            TheaterDTO m = (TheaterDTO) o;
            if (id == m.id) {
                return true;
            }
        }

        return false;
    }

}
