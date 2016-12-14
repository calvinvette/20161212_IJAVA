package com.weasley.store;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public class StringsCompare {

	public static void main(String[] args) {
		int Y = 25;
		int N = 7777777;
		long t;
		Map<String, List<Float>> results = new HashMap<>();
		results.put("StringBuilder", new Vector<>());
		results.put("StringBuffer", new Vector<>());
		results.put("ArrayList", new Vector<>());
		results.put("Vector", new Vector<>());
		for (int yy = 0; yy < Y; yy++) {
			{
				StringBuilder sb = new StringBuilder();
				t = System.currentTimeMillis();
				for (int i = N; i-- > 0;) {
					sb.append("");
				}
				float time = (System.currentTimeMillis() - t);
				System.out.println("StringBuilder:\t" + time);
				if (yy > 5) {
					results.get("StringBuilder").add(time);
				}
			}
			{
				StringBuffer sb = new StringBuffer();
				t = System.currentTimeMillis();
				for (int i = N; i-- > 0;) {
					sb.append("");
				}
				float time = (System.currentTimeMillis() - t);
				System.out.println("StringBuffer:\t" + time);
				if (yy > 5) {
					results.get("StringBuffer").add(time);
				}
			}
			List<Customer> customers;
			{
				customers = new ArrayList<>(N + 1);
				t = System.currentTimeMillis();
				for (int i = N; i-- > 0;) {
					customers.add(new Customer("Harry", "Potter"));
				}
				float time = (System.currentTimeMillis() - t);
				System.out.println("ArrayList:\t" + time);
				if (yy > 5) {
					results.get("ArrayList").add(time);
				}
			}
			{
				customers = new Vector<>(N + 1);
				t = System.currentTimeMillis();
				for (int i = N; i-- > 0;) {
					customers.add(new Customer("Harry", "Potter"));
				}
				float time = (System.currentTimeMillis() - t);
				System.out.println("Vector:\t\t" + time);
				if (yy > 5) {
					results.get("Vector").add(time);
				}
			}
		}
		median(results.get("StringBuilder"));
		median(results.get("StringBuffer"));
		median(results.get("ArrayList"));
		median(results.get("Vector"));
	}

	private static void median(List<Float> results) {
		float total = 0F;
		for (Float f : results) {
			total += f;
		}
		System.out.println(total / results.size());
	}

}
