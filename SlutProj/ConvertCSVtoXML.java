package SlutProj;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.lang.StringBuilder;

public class ConvertCSVtoXML {
	
	public static String COMMA_DELIMITER = ",";
	public static int x = 1;
	
	public ConvertCSVtoXML() {
	
	//läser in till list från infilen	
		List<List<String>> records = new ArrayList<>();
		
		try (Scanner scanner = new Scanner(mainUI.inFileName))	{
			while (scanner.hasNextLine()) {
				records.add(getRecordFromLine(scanner.nextLine()));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
				
		
		//tar bort tecken som XML inte gillar
		ArrayList<String> thirdTierTitles = new ArrayList<String>();
	    thirdTierTitles = removeSpace(records, false);
	    // variable x håller reda på hur många kolumner det är, bara dem som innehåller något kommer med och inte efter tomma heller
	    x = x -1; 
		
		ArrayList<String> secondTierTitles = new ArrayList<String>();
		secondTierTitles = removeSpace(records, true);			
		
		
		//skriver till utfilen i XML format
		try {
	      FileWriter myWriter = new FileWriter(mainUI.outFileName);
	      myWriter.write("<?xml version=\"1.0\" encoding=\"iso-8859-1\"?>");
	      myWriter.write("\n");
	      myWriter.write("<_"+records.get(0).get(0)+">");
	      
	      
	      
	      for (int y = 1; y <records.size() ; y++) {
	    	  if (!records.get(y).get(0).equals("")) {
	    		  myWriter.write("\n");
	    		  myWriter.write("    <_"+secondTierTitles.get(y-1)+">");
	    		  	 for (int z = 0; z < x; z++) {
	    		  		 myWriter.write("\n");
	    		  		 myWriter.write("        <"+thirdTierTitles.get(z)+">"+records.get(y).get(z+1)+"</"+thirdTierTitles.get(z)+">");
	    		  	 	 }
	    		  
	    		  myWriter.write("\n");
	    		  myWriter.write("    </_"+secondTierTitles.get(y-1)+">");
	    		  myWriter.write("\n");
	    	  }
	    	  
	      }     
	       
	      
	      myWriter.write("\n");	      
	      myWriter.write("</_"+records.get(0).get(0)+">");
	      
	   	      
	      myWriter.close();
	      mainUI.Status.setText("Konvertering klar!");
	    } catch (IOException e) {
	      mainUI.Status.setText("Okänt fel uppstod!");
	      e.printStackTrace();	 
	    }
				
		
	}

	//separerar genom ,
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

	//tar bort tecken som XML inte gillar och ersätter med _
	//boolean talar om det är kolumnnamnen eller radnamnen som ska ordnas
	public static ArrayList<String> removeSpace(List<List<String>> rebuild, boolean g) {
		StringBuilder xmlDontLikeSpaceAmazing = new StringBuilder();
		xmlDontLikeSpaceAmazing = new StringBuilder();
		ArrayList<String> XMLisAmazingSaidNoOne = new ArrayList<String>();
		int p = 1;
		int b = 1;
		
		if (g) {
			p=0;
		}else {
			b=0;
		}
		
		while (!rebuild.get(b).get(p).equals("")) {
			 xmlDontLikeSpaceAmazing.append(rebuild.get(b).get(p));
			
			for (int t = 0 ; t < xmlDontLikeSpaceAmazing.length() ; t++) {
				char u = xmlDontLikeSpaceAmazing.charAt(t);
					switch (u) {
					case ' ':
						xmlDontLikeSpaceAmazing.setCharAt(t ,'_');
						break;
					case '/':
						xmlDontLikeSpaceAmazing.setCharAt(t ,'_');
						break;
					case ':':
						xmlDontLikeSpaceAmazing.setCharAt(t ,'_');
						break;
					case '#':
						xmlDontLikeSpaceAmazing.setCharAt(t ,'_');
						break;
					case '?':
						xmlDontLikeSpaceAmazing.setCharAt(t ,'_');
						break;
					case '(':
						xmlDontLikeSpaceAmazing.setCharAt(t ,'_');
						break;
					case ')':
						xmlDontLikeSpaceAmazing.setCharAt(t ,'_');
						break;
					}
			}
			XMLisAmazingSaidNoOne.add(xmlDontLikeSpaceAmazing.toString());
			xmlDontLikeSpaceAmazing.delete(0,xmlDontLikeSpaceAmazing.length());
			if (g) { 
				b++;
			}
			else {
				x++;
				p++;
			}						
		}		
		return XMLisAmazingSaidNoOne;
	}
	
	
}