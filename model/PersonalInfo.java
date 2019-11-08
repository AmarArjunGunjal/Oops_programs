package model;



public class PersonalInfo
{
	private String firstname;
	private String lastname;
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public Address getAddressobj() {
		return addressobj;
	}
	public void setAddressobj(Address addressobj) {
		this.addressobj = addressobj;
	}
	public long getMobileno() {
		return mobileno;
	}
	public void setMobileno(long mobileno) {
		this.mobileno = mobileno;
	}
	private Address addressobj;
	private long mobileno;
}
