package ar.com.ignacioflores.tdd.item_3;

import java.util.ArrayList;

public class RecentFileList {
	
	ArrayList<File> list = new ArrayList<File>(15); 
	
	public ArrayList<File> getList(){
		return list;
	};
	
	public void open(File file) {
		if (list.contains(file) == false){
			list = openNewFile(list, file);
		}
		else{
			list = openFile(list, file);
		}
	}	

	private ArrayList<File> openNewFile(ArrayList<File> list, File file){
		
		ArrayList<File> res = new ArrayList<File>(15);
		int i = 0;
		
		res.add(file);
		for (File f : list) {
			if (i < 14){
				res.add(f);
				i++;
			}
		}
		return res;
	}
	
	private ArrayList<File> openFile(ArrayList<File> list, File file) {
		
		ArrayList<File> res = new ArrayList<File>(15);
		int pos = list.indexOf(file);
		int i = 0;
		
		res.add(list.get(pos));
		for (File f : list) {
			if (i != pos){
				res.add(f);
				i++;
			}
			else{
				i++;
			}
		}
		return res;		
	}
}
