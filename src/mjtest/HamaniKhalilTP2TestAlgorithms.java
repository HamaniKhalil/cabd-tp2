package mjtest;

import static HamaniKhalilTP2.SystemConfiguration.BUFFER_SIZE;
import static HamaniKhalilTP2.SystemConfiguration.FIRST_ARRAY_ELEMENT_INDEX;
import static HamaniKhalilTP2.SystemConfiguration.THE_NONE_CHARACTER;
import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.junit.Test;

import HamaniKhalilTP2.HamaniKhalilMergeJoin;;

public class HamaniKhalilTP2TestAlgorithms {
	
	public static final String	FILE_PREFIX		= "T";
	public static final String	S_FILE_SUFFIX	= "-S.txt";
	public static final String	R_FILE_SUFFIX	= "-R.txt";
	public static final String	RS_FILE_SUFFIX	= "-RS.txt";
	public static final String	RS_CORRECT_FILE	= "-C";
	public static final String	RS_OUTPUT_FILE	= "-O";
	
	/*
	 * +----------------------------------------+
	 * |	Nested loop algorithm test cases	|
	 * +----------------------------------------+
	 * */
	
	
	/**
	 * When the values are the same for the two sets to be joined
	 */
	@Test
	public void testNestedLoopSameSet() {
		/*
		 * Testing the join of two sets of the exact same elements
		 * =======================================================
		 * Using all the buffer size
		 * 
		 * */
		char [] r	= {
				'A',
				'B',
				'C',
				'D',
				'E',
				'F',
				'G',
				'H',
				'I',
				'J'
		};
		
		char [] s	= {
				'A',
				'B',
				'C',
				'D',
				'E',
				'F',
				'G',
				'H',
				'I',
				'J'
		};
		
		char []	correctRS	= {
				'A',
				'B',
				'C',
				'D',
				'E',
				'F',
				'G',
				'H',
				'I',
				'J'
		};
		
		char[] rs	= new char [BUFFER_SIZE];
		
		rs = HamaniKhalilMergeJoin.mergeJoin(r, s);
		
		for(int i = FIRST_ARRAY_ELEMENT_INDEX; i < BUFFER_SIZE; i ++) {
			assertEquals(correctRS[i], rs[i]);
		}
		
		
		/*
		 * Not uning the hole buffer size
		 * */
		
		r			= new char [BUFFER_SIZE];
		s			= new char [BUFFER_SIZE];
		correctRS	= new char [BUFFER_SIZE];
		
		r[0]			= 'A';
		r[1]			= 'B';
		r[2]			= 'C';
		r[3]			= 'D';
		r[4]			= 'E';
		
		s[0]			= 'A';
		s[1]			= 'B';
		s[2]			= 'C';
		s[3]			= 'D';
		s[4]			= 'E';
		
		
		correctRS[0]	= 'A';
		correctRS[1]	= 'B';
		correctRS[2]	= 'C';
		correctRS[3]	= 'D';
		correctRS[4]	= 'E';
		
		rs	= new char [BUFFER_SIZE];
		
		rs	= HamaniKhalilMergeJoin.mergeJoin(r, s);
		
		for(int i = FIRST_ARRAY_ELEMENT_INDEX; i < BUFFER_SIZE; i ++) {
			assertEquals(correctRS[i], rs[i]);
		}
	}
	
	@Test
	public void testNestedLoopDifferentElements() {
		/*
		 * Testing two relations with different elements
		 * =============================================
		 * Under the buffer size limit
		 * */
		char []	r			= {
				'A',
				'B',
				'D',
				'V',
				'Z'
		};
		
		char []	s			= {
				'A',
				'E',
				'F',
				'L',
				'V',
				'Z'
		};
		
		char []	correctRS	= new char [BUFFER_SIZE];
		
		correctRS[0]	= 'A';
		correctRS[1]	= 'V';
		correctRS[2]	= 'Z';
		
		char[] rs	= new char [BUFFER_SIZE];
		
		rs	= HamaniKhalilMergeJoin.mergeJoin(r, s);
		
		for(int i = FIRST_ARRAY_ELEMENT_INDEX; i < correctRS.length; i ++) {
			if(correctRS[i] != THE_NONE_CHARACTER) {
				assertEquals(correctRS[i], rs[i]);
			}
		}
		
		/*
		 * 
		 * Using all the buffer size
		 * */
		
		r	= new char [BUFFER_SIZE];
		
		r[0]	= 'A';
		r[1]	= 'B';
		r[2]	= 'C';
		r[3]	= 'D';
		r[4]	= 'E';
		r[5]	= 'F';
		r[6]	= 'G';
		r[7]	= 'H';
		r[8]	= 'I';
		r[9]	= 'J';
		
		
		s	= new char [BUFFER_SIZE];
		
		s[0]	= 'A';
		s[1]	= 'D';
		s[2]	= 'E';
		s[3]	= 'H';
		s[4]	= 'I';
		s[5]	= 'K';
		s[6]	= 'L';
		s[7]	= 'S';
		s[8]	= 'T';
		s[9]	= 'U';
		
		correctRS	= new char [BUFFER_SIZE];
		
		correctRS[0]	= 'A';
		correctRS[1]	= 'D';
		correctRS[2]	= 'E';
		correctRS[3]	= 'H';
		
		rs	= new char [BUFFER_SIZE];
		
		rs	= HamaniKhalilMergeJoin.mergeJoin(r, s);
		
		for(int i = FIRST_ARRAY_ELEMENT_INDEX; i < correctRS.length; i ++) {
			if(correctRS[i] != THE_NONE_CHARACTER) {
				assertEquals(correctRS[i], rs[i]);
			}
		}
		
	}
	
