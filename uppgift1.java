package uppgift1;

import java.util.Objects;
import java.util.Scanner;

public class uppgift1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Scanner reader =new Scanner(System.in);
		System.out.print("Hej ange l�senordtest:");
		String input = reader.nextLine();
		boolean check = Objects.equals(input, "test");
		
		
		if (check == true) {
			System.out.println("R�tt l�senord!");
			System.exit(0);
		} else {
			System.out.print("Felaktigt l�senord f�rs�k igen:");	
				}
		
		input = reader.nextLine();
		check = Objects.equals(input, "test");
		
		if (check == true) {
			System.out.println("R�tt l�senord!");
			System.exit(0) ;
		} else {
			System.out.print("Felaktigt l�senord f�rs�k igen:");	
				}
			
		input = reader.nextLine();
		check = Objects.equals(input, "test");
		
		if (check == true) {
			System.out.println("R�tt l�senord!");
			System.exit(0);
		} else {
			System.out.println("3 f�rs�k uppn�da, l�ser!");	
				}
		
		reader.close();
							
		}
			
			
				
		
		
		
		
		
}


