package PDFexam;

import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;

public class PdfboxTest {
	public static void main(String[] args) throws IOException {
		
		//빈 PDF 문서 객체 생성 
		PDDocument document  = new PDDocument();
		
		//문서저장 및 출력문으로 확인 
		document.save("/Users/kim-yurim/Desktop/스프링 개발을 위한 메이븐 프로젝트 구성방법_김유림.pdf");
		System.out.println("PDF Created!");
		
		//문서 닫기 
		document.close();
	}
}	
