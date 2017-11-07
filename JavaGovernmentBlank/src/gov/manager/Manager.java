package gov.manager;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import gov.vo.FireStation;
import gov.vo.GovernmentOffice;
import gov.vo.PoliceOffice;

public class Manager {
	private final String FILE_NAME = "gov.dat";
	
	private ArrayList<GovernmentOffice> officeList;	// 관공서 리스트
	ObjectOutputStream oos;
	ObjectInputStream ois;
	
	/**
	 * Constructor
	 */
	public Manager() {
		if(new File(FILE_NAME).exists()){
			loadFile();
		} else {
			officeList = new ArrayList<GovernmentOffice>();
		}
	}
	
	/**
	 * gov.dat를 저장한다
	 */
	public void saveFile() {
		// CODE HERE
		try {
			oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME));
			oos.writeObject(officeList);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
				try {
					if(oos != null)
						oos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
	
	/**
	 * gov.dat를 불러온다
	 */
	public void loadFile() {
		// CODE HERE
		try {
			ois = new ObjectInputStream(new FileInputStream(FILE_NAME));
			officeList = (ArrayList<GovernmentOffice>) ois.readObject();
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
				try {
					if(ois != null)
						ois.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
	}
	
	/**
	 * 관공서 정보를 저장한다. 관공서는 관리 번호에 의해 분류되고 중복될 수 없다.
	 * @param office 저장할 관공서 정보
	 * @return 저장 여부
	 */
	public boolean insert(GovernmentOffice office) {
		// CODE HERE
		if(search(office.getOfficeId()) != null)
			return false;
		
		officeList.add(office);
		return true;
	}

	/**
	 * 관리 번호를 통해 관공서 정보를 찾는다.
	 * @param officeId 검색할 관공서의 관리 번호
	 * @return 일치하는 관공서 정보
	 */
	public GovernmentOffice search(String officeId) {
		// CODE HERE
		for (GovernmentOffice g : officeList) {
			if(officeId.equals(g.getOfficeId()))
				return g;
		}
		return null;
	}

	/**
	 * 관리 번호를 통해 관공서 정보를 삭제한다.
	 * @param officeId 삭제할 관공서의 관리 번호
	 * @return 삭제 여부
	 */
	public boolean delete(String officeId) {
		// CODE HERE
		GovernmentOffice office = search(officeId);
		if(office != null) {
			officeList.remove(office);
			return true;
		}
		return false;
	}

	/**
	 * 관공서 리스트를 얻는다
	 * @return
	 */
	public ArrayList<GovernmentOffice> getOfficeList() {
		return officeList;
	}

	/**
	 * 경찰서의 갯수를 얻는다
	 * @return 경찰서의 갯수
	 */
	public int getPoliceOfficeCount() {
		int count = 0;
		
		// CODE HERE
		for (GovernmentOffice g : officeList) {
			if(g instanceof PoliceOffice) {
				count++;
			}
		}
		officeList.size();
		return count;
	}

	/**
	 * 소방서의 갯수를 얻는다
	 * @return 소방서의 갯수
	 */
	public int getFireStationCount() {
		int count = 0;
		
		// CODE HERE
		for (GovernmentOffice g : officeList) {
			if(g instanceof FireStation)
				count++;
		}
		return count;
	}

	/**
	 * 전체 관공서의 종사자 수를 얻는다
	 * @return 전체 관공서의 종사자 수
	 */
	public int getEmployeeCount() {
		int sum = 0;
		
		// CODE HERE
		for (GovernmentOffice g : officeList) {
			sum += g.getEmployeeCount();
		}
		return sum;
	}
}
