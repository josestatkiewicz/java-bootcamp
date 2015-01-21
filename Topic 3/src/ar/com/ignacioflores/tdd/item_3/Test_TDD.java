package ar.com.ignacioflores.tdd.item_3;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

public class Test_TDD {

	@Test
	public void RecentFileListTest() {
		
		RecentFileList recentFileList = new RecentFileList();
		ArrayList<File> expected;
		
		File f1 = new File("/home/ignacio/files/f1.txt", "File 1", "blablabla");
		File f2 = new File("/home/ignacio/files/f2.txt", "File 2", "blablabla");
		File f3 = new File("/home/ignacio/files/f3.txt", "File 3", "blablabla");
		File f4 = new File("/home/ignacio/files/f4.txt", "File 4", "blablabla");
		File f5 = new File("/home/ignacio/files/f5.txt", "File 5", "blablabla");
		File f6 = new File("/home/ignacio/files/f6.txt", "File 6", "blablabla");
		File f7 = new File("/home/ignacio/files/f7.txt", "File 7", "blablabla");
		File f8 = new File("/home/ignacio/files/f8.txt", "File 8", "blablabla");
		File f9 = new File("/home/ignacio/files/f9.txt", "File 9", "blablabla");
		File f10 = new File("/home/ignacio/files/f10.txt", "File 10", "blablabla");
		File f11 = new File("/home/ignacio/files/f11.txt", "File 11", "blablabla");
		File f12 = new File("/home/ignacio/files/f12.txt", "File 12", "blablabla");
		File f13 = new File("/home/ignacio/files/f13.txt", "File 13", "blablabla");
		File f14 = new File("/home/ignacio/files/f14.txt", "File 14", "blablabla");
		File f15 = new File("/home/ignacio/files/f15.txt", "File 15", "blablabla");
		File f16 = new File("/home/ignacio/files/f16.txt", "File 16", "blablabla");
		
		
		expected = new ArrayList<File>();
		recentFileList.getList();
		assertEquals("Test RecentFileList  1", expected, recentFileList.getList());
		
		expected = new ArrayList<File>();
		expected.add(f1);
		recentFileList.open(f1);
		assertEquals("Test RecentFileList  2", expected, recentFileList.getList());
		
		expected = new ArrayList<File>();
		expected.add(f1);
		expected.add(f2);
		recentFileList.open(f1);
		recentFileList.open(f2);
		recentFileList.open(f1);
		assertEquals("Test RecentFileList  3", expected, recentFileList.getList());
		
		expected = new ArrayList<File>();
		expected.add(f16);
		expected.add(f15);
		expected.add(f14);
		expected.add(f13);
		expected.add(f12);
		expected.add(f11);
		expected.add(f10);
		expected.add(f9);
		expected.add(f8);
		expected.add(f7);
		expected.add(f6);
		expected.add(f5);
		expected.add(f4);
		expected.add(f3);
		expected.add(f2);
		recentFileList.open(f1);
		recentFileList.open(f2);
		recentFileList.open(f3);
		recentFileList.open(f4);
		recentFileList.open(f5);
		recentFileList.open(f6);
		recentFileList.open(f7);
		recentFileList.open(f8);
		recentFileList.open(f9);
		recentFileList.open(f10);
		recentFileList.open(f11);
		recentFileList.open(f12);
		recentFileList.open(f13);
		recentFileList.open(f14);
		recentFileList.open(f15);
		recentFileList.open(f16);
		assertEquals("Test RecentFileList  3", expected, recentFileList.getList());
	}
}