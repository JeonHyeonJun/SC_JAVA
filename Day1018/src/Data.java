
public class Data implements Comparable<Data>{
	private int pnum;
	private String pname;
	
	public Data() {}
	
	public Data(int pnum, String pname) {
		this.pnum = pnum;
		this.pname = pname;
	}

	public int getPnum() {
		return pnum;
	}

	public void setPnum(int pnum) {
		this.pnum = pnum;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	@Override
	public String toString() {
		return "Data [pnum=" + pnum + ", pname=" + pname + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Data))
			return false;
		Data other = (Data) obj;
		if (pname == null) {
			if (other.pname != null)
				return false;
		} else if (!pname.equals(other.pname))
			return false;
		if (pnum != other.pnum)
			return false;
		return true;
	}

	@Override
	public int compareTo(Data o) {
		// TODO Auto-generated method stub
//		if(pnum > o.pnum)
//			return 1;	//���Ǽ��ڰ� �� ũ�ٸ�, ����� return�ϸ� ��. ���� 1���ʿ����
//		else if(pnum < o.pnum)
//			return -1;	//���Ǽ��ڰ� �� �۴ٸ�, ������ return�ϸ� ��. ���� -1���ʿ����
//		else
//			return 0;	//�μ��ڰ� ���ٸ� 0���� return�ϸ� ��.
		
		return pnum - o.pnum;	//���ٷ� �����ϸ� �̷��� ��.
	}
	
	
}
