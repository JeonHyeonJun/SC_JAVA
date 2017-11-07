
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
//			return 1;	//앞의숫자가 더 크다면, 양수로 return하면 됨. 굳이 1일필요없음
//		else if(pnum < o.pnum)
//			return -1;	//앞의숫자가 더 작다면, 음수로 return하면 됨. 굳이 -1일필요없음
//		else
//			return 0;	//두숫자가 같다면 0으로 return하면 됨.
		
		return pnum - o.pnum;	//한줄로 정의하면 이렇게 됨.
	}
	
	
}
