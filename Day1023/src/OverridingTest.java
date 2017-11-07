import java.io.EOFException;
import java.io.IOException;

public class OverridingTest {
	int test(int a) throws IOException {
		return 0;
	}
}

class A extends OverridingTest {
//	int test(int a) throws IOException { return 0; }			//o. 똑같이 쓰는거 가능
//	public int test(int a) throws IOException { return 0; }		//o. public이 더 개방적이므로 가능
//	int test() throws IOException { return 0; }					//오버로딩임
//	int test(int a) { return 0; }								//o. throws 지워도 가능
//	int test(int a) throws Exception { return 0; }				//x. Exception이 더 상위타입이므로 안됨
//	int test(int a) throws EOFException { return 0; }			//o. EOFException이 더 하위타입이므로 가능
}
