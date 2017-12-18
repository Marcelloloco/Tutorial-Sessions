package htw.tutorium.Datastructures;

import htw.tutorium.arrays.SortedArray;
//import htw.tutorium.arrays.UnsortedArray;

public class App 
{
    public static void main( String[] args )
    {
       runSorted();
    }
    
    public void runUnsorted() {
//    		UnsortedArray u = new UnsortedArray(8);
//        u.insert(6);
//        u.insert(7);
//        u.insert(74);
//        u.insert(1);
        
        
//        int[] tmp = u.returnArray();
//        for(int i = 0; i<tmp.length; i++) {
//        	System.out.println(tmp[i]);
//        }
//        u.delete(74);
        
//        tmp = u.returnArray();
//        for(int i = 0; i<tmp.length; i++) {
//        	System.out.println(tmp[i]);
//        }
    }
    
    public static void runSorted() {
    	SortedArray s = new SortedArray(18);
    	s.insert(8);
    	s.insert(10);
    	s.insert(13);
    	s.insert(16);
    	s.insert(19);
    	s.insert(20);
    	s.insert(22);
    	s.insert(26);
    	s.insert(28);
    	s.insert(30);
    	s.insert(33);
    	s.insert(40);
    	s.insert(42);
    	s.insert(45);
    	s.insert(46);
    	s.insert(50);
    	s.insert(60);
    	
    	
    	int[] tmp = s.returnArray();
    	for(int i = 0; i < tmp.length;i++) {
    		System.out.println("index " + i + ": " + tmp[i]);
    	}
    	
    	s.delete(22);
    	
    	tmp = s.returnArray();
    	for(int i = 0; i < tmp.length;i++) {
    		System.out.println("index " + i + ": " + tmp[i]);
    	}
    }
    
    public void levenstein() {
    	String string1 = "abcde";
    	String string2 = "abef";
    	
    	int[][] levenstein = new int[4][4];
    	
    	
    	for(int i = 0; i < levenstein.length; i++) {
    		for(int j = 0; j < levenstein[0].length; j++) {
    			
    			
    			int min = (Math.min( levenstein[i][j - 1], Math.min( levenstein[i - 1][j - 1], levenstein[i - 1][j]))) + 1;
    		}
    	}
    	
    	
    }
    
}
