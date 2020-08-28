package uppgift2backup;

import java.util.Scanner;
import java.util.Random;


// huvudprogrammet startar antingen spel mot datorn eller spelare och frågar om man vill spela igen
public class uppgift2backup {

		public static void main(String[] args) {
		
		Scanner reader=new Scanner(System.in);
		
		int startslut = 1;
				
		while (startslut > 0) {
		
			System.out.print("Välj 1 för spel mot varandra, 2 mot datorn:");
			int input = reader.nextInt();
			if (input == 1) {
				spelet start = new spelet();
				} else {
					datorn start = new datorn();
				}
			
			System.out.println("Spela igen? 1 = ja, 0 = nej");
		    startslut = reader.nextInt();
					}

		reader.close();	 
		
		}
	
				
		
}
		
		

//spel mot varandra metoden
class spelet {	
	
		
	public spelet() {
		
		int spelar1input = 0;
		int spelar2input = 0;
		 
		System.out.println("Ange namn 1:");
		Scanner reader3 = new Scanner(System.in);	   
		String namn1 = reader3.nextLine();
		System.out.println("Ange namn 2:");
		String namn2 = reader3.nextLine();
		
		
		System.out.println("1 eller sax för sax, 2 eller sten för sten, 3 eller påse för påse");
		System.out.println(namn1 + " tur:");
		spelar1input = spelarinput(0);
		System.out.println(namn2 + " tur:");
		spelar2input = spelarinput(0);
		
		//kolllar vem som vinner
		  if (spelar1input == 1 && spelar2input == 3) {
		    	System.out.println(namn1 + " vinner!");
		    } else if (spelar1input == 1 && spelar2input == 2) {
		    	System.out.println(namn2 + " vinner!");
		    } else if (spelar1input == 1 && spelar2input == 1) {
		    	System.out.println("Oavgjort!");
		    } else if (spelar1input == 2 && spelar2input == 1) {
		    	System.out.println(namn1 + " vinner!");
		    } else if (spelar1input == 2 && spelar2input == 2) {
		    	System.out.println("Oavgjort!");
		    } else if (spelar1input == 2 && spelar2input == 3) {
		    	System.out.println(namn2 + " vinner!");
		    } else if (spelar1input == 3 && spelar2input == 1) {
		    	System.out.println(namn2 + " vinner!");
		    } else if (spelar1input == 3 && spelar2input == 2) {
		    	System.out.println(namn1 + " vinner!");
		    } else if (spelar1input == 3 && spelar2input == 3) {
		    	System.out.println("Oavgjort!");
		    }
		  
		  
		  
		  
	
	}
	
	//spelar input, gör också om sax osv till ett nummer
	public int spelarinput(int first) {
		    Scanner reader2 = new Scanner(System.in);	   
			String spelarin = reader2.nextLine();
		    int spelarut = 0;
		    String addshit = "11111"; //ibland blir stringen för kort och blir error..löses med fylla ut den så char alltid ser minst 4 karaktärer
		    spelarin = spelarin + addshit;
		    
		    char c = spelarin.charAt(0);
			char c2 = spelarin.charAt(1); 
		    char c3 = spelarin.charAt(2);
		    char c4 = spelarin.charAt(3);   
		    
		    	
		    if (c == '1') {
		    	spelarut = 1;
		    } else if (c == '2') {
		    	spelarut = 2;
		    } else if (c == '3') {
		    	spelarut = 3;
		    } else if (c == 's' && c2 == 'a' && c3 == 'x') {
		    	spelarut = 1;
		    } else if (c == 's' && c2 == 't' && c3 == 'e' && c4 == 'n') {
		    	spelarut = 2;
		    } else if (c == 'p' && c2 == 'å' && c3 == 's' && c4 == 'e') {
		    	spelarut = 3;
		    }
		   	
				
		
			return spelarut;
			
		}
	
	
}
	
	
class datorn {	

	
	public datorn() {
		
	Random random = new Random();	
		
		int spelar1input = 0;
		int datorninput =  random.nextInt(3) +1;
	    
		
		System.out.println("1 eller sax för sax, 2 eller sten för sten, 3 eller påse för påse");
		System.out.println("Spelare 1 tur:");
		spelar1input = spelarinput(0);
		System.out.println("Datorn: " + datorninput);
			
		  if (spelar1input == 1 && datorninput == 3) {
		    	System.out.println("Spelare 1 vinner!");
		    } else if (spelar1input == 1 && datorninput == 2) {
		    	System.out.println("Datorn vinner!");
		    } else if (spelar1input == 1 && datorninput == 1) {
		    	System.out.println("Oavgjort!");
		    } else if (spelar1input == 2 && datorninput == 1) {
		    	System.out.println("Datorn vinner!");
		    } else if (spelar1input == 2 && datorninput == 2) {
		    	System.out.println("Oavgjort!");
		    } else if (spelar1input == 2 && datorninput == 3) {
		    	System.out.println("Datorn vinner!");
		    } else if (spelar1input == 3 && datorninput == 1) {
		    	System.out.println("Datorn vinner!");
		    } else if (spelar1input == 3 && datorninput == 2) {
		    	System.out.println("Spelare 1 vinner!");
		    } else if (spelar1input == 3 && datorninput == 3) {
		    	System.out.println("Oavgjort!");
		    }
		  
		  
		  
		  
	
	}
	
	public int spelarinput(int first) {
		    Scanner reader2 = new Scanner(System.in);
			String spelarin = reader2.nextLine();
		    int spelarut = 0;
		    String addshit = "11111";
		    spelarin = spelarin + addshit;
		    
		    char c = spelarin.charAt(0);
			char c2 = spelarin.charAt(1); 
		    char c3 = spelarin.charAt(2);
		    char c4 = spelarin.charAt(3);   
		    
		    	
		    if (c == '1') {
		    	spelarut = 1;
		    } else if (c == '2') {
		    	spelarut = 2;
		    } else if (c == '3') {
		    	spelarut = 3;
		    } else if (c == 's' && c2 == 'a' && c3 == 'x') {
		    	spelarut = 1;
		    } else if (c == 's' && c2 == 't' && c3 == 'e' && c4 == 'n') {
		    	spelarut = 2;
		    } else if (c == 'p' && c2 == 'å' && c3 == 's' && c4 == 'e') {
		    	spelarut = 3;
		    }
		   	
				
		
			return spelarut;
			
		}
	
	
	
}

