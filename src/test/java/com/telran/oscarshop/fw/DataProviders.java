package com.telran.oscarshop.fw;

import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviders {

	// Users Valid - Registration / Login
	@DataProvider
	public static Iterator<Object[]> UserValidFromCSV() throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(
				DataProviders.class.getResourceAsStream("/UsersValid.csv")));
		List<Object[]> userData = new ArrayList<Object[]>();
		String line = in.readLine();
		while (line != null) {
			userData.add(line.split(","));
			line = in.readLine();
		}
		in.close();
		return userData.iterator();
	}

	// Users Invalid - Registration / Login
	@DataProvider
	public static Iterator<Object[]> UserInvalidFromCSV() throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(
				DataProviders.class.getResourceAsStream("/UsersInvalid.csv")));
		List<Object[]> userData = new ArrayList<>();
		String line = in.readLine();
		while (line != null) {
			userData.add(line.split(","));
			line = in.readLine();
		}
		in.close();
		return userData.iterator();
	}
}
