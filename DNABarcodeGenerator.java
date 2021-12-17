import java.util.Scanner;

import java.lang.Math;

public class DNABarcodeGenerator {
	
	public static void main(String[] args) {
		
		String[] Sequence = generateBarcode();
		
		for(int i = 0; i < Sequence.length; i++)
		
			System.out.println(Sequence[i]);

		// JT Thompson
		
	}
	
	public static String[] generateBarcode() {
	
		char nucleotides[] = {'A', 'T', 'C', 'G'}; 
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("How many sequences of DNA barcodes you would like to generate? ");
		int n = sc.nextInt();
		
		System.out.println("What is the length of the DNA barcode? ");
		int l = sc.nextInt();
		
		String[] Sequence = new String[n];
		
		for(int i = 0; i < n; i++) {
			
			String barcode = "";
			
			
			
			
			for(int j = 0; j < l; j++) {
				int index = (int) (Math.random() * 4);
				barcode += nucleotides[index];
				
				
				}

			
			barcode = isRestrictedList(barcode);
			barcode = validateGCCount(barcode);
			barcode = isRedundantBarcode(barcode);
			
			Sequence[i] = barcode;
	
		
		}
		
		return Sequence;
	
	}
	
	
	 public static String isRestrictedList(String barcode) {
		
		String[] RestrictedList = {"ACCGGT", "GGCGCGCC", "GGATCC", "CCTGCAGG"};
		
		// if Sequences[i] has elements of RestrictedSequences, Generate new barcode
		
		while((barcode.contains(RestrictedList[0]) || (barcode.contains(RestrictedList[1]) || (barcode.contains(RestrictedList[2]) || (barcode.contains(RestrictedList[3])))))) {
		
				generateBarcode();
				
				barcode = generateBarcode().toString();	
			}
		
		return barcode;
		
		}
	 	
	
	 public static String validateGCCount(String barcode) {
	// for every element in Sequence, count amount of A, C, T, G
		
		int GCount = 0;
		
		int CCount = 0;
		
		for(int i = 0; i < barcode.length(); i++) {
			if(barcode.charAt(i) == 'C') {
				CCount++;
			}
			if(barcode.charAt(i) == 'G') {
				GCount++;
			}
		}
		
		if((double) GCount / ((double) barcode.length()) >= .4 && (double) GCount / ((double) barcode.length()) <= .6) {
			
			if((double) CCount / ((double) barcode.length()) >= .4 && (double) CCount / ((double) barcode.length()) <= .6) {
				return true;
			
			}
			
			else {
			
				return false;
			
			}
			
		} else {
			
			return false;
		
		}
	 }
	 
	
	
	public static String isRedundantBarcode(String barcode) {
		String[] RedundantBarcodes = {"AAA", "TTT", "CCC", "GGG",};
		
		if((barcode.contains(RedundantBarcodes[0]) || (barcode.contains(RedundantBarcodes[1]) || (barcode.contains(RedundantBarcodes[2]) || (barcode.contains(RedundantBarcodes[3])))))) {
			return true;
		}
		else
			return false;
		
	}
	
}
