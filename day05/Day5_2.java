package ordon.marek.adventofcode;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Scanner;

public class Day5_2 {

	public static void main(String[] args) throws NoSuchAlgorithmException {
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		char[] password = {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
		String test="";
		String wynik="";
		
		int counter =0;
		
		for (int i = 0 ; i<8 ; i++){
			while(true){
				MessageDigest md = MessageDigest.getInstance("MD5");
				test = input + Integer.toString(counter);
				md.update(test.getBytes());
				counter++;
				byte[] digest = md.digest();
				StringBuffer sb = new StringBuffer();
				for (byte b : digest) {
					sb.append(String.format("%02x", b & 0xff));
				}
				wynik = sb.toString();
				if(wynik.startsWith("00000")){
					char c = wynik.charAt(5);
					if(c<'8' && password[Character.getNumericValue(c)]==' '){
						password[Character.getNumericValue(c)]=wynik.charAt(6);
						break;
					}
				}
				if(counter%1000==0)
					System.out.println(i + " "+ counter);
			}
		}
		
		System.out.println(Arrays.toString(password));

	}

}
