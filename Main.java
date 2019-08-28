package main;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		boolean prefixHex = false;
		
		for (String argument : args) {
			if (argument.equalsIgnoreCase("-prefix-hex")) {
				prefixHex = true;
			} else if (argument.equalsIgnoreCase("-help")) {
				System.out.println("-prefix-hex: Prefixes the hex codes with \"0x\"");
				System.out.println("This Utility converts a Sequence of Characters to binary, hexadecimal and decimal");
				System.out.println("Type \"exit\" to exit this program");
			}
		}
		
		
		
		Scanner s = new Scanner(System.in);
		while (true) {
			System.out.print("Eingabe: ");
			String string  = s.nextLine();
			String[] parts = string.split("");
			
			String binary_String = "";
			String hex_String = "";
			
			for (String part : parts) {
				char c = part.toCharArray()[0];
				int ascii_dec = c;
				String hex = Integer.toHexString(ascii_dec);
				String bin = "0" + Integer.toBinaryString(ascii_dec);
				
				binary_String += bin + " ";
				
				if (prefixHex) {
					hex_String += "0x" + hex + " ";
				} else {
					hex_String += hex + " ";
				}
				
				System.out.println("Character " + c + ":");
				System.out.println("Hex: " + hex);
				System.out.println("Binary: " + bin);
				System.out.println("Decimal: " + ascii_dec);
				System.out.println("");
			}
			
			System.out.println("Binary String: " + binary_String);
			System.out.println("Hex String: " + hex_String);
			
			if (string.equalsIgnoreCase("exit")) {
				s.close();
				break;
			}
			
			
		}
		
	}
	

}
