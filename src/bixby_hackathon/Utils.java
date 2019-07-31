/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ashish, Banoth
 */

package bixby_hackathon;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;


public class Utils {
    
    private static final String OUTPUT_PATH = "E:\\output.txt"; // Change output path here
    
    /**
     * 
     * @param str
     * @return True: If English, False: If Hindi
     */
    public static boolean isEnglish(String str){
      if(((int)str.charAt(0)>=65&&(int)str.charAt(0)<=90)||((int)str.charAt(0)>=97&&(int)str.charAt(0)<=122)){
        return true;
      }
      return false;
    }
    
    /**
     * 
     * @param res
     * @param size
     * @return The accuracy of the prediction
     */
    public static String getAccuracy(int res, int size){
        return ""+((double)res/(double)size)*100;
    }
    
    /**
     * 
     * @return Initialize Character Encoding Map
     * @throws FileNotFoundException 
     */    
    public static HashMap<Character,Character> _init_map() throws FileNotFoundException{ 
        HashMap<Character,Character> char_map = new HashMap<>();
        char_map.put('\u0901','0');
        char_map.put('\u0902','N');
        char_map.put('\u0903','0');
        char_map.put('\u0904','0');
        char_map.put('\u0905','A');
        char_map.put('\u0906','A');
        char_map.put('\u0907','B');
        char_map.put('\u0908','B');
        char_map.put('\u0909','C');
        char_map.put('\u090a','C');
        char_map.put('\u090b','P');
        char_map.put('\u090c','Q');
        char_map.put('\u090d','0');
        char_map.put('\u090e','D');
        char_map.put('\u090f','D');
        char_map.put('\u0910','D');
        char_map.put('\u0911','E');
        char_map.put('\u0912','E');
        char_map.put('\u0913','E');
        char_map.put('\u0914','E');
        char_map.put('\u0915','F');
        char_map.put('\u0916','F');
        char_map.put('\u0917','F');
        char_map.put('\u0918','F');
        char_map.put('\u0919','G');
        char_map.put('\u091a','H');
        char_map.put('\u091b','H');
        char_map.put('\u091c','H');
        char_map.put('\u091d','H');
        char_map.put('\u091e','G');
        char_map.put('\u091f','I');
        char_map.put('\u0920','I');
        char_map.put('\u0921','I');
        char_map.put('\u0922','I');
        char_map.put('\u0923','J');
        char_map.put('\u0924','K');
        char_map.put('\u0925','K');
        char_map.put('\u0926','K');
        char_map.put('\u0927','K');
        char_map.put('\u0928','L');
        char_map.put('\u0929','L');
        char_map.put('\u092a','M');
        char_map.put('\u092b','M');
        char_map.put('\u092c','M');
        char_map.put('\u092d','M');
        char_map.put('\u092e','N');
        char_map.put('\u092f','O');
        char_map.put('\u0930','P');
        char_map.put('\u0931','P');
        char_map.put('\u0932','Q');
        char_map.put('\u0933','Q');
        char_map.put('\u0934','Q');
        char_map.put('\u0935','R');
        char_map.put('\u0936','S');
        char_map.put('\u0937','S');
        char_map.put('\u0938','S');
        char_map.put('\u0939','T');
        char_map.put('\u093a','0');
        char_map.put('\u093b','0');
        char_map.put('\u093c','0');
        char_map.put('\u093d','0');
        char_map.put('\u093e','A');
        char_map.put('\u093f','B');
        char_map.put('\u0940','B');
        char_map.put('\u0941','C');
        char_map.put('\u0942','C');
        char_map.put('\u0943','P');
        char_map.put('\u0944','P');
        char_map.put('\u0945','E');
        char_map.put('\u0946','D');
        char_map.put('\u0947','D');
        char_map.put('\u0948','D');
        char_map.put('\u0949','D');
        char_map.put('\u094a','E');
        char_map.put('\u094b','E');
        char_map.put('\u094c','E');
        char_map.put('\u094d','0');
        char_map.put('\u094e','0');
        char_map.put('\u094f','0');
        char_map.put('\u0950','0');
        char_map.put('\u0951','0');
        char_map.put('\u0952','0');
        char_map.put('\u0953','0');
        char_map.put('\u0954','0');
        char_map.put('\u0955','0');
        char_map.put('\u0956','0');
        char_map.put('\u0957','E');
        char_map.put('\u0958','0');
        char_map.put('\u0959','0');
        char_map.put('\u095a','0');
        char_map.put('\u095b','0');
        char_map.put('\u095c','0');
        char_map.put('\u095d','0');
        char_map.put('\u095e','0');
        char_map.put('\u095f','0');
        char_map.put('\u0960','P');
        char_map.put('\u0961','Q');
        char_map.put('\u0962','Q');
        char_map.put('\u0963','Q');
        char_map.put('\u0964','0');
        char_map.put('\u0965','0');
        char_map.put('\u0970','0');
        char_map.put('\u0971','0');
        char_map.put('\u0972','0');
        char_map.put('\u0973','0');
        char_map.put('\u0974','0');
        char_map.put('\u0975','0');
        char_map.put('\u0976','0');
        char_map.put('\u0977','0');
        char_map.put('\u0978','0');
        char_map.put('\u0979','0');
        char_map.put('\u097a','J');
        char_map.put('\u097b','J');
        char_map.put('\u097c','Q');
        char_map.put('\u097d','P');
        char_map.put('\u097e','P');
        char_map.put('\u097f','F');

        return char_map;
    }
    
    
    public static void writeTemp(String s1,String s2){
        BufferedWriter bw = null;
	FileWriter fw = null;
try {
            fw = new FileWriter("E:\\result_temp.txt", true);
	    bw = new BufferedWriter(fw);
	    bw.write(s1+"\t\t"+s2+"\n");
            } catch (IOException e) {
                e.printStackTrace();
            } finally {

			try {

				if (bw != null)
					bw.close();

				if (fw != null)
					fw.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}

		}
        
    }
    
    public static void writeOutput(String s1,String s2, String output){
         
        BufferedWriter bw = null;
	FileWriter fw = null;
        try {
            fw = new FileWriter(OUTPUT_PATH, true);
	    bw = new BufferedWriter(fw);
	    bw.write(s1+"\t"+s2+"\t"+output);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {

			try {

				if (bw != null)
					bw.close();

				if (fw != null)
					fw.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}

		}

    
    }
    
}
