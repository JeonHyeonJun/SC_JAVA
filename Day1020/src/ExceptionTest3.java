import java.io.IOException;

public class ExceptionTest3 {
	//throws는 예외처리를 떠넘김
	public static void main(String[] args) throws IOException {
		char ch;
		
		try {
			ch = (char) System.in.read();	//System.in.read()는 throws IOException이 붙어있기 때문에
											//사용하려면 IOException을 예외처리 해줘야만 사용할 수 있다.
											//RuntimeException의 하위타입이 아닌 다른 Exception은 컴파일 단계부터 에러가 발생한다.
			System.out.println("입력한 문자: " + ch);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();	//에러 메시지 출력. 디버깅용 출력 메시지
		}
		
		ch = (char) System.in.read();
	}
}
