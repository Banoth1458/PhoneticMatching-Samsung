/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ashish, Banoth
 * Department of Computer Science and Engineering - Informaion Security and Information Technology
 * National Institute of Technology Surathkal, Karnataka - India
 */

package bixby_hackathon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Bixby_hackathon {

    // Change Input file path here
    private static final String FILENAME = "E:\\input.txt";
    
    private static String[] hindi = new String[]{

                 "अ","आ","इ","ई","उ","ऊ","ऋ","ऌ","ऍ","ए","ऐ","ऑ","ओ","औ",
                 "क", "ख", "ग", "घ" ,"ङ",
                 "च" ,"छ" ,"ज","झ","ञ",
                 "ट","ठ", "ड","ढ","ण",
                 "त", "थ", "द", "ध", "न",
                 "प", "फ", "ब","भ","म",
                 "य", "र", "ल", "ळ",
                 "व", "श" ,"ष","स" ,"ह","ं","ा","ि","ी","ु","ू","ॅ",
                 "े","ै","ॉ","ो","ौ","्"
            };   
        
    private static String[] english= new String[]{
                "a","aa","e","ee","u","uu","ru","rhu","a","aa","i","o","oo","ou",
                 
                "ka","kha","ga","gha","da",
                 
                "cha","cha","ja","jaa","na",
                 
                "ta","tha","da","dha","naa",
                 
                "ta","tha","da","dha","na",
                 
                "pa","pha","ba","bha","ma",
                 
                "ya","ra","la","laa","wa","sha","sha","sa","ha","n","a","i","i","u","u","a","e","e","a","o","ho",""
         };
    
    public static void main(String[] args) throws FileNotFoundException {
        HashMap<Character,Character> char_map = Utils._init_map();
        int res = 0;
        int lineCount =0;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(FILENAME),"UTF-8"))) {

	    String sCurrentLine;
            
            while ((sCurrentLine = br.readLine()) != null) {
                    lineCount+=1;
                    String[] words = sCurrentLine.split("\t");
                    String word_one = words[0];
                    String word_two = words[1].toLowerCase();
                            
                    // Step 1: Check if both the words are in same language
                    // For Hindi-English
                    if(Utils.isEnglish(word_two)){
                        String[] str1 = hin_to_eng(word_one);
                        int match = 0;
                        
                        for(String s:str1){
                          if(s.equals(word_two)){
                            match = 1;
                            break;
                          }
                        }
                        

                        if(match==1){
                            Utils.writeOutput(word_one, word_two, "1\n");
                            if(words[2].equals("1")){
                                res+=1;
                                }
                            }
                            else{
                                 Utils.writeOutput(word_one, word_two, "0\n");
                                 if(words[2].equals("0")){
                                 res+=1;
                                }
                            }
                        }
                       // For Hindi-Hindi
                        else{
                            
                            StringBuffer s1 = new StringBuffer();
                            StringBuffer s2 = new StringBuffer();
                            
                            s1.append(word_one.charAt(0));
                            s2.append(word_two.charAt(0));
                            
                            
                            for(int i=1;i<word_one.length();i++){
                                int u = word_one.charAt(i);
				
                                if(char_map.containsKey(word_one.charAt(i))){
                                  
                                  if(word_one.charAt(i)!='0'){
                                    s1.append(char_map.get(word_one.charAt(i)));
                                  }
                                }

                            
                            }
                            
                            for(int i=1;i<word_two.length();i++){
                                int u = word_two.charAt(i);
				
                                if(char_map.containsKey(word_two.charAt(i))){
                                  
                                  if(word_two.charAt(i)!='0'){
                                    s2.append(char_map.get(word_two.charAt(i)));
                                  }
                                }

                                
                            }
                            
                            int len1 = s1.length();
                            int len2 = s2.length();
                            
                            if(8-len1>0){
                               while(len1!=8){
                                s1.append('0');
                                len1+=1;
                               }
                            }
                            
                            if(8-len2>0){
                              while(len2!=8){
                                s2.append('0');
                                len2+=1;
                              }
                            }
                            
                            
                            
                            int match = 0;
                            for(int j=0;j<8;j++){
                              if(s1.charAt(j)==s2.charAt(j)){
                                match+=1;
                              }
                            }
                            
                            
                            if(match==8){
                                
                                Utils.writeOutput(word_one, word_two, "1\n");
                                if(words[2].equals("1")){
                                    res+=1;
                                }
                            }
                            else{
                             
                             Utils.writeOutput(word_one, word_two, "0\n");
                             if(words[2].equals("0")){
                                 res+=1;
                             }
                            }   
                              
                            }
			}
                        
                        
                        System.out.println("Accuracy: "+(double)((double)res/(double)lineCount)*100);
                        

		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    

    
    
    
    /**
     * 
     * @param str to be converted from Hindi to Hinglish
     * @return Converted Hinglish
     */
    public static String[] hin_to_eng(String str){
       int strLen = str.length();
       char array[] = new char[strLen];
       String strArray1[] = new String[strLen];
       for (int i=0 ; i< strLen ; i++)
       {
           array[i] = str.charAt(i);
           strArray1[i] = Character.toString(str.charAt(i));
       }
       
       
       HashMap<String,ArrayList<String>> matra = new HashMap<String,ArrayList<String>>(); 
       ArrayList<String> ar = new ArrayList<String>();
       ar.add("nn");
       matra.put("ं", ar);
       ar.clear();
       ar.add("oo");
       matra.put("ू", ar);
       
    
         String res="";
         int z=0;
          String res1="";
        
         String[] temp = new String[2];
         temp[0] = "";
         temp[1] = "";
         
      for(int i=0;i<strLen;i++){
         
          for(int j=0;j<61;j++){
              if(strArray1[i].equals(hindi[j])){
                  if(j>48 && j<61){

                      temp[z]="";
                    temp[z+1]="";
                    for(int k=0;k<res.length()-1;k++){
                        temp[z] = temp[z] + Character.toString(res.charAt(k));
                    }
                    for(int k=0;k<res1.length()-1;k++){
                        temp[z+1] = temp[z+1] + Character.toString(res1.charAt(k));
                    }
                    
                   if(strArray1[i].equals("ू"))
                    {   
                    temp[z+1]=temp[z]+ matra.get(strArray1[i]).get(0);   
                    temp[z] = temp[z] + english[j];
                    }else{
                    temp[z] = temp[z] + english[j];
                    temp[z+1]=temp[z+1]+ english[j];
                    }
                  }else{
                  
                  temp[z] = temp[z]+english[j];
                  temp[z+1] =temp[z+1]+english[j];
                  
                  res = temp[z];
                  res1=temp[z+1];
                  }
                  break;
              }
          }
      }

     String[] fina= new String[2];
     fina[0] = "";
     fina[1] = "";
      if(!strArray1[strLen-1].equals("ा")){
          
          for(int i=0;i<2;i++){
          if(temp[i].charAt(temp[i].length()-1) =='a'){
              for(int k=0;k<temp[i].length()-1;k++){
                    fina[i] = fina[i] + Character.toString(temp[i].charAt(k));
                    
                }
            }
          
          }
            
              
      }


        
     if(!fina[0].isEmpty()||!fina[1].isEmpty()){
       return fina;
     }
     else{
     return temp;
     }
     
    }
        
}
