package workshop.pserson.entity;

public class PersonEntity {
	private String name;
	private char gender;
	private String ssn;
	private String address;
	private String phone;
	
	public PersonEntity(String name, String ssn, String address, String phone) {
		this.name = name;
		this.setSsn(ssn);
		this.address = address;
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "PersonEntity [name=" + name + ", gender=" + gender + ", ssn=" + ssn + ", address=" + address
				+ ", phone=" + phone + "]";
	}

	public PersonEntity(String name, char gender, String ssn, String address, String phone) {
		super();
		this.name = name;
		this.gender = gender;
		this.ssn = ssn;
		this.address = address;
		this.phone = phone;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public char getGender() {
		return this.gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}
	
	public String getSsn() {
		return this.ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
		char flag = ssn.charAt(6);
		if (flag == '1' || flag == '3') {
			this.setGender('남');
		} else if (flag == '2' || flag == '4') {
			this.setGender('여');
		}
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
}
