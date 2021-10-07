package model;

/*
 * 평점관리 클래스
 */

public class EvaluationDTO {
	//평점번호, 작성회원번호, 영화번호, 평점, 평론
	private int id;				// 평점번호
	private String writer;		// 작성회원번호
	private String movieid;		// 영화번호
	private String Evalgrade;	// 평점
	private String content;		// 평론
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getMovieid() {
		return movieid;
	}
	public void setMovieid(String movieid) {
		this.movieid = movieid;
	}
	public String getEvalgrade() {
		return Evalgrade;
	}
	public void setEvalgrade(String evalgrade) {
		Evalgrade = evalgrade;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	
	public boolean equals(Object o) {
        if (o instanceof EvaluationDTO) {
            EvaluationDTO m = (EvaluationDTO) o;
            return id == m.id;
            }
        return false;
        }
	
	
	
	}


