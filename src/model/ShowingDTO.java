package model;

/*
 * ���������� Ŭ����
 */

public class ShowingDTO {
	private int id;				//������ ��ȣ
	private String movieid;		//��ȭ��ȣ
	private String theaterid;	//�����ȣ
	private String showingtime;	//�󿵽ð�
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMovieid() {
		return movieid;
	}
	public void setMovieid(String movieid) {
		this.movieid = movieid;
	}
	public String getTheaterid() {
		return theaterid;
	}
	public void setTheaterid(String theaterid) {
		this.theaterid = theaterid;
	}
	public String getShowingtime() {
		return showingtime;
	}
	public void setShowingtime(String showingtime) {
		this.showingtime = showingtime;
	}
	
	
	public boolean equals(Object o) {
        if (o instanceof ShowingDTO) {
            ShowingDTO m = (ShowingDTO) o;
            if (id == m.id) {
                return true;
            }
        }

        return false;
    }
	

}
