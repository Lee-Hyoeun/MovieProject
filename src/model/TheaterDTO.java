package model;

/*
 * ������� Ŭ����
 */

public class TheaterDTO {
	private int id;				//���� ��ȣ
	private String theatername;	//���� �̸�
	private String theaterplace;//���� ��ġ
	private String theaternum;	//���� ��ȭ��ȣ
	
	
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
