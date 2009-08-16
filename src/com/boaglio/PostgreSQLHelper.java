package com.boaglio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PostgreSQLHelper {

	static String SQL = "select termo_original,termo_traduzido from vocabulario_padrao  order by 1,2";

	public static List<Termo> getTermsFromPostgreSQL() {

		List<Termo> list = new ArrayList<Termo>();

		System.out
				.println("Checking if Driver is registered with DriverManager.");

		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException cnfe) {
			System.out.println("Couldn't find the driver!");
			System.out.println("Let's print a stack trace, and exit.");
			cnfe.printStackTrace();
			System.exit(1);
		}

		System.out
				.println("Registered the driver ok, so let's make a connection.");

		Connection c = null;

		try {
			// The second and third arguments are the username and password,
			// respectively. They should be whatever is necessary to connect
			// to the database.
			c = DriverManager.getConnection("jdbc:postgresql://localhost/vp",
					"fb", "");

			PreparedStatement ps = c.prepareStatement(SQL);

			ResultSet rs = ps.executeQuery();
			int contador = 1;
			while (rs.next()) {
				Termo t = new Termo();
				t.setId(String.valueOf(contador++));
				t.setDefinition("");

				t.setEnTerm(replaceValues(rs.getString(1)));

				t.setPtTerm(replaceValues(rs.getString(2)));

				list.add(t);
			}

			System.out.println("rows = "+contador);

		} catch (SQLException se) {
			System.out
					.println("Couldn't connect: print out a stack trace and exit.");
			se.printStackTrace();
			System.exit(1);
		}

		if (c != null)
			System.out.println("Hooray! We connected to the database!");
		else
			System.out.println("We should never get here.");

		return list;
	}

	private static String replaceValues(String str) {

	   String newStr = str.replaceAll("&","&amp;");
	   newStr = newStr.replaceAll (">","&gt;");
	   newStr = newStr.replaceAll ("<","&lt;");

	   return newStr;

	}
}