package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import spring.AlreadyExistingMemberException;
import spring.ChangePasswordService;
import spring.IdPasswordNotMatchingException;
import spring.MemberInfoPrinter;
import spring.MemberListPrinter;
import spring.MemberNotFoundException;
import spring.MemberRegisterService;
import spring.RegisterRequest;
import spring.VersionPrinter;

public class Main {
	
	//context객체(Asemmbler == 스프링 컨테이너 == ctx.xml == 설정파일) 참조 추가 
	private static ApplicationContext ctx = null;
	
	public static void main(String[] args) throws IOException {
		//스프링 설정파일(appCtx.xml)을 통해 객체를 생성하고 의존객체(DI)를 주입하는 스프링 컨테이너 생성
		ctx = new GenericXmlApplicationContext("classpath:appCtx.xml");
		
		//Scanner와 같은 기능(사용자로부터 입력받는) / InputStreamReader : 빨대 
		BufferedReader reader = new BufferedReader(
				new InputStreamReader(System.in));
		
		while(true) {
			System.out.print("명령어를 입력하세요 : ");
			String command = reader.readLine();
			
			//equalsIgnoreCase : 문자열 비교 시 대소문자를 무시(대소문자 달라도 동일한 것으로 간주)
			if(command.equalsIgnoreCase("exit")) {
				System.out.println("종료합니다.");
				break;
			}
			//startsWith : 인자 값이 문자열인지 아닌지를 boolean으로 반환
			//split : 공백을 인지하는 메서드,
			//split() : 실제 공백 갯수 상관없이 공백이 있으면 1개로 인식
			//split("") : 있는 그대로 공백 인식하며 공백 후 문자열까지도 인식
			if(command.startsWith("new ")) {
				processNewCommand(command.split(" "));	//new입력시 새로운 회원 등록
				continue;
			}else if(command.startsWith("change ")) {
				processChangeCommand(command.split(" "));	//change 입력시 회원의 비밀번호를 바꿈 
				continue;
			
			//list메서드 추가 후 추가 부분 
			}else if(command.equals("list")) {
				processListCommand();
				continue;
			//이메일 검색으로 회원정보 출력 메서드 추가(set()와 property태그 사용위해 추가한 부분) 
			}else if(command.startsWith("info ")) {
				processInfoCommand(command.split(" "));
				continue;
			//프로그램 버전 출력 메서드 추가 (set(), property태그 사용 예제)
			}else if(command.equals("version")) {
				processVersionCommand();
				continue;
			}
			printHelp();	//도움말 표시하기
		}
	}
	
		//조립기(Aseembler) 사용 안함 
//		private static Assembler assembler = new Assembler();
		
		//새로운 회원을 만드는 메서드(문자열 배열을 매개변수로 전달받음)
		private static void processNewCommand(String[] arg) {
			
			//사용자가 입력하는 글자의 갯수가 5개 아니라면(컬럼갯수가 5개이기 때문)
			if(arg.length != 5) {	
				printHelp();	//도움말
				return;
			}
			
			//사용자가 입력하는 글자의 갯수가 5라면 회원 가입 진행 
			//위 서비스 객체 가져오기를 스프링 컨테이너로부터 가져오도록 다음과 같이 변경 
//			MemberRegisterService regSvc = assembler.getMemberRegisterService();
			MemberRegisterService regSvc = ctx.getBean("memberRegSvc", MemberRegisterService.class);
			
			RegisterRequest req = new RegisterRequest();
			req.setEmail(arg[1]);
			req.setName(arg[2]);
			req.setPassword(arg[3]);
			req.setConfirmPassword(arg[4]);
			
			//처음 입력한 비밀번호와 확인용 비밀번호가 일치하지 않다면
			if(!req.isPasswordEqualToConfirmPassword()) {
				System.out.println("암호화 확인이 일치하지 않습니다.\n");
				return;
			}
			//처음 입력한 비밀번호와 확인용 비밀번호가 일치하다면 등록과정 계속 진행
			try {
				regSvc.regist(req);	//스프링 컨테이너 객체의 기능 사용(회원 등록)
				System.out.println("등록되었습니다.\n");
				
			//회원 가입시 이메일검색으로 기존회원확인에서 일어날 수 있는 에외처리 표시 
			}catch(AlreadyExistingMemberException e) {
				System.out.println("이미 존재하는 이메일입니다.\n");
			}
		}
		
		private static void processChangeCommand(String[] arg) {
			
			//사용자가 입력한 글자의 갯수가 4가 아니라면 도움말 표시 
			if(arg.length != 4) {
				printHelp();
				return;
			}
			//사용자가 입력한 글자의 갯수가 4라면 비밀번호 변경 
//			ChangePasswordService changePwdSvc = assembler.getChangePasswordService();
			ChangePasswordService changePwdSvc = ctx.getBean("changePwdSvc", ChangePasswordService.class);
			
			try {
				//스프링컨테이너 객체의 기능 사용 (email, oldPwd, newPwd)
				changePwdSvc.changePassword(arg[1], arg[2], arg[3]);	
				System.out.println("비밀번호가 변경되었습니다.\n");
			}catch(MemberNotFoundException e) {
				System.out.println("존재하지 않는 이메일입니다.\n");
			}catch(IdPasswordNotMatchingException e) {
				System.out.println("이메일과 비밀번호가 일치하지 않습니다.\n");
			}
		}		
			
		//list명령어가 입력되면 리스트(회원목록)이 출력되는 메서드 추가 
		private static void processListCommand() {
			MemberListPrinter listPrinter = 
					ctx.getBean("listPrinter", MemberListPrinter.class);
			listPrinter.printAll();
		}
		
		//이메일 검색으로 회원 정보 출력하는 메서드 추가 
		private static void processInfoCommand(String[] arg) {
			if(arg.length != 2) {
				printHelp();
				return;
			}
			MemberInfoPrinter infoPrinter = 
					ctx.getBean("infoPrinter", MemberInfoPrinter.class);
			infoPrinter.printMemberInfo(arg[1]);
		}
		
		//프로그램 버전 출력 메서드 추가 
		public static void processVersionCommand() {
			VersionPrinter versionPrinter = 
					ctx.getBean("versionPrinter", VersionPrinter.class);
			versionPrinter.print();
		}
		
		
		private static void printHelp() {
			System.out.println();
			System.out.println("명령어 사용법을 확인하세요.");
			System.out.println("help : ");
			System.out.println("list : 목록");
			System.out.println("version : 프로그램 버전");
			System.out.println("new [이메일] [이름] [비밀번호] [비밀번호 확인]");
			System.out.println("change [이메일] [현재 비밀번호] [변경할 비밀번호]");
			System.out.println("info [이메일]");
			System.out.println();
		}
			
}


















