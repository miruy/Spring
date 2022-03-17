package board.domain;

import java.sql.Timestamp;

import org.apache.ibatis.type.Alias;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/*
 * myBatis에서 지원하는 별칭 지정 어노테이션,
 * 해당 별칭으로 sql-mapper파일에서 반환형으로 클래스 명 대신 별칭 사용가능
 */
@Alias("BoardVO")
public class BoardVO {
	private int seq;	//시퀀스 값
	
	@Length(min=2, max=5, message="제목은 2자 이상, 5자 미만 입력해야 합니다.")
	private String title;	//제목
	
	@NotEmpty(message="내용을 입력하세요.")
	private String content;	//내용
	
	@NotEmpty(message="작성자를 입력하세요.")
	private String writer;	//작성자
	private int password;	//비밀번호
	private Timestamp regDate;	//등록일
	private int cnt;	//조회 수
	
	public BoardVO() {}	//디폴트 생성자
	
	public BoardVO(String title, String content, String writer, int password) {	//사용자에게 입력받는 데이터를 매개변수로 가지고 있는 오버로딩 생성자
		super();
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.password = password;
		this.cnt = cnt;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public int getPassword() {
		return password;
	}

	public void setPassword(int password) {
		this.password = password;
	}

	public Timestamp getRegDate() {
		return regDate;
	}

	public void setRegDate(Timestamp regDate) {
		this.regDate = regDate;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
}
