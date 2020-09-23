package SlutProjV2;



import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.lang.StringBuilder;

public class ConvertCSVtoXML {
	
	public static String COMMA_DELIMITER = ",";
	
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
				
		
	

		
		int kolumnbredd = 0;		
		
		
		//skriver till utfilen i XML format
		try {
	      FileWriter myWriter = new FileWriter(mainUI.outFileName);
	      myWriter.write("<?xml version=\"1.0\" encoding=\"iso-8859-1\"?>");
	      myWriter.write("<Workbook>");
	      
	      
	      
	      for (int y = 0; y <records.size() ; y++) {
	    	  if (!records.get(y).get(0).equals("")) {
	    		 kolumnbredd = 0;
	    		  myWriter.write("<Row>");
	    		  
	    		  
	    		  
	    		  	 while (!records.get(y).get(kolumnbredd).equals("")) {
	    		  		 myWriter.write("<Cell>"+records.get(y).get(kolumnbredd)+"</Cell>");
	    		  		 kolumnbredd++;
	    		  	 	 }
	    		  
	    		
	    		  myWriter.write("</Row>");
	    	  }
	    	  
	      }     
	       
	      myWriter.write("</Workbook>");
	        
	      	      
	   	      
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

			
	
}