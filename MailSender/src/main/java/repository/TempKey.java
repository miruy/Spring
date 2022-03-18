package repository;

import java.util.Random;

// mail인증 키 생성을 위한 클래스(이메일 인증코드를 난수화함(랜덤으로)
public class TempKey {
	
	private boolean lowerCheck;	//인증 키가 소문자인지 판단
	private int size;	//인증 키의 길이
	
	public String getKey(int size, boolean lowerCheck) {
		this.lowerCheck = lowerCheck;
		this.size = size;
		return init();
	}
	
	/*
	 * 인증 키의 경우 소문자 영어와 랜덤 숫자로 구성되어 있음
	 */
	
	private String init() {
		Random ran = new Random();	//랜덤 난수 객체 생성
		StringBuffer sb = new StringBuffer();	//문자열 객체 생성
		int num = 0;
		
		do {
			num = ran.nextInt(75)+48;	//num에 랜덤 난수 저장
			
			if((num >= 48 && num <= 57) || (num >= 65 && num <= 90) || (num >= 97 && num <= 122)) {
				sb.append((char)num);	//랜덤 난수의 조건에 일치한다면 문자열객체에 랜덤 난수 저장
			}else {
				continue;
			}
		}while(sb.length() < size);	//인자로 전달받은 인증 키의 길이보다 랜덤난수 문자열객체의 길이가 짧다면
	
		if(lowerCheck) {	//인증키가 대문자라면
			return sb.toString().toLowerCase();	//소문자로 변환해 반환 , toLowerCase() : 문자열을 소문자로 변환해 반환하는 메서드
		}
		return sb.toString();
	}
	
}	
