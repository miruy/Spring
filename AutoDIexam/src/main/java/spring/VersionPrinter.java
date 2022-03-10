package spring;

//프로그램버전 출력 클래스 (기본타입형 : int, double, boorean등 적용), property태그 사용예제
public class VersionPrinter {
	private int majorVersion;
	private int minorVersion;
	
	public void setMajorVersion(int majorVersion) {
		this.majorVersion = majorVersion;
	}
	
	public void setMinorVersion(int minorVersion) {
		this.minorVersion = minorVersion;
	}
	
	public void print() {
		System.out.printf("프로그램 버전 %d.%d\n\n", majorVersion, minorVersion);
	}
}
