package model;

/*
 * �������� Ŭ����
 */

public class EvaluationDTO {
	//������ȣ, �ۼ�ȸ����ȣ, ��ȭ��ȣ, ����, ���
	private int id;				// ������ȣ
	private String writer;		// �ۼ�ȸ����ȣ
	private String movieid;		// ��ȭ��ȣ
	private String Evalgrade;	// ����
	private String content;		// ���
	
	
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


