package survey;

import java.util.Collections;
import java.util.List;

//컨트롤러는 해당 클래스를 사용하여 DB에 있는 설문 항목(title)을 불러와서 목록(list)을 만들 계획
public class Question {
	private String title;	//질문
	private List<String> options;	//답변을 고르는 옵션
	
	public Question(String title, List<String> options) {
		this.options = options;
		this.title = title;
	}
	
	//Collections 클래스 의 emptyList() 메소드는 빈 리스트를 생성하고 싶을 때 사용
	//매개변수로 질문(title)을 넣어 Question클래스의 객체를 생성 시 : 주관식 항목일 경우 
	//-> 해당 질문을 제목으로 가진 답변 옵션이 없는 배열 객체(emptyList())를 생성
	public Question(String title) {
		this(title, Collections.<String>emptyList());
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<String> getOptions() {
		return options;
	}

	public void setOptions(List<String> options) {
		this.options = options;
	}
	
	//사용자가 답변을 체크하였다면(옵션 체크에 값이 있다면) 메서드 실행, 값의 유무를 참,거짓으로 반환 
	public boolean isChoice() {
		return options != null && !options.isEmpty();
	}
}
