package mkdir;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class SESManager {
	private final String F_NAME = "testDat.dat";
	static ArrayList<Human> list;
	ObjectOutputStream oos;
	ObjectInputStream ois;

	public SESManager() {
		getList();

	}

	public boolean insertHuman(Human h) {

		if (find_h(h.getJumin()) != null)
			return false;

		list.add(h);
		setList();
		return true;
	}
	
	public boolean deleteHuman(String jumin) {
		if(find_h(jumin) != null) {
			for (Human h : list) {
				if(jumin.equals(h.getJumin())) {
					list.remove(h);
					setList();
					return true;
				}
			}
		}
		return false;
	}

	public void showAll() {
		for (Human h : list) {
			System.out.println(h);
		}
	}

	public Human find_h(String jumin) {
		for (Human h : list) {
			if (jumin.equals(h.getJumin()))
				return h;
		}
		return null;
	}

	public void getList() {
		try {
			ois = new ObjectInputStream(new FileInputStream(F_NAME));
			list = (ArrayList<Human>) ois.readObject();
		} catch (FileNotFoundException e) {
			list = new ArrayList<>();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
	}

	public void setList() {
		try {
			oos = new ObjectOutputStream(new FileOutputStream(F_NAME));
			oos.writeObject(list);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
	}

	public void close() {
		try {
			if (ois != null)
				ois.close();
			if (oos != null)
				oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
