package ar.com.ignacioflores.tdd.item_5;

public class Soundex {

	public static String toSoundex(String word) {

		String cod1 = code(word);
		String cod2 = recodeAndDel(word, cod1);
		String cod3 = firstChar(word.charAt(0), cod2);
		String res = checkLenght(cod3);
		
		return res;
	}
	
	
	
	private static String code(String word){
		
		String cod = "";
		
		for (int i=0; i<word.length(); i++){
			switch (word.charAt(i)) {
			case 'a'|'A':
				cod = cod + "v";
				break;
			case 'b'|'B':
				cod = cod + "1";
				break;
			case 'c'|'C':
				cod = cod + "2";
				break;
			case 'd'|'D':
				cod = cod + "3";
				break;
			case 'e'|'E':
				cod = cod + "v";
				break;
			case 'f'|'F':
				cod = cod + "1";
				break;
			case 'g'|'G':
				cod = cod + "2";
				break;
			case 'h'|'H':
				cod = cod + "h";
				break;
			case 'i'|'I':
				cod = cod + "v";
				break;
			case 'j'|'J':
				cod = cod + "2";
				break;
			case 'k'|'K':
				cod = cod + "2";
				break;
			case 'l'|'L':
				cod = cod + "4";
				break;
			case 'm'|'M':
				cod = cod + "5";
				break;
			case 'n'|'N':
				cod = cod + "5";
				break;
			case 'o'|'O':
				cod = cod + "v";
				break;
			case 'p'|'P':
				cod = cod + "1";
				break;
			case 'q'|'Q':
				cod = cod + "2";
				break;
			case 'r'|'R':
				cod = cod + "6";
				break;
			case 's'|'S':
				cod = cod + "2";
				break;
			case 't'|'T':
				cod = cod + "3";
				break;
			case 'u'|'U':
				cod = cod + "v";
				break;
			case 'v'|'V':
				cod = cod + "1";
				break;
			case 'w'|'W':
				cod = cod + "h";
				break;
			case 'x'|'X':
				cod = cod + "2";
				break;
			case 'y'|'Y':
				cod = cod + "v";
				break;
			case 'z'|'Z':
				cod = cod + "2";
				break;
			}
		}
		return cod;
	}

	private static String recodeAndDel(String word, String cod){
		String res = "";
		char preH = '0';
		
		for (int i=0; i<word.length()-2; i++){
			if (cod.charAt(i) != cod.charAt(i+1)){
				if ((cod.charAt(i) != 'v') && (cod.charAt(i) != 'h')){
					if (cod.charAt(i+1) == 'h'){
						preH = cod.charAt(i);
					}
					else if (preH == '0'){
						res = res + cod.charAt(i);
					}
					else if (preH != '0'){
						if (cod.charAt(i) == preH){
							res = res + preH;
							preH = '0';
						}
						else {
							res = res + preH + cod.charAt(i);
							preH = '0';
						}
					}
				}
			}
		}
		if (	(cod.charAt(cod.length()-1) != (res.charAt(res.length()-1)) && 
				((cod.charAt(cod.length()-1) != 'h') && 
				((cod.charAt(cod.length()-1) != 'v'))))){
			res = res + cod.charAt(cod.length()-1);
		}
		
		return res;
	}

	private static String checkLenght(String cod){
		String res = "";
		while (cod.length() <= 3){
			cod = cod + '0'; 
		}
		for (int i=0; i<=3; i++){
			res = res + cod.charAt(i);					
		}
		return res;
	};

	private static String firstChar(char firstChar, String cod2){
		
		String res = "";
		res = res + firstChar + cod2; 
		return res;
	}
}