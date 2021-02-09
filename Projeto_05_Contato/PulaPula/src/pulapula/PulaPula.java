
package pulapula;

import java.util.ArrayList;
import java.util.Scanner;

class Crianca{

    private String nome;
    private int idade;
    
    Crianca(String nome, int idade){
        
        this.nome=nome;
        this.idade=idade;
        
    }
    
    String getNome(){
    
        return nome;
    
    }
    
    int getIdade(){
    
        return idade;
    
    }
    
    public String toString(){
    
        return    " Seu nome   " + nome + " Sua idade " + idade;
    
    }



}

public class PulaPula {
    
    Crianca cria;
    //Crianca espera[];
    ArrayList<Crianca> brincando = new ArrayList<Crianca>();
    ArrayList<Crianca> espera = new ArrayList<Crianca>();
    
    
    
    //ela vai pro vetor das kids esperando
    void chegar(Crianca crianca){
    
       
       espera.add(crianca);
       System.out.println("A    " + crianca.getNome() + "    chegou na fila"); 
        
    }
    

    void mostrar(){
    
        System.out.println("Essas são as crianças que estão esperando para brincar" + espera);
        System.out.println("Essas são as crianças que estão brincando" + brincando);    
    }
    
    //tá no vetor de kids brincando
    void dentro(){
    
        brincando.add(espera.get(0));
        espera.remove(espera.get(0));
                     
        System.out.println("Uma criança entrou pro pula pula!");
    }
    
    //ela sai do vetor de kids brincando e vai pro último lugar das kids esperando
    void fora(){
        
       espera.add(brincando.get(0)); 
       brincando.remove(brincando.get(0));
       
       System.out.println("Uma criança saiu do pula pula!");
       
    }

    
    public static void main(String[] args) {

        PulaPula trampo= new PulaPula();
        
        
        Scanner dad = new Scanner(System.in);
                                 
        System.out.println("Digite a opção - chegar, mostrar, dentro, fora");
         while(true){
            String novodado = dad.nextLine();
            String[] dd = novodado.split(" ");
            if(dd[0].equals("interromper")){
                break;
            }else if(dd[0].equals("chegar")){
                
                trampo.chegar(new Crianca(dd[1], Integer.parseInt(dd[2])));
                trampo.mostrar();
                
            }else if(dd[0].equals("mostrar")){
                
                trampo.mostrar();
                
            }else if(dd[0].equals("dentro")){
                
                trampo.dentro();
                trampo.mostrar();
                
            }else if(dd[0].equals("fora")){
                
                trampo.fora();
                trampo.mostrar();
              
            }else{
                
                System.out.println("invalido");
                
            }
        }
         
         trampo.mostrar();
         
         dad.close();
        
}


}