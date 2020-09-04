package uppgift3;
import java.util.Arrays;

public class uppgift3data {

	private static String ordet = "";
	static String omega = "";
	static int t = ordet.length();
	static char[] omegacheck;
	
	public static void hideordet () { 
		omegacheck = ordet.toCharArray();
		for(int i = 0; i < ordet.length(); i++) 
			 {
				omegacheck[i] = '_';
			}
	}
	
	
	public static void hemligaordet(String hangordet) {
	ordet = hangordet;	
	}
	
	public static int kollabokstav(String kollaB) {
		 int vunnit = 0;
		 char c = kollaB.charAt(0);
		 		 
		 for(int i = 0; i < ordet.length(); i++) {
			 if (c == ordet.charAt(i)) {
				omegacheck[i] = c;
				 }// else {
			//	System.out.print(omega = String.valueOf(omegacheck));
				
			 //}
		 }
		 
		 omega = String.valueOf(omegacheck);
		 
		 if (omega.equals(ordet)) {
				System.out.println("Rätt ord!");
				omegacheck = ordet.toCharArray();
				vunnit = 1;
			}
		 
		 return vunnit;
	}
	
	public static int kollaord(String kollaO) {
		int vunnit = 0;
		//System.out.println(kollaO);
		if (kollaO.equals(ordet)) {
			System.out.println("Rätt ord!");
			omegacheck = ordet.toCharArray();
			vunnit = 1;
		}
		
		return vunnit;
	}
	
	public static void printordet (){
		System.out.println(ordet);
	}
	
	public static void printomega () {
		System.out.println("Hemliga ordet: " + (omega = String.valueOf(omegacheck)));
	}
	
	
}