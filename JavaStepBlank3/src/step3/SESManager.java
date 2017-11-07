package step3;
import java.io.*;
import java.util.*;

/**
 * <pre>
 * SES(Soft Engineer School) ���� ���α׷��� ���������� �����ϴ� Ŭ����
 * �ֿ� ������δ� ������ ����.
 * 1. �ű� �����ο� ���
 * 2. ����ο� �˻�
 * 3. ����ο� ����
 * 4. ��ü ����ο� ���
 * </pre>
 * */
public class SESManager {
	private final String FILE_NAME = "human.dat";	// ���ϸ� ���
	private ArrayList<Human> list;	// Human ��ü�� ���� ����Ʈ
	
	private FileInputStream fis;	//������ �б����� ��Ʈ��
	private FileOutputStream fos;	//������ �������� ��Ʈ��
	private ObjectInputStream ois;	//��ü�� �б����� ��Ʈ��
	private ObjectOutputStream oos;	//��ü�� �������� ��Ʈ��
	
	/**
	 * ������
	 */
	public SESManager(){
		// ������ �����ϸ� �о���δ�. ������ ArrayList�� �����Ѵ�.
		File f = new File(FILE_NAME);
		if(!f.exists()) 
			list = new ArrayList<>();
		else 
			getFile();
		
	}
	
	/**
	 * ���ο� Human ��ü�� ����Ѵ�.
	 * @param human ����� Professor, Trainee, Staff Ŭ������ ��ü
	 * @return ���� ����
	 * */
	public boolean insertHuman(Human human) {
		// ���޵� ��ü�� �ֹε�Ϲ�ȣ�� �˻��Ѵ�.
		Human find_h = findHuman(human.getJumin());
		
		// ��ϵ� �ֹι�ȣ���� üũ�Ѵ�. �̹� �ִ� �ֹε�Ϲ�ȣ�� ���� false�� �����Ѵ�.
		if(find_h != null) 
			return false;
		
		//����Ʈ�� ���ο� Human ��ü�� �߰��Ѵ�.
		list.add(human);
		//���Ͽ� ���� ����Ʈ�� �����
		setFile();
		//true�� �����Ѵ�.
		return true;
	}

	/**
	 * ��ϵ� Human ��ü�� �˻��Ѵ�.
	 * @param jumin �˻��� Human�� �ֹι�ȣ
	 * @return Human �迭�� ��ϵ� ��ü�� �� �Ķ���ͷ� ���޵� �ֹι�ȣ�� ��ġ�Ǵ� Human ��ü, �˻� ����� ���� �� null�� ��ȯ�Ѵ�.
	 * */
	public Human findHuman(String jumin) {
		//���޵� �ֹι�ȣ�� ����Ʈ���� �˻��Ͽ� ������ �ش� ��ü�� �����Ѵ�.
		for (Human h : list) {
			if(jumin.equals(h.getJumin())) 
				return h;
		}
		return null;
		//������ null�� �����Ѵ�.
	}

	/**
	 * ��ϵ� Human ��ü�� �����Ѵ�.
	 * @param jumin ������ Human�� �ֹι�ȣ
	 * @return �־��� �ֹι�ȣ�� ��ġ�Ǵ� Human ��ü�� ���� ���, Human �迭�� ��ϵ� ��ü�� �� �Ķ���ͷ� ���޵� �ֹι�ȣ�� ��ġ�Ǵ� Human ��ü�� �߰ߵǾ� ������ �����ϸ� true�� �׷��� ������ false�� ��ȯ
	 * */
	public boolean deleteHuman(String jumin){
		//���޵� �ֹι�ȣ�� ã�� �ش� ��ü�� �����Ѵ�.
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
		//���� ���� ���θ� �����Ѵ�.
		return false;
	}

	/**
	 * ��ϵ� ��� Human ��ü ������ ����Ѵ�.
	 * */
	public void showAll() {
		//����Ʈ�� ��� ��ü ���
		for (Human h : list) {
			System.out.println(h);
		}
	}
	
	/**
	 * ����Ʈ�� ��ϵ� ��� Human ��ü ������ ���Ͽ� ����.
	 * @return ���� ���� ���� ����
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
	 * ���Ͽ� ������ ��� Human ��ü ������ ArrayList�� �о���δ�.
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
	 * ��Ʈ�� ��ü�� ��� close �Ͽ� �ڿ��� ��ȯ�Ѵ�.
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
