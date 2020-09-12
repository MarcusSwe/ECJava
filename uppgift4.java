package uppgift4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;


public class uppgift4 {
	
	public static String COMMA_DELIMITER = ",";
	

	public static void main(String[] args) {

		List<List<String>> records = new ArrayList<>();
		
		try (Scanner scanner = new Scanner(new File("sample.csv"));) {
			while (scanner.hasNextLine()) {
				records.add(getRecordFromLine(scanner.nextLine()));
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
		
		// Hur många personer har A i sitt namn -------------------
		int groupname1 = 0;
		int groupname2 = 0;
		for (int i = 0; i < records.size() ; i++) {
			if ((records.get(i).get(1).toLowerCase()).contains("a")){
							groupname1++;
			}
		}
		for (int i = 0; i < records.size() ; i++) {
			if ((records.get(i).get(2).toLowerCase()).contains("a")){
							groupname2++;
			}
		}
		
		// ---------------------------------------------------------
		
		
		// Vilka personer har samma tidsstämpel --------------------
		// bygger hash och kollar om man hittar dupleter
		
		Set<String> sammaTidstampel = new HashSet<>();
		ArrayList<String> DatumDuplicate = new ArrayList<String>();
				
		for (int Y = 0; Y < records.size() ; Y++) {
			if (sammaTidstampel.add(records.get(Y).get(0)) == false){
				//System.out.println(records.get(Y).get(0));
				
				if (records.get(Y).get(0).equals("")) {
									} else {
										DatumDuplicate.add(records.get(Y).get(0));
										//System.out.println(Y);
									}
					}
		}
				
		// ---------------------------------------------------------
		
		
		// Hur många personer har valt att arbeta med en Andriod app
		int androidapp = 0;
		for (int i = 0; i < records.size() ; i++) {
			if ((records.get(i).get(6).toLowerCase()).contains("android")){
							androidapp++;
			}
		}
		// ---------------------------------------------------------
		
		// Printar ut resultatet -----------------------------------
		System.out.println("Antal personer med bokstaven A i sitt namn: "+(groupname1+groupname2-2));
		System.out.println("Hur många har valt Andriod att jobba med: " +androidapp);
		for (int X = 0; X < DatumDuplicate.size(); X++) {
			System.out.println();
			System.out.print("Vid detta datum " + DatumDuplicate.get(X) + " var dessa skyldiga: ");
			for (int Y = 0; Y < records.size() ; Y++) {
				if (DatumDuplicate.get(X).equals(records.get(Y).get(0))){
										System.out.print(records.get(Y).get(1));
										System.out.print(" ");
										System.out.print(records.get(Y).get(2));
										System.out.print(" ");
										
				}
			}
		}
		//------------------------------------------------------------
		
	}
		
		
		
	

	private static List<String> getRecordFromLine(String line) {
		List<String> values = new ArrayList<String>();
		try (Scanner rowScanner = new Scanner(line)) {
			rowScanner.useDelimiter(COMMA_DELIMITER);
			while (rowScanner.hasNext()) {
				values.add(rowScanner.next());
			}
		}
		
		return values;
	}

	
		
	
}
