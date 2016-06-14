package com.teamtreehouse;

import java.io.*;

public class Treets {
	public static void save(Treet[] treets) {
		try (
			FileOutputStream fos = new FileOutputStream("treets.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
		) {
			oos.writeObject(treets);
		} catch(IOException ioe) {
			System.out.println("Problem saving Treets");
			ioe.printStackTrace();
		} 			
	}

	public static Treet[] load() {
		Treet[] treets = new Treet[0];
		// A try-with-resources block will automatically 
		// close any streams that are opened.
		try (
			FileInputStream fis = FileInputStream("treets.ser");
			ObjectOutputStream ois = new ObjectOutputStream(fis);
			) {
			treets = (Treet[]) ois.readObject();
		} 	catch(IOException ioe) {
			System.out.println("Error reading file");
			ioe.printStackTrace();
		} 	catch(ClassNotFoundException cnfe) {
			System.out.println("Error loading treets");
			cnfe.printStackTrace();
		}
		return treets;
	}
}