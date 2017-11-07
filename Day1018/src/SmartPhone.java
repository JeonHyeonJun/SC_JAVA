
public class SmartPhone extends Phone implements Comparable<SmartPhone>{
	private String os;
	private String ver;
	private int memory;
	private boolean camera;
	private boolean bluetooth;
	
	public SmartPhone() {}

	public SmartPhone(String made, int money, String type, String os, String ver, int memory, boolean camera,
			boolean bluetooth) {
		super(made, money, type);
		this.os = os;
		this.ver = ver;
		this.memory = memory;
		this.camera = camera;
		this.bluetooth = bluetooth;
	}



	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public String getVer() {
		return ver;
	}

	public void setVer(String ver) {
		this.ver = ver;
	}

	public int getMemory() {
		return memory;
	}

	public void setMemory(int memory) {
		this.memory = memory;
	}

	public boolean isCamera() {
		return camera;
	}

	public void setCamera(boolean camera) {
		this.camera = camera;
	}

	public boolean isBluetooth() {
		return bluetooth;
	}

	public void setBluetooth(boolean bluetooth) {
		this.bluetooth = bluetooth;
	}

	

	@Override
	public String toString() {
		return "SmartPhone [ made=" + getMade() + ", money=" + getMoney() + ", type=" + getType() + ", os=" + os + ", ver=" + ver + ", memory=" + memory + ", camera=" + camera + ", bluetooth="
				+ bluetooth + "]";
	}

	@Override
	public int compareTo(SmartPhone o) {
		if(getMade().compareTo(o.getMade()) != 0) 
			return getMade().compareTo(o.getMade());
		else
			return os.compareTo(o.os);
	}
	
	
}
