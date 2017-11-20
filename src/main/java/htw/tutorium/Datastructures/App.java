package htw.tutorium.Datastructures;

import htw.tutorium.arrays.UnsortedArray;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        UnsortedArray u = new UnsortedArray(8);
        u.insert(6);
        u.insert(7);
        u.insert(74);
        u.insert(1);
        
        
        int[] tmp = u.returnArray();
        for(int i = 0; i<tmp.length; i++) {
        	System.out.println(tmp[i]);
        }
        u.delete(74);
        
        tmp = u.returnArray();
        for(int i = 0; i<tmp.length; i++) {
        	System.out.println(tmp[i]);
        }
    }
    
    
}
