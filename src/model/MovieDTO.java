package model;

/*
 * ��ȭ���� Ŭ����
 */

public class MovieDTO {
	private int id;				//��ȭ��ȣ
	private String title;		//��ȭ����
	private String story;		//��ȭ�ٰŸ�
	private String moviegrade;	//��ȭ ���
	
	
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
