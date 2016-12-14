
 /*
  * High Networth Individual
  */
public class HNICustomer extends Customer {
	private int tier;
	private String accountManager;

	public HNICustomer() {
		super();
	}
	
	public HNICustomer(Long customerId, String firstName, String lastName, String fullName, String taxId, String email,
			String phoneNumber, String title, boolean active) {
		super(customerId, firstName, lastName, fullName, taxId, email, phoneNumber, title, active);
	}


	public HNICustomer(String firstName, String lastName, String fullName, String taxId, String email,
			String phoneNumber, String title, boolean active) {
		super(firstName, lastName, fullName, taxId, email, phoneNumber, title, active);
	}

	public HNICustomer(String firstName, String lastName) {
		super(firstName, lastName);
	}

	public HNICustomer(String firstName, String lastName, int tier, String accountManager) {
		super(firstName, lastName);
		this.tier = tier;
		this.accountManager = accountManager;
	}



	public String getAccountManager() {
		return accountManager;
	}

	public void setAccountManager(String accountManager) {
		this.accountManager = accountManager;
	}

	public int getTier() {
		return tier;
	}

	public void setTier(int tier) {
		this.tier = tier;
	}
	
	@Override
	public String toString() {
		return "HNICustomer: Tier: " + getTier() + " Manager: " + getAccountManager() + " " + super.toString();
	}

}
