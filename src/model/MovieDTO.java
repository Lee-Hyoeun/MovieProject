package model;

/*
 * 영화관리 클래스
 */

public class MovieDTO {
	private int id;				//영화번호
	private String title;		//영화제목
	private String story;		//영화줄거리
	private String moviegrade;	//영화 등급
	
	
	public int getid() {
		return id;
	}
	public void setMovieid(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getStory() {
		return story;
	}
	public void setStory(String story) {
		this.story = story;
	}
	public String getMoviegrade() {
		return moviegrade;
	}
	public void setMoviegrade(String moviegrade) {
		this.moviegrade = moviegrade;
	}
	
	
	public boolean equals(Object o) {
        if (o instanceof MovieDTO) {
            MovieDTO m = (MovieDTO) o;
            if (id == m.id) {
                return true;
            }
        }

        return false;
    }

}
