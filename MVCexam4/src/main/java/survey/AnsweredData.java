package survey;

import java.util.List;

//커맨드 객체로 사용할 클래스 
public class AnsweredData {	//설문 항목에 대한 답변과 응답자의 정보를 모두 담기 위한 클래스 
	private List<String> responses;	//submitted.jsp파일에서 해당 클래스의 변수를 이용해 forEach로 요청파라미터를 받을 때 꼭 이변수와 같은 이름을 써야함 
	
	//그냥 AnsweredData클래스는 질문의 대한 답변만을 배열로 저장하는 클래스이지만, Respondent res를 선언하여 해당 클래스를 참조하므로써,
	//Respondent클래스가 가진 응답자의 정보(위치, 나이)도 함께 배열로 묶어 저장하고 view에게 전송하는 기능을 가지게 됨
	private Respondent res;
	
	public List<String> getResponses() {
		return responses;
	}
	public void setResponses(List<String> responses) {
		this.responses = responses;
	}
	public Respondent getRes() {
		return res;
	}
	public void setRes(Respondent res) {
		this.res = res;
	}
	
	
	
	
}
