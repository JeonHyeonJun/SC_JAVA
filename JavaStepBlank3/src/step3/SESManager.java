package step3;
import java.io.*;
import java.util.*;

/**
 * <pre>
 * SES(Soft Engineer School) 관리 프로그램의 업무로직을 관리하는 클래스
 * 주요 기능으로는 다음과 같다.
 * 1. 신규 관리인원 등록
 * 2. 등록인원 검색
 * 3. 등록인원 삭제
 * 4. 전체 등록인원 출력
 * </pre>
 * */
public class SESManager {
	private final String FILE_NAME = "human.dat";	// 파일명 상수
	private ArrayList<Human> list;	// Human 객체를 담을 리스트
	
	private FileInputStream fis;	//파일을 읽기위한 스트림
	private FileOutputStream fos;	//파일을 쓰기위한 스트림
	private ObjectInputStream ois;	//객체를 읽기위한 스트림
	private ObjectOutputStream oos;	//객체를 쓰기위한 스트림
	
	/**
	 * 생성자
	 */
	public SESManager(){
		// 파일이 존재하면 읽어들인다. 없으면 ArrayList를 생성한다.
		File f = new File(FILE_NAME);
		if(!f.exists()) 
			list = new ArrayList<>();
		else 
			getFile();
		
	}
	
	/**
	 * 새로운 Human 객체를 등록한다.
	 * @param human 등록할 Professor, Trainee, Staff 클래스의 객체
	 * @return 성공 여부
	 * */
	public boolean insertHuman(Human human) {
		// 전달된 객체의 주민등록번호로 검색한다.
		Human find_h = findHuman(human.getJumin());
		
		// 등록된 주민번호인지 체크한다. 이미 있는 주민등록번호인 경우는 false를 리턴한다.
		if(find_h != null) 
			return false;
		
		//리스트에 새로운 Human 객체를 추가한다.
		list.add(human);
		//파일에 저장 리스트를 덮어쓴다
		setFile();
		//true를 리턴한다.
		return true;
	}

	/**
	 * 등록된 Human 객체를 검색한다.
	 * @param jumin 검색할 Human의 주민번호
	 * @return Human 배열에 등록된 객체들 중 파라메터로 전달된 주민번호와 일치되는 Human 객체, 검색 결과가 없을 시 null을 반환한다.
	 * */
	public Human findHuman(String jumin) {
		//전달된 주민번호를 리스트에서 검색하여 있으면 해당 객체를 리턴한다.
		for (Human h : list) {
			if(jumin.equals(h.getJumin())) 
				return h;
		}
		return null;
		//없으면 null을 리턴한다.
	}

	/**
	 * 등록된 Human 객체를 삭제한다.
	 * @param jumin 삭제할 Human의 주민번호
	 * @return 주어진 주민번호와 일치되는 Human 객체의 삭제 결과, Human 배열에 등록된 객체들 중 파라메터로 전달된 주민번호와 일치되는 Human 객체가 발견되어 삭제를 성공하면 true를 그렇지 않으면 false를 반환
	 * */
	public boolean deleteHuman(String jumin){
		//전달된 주민번호를 찾아 해당 객체를 삭제한다.
		Human find_h = findHuman(jumin);
		if(find_h != null) {
			for (Human h : list) {
				if(find_h.getJumin().equals(h.getJumin())) {
					list.remove(h);
					setFile();
					return true;
				}
			}
		}
		//삭제 성공 여부를 리턴한다.
		return false;
	}

	/**
	 * 등록된 모든 Human 객체 정보를 출력한다.
	 * */
	public void showAll() {
		//리스트의 모든 객체 출력
		for (Human h : list) {
			System.out.println(h);
		}
	}
	
	/**
	 * 리스트에 등록된 모든 Human 객체 정보를 파일에 쓴다.
	 * @return 파일 쓰기 성공 여부
	 * */
	public boolean setFile(){
		try {
			fos = new FileOutputStream(FILE_NAME);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(list);
			return true;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		} finally {
			closeStreams();
		}
	}
	
	/**
	 * 파일에 쓰여진 모든 Human 객체 정보를 ArrayList로 읽어들인다.
	 * */
	public void getFile() {
		try {
			fis = new FileInputStream(FILE_NAME);
			ois = new ObjectInputStream(fis);
			list = (ArrayList<Human>)ois.readObject();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeStreams();
		}
	}
	
	/**
	 * 스트림 객체를 모두 close 하여 자원을 반환한다.
	 * */
	private void closeStreams() {
		try {
			if(oos != null)
				oos.close();
			if(ois != null)
				ois.close();
			if(fos != null)
				fos.close();
			if(fis != null)
				fis.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
