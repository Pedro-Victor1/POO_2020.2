
package primeiroprograma;


public class PrimeiroPrograma {

    public static void main(String[] args) {
        //Programa para saber quais e quantos números pares tem de 0 até 100.
        
        int contador=0;
        
        for(int i=0; i<100; i++){
        
            if(i%2==0){
                
                contador=contador+1;
                System.out.println(i);
            
            }
        
        }
        
        System.out.println(contador);
        
    }
    
}
