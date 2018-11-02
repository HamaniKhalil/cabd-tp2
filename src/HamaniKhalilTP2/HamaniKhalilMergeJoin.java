/*
 * TP N°		: 02
 * Version N°	: 01
 * 
 * Titre du TP	: Nested Loops
 * 
 * Date			: 19 Octobre 2018
 * 
 * Nom			: Hamani
 * Prenom		: Khalil
 * N° Etudiant	: 21810826
 * 
 * Email		: hamani_khalil@yahoo.fr
 * 
 * Remarques	: N/A
 * 
 * */

/*
 * This one is for merge algorithms :
 * 
 * - Read from file and put to char array
 * - Read from char array and put to file
 * 
 * */


package HamaniKhalilTP2;

import static HamaniKhalilTP2.SystemConfiguration.BUFFER_SIZE;
import static HamaniKhalilTP2.SystemConfiguration.FIRST_ARRAY_ELEMENT_INDEX;
import static HamaniKhalilTP2.SystemConfiguration.THE_NONE_CHARACTER;

import java.io.File;
import java.util.Arrays;


public class HamaniKhalilMergeJoin {

	public static final void joinWithMergeJoin(String rFilename, String sFilename, String rsFilename) {
		int	sReadLevel	= 0;
		int	rReadLevel	= 0;
		
		char []	r	= FileManager.fileToArray(rFilename, rReadLevel);
		char []	s	= FileManager.fileToArray(sFilename, sReadLevel);
		
		try {			
			while(s != null) {
				while(r != null) {
					Arrays.sort(r);
					Arrays.sort(s);
					
					FileManager.arrayToFile(mergeJoin(s, r), rsFilename);					
					r	= FileManager.fileToArray(rFilename, ++ rReadLevel);
				}
				s	= FileManager.fileToArray(sFilename, ++ sReadLevel);
			}
			
			// Create an empty file if the join returns no row
			File	rsFile	= new File(rsFilename);
			if(!rsFile.exists()) {
				rsFile.createNewFile();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/*
	 * Supposed to merge until the char array is full
	 * */
	public static final char [] joinUntilFull() {
		/*
		 * Not yet implemented
		 * */
		return null;
	}
	
	
	/**
	 * 
	 * @param s
	 * The first array to join
	 * @param r
	 * The second array to join
	 * @return
	 * The join array between the entered arrays
	 * @throws Exception
	 * In case one, or both, of the array entries exceeds the buffer limit
	 */
	
	public static final char [] mergeJoin(char [] r, char [] s) {
		if(r.length > BUFFER_SIZE || s.length > BUFFER_SIZE) {
			return null;
		}

		char [] rs		= new char[BUFFER_SIZE];
		int		index	= 0;
		int		i		= 0;
		int		j		= 0;
		
		while(i < r.length && j < s.length) {
			if(r[i] > s[j]) {
				j ++;
			}
			else {
				if(r[i] == s[j]) {
					rs[index ++] = r[i];
				}
				i ++;
			}
		}
		
		return rs[FIRST_ARRAY_ELEMENT_INDEX] == THE_NONE_CHARACTER ?
				null :
					rs;
	}
}
