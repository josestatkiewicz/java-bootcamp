package ar.com.ignacioflores.tdd.Item_2;

import java.util.ArrayList;

public class WordWrapping {
	
	
	public ArrayList<String> wrap(String string, int rowLenght) {
		
		ArrayList<String> words = words(string);
		ArrayList<String> wordsCut = controlAndCut(words, rowLenght);
		ArrayList<String> res = canGroup(wordsCut, rowLenght);
		
		return res;
	}
	
	
	// Separates the string into words
	private ArrayList<String> words(String string){
		
		ArrayList<String> res = new ArrayList<String>();
		String word = "";
		
		for(int i=0;i<string.length();i++){
			if((string.charAt(i) != " ".charAt(0))) {
				word = word + string.charAt(i);
			}
			else{
				res.add(word);
				word = "";
			}
		}
		res.add(word);
		return res;
	}
	
	// Cut the words depending on the size
	private ArrayList<String> controlAndCut(ArrayList<String> words, int rowLenght){
		
		ArrayList<String> res = new ArrayList<String>();
		String string = "";
		int r;
		int c1 = 0;
		int c2 = 0;
		for (int j=0;j<words.size();j++){
			if (words.get(j).length() <= rowLenght){
				res.add(String.valueOf(words.get(j)));
			}
			else{
				if ((words.get(j).length() % rowLenght) == 0){
					r = (int) (words.get(j).length() / rowLenght) - 1;				
				}
				else{
					r = (int) (words.get(j).length() / rowLenght);
				}
				
				for (int i=0;i<=r;i++){
					while ((c2 < rowLenght)&&(c1 < words.get(j).length())){
						string = string + words.get(j).charAt(c1);
						c1 = c1 + 1;
						c2 = c2 + 1;
					}				
					res.add(string);
					string = "";
					c2 = 0;
				} 
				c1 = 0;
			}
		}
		
		return res; 
	}
	
	// Groups the words depending the size
	private ArrayList<String> canGroup(ArrayList<String> wordsCut, int rowLenght){
		
		ArrayList<String> res = new ArrayList<String>();
		String word = "";
		
		for (int i=0;i<wordsCut.size();i++){
			if (word == ""){
				word = wordsCut.get(i);
			}
			else{
				if ((word.length() + wordsCut.get(i).length()) <= rowLenght){
					word = word + " " + wordsCut.get(i);
				}
				else{
					res.add(word);
					word = "";
					word = word + wordsCut.get(i);
				}
			}
			if ((i + 1 == wordsCut.size()) && (word != "")){
				res.add(word);
				word = "";
			}
		}
		
		return res;
	}
}