	@Test
	public void testNestedLoopEmptyJoin() {
		/*
		 * 
		 * Using all the buffer size
		 * */
		char [] r	= {
				'A',
				'B',
				'C',
				'D',
				'E',
				'F',
				'G',
				'H',
				'I',
				'J'
		};
		
		char [] s	= {
				'K',
				'L',
				'M',
				'N',
				'O',
				'P',
				'Q',
				'R',
				'S',
				'T'
		};
		
		char []	correctRS	= null;
		char []	rs			= HamaniKhalilMergeJoin.mergeJoin(r, s);
		
		assertEquals(correctRS, rs);
		
		/*
		 * 
		 * Not using all the buffer size
		 * */
		
		r	= new char [BUFFER_SIZE];
		
		r[0]	= 'A';
		r[1]	= 'B';
		r[2]	= 'C';
		r[3]	= 'D';
		r[4]	= 'E';
		
		s	= new char [BUFFER_SIZE];
		
		s[0]	= 'F';
		s[1]	= 'G';
		s[2]	= 'H';
		s[3]	= 'I';
		s[4]	= 'J';
				
		correctRS	= null;
		rs			= HamaniKhalilMergeJoin.mergeJoin(r, s);
		
		assertEquals(correctRS, rs);
		
		/*
		 * 
		 * Empty sets
		 * */
		
		r			= new char [BUFFER_SIZE];
		s			= new char [BUFFER_SIZE];
		correctRS	= null;
		
		assertEquals(correctRS, rs);
		
		/*
		 * 
		 * One empty set
		 * */
		
		r	= new char [BUFFER_SIZE];
		
		r[0]	= 'A';
		r[1]	= 'B';
		r[2]	= 'C';
		r[3]	= 'D';
		r[4]	= 'E';
		
		s			= new char [BUFFER_SIZE];
		correctRS	= null;
		
		assertEquals(correctRS, rs);
	}
	

	/*
	 * +------------------------------------------------+
	 * |	Join algorithm test cases (Write on files)	|
	 * +------------------------------------------------+
	 * */
	
	@Test
	public void testJoinOperation() {
		/*
		 * Automatic testing method that needs to have a standard naming as "T###-R.txt" for R relation
		 * and "T###-R.txt" for S relation
		 * and "T###-C-RS.txt" for RS join that is known to be correct
		 * and "T###-O-RS.txt" for RS join that is performed by the method that is tested
		 * 
		 * Having ### to be a tree (03) digit number as codified as a sequence of tests starting from 001 and ending with 999
		 * 
		 * P.S: It's important to have the tree (03) digits on the name
		 * */
		
		try {
			int		testNumber			= 1;
			String	correctRSFilename	= FILE_PREFIX + String.format("%03d", testNumber) + RS_CORRECT_FILE + RS_FILE_SUFFIX;
			File	correctRSFile		= new File(correctRSFilename);
			
			
			while(correctRSFile.exists()) {
				String	outputRSFilename	= FILE_PREFIX + String.format("%03d", testNumber) + RS_OUTPUT_FILE + RS_FILE_SUFFIX;
				String	rFilename			= FILE_PREFIX + String.format("%03d", testNumber) + R_FILE_SUFFIX;
				String	sFilename			= FILE_PREFIX + String.format("%03d", testNumber) + S_FILE_SUFFIX;
				
				HamaniKhalilMergeJoin.joinWithMergeJoin(rFilename, sFilename, outputRSFilename);
				
				FileReader		outputRSFR	= new FileReader(outputRSFilename);
				BufferedReader	outputRSBR	= new BufferedReader(outputRSFR);
				
				FileReader		correctRSFR	= new FileReader(correctRSFilename);
				BufferedReader	correctRSBR	= new BufferedReader(correctRSFR);
				
				String	outputLine	= null;
				String	correctLine	= null;
				
				while((correctLine = correctRSBR.readLine()) != null && (outputLine = outputRSBR.readLine()) != null) {
					assertEquals(correctLine.charAt(0), outputLine.charAt(0));
				}
				
				// Incrementation
				testNumber ++;
				correctRSFilename	= FILE_PREFIX + String.format("%03d", testNumber) + RS_CORRECT_FILE + RS_FILE_SUFFIX;
				correctRSFile		= new File(correctRSFilename);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
