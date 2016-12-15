package com.weasley.store;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class WeasleyCustomerManagement {

	public static void main(String[] args) {
		CustomerDAO dao = new CustomerMockDAO(); // TODO - figure out how to do this...
//		Customer[] customers = importCustomers();
		List<Customer> customers = importCustomers();
		for(Customer c: customers) {
			dao.insert(c);
		}
		boolean done = false;
		boolean stillGoing = true;
//		while (!done) {
		while (stillGoing) {
			String lastName = JOptionPane.showInputDialog("Find By LastName: ");
			if (lastName == null || lastName.trim().equals("")) {
//				System.exit(0);
				done = true;
				stillGoing = false;
				continue;
			}
			List<Customer> results = dao.findByLastName(lastName);
//			System.out.println(results);
			for(Customer c : results) {
				System.out.println(c);
			}
		}
		System.out.println("Thanks for playing!");
		
		try {
			PrintWriter dumpFile = new PrintWriter(new FileWriter(new File("customers.dump.txt")));
			for (Customer c : customers) {
				dumpFile.println(c);
			}
			dumpFile.flush();
			dumpFile.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
//		done = false;
//		if (done)
//			System.out.println("foo");
//			System.out.println("bar");
//			
//		System.out.println("Absolutely done...");
	}

	public static /* Customer[] */ List<Customer> importCustomers() {
		List<Customer> importedCusts = new ArrayList<>();
		try {
//			File custFile = new File("c:/Users/myuser/Documents/customersXXX.txt");
//			File custFile = new File("customers.txt");
//			FileReader fr = new FileReader(custFile);
//			BufferedReader br = new BufferedReader(fr);
			// check javax.crypto and java.util.zip packages for more on this:
//			DecryptingReader dr = new DecryptingReader(br);
//			DecompressingReader dcr = new DecompressingReader(dr);
			BufferedReader br = new BufferedReader(new FileReader(new File("customers.txt")));
			String line;
			br.readLine(); // throw away the first line - it's the header row...
//			while ((line = dcr.readLine()) != null) {
			while ((line = br.readLine()) != null) {
					String[] fields = line.split("\t");
					Customer c = new Customer(fields[1], fields[2]);
					c.setPhoneNumber(fields[3]);
					importedCusts.add(c);
			}
			br.close();
//			dcr.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return importedCusts;
		
		
		
//		String[] lines = {
//				"1	Harry	Potter	+44 0206 987-1234	2	1",
//				"2	Ron	Weasley	+44 0206 987-1143	4	3",
//				"3	Hermione	Granger	+44 0206 987-6631	NULL	5",
//				"4	Neville	Longbottom	+44 0206 987-5151	NULL	6",
//				"5	Dean	Thomas	+44 0206 987-5157	NULL	7",
//				"6	Seamus	Finnigan	+44 0206 987-7467	NULL	8",
//				"7	Ginny	Weasley	+44 0206 987-2728	10	9",
//				"8	Lee	Jordan	+44 0206 987-9713	NULL	11",
//				"9	Fred	Weasley	+44 0206 987-3971	13	12",
//				"10	George	Weasley	+44 0206 987-6431	15	14",
//				"11	Cho	Chang	+44 0206 987-1793	NULL	16",
//				"12	Luna	Lovegood	+44 0206 987-7867	NULL	NULL",
//				"13	Parvati	Patil	+44 0206 987-2345	NULL	NULL",
//				"14	Padma	Patil	+44 0206 413-5903	NULL	NULL",
//				"15	Draco	Malfoy	+44 0206 987-2216	NULL	NULL",
//				"16	Vincent	Crabbe	+44 0206 987-9438	NULL	NULL",
//				"17	Gregory	Goyle	+44 0206 987-1178	NULL	NULL",
//				"18	Penelope	Clearwater	+44 0206 987-9392	NULL	NULL",
//				"19	Justin	Finch-Fletchley	+44 0206 987-1190	NULL	NULL",
//				"20	Ernie	Macmillan	+44 0206 987-1059	NULL	NULL",
//				"21	Cedric	Diggory	+44 0206 987-7715	NULL	NULL",
//				"22	Millicent	Bulstrode	+44 0206 987-4324	NULL	NULL",
//				"23	Hanna	Abbott	+44 0206 987-4300	NULL	NULL",
//				"24	Susan	Bones	+44 0206 987-6544	NULL	NULL",
//				"25	Fleur	Delacour	+44 0206 987-9304	NULL	NULL",
//				"26	Viktor	Krum	+44 0206 987-6317	NULL	NULL"
//		}; // literal string array sized & populated
//		Customer[] importedCusts = new Customer[lines.length];
//		List<Customer> importedCusts = new ArrayList<>();
//		int lineNumber = 0;
//		for (String line : lines) {
//			String[] fields = line.split("\t");
//			importedCusts.add(new Customer(fields[1], fields[2]));
////			importedCusts[lineNumber++] = new Customer(fields[1], fields[2]);
//		}
//		return importedCusts;
	}
}
