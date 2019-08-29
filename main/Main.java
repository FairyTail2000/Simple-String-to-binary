package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		boolean fromHex = false;
		boolean prefixHex = false;
		boolean fromBinary = false;
		for (String argument : args) {
			if (argument.equalsIgnoreCase("-prefix-hex")) {
				prefixHex = true;
			} else if (argument.equalsIgnoreCase("-help")) {
				System.out.println("-prefix-hex: Prefixes the hex codes with \"0x\"");
				System.out.println("-fromHex: Converts from hex to Text");
				System.out.println("-fromBinary Converts from Binary to Text");
				System.out.println("This Utility converts a Sequence of Characters to binary, hexadecimal and decimal");
				System.out.println("Type \"exit\" to exit this program");
			} else if (argument.equalsIgnoreCase("-fromBinary")) {
				fromBinary = true;
			} else if (argument.equalsIgnoreCase("-fromHex")) {
				fromHex = true;
			} else {
				System.out.println("Unknown: " + argument);
			}
		}

		Scanner s = new Scanner(System.in);

		if (fromBinary) {
			while (true) {
				System.out.print("Eingabe: ");
				String string = s.nextLine().replaceAll(" ", "");

				if (string.equalsIgnoreCase("exit")) {
					s.close();
					System.exit(0);
				}

				List<String> list = splitIntoDamnPieces(8, string);
				int[] ints = new int[list.size()];
				char[] chars = new char[list.size()];
				List<String> hex = new ArrayList<String>();

				for (int i = 0; i < list.size(); i++) {
					ints[i] = Integer.parseInt(list.get(i), 2);
					chars[i] = (char) ints[i];
					if (prefixHex) {
						hex.add("0x" + Integer.toHexString(ints[i]) + " ");
					} else {
						hex.add(Integer.toHexString(ints[i]) + " ");
					}
					String result = new String(chars);
					System.out.println("Normal:" + result);
					System.out.print("Hex: ");
					hex.forEach(System.out::print);
					System.out.println();
					System.out.print("Zahlencodes: ");
					for (int i2 : ints) {
						System.out.print(i2 + " ");
					}
					System.out.println("\n");
				}
			}

		} else if (fromHex) {
			//From Hexadecimal
			while (true) {
				System.out.print("Eingabe: ");
				String string = s.nextLine().replaceAll(" ", "").replaceAll("0x", "");

				if (string.equalsIgnoreCase("exit")) {
					s.close();
					System.exit(0);
				}

				List<String> list = splitIntoDamnPieces(2, string);
				int[] ints = new int[list.size()];
				char[] chars = new char[list.size()];
				List<String> bin = new ArrayList<String>();

				for (int i = 0; i < list.size(); i++) {
					ints[i] = Integer.parseInt(list.get(i), 16);
					chars[i] = (char) ints[i];
					bin.add(Integer.toBinaryString(ints[i]));
				}
				String result = new String(chars);
				System.out.println("Normal:" + result);
				System.out.print("Zahlencodes: ");
				for (int i2 : ints) {
					System.out.print(i2 + " ");
				}
				System.out.println();
				System.out.println("Binär: ");
				for (String bina : bin) {
					System.out.print(bina);
				}
				
				System.out.println("\n");
			}
		} else {
			while (true) {
				System.out.print("Eingabe: ");
				String string = s.nextLine();
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
					System.exit(0);
				}
			}
		} 
	}

	private static List<String> splitIntoDamnPieces(int splitSize, String toSplit) {
		List<String> list = new ArrayList<>();
		for (int i = 0; i < toSplit.length(); i += splitSize) {
			list.add(toSplit.substring(i, Math.min(toSplit.length(), i + splitSize)));
		}
		return list;
	}

}
