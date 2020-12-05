
package javaapplication6;

import java.util.Scanner;

import java.util.Arrays;

public class JavaApplication6 {

    public static void main(String[] args) {

        /*Scanner c1 = new Scanner(System.in);
            
            int contador=0;
            int a=0;
            while(a>-1){
            
                a=c1.nextInt();
                
                if(a%2==0){
                    
                    contador=contador+a;
                
                }
                
            }

            System.out.println(contador);
            c1.close();
          */
        
           Scanner c1= new Scanner(System.in);
           
           String line="12345";
           
           String[] words=line.split("");
           
           System.out.println(words.length);
           
           System.out.println(words[0] + words[2]);
           
           System.out.print("[");
           
           for(int i=0; i<words.length; i++){
           
               System.out.print(words[i]+" ");
             
           }
           
           System.out.println("]");
            
           System.out.println(Arrays.asList(words));
           
           float oi=0;
           
           for(int ii=0; ii<words.length; ii++){
           
               oi+=Float.parseFloat(words[ii]);
           
           }
           
           System.out.println(oi);
           
    }
    
}
