package PDFexam;

import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;

public class AddPage {
	public static void main(String[] args) throws IOException {
		
		//PDF 문서 객체 생성
		PDDocument document = new PDDocument();
		
		for(int i = 0; i < 10; i++) {
			PDPage page = new PDPage(); //빈 페이지 생성(10장)
			
			document.addPage(page); //빈 페이지 문서에 추가 
		}
		
		
		//문서 저장 및 생성확인 
		document.save("/Users/kim-yurim/Desktop/workspace/스프링 개발을 위한 메이븐 프로젝트 구성방법_김유림.pdf");
		System.out.println("PDF Created!");
	}
}
