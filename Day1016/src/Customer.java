
public class Customer extends Person{
	private int num;
	private int sg;
	
	
	public Customer(String name, String adress, String phone, int num, int sg) {
		super(name, adress, phone);
		this.num = num;
		this.sg = sg;
	}
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getSg() {
		return sg;
	}
	public void setSg(int sg) {
		this.sg = sg;
	}

	@Override
	public String toString() {
		return "Customer [num=" + num + ", sg=" + sg + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + num;
		result = prime * result + sg;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof Customer))
			return false;
		Customer other = (Customer) obj;
		if (num != other.num)
			return false;
		if (sg != other.sg)
			return false;
		return true;
	}	
	
	
	
}
