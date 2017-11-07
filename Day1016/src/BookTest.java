
public class BookTest {
	public static void main(String[] args) {
		Book a = new Book("제목", 100, "글쓴이");
		Book b = new Book("제목", 100, "글쓴이");
		System.out.println(a.toString());
		System.out.println(a.equals(b));
	}
}
