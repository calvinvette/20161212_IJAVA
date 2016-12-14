public class Customer extends java.lang.Object {
	// DB-assigned primary key
	private Long customerId = -1L; // "Long" 64-bit integer

	private String firstName = "";
	private String lastName;
	// private String firstName, lastName;

	// TODO - work out an Address class later
	// private Address homeAddress;
	// private Address workAddress;

	// Store or calculate on the fly?
	private String fullName;
	// WTF - deal with Security/Privacy issues
	/**
	 * Social Security # or FEIN (Federal Employee Identification Number)
	 */
	private String taxId;
	private String email;
	private String phoneNumber;
	private String title;
	private boolean active;

	public Customer() {
		System.out.println("No-Arg CTOR");
	}
	
	public Customer(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	
	// Encapsulation - getters and setters
	// Used to protect the private instance variables and enforce business rules
	// and data integrity
	
	

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	// if (harry.isActive()) {
	// // Do something with the active harry customer
	// }
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
//		if (firstName.length() < 2 || firstName.length() > 12) {
//			System.out.println("First Name must be between 2 and 12 characters!");
//			return; // either return or use else clause below:
//		} // else {
			this.firstName = firstName;
		//}
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getTaxId() {
		return taxId;
	}

	public void setTaxId(String taxId) {
		this.taxId = taxId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName + ", taxId="
				+ taxId + ", email=" + email + ", phoneNumber=" + phoneNumber + ", title=" + title + ", active="
				+ active + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (phoneNumber == null) {
			if (other.phoneNumber != null)
				return false;
		} else if (!phoneNumber.equals(other.phoneNumber))
			return false;
		return true;
	}
	
	
	
//	@Override
	// harry.equals(someOtherCustomer)
	// lhs == Left-Hand Side (harry)
	// rhs == Right-Hand Side (someOtherCustomer)
//	public boolean equals(Object obj) {
//		Customer rhs = (Customer) obj;
//		Customer lhs = this; // this == current instance/"me"/"self"
//		if (lhs.getFirstName().equals(rhs.getFirstName()) &&
//			lhs.getLastName().equals(rhs.getLastName()) &&
//			lhs.getEmail().equals(rhs.getEmail())
//				) {
//			return true;
//		}
//		return super.equals(obj);
//	}

	
	
	
}
