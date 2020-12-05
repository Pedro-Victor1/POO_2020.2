/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calango;

import java.util.Scanner;

public class Calango {
  // atributo -> estado
    int energia;
    int nPatas;
    int rabo;
    int predadores;
    
    //parâmetros
    Calango(int energia, int nPatas, int rabo, int predadores){
    
        this.energia=energia;
        this.nPatas=nPatas;
        this.rabo=rabo;
        this.predadores=predadores;
        //maxEnergia -> coloco o máximo de energia
        //maxPatas -> coloco o máximo de patas
        
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
    
    void contraAtaque(){
    
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
    
    

    
    //método que informa como o meu objeto deve ser convertido para texto
    public String toString(){
        
        return "Energia:" + energia + "Patas:" + nPatas + "Rabo:" + rabo + "Predadores:" + predadores;
    
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
         System.out.println("Digita a energia:");
         int energia=leitor.nextInt();
         System.out.println("Digita o número de patas");
         int nPatas=leitor.nextInt();
         System.out.println("Digita o número de rabos");
         int rabo=leitor.nextInt();
         System.out.println("Digita o número de predadores");
         int predadores=leitor.nextInt();
         
         leitor.close();
         
       //aqui estou criando um objeto
        Calango deadpool = new Calango(energia, nPatas, rabo, predadores); //criei um objeto aqui
        
        //aqui estou chamando o método 
        System.out.println(deadpool);

        deadpool.correr();
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
        
    }
}