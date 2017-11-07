
public class Person {
	private String name;
	private String adress;
	private String phone;
	
	public Person() {
	}
	
	public Person(String name, String adress, String phone) {
		this.name = name;
		this.adress = adress;
		this.phone = phone;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", adress=" + adress + ", phone=" + phone + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adress == null) ? 0 : adress.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Person))
			return false;
		Person other = (Person) obj;
		if (adress == null) {
			if (other.adress != null)
				return false;
		} else if (!adress.equals(other.adress))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		return true;
	}
	
	
	
	/*@Override
	public boolean equals(Object obj) {
		//비교대상이 Person객체가 아니면 false
		if(!(obj instanceof Person)) {
			System.out.println("객체가다름");
			return false;
		}
		
		//같은 종류의 객체 비교는 무조건 true
		if(this == obj) {
			System.out.println("주소가 같음");
			return true;
		}
		
		Person p = (Person) obj;
		
		if(this.getName().equals(p.getName()) && this.getAdress().equals(p.getAdress()) && this.getPhone().equals(p.getPhone())) {
			return true;
		}
		else {
			return false;
		}
		
	}*/
}
