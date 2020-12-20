/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calango;

import java.util.Scanner;

class Inseto{
    
    int tamanho;
    int energia;
    
   Inseto(int tamanho, int energia){
    
        this.tamanho=tamanho;
        this.energia=energia;
        
    }
    
    public String toString(){
       
        return "t:" + this.tamanho + "e:" + this.energia;
    
    }

}

public class Calango {
  // atributo -> estado
    Inseto barriga;
    int energia;
    int nPatas;
    int rabo;
    //int predadores;
    
    //parâmetros
    Calango(int energia, int nPatas, int rabo){
    
        this.energia=energia;
        this.nPatas=nPatas;
        this.rabo=rabo;
        //aqui aparece que ela não aponta pra nada, ela tá vazia moh
        this.barriga=null;
        
        //this.predadores=predadores;
        //maxEnergia -> coloco o máximo de energia
        //maxPatas -> coloco o máximo de patas
        
    }
    
    void comer(Inseto Inseto){
        
        if(this.barriga!=null){
    
            System.out.println("Tá cheia já)");
            return;
            
         }
        
        this.barriga=Inseto;
       
    
    }
    
    Inseto vomitar(){
    
        if(barriga==null){
            
            System.out.println("Nãoo tem nada pra vomitar");
            return null;
            
            
        }
        
        Inseto aux=barriga;
        barriga=null;
        return aux;
        
    
    }
    
    void digerir(){
    
        if(barriga==null){
            
            System.out.println("Não tem nada)");
            return;
            
        }
        
        this.energia+=barriga.energia;
        barriga = null;
    
    }
    
    // métodos -> comportamento
    void correr(){
        if(nPatas<2){
            
            System.out.println("Estou quase sem patas! Não vou poder correr! O que vou fazer?");
            return;
            
        }

        if(energia > 0){
        
            System.out.println("Correndo dos predadores!");
            energia-=1;
            
        }
        else{
            
            System.out.println("Estou cansado, me falta forças!");
            
        }
        
    
    }
    
    void camuflar(){
        
        if(energia<2){
        
            System.out.println("Descansando");
            energia+=1;
            
        }
    
    }
    
    void regenerar(){
        
        if(nPatas<4){
        
            System.out.println("Vou me regenerar e acabar com os predadores!");
            nPatas+=1;
            
            
        }
        else{
            
            if(nPatas>=4 && rabo <1){
            
              System.out.println("Estou 100% agora!");
              rabo+=1;
            
            }
        
        
        }
    
    
    }
    
    void ataque(){
        if(nPatas > 0){
            
            nPatas-=1;
            System.out.println("Os predadores me atacaram! Perdi uma pata!");
            
        }
        else{
                         
            if(nPatas<1 && rabo>0){
            
                System.out.println("Levaram meu rabo agora!");
                rabo-=1;
                
                
            }

        }
    }
    
    void brigar(Calango other){
        //jeff é  this e o karl é o other
        if(this.energia>3){
        
            System.out.println("Vamos brigar!");
        
        }
        if(other.nPatas>0){
            
            other.nPatas-=1;
            System.out.println("Arranquei sua pata!");
        
        }
        else if(other.rabo>0){
        
            other.rabo-=1;
            System.out.println("Vou arrancar teu rabo");
            
            
        }
        else{
        
            other.energia-=this.energia;
            System.out.println("Vou acabar com suas energias");
            
            
        }
        
    
    
    }
    
    /*void contraAtaque(){
    
        if(predadores>0 && rabo>0 && nPatas>0){
            
            System.out.println("Vou dar uma chicotada em vocês com meu rabo!! ");
            predadores-=1;
            energia-=1;
            
        }
        else{
            
            if(predadores>0 && rabo<1){
            
                System.out.println("Invocando fúria do dragão!!");
                System.out.println("Fogo pela boca neles!!");
                predadores-=1;
                energia-=1;
            
            }
            
            
        }
    
    }
    */
    
   
  
    

    
    //método que informa como o meu objeto deve ser convertido para texto
    public String toString(){
        
        return "Energia:" + energia + "Patas:" + nPatas + "Rabo:" + rabo;
    
    }
    
    public static void main(String[] args) {
        
        /*Scanner leitor = new Scanner(System.in);
        String line = leitor.nextLine();
        String[] words = line.split(" ");
        float acc=0;
        
        for(int i=0; i<words.length;){
        
            System.out.println(acc);
            
            leitor.close();
        
            i=i+1;
        }
        
     
        }
    }
        */
        
         Scanner leitor = new Scanner(System.in);
         /*System.out.println("Digita a energia:");
         int energia=leitor.nextInt();
         System.out.println("Digita o número de patas");
         int nPatas=leitor.nextInt();
         System.out.println("Digita o número de rabos");
         int rabo=leitor.nextInt();
         System.out.println("Digita o número de predadores");
         int predadores=leitor.nextInt();
         
         leitor.close();
         */
         
       //aqui estou criando um objeto
        Calango jeff = new Calango(10, 4, 1); //criei um objeto aqui
        jeff.correr();
        
        System.out.println(jeff);
        
        Calango karl = new Calango(8, 3, 1);
        
        jeff.brigar(karl);
        jeff.brigar(karl);
        jeff.brigar(karl);
        jeff.brigar(karl);
        jeff.brigar(karl);
        
        System.out.println(jeff);
        System.out.println(karl);
        
        Inseto muri = new Inseto(1, 3);
        
        karl.comer(muri);
        karl.digerir();
         
        System.out.println(jeff);
        System.out.println(karl);
        
        
        
        //aqui estou chamando o método 

        /*deadpool.correr();
        deadpool.correr();
        deadpool.ataque();
        deadpool.ataque();
        deadpool.correr();
        deadpool.ataque();
        deadpool.correr();
        deadpool.camuflar();
        deadpool.contraAtaque();
        deadpool.correr();
        deadpool.camuflar();
        deadpool.camuflar();
        deadpool.regenerar();
        deadpool.ataque();
        deadpool.correr();
        deadpool.ataque();
        deadpool.camuflar();
        deadpool.camuflar();
        deadpool.ataque();
        deadpool.ataque();
        deadpool.ataque();
        deadpool.ataque();
        deadpool.contraAtaque();
        deadpool.regenerar();
        deadpool.regenerar();
        deadpool.regenerar();
        deadpool.regenerar();
        deadpool.correr();
        deadpool.contraAtaque();
        deadpool.regenerar();
        
        System.out.println(deadpool);
        */
    }
}