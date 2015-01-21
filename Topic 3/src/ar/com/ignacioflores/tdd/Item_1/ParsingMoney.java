package ar.com.ignacioflores.tdd.Item_1;

import ar.com.ignacioflores.tdd.Item_1.StringNumber;

public class ParsingMoney {

	public String toString(double number) {
		
		String r54 = "";
		String r3 = "";
		String r21 = "";
		String rm12 = "";
		
		if (((number % 100000) / 1000) != 0){
			r54 = StringNumber.catchNumber((int) ((number % 100000) / 1000)) + " thousand ";
		}
		if (((number % 1000) / 100) != 0){
			r3 = StringNumber.catchNumber((int) ((number % 1000) / 100)) + " hundred ";
		}
		if ((number % 100) != 0){
			r21 = StringNumber.catchNumber((int) (number % 100)) + " ";
		}
		if ((int) ((number * 100) % 100) != 0 ){
			if ((int) ((number * 100) % 100) <= 9 ){
				rm12 = "0" + String.valueOf(((int) (number * 100) % 100)) + "/100";
			}else{
				rm12 = String.valueOf(((int) (number * 100) % 100)) + "/100";
			}
		}
		return (r54 + r3 + r21 + "and " + rm12 + " dollars");
	}
}