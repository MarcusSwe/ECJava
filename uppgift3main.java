package uppgift3;

import java.util.Scanner;
import java.util.Arrays;


public class uppgift3main {

	public static void main(String[] args) {
		
        Scanner reader = new Scanner(System.in);
		Scanner reader2 = new Scanner(System.in);
        
		int startslut = 1;
				
		while (startslut > 0) {
		
			System.out.print("Hangman, skriv hemliga ordet:");
			uppgift3data.hemligaordet(reader2.nextLine());
			uppgift3data.hideordet();
			
			for (int i = 0; i < 50; ++i) System.out.println();
						
			spelet startgame = new spelet();
			
			System.out.println("Spela igen? 1 = ja, 0 = nej");
		    startslut = reader.nextInt();
					}

		reader.close();	 
        reader2.close();
	}

}





class spelet {

	  int scoren = 0;	
	  int vunnit = 0;
	
	 	 
	public spelet() { 
					
	
		while (scoren < 14 && vunnit <1) {
		int lul = 14 - scoren;
			
		printgubbe gubben = new printgubbe(scoren);
		
		System.out.println("Du har " +lul + " försök kvar!");
		System.out.println("1. för gissa bokstav 2. för gissa ordet");
		
		Scanner reader4 = new Scanner(System.in);
		int input = reader4.nextInt();
		
			if (input == 1) {
				String spelarinput = inputbokstav();
									
				if (uppgift3data.kollabokstav(spelarinput) == 1) {
					vunnit = 1;
				}
				
				
			}else {
				String spelarinput = inputordet();
											
				if (uppgift3data.kollaord(spelarinput) == 1) {
					vunnit = 1;
				}
			
			}
					
		scoren++;
		
		System.out.println();
		uppgift3data.printomega();
				
		}
			
			if (scoren == 14) {
				printgubbe gubben = new printgubbe(scoren);
				System.out.println("");
				System.out.println("Du förlorade!");				
			}
		
			if (vunnit ==1) {
				printgubbe gubben = new printgubbe(scoren);
				System.out.println("");
				System.out.println("Du vann!");
			}
					
	}
	

	
	
	public String inputbokstav() {
		String spelarut = "";
		Scanner reader3 =  new Scanner(System.in);
		System.out.print("Skriv en bokstav: ");
		String spelarin = reader3.nextLine();
		spelarut = spelarin;
		return spelarut;
	}	 

	public String inputordet() {
		String spelarut = "";
		Scanner reader5 =  new Scanner(System.in);
		System.out.print("Skriv ordet: ");
		String spelarin = reader5.nextLine();
		spelarut = spelarin;
		return spelarut;
	}	
		
	
}

	
	
	
		

class printgubbe {
	
	
	
	public printgubbe(int scoren) {
		
		System.out.println("");
		
		if (scoren == 9 ) {
			System.out.println("---");
		}else if (scoren > 9) {
			System.out.println("------");
		} else System.out.println("");
		
		if (scoren >= 8 && scoren <11) {
			System.out.println(" |");
		}else if (scoren >= 11) {
			System.out.println(" |  |");
		} else System.out.println("");
		
		if (scoren >= 7 && scoren <12) {
			System.out.println(" |");
		}else if (scoren >= 12) {
			System.out.println(" |  O");
		} else System.out.println("");
		
		if (scoren >= 6 && scoren <13) {
			System.out.println(" |");
		}else if (scoren >= 13) {
			System.out.println(" | /|\\");
		} else System.out.println("");
		
		if (scoren >= 5 && scoren <14) {
			System.out.println(" |");
		}else if (scoren >= 14) {
			System.out.println(" | "+ "/ \\");
		} else System.out.println("");
		
		if (scoren >= 4) {
			System.out.println(" |");
		} else System.out.println("");
		
		if (scoren >= 3) {
			System.out.println(" |");
		} else System.out.println("");
		
		if (scoren >= 2) {
			System.out.println(" |");
		} else System.out.println("");
		
		if (scoren >= 1) {
			System.out.println("/|\\");
		} else System.out.println("");
		
	}
	
}
