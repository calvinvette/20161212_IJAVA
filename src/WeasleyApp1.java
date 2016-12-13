public class WeasleyApp1 {
	public static void main(String[] args) {
		Customer harry = new Customer(); // Java CLASSPATH must have
											// Customer.class in it to run this
											// program
		harry.setFirstName("Harry");
		harry.setLastName("Potter");
		harry.setPhoneNumber("+44 0206 510-1855");
		harry.setEmail("harry@hogwarts.ac.uk");

		Customer hermione = new Customer();
		hermione.setFirstName("Hermione");
		hermione.setLastName("Granger");
		hermione.setEmail("hermione@hogwarts.ac.uk");

		Customer ron = new Customer();
		ron.setFirstName("Ronald");
		ron.setLastName("Weasley");
		ron.setEmail("ron@hogwarts.ac.uk");

		//
		// float pi = 3.14159265F;
		// long avo = 6022339184252485L;
		//
		// System.out.println(avo); //485
		// avo = avo + 1;
		// System.out.println(avo); //486
		// avo += 1;
		// System.out.println(avo); //487
		// avo++; // postfix increment operator
		// System.out.println(avo); //488
		// System.out.println(avo++); //489 - NOT! (PostFix), will display 488
		// again then increment
		// System.out.println(avo); //489
		// System.out.println(++avo); //490 - Prefix increment - increment
		// first, then display
		// System.out.println(--avo); //489 - Prefix decrement - decrement
		// first, then display

		int age = 4;

		if ((age >= 17) // false
				&& (age < 21) // true
								// false & true == false
								// true & false == false
								// true & true == true
		) { // Wizards are "adults" at 17...
			System.out.println("Harry is an adult wizard but not legal to drink in the US.");
		} else {
			System.out.println("Harry is an NOT an adult wizard");

		}

		Customer draco = null;
		draco = new Customer();
		draco.setFirstName("Draco");
		draco.setLastName("Malfoy");
		if (draco != null && draco.getFirstName() == "Draco" && draco.getLastName() == "Malfoy") {
			System.out.println("Draco Malfoy has been banned from Weasley's Wizarding Wheezes.");
		} else {
			System.out.println("Customer approved.");
		}

		age = 4;
		if (age < 17 || age >= 21) { // "Pipe" == "or" (logical or)
			// true | false == true
			// false | true == true
			// false | false == false
			// true | true == true
			System.out.println("Not in the right age range.");
		} else {
			System.out.println("In that range...");
		}

		// System.out.println("Welcome to Diagon Alley, " + harry.firstName + "
		// " + harry.lastName);
		// System.out.println("Welcome to Diagon Alley, " + ron.firstName + " "
		// + ron.lastName);
		// System.out.println("Welcome to Diagon Alley, " + hermione.firstName +
		// " " + hermione.lastName);

		// welcome(harry); // 53
		// welcome(ron); // 53
		// welcome(hermione); // 53 (one customer version of "welcome")
		// welcome(harry, ron); // 58 (two customer version of "welcome")

		Customer[] customers;
		customers = new Customer[5];
		customers[0] = harry;
		customers[3] = draco;
		customers[2] = hermione;
		customers[1] = ron;
		customers[4] = new Customer();

		customers[4].setFirstName("Harry");
		customers[4].setLastName("Potter");
		customers[4].setPhoneNumber("+44 0206 510-1855");
		customers[4].setEmail("harry@hogwarts.ac.uk");

		System.out.println("#Customers: " + customers.length);
		
		// harry@hogwarts.ac.uk
		System.out.println("# chars: " + harry.getEmail().length());
		
		
		
		System.out.println("charAt(9): " + harry.getEmail().charAt(9));
		System.out.println("First @: " + harry.getEmail().indexOf('@'));
		int location = harry.getEmail().indexOf('a');
		System.out.println("First 'a': " + location);
		System.out.println("Second 'a': " + harry.getEmail().indexOf('a', location + 1));
		
		
//		customerId	firstName	lastName	phoneNumber	homeAddress	workAddress
//		1	Harry	Potter	+44 0206 987-1234	2	1
//		2	Ron	Weasley	+44 0206 987-1143	4	3
//		3	Hermione	Granger	+44 0206 987-6631	NULL	5
//		4	Neville	Longbottom	+44 0206 987-5151	NULL	6
		
//		String line1 = "1	Harry	Potter	+44 0206 987-1234	2	1"; //   '\t' == tab stop
		String[] lines = {
				"1	Harry	Potter	+44 0206 987-1234	2	1",
				"2	Ron	Weasley	+44 0206 987-1143	4	3",
				"3	Hermione	Granger	+44 0206 987-6631	NULL	5",
				"4	Neville	Longbottom	+44 0206 987-5151	NULL	6"
		}; // literal string array sized & populated
		for (String line : lines) {
			int nextTab = 0;
			nextTab = line.indexOf('\t', nextTab + 1);
			String[] fields = new String[6];
			int fieldCounter = 0;
			int currentPosition = 0;
			while (nextTab >= 0) {
				fields[fieldCounter] = line.substring(currentPosition, nextTab);
				currentPosition = nextTab + 1;
				nextTab = line.indexOf('\t', nextTab + 1);
				fieldCounter++;
			}
			fields[fieldCounter] = line.substring(currentPosition); // without endPosition, take to the end of line
			System.out.println("*** Fields ***");
			for(String field : fields) {
				System.out.println(field);
			}
		}
			
//		1
//		Harry
//		Potter
//		+44 0206 987-1234
//		2
//		null
		
		
		
		System.exit(0);
		
		
		for (Customer c : customers) {
			welcome(c);
		}

		 for (int i = 0; i < 10; i++) {
			 System.out.println("Customer #" + (i + 1));
		 }
		 
		if (customers[0] == harry) { // are the memory addresses the same???
			System.out.println("customers[0] == harry");
		} else {
			System.out.println("customers[0] != harry");
		}
		if (customers[0] == customers[4]) { // are the memory addresses the
											// same???
			System.out.println("customers[0] == customers[4]");
		} else {
			System.out.println("customers[0] != customers[4]");
		}
		if (customers[0].equals(customers[4])) { // are the object qualities the
													// same???
			System.out.println("customers[0] dot-equals customers[4]");
		} else {
			System.out.println("customers[0] not dot-equals customers[4]");
		}
		// customers-sub-0 is Harry...
		System.out.println("# customers: " + customers.length);
		// for (int i = 0; i < customers.length; i++) {
		// welcome(customers[i]);
		// }
		// for (Customer c : customers) {
		// welcome(c);
		// }
		int ctr = 0;
		// while (ctr < customers.length) {
		// welcome(customers[ctr]);
		// ctr++;
		// }

		// System.out.println(i);
		// System.out.println(ctr);
		// customers[0]-4 for a 5 element array
		// customers[5] is past the end of the array (the 6th customer)
		// This will blow an ArrayIndexOutOfBoundsException
		// Obi-wan error / Off-by-one error
		// System.out.println(customers[5]);

		// UTSL - Use the Source, Luke
		// RTFM - Read the Fine Manual
		ctr = 0;
		if (customers.length > 0) {
			do {
				welcome(customers[ctr]);
				ctr++;
			} while (ctr < customers.length);
		}

		age = 17;
		switch (age) {
		case 4:
			System.out.println("Four-year olds shouldn't be playing with wands");
			break;
		case 17:
			System.out.println("Age of legal majority for wizards");
			break;
		case 18:
			System.out.println("Age of legal majority for muggles");
			break;
		case 21:
			System.out.println("Old enough to drink alcohol in the US");
			break;
		default:
			System.out.println("I got nothin for you.");
			break; // Redundant - there's nothing left after this...
		}

		char myChar = 'a';
		switch (myChar) {
		case 'A':
		case 'a':
			System.out.println("An 'a' or 'A' was pressed");
			break;
		case 'B':
		case 'b':
			System.out.println("A 'b' or 'B' was pressed");
			break;
		case 'C':
		case 'c':
			System.out.println("A 'c' or 'C' was pressed");
			break;
		default:
			System.out.println("Unknown character pressed...");
		}

		System.out.println("Done...");
	}

	private static void welcome(Customer c) {
		System.out.println("Welcome to Weasley's Wizarding Wheezes, " + c.getFirstName() + " " + c.getLastName());
	}
	//
	// private static void welcome(Customer c1, Customer c2) {
	// System.out.println("Welcome to Team members: " + c1.firstName + " & " +
	// c2.firstName);
	// }
}
