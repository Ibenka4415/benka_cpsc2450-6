package matlib;

import java.io.File;
import java.io.FileReader;
import java.util.Scanner;
import java.io.IOException;
import java.util.ArrayList;

import java.util.List;

import java.util.Random;


public class matlib {
	
	private static ArrayList<String> adj, adv, pastVerb, pluVerb, singNoun, singVerb, pluNoun;
    
	public static void printWelcome() {
		System.out.println("*************************************************************");
		System.out.printf("%45s","Welcome to Text Analyzer V1.0\n");
		System.out.println("*************************************************************");
		System.out.println("");
	}
        
	
	
	
	 public static void wordsArrayList() { 
		 adj = new ArrayList<String>();
	     adv = new ArrayList<String>();
	     pastVerb = new ArrayList<String>();
	     pluNoun = new ArrayList<String>();
	     pluVerb = new ArrayList<String>();
	     singNoun = new ArrayList<String>();
	     singVerb = new ArrayList<String>();
	        
	    }
	 
	 
	 
	 public static boolean getWordsFiles(String folderPath) {
	        try {
	            Scanner fsc = new Scanner(new File(folderPath, "adj.txt"));
	            while (fsc.hasNextLine()) {
	                singNoun.add(fsc.nextLine());
	            }
	            fsc.close();
	            
	            Scanner fsc2 = new Scanner(new File(folderPath, "adv.txt"));
	            while (fsc2.hasNextLine()) {
	                adj.add(fsc2.nextLine());
	            }
	            fsc2.close();
	            
	            Scanner fsc3 = new Scanner(new File(folderPath, "pastverb.txt"));
	            while (fsc3.hasNextLine()) {
	                adv.add(fsc3.nextLine());
	            }
	            fsc3.close();
	            
	            Scanner fsc4 = new Scanner(new File(folderPath, "plunoun.txt"));
	            while (fsc4.hasNextLine()) {
	                pastVerb.add(fsc4.nextLine());
	            }
	            fsc4.close();
	            
	            Scanner fsc5 = new Scanner(new File(folderPath, "pluverb.txt"));
	            while (fsc5.hasNextLine()) {
	                pluNoun.add(fsc5.nextLine());
	            }
	            fsc5.close();
	            
	            Scanner fsc6 = new Scanner(new File(folderPath, "singnoun.txt"));
	            while (fsc6.hasNextLine()) {
	                pluVerb.add(fsc6.nextLine());
	            }
	            fsc6.close();
	            
	            Scanner fsc7 = new Scanner(new File(folderPath, "singverb.txt"));
	            while (fsc7.hasNextLine()) {
	                singVerb.add(fsc7.nextLine());
	                //System.out.print(singVerb);
	            }
	            fsc7.close();
	            
	            return true;
	        } catch (Exception e) {
	            return false;    
	        }
	    }
	 
	 
	 public static ArrayList<String>storyArray(String folderPath,String storyNumber){
		 ArrayList<String> result = new ArrayList<String>();
		 try {
			 Scanner fsc = new Scanner(new File(folderPath,storyNumber));
			 while (fsc.hasNextLine()) {
				 result.add(fsc.nextLine());
			 }
			 fsc.close();
			 return result;
		 }catch (Exception e) {
				 return null;
		 }
		 }
	 public static void matlibFiller(ArrayList<String> storyMaker) {
		 Random rnd = new Random();
		 for(String line : storyMaker) {
			 String word = line;
			 
			 while(word.indexOf("<adj>")>=0) {
				 String replacement = adj.get(rnd.nextInt(adj.size()));
		         word = word.replaceFirst("<adj>", replacement);
			 }
			 while(word.indexOf("<adv>")>=0) {
				 String replacement = adv.get(rnd.nextInt(adv.size()));
		         word = word.replaceFirst("<adv>", replacement);
			 }
			 while(word.indexOf("<pastverb>")>=0) {
				 String replacement = pastVerb.get(rnd.nextInt(pastVerb.size()));
		         word = word.replaceFirst("<pastverb>", replacement);
			 }
			 while(word.indexOf("<plunoun>")>=0) {
				 String replacement = pluNoun.get(rnd.nextInt(pluNoun.size()));
		         word = word.replaceFirst("<plunoun>", replacement);
			 }
			 while(word.indexOf("<pluverb>")>=0) {
				 String replacement = pluVerb.get(rnd.nextInt(pluVerb.size()));
		         word = word.replaceFirst("<pluverb>", replacement);
			 }
			 while(word.indexOf("<singnoun>")>=0) {
				 String replacement = singNoun.get(rnd.nextInt(singNoun.size()));
		         word = word.replaceFirst("<singnoun>", replacement);
			 }
			 while(word.indexOf("<singverb>")>=0) {
				 String replacement = singVerb.get(rnd.nextInt(singVerb.size()));
		         word = word.replaceFirst("<singverb>", replacement);
			 }
			 System.out.println(word);
		 }
	 }
	 
	 public static void main(String[] args) {
		 	printWelcome();
	        Scanner sc = new Scanner(System.in);
	        String storyNumber ;
	        System.out.print("Enter the path of the folder containing the file.\n");
	        System.out.print("Or just press Enter to accept the default location: c:\\temp\\ml");
	        System.out.println("");
	        String folderInput = sc.nextLine().trim();
	        String folderPath = (folderInput.isEmpty()) ? "c:\\temp\\ml" : folderInput;
	        wordsArrayList();
	        String choice = "";
	        //getWordsFiles(folderPath);
	        if (getWordsFiles(folderPath)) {
	        	do {
	        		System.out.print("Enter a story number or q to quit: ");
	        		choice = sc.nextLine().toLowerCase();
	        		System.out.println("");
	        		
	        		if(choice.equals("1")) {
	        			storyNumber = "story1.txt";
	        			ArrayList<String> storyMaker = storyArray(folderPath, storyNumber);
	                    matlibFiller(storyMaker);
	                    System.out.println("");
	                    
	        		}else if (choice.equals("2")) {
	        			storyNumber = "story2.txt";
	        			ArrayList<String> storyMaker = storyArray(folderPath, storyNumber);
	                    matlibFiller(storyMaker);
	                    System.out.println("");
	                    
	        		}else if (!choice.equals("q")) {
	        			System.out.println("");
	        			System.out.println("That story does not exist. Please Choose again.\n");
	        		}
	        	}while (!choice.equals("q"));
	        }else {
	        	System.out.println("Failed to find the File");
	        	
	        }
	        System.out.println("");
	        System.out.println("Thank you for using this program.");
	        sc.close();
	    }
	}
	




