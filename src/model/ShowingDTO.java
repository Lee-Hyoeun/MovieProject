package model;

/*
 * 상영정보관리 클래스
 */

public class ShowingDTO {
	private int id;				//상영정보 번호
	private String movieid;		//영화번호
	private String theaterid;	//극장번호
	private String showingtime;	//상영시간
	
	
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
