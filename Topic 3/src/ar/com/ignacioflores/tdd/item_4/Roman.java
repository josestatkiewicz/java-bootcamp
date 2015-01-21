package ar.com.ignacioflores.tdd.item_4;

public class Roman {

	public static String toRoman(int number) {

		String res = "";
		int rUM = (int) number / 1000;
		int mUM = number % 1000;
		int rC = (int) mUM / 100;
		int mC = mUM % 100;
		int rD = (int) mC / 10;
		int mD = mC % 10;
		int rU = (int) mD;

		if (rUM != 0){
			for (int i=0; i<rUM; i++){
				res = res + "M";
			}
		}
		switch (rC){
			case 0: break;
			case 1: res = res + "C"; break;
			case 2: res = res + "CC"; break;
			case 3: res = res + "CCC"; break;
			case 4: res = res + "CD"; break;
			case 5: res = res + "D"; break;
			case 6: res = res + "DC"; break;
			case 7: res = res + "DCC"; break;
			case 8: res = res + "DCCC"; break;
			case 9: res = res + "CM"; break;
		}
		switch (rD){
			case 0: break;
			case 1: res = res + "X"; break;
			case 2: res = res + "XX"; break;
			case 3: res = res + "XXX"; break;
			case 4: res = res + "XL"; break;
			case 5: res = res + "L"; break;
			case 6: res = res + "LX"; break;
			case 7: res = res + "LXX"; break;
			case 8: res = res + "LXXX"; break;
			case 9: res = res + "XC"; break;
		}
		switch (rU){
		case 0: break;
		case 1: res = res + "I"; break;
		case 2: res = res + "II"; break;
		case 3: res = res + "III"; break;
		case 4: res = res + "IV"; break;
		case 5: res = res + "V"; break;
		case 6: res = res + "VI"; break;
		case 7: res = res + "VII"; break;
		case 8: res = res + "VIII"; break;
		case 9: res = res + "IX"; break;
		}
		return res;
	}

	public static int toInt(String romanNumber) throws Exception{
		
		int res = 0;
		
		if (validateRoman(romanNumber) == true){
			for (int i=0; i<romanNumber.length(); i++){
				switch (romanNumber.charAt(i)){
				case 'M':
					res = res + 1000;
					break;
				case 'D':
					res = res + 500;
					break;
				case 'C':
					if (i == romanNumber.length()-1){
						res = res + 100; 
					}
					else{
						if ((romanNumber.charAt(i+1) == 'M')||(romanNumber.charAt(i+1) == 'D')){
							res = res - 100;
						}
						else{
							res = res + 100;
						}
					}
					break;
				case 'L':
					res = res + 50;
					break;
				case 'X':
					if (i == romanNumber.length()-1){
						res = res + 10; 
					}
					else{
						if ((romanNumber.charAt(i+1) == 'C')||(romanNumber.charAt(i+1) == 'L')){
							res = res - 10;
						}
						else{
							res = res + 10;
						}
					}
					break;
				case 'V':
					res = res + 5;
					break;
				case 'I':
					if (i == romanNumber.length()-1){
						res = res + 1; 
					}
					else{
						if ((romanNumber.charAt(i+1) == 'X')||(romanNumber.charAt(i+1) == 'V')){
							res = res - 1;
						}
						else{
							res = res + 1;
						}
					}
					break;
				}
			}
			
			return res;
		}
		else{
			throw new Exception("Error: you have not entered a Roman numeral");
		}
	}
	
	private static boolean validateRoman(String romanNumber){
		boolean res = true;
		
		for (int i=0; i<romanNumber.length(); i++){
			if (!(	romanNumber.charAt(i) == 'M'||
					romanNumber.charAt(i) == 'D'||
					romanNumber.charAt(i) == 'C'||
					romanNumber.charAt(i) == 'L'||
					romanNumber.charAt(i) == 'X'||
					romanNumber.charAt(i) == 'V'||
					romanNumber.charAt(i) == 'I')){
				res = false;
			}
			if (i != romanNumber.length()-1){
				switch (romanNumber.charAt(i)){
				case 'M': 
					break;
				case 'D':
					if (romanNumber.charAt(i+1) == ('M'|'D')){
						res = false;
					}
					break;
				case 'C':
					break;
				case 'L':
					if (romanNumber.charAt(i+1) == ('M'|'D'|'C'|'L')){
						res = false;
					}
					break;
				case 'X':
					if (romanNumber.charAt(i+1) == ('M'|'D')){
						res = false;
					}
					break;
				case 'V':
					if (romanNumber.charAt(i+1) == ('M'|'D'|'C'|'L'|'X'|'V')){
						res = false;
					}
					break;
				case 'I':
					if (romanNumber.charAt(i+1) == ('M'|'D'|'C'|'L')){
						res = false;
					}
					break;
				}
			}
		}
		return res;
	}
}