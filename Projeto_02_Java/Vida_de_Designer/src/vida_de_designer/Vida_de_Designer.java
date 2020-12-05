
package vida_de_designer;

import java.util.Scanner;

public class Vida_de_Designer {

    int energia;
    int dinheiro;
    int trabalhos;
    int estresse;
    
    //criando meu construtor e passando os parâmetros
    Vida_de_Designer(int energia, int dinheiro, int trabalhos, int estresse){
    
    this.energia=energia;
    this.dinheiro=dinheiro;
    this.trabalhos=trabalhos;
    this.estresse=estresse;
    
    }
    
    void trabalhar(){
    
        if(energia>2 && trabalhos>0){
        
            System.out.println("Vou começar a trabalhar!");
            energia-=1;
            estresse+=1;
            
        }
        else{
            
            if(energia<2 && estresse>3){
            
                System.out.println("Preciso pausar para o café!");
                 
            
            }
        
        }
    
    }
    
    void entregar_trabalho(){
    
        if(trabalhos>0){
            
            System.out.println("Ufa, terminei um trabalho!");
            trabalhos-=1;
            dinheiro+=1;
        
        }

    }
    
    void alteracao_trabalho(){
    
        if(energia>1 && estresse <4){
            
            System.out.println("Que cliente chatooo!!!");
            energia-=1;
            estresse+=1;
            
    
        }
        else{
        
            System.out.print("Não tenho mais condições de alterar esse trabalho!! Não vou fazer!");
            
                dinheiro-=1;
                estresse+=1;
                
        
        }
    }
    
    void pausa_cafe(){
            
            System.out.println("Só um café para continuar os trabalhos!");
            energia+=1;
      
    }
    
    void comer(){
    
        System.out.println("Hora de comer!");
        energia+=2;
        
    }
    
    void descansar(){
    
        if(energia<1 || estresse>3){
            
            System.out.println("Hora de descansar! Daqui a pouco volto!");
            energia+=1;
            estresse-=1;
            
        
        }
        else{
        
            System.out.println("Acho que aguento mais um pouquinho!");
        
        }
    
    }
    
    void renovar_licenca(){
        
        if(dinheiro > 0){
        
            System.out.println("Vish! A Adobe descobriu seu Photoshop pirata e agora quer que você pague a licença!");
            dinheiro-=1;
        
        }
        else{
        
            System.out.println("Não tenho grana para renovar! Vou perder os trabalhos que tenho!");
            trabalhos-=trabalhos;
            estresse+=1;
        
        }
    
    }
    
    void novo_trabalho(){
        
        if(energia < 3 && trabalhos < 3 && estresse <2){
            
            System.out.println("Um novo trabalho! apareceu!");
            trabalhos+=1;
            
        }
        else{
                
                System.out.println("Um trabalho apareceu, mas tive que recusar pq tava um pouco cansado!");
                
        }
    }
    
    void updrade_pc(){
    
        if(dinheiro>0){
            
            System.out.println("Vish! Comecei a trabalhar com modelagem 3D e preciso de mais memória RAM!");
            dinheiro-=1;
        
        }
        else{
        
            System.out.println("Não vou conseguir mais memória ram!! :(");
            estresse-=1;

        
        }
    
    }
    
    public String toString(){
    
       return "Você tem: " + energia + " de energia, " + "Você tem R$ " + dinheiro + ", " + "Você tem: " + trabalhos + " trabalhos " + " Você tá no nível " + estresse + "de estresse";
    
    }
    
    //função principal
    public static void main(String[] args) {

        //criando objeto q vai ler os valores
        Scanner dados = new Scanner(System.in);
        
        System.out.println("Qual a energia do seu designer?");
        int energia=dados.nextInt();
        
        System.out.println("Quanto de dinheiro seu designer tem?");
        int dinheiro=dados.nextInt();
        
        System.out.println("Quantos trabalhos seu designer tem?");
        int trabalhos=dados.nextInt();
        
        System.out.println("Qual o nível de estresse do seu designer? (1 até 5)");
        int estresse=dados.nextInt();
        
        dados.close();
        
        //criando o meu designer e dando seus parÂmetros
        Vida_de_Designer designer = new Vida_de_Designer(energia, dinheiro, trabalhos, estresse);
        
        System.out.println(designer);
        
      
            
        designer.trabalhar();
        designer.trabalhar();
        
        designer.pausa_cafe();
        designer.entregar_trabalho();
        designer.alteracao_trabalho();
        designer.trabalhar();
        designer.trabalhar();
        designer.entregar_trabalho();
        designer.novo_trabalho();
        designer.descansar();
        designer.novo_trabalho();
        designer.renovar_licenca();
        designer.updrade_pc();
        designer.novo_trabalho();
        designer.trabalhar();
        designer.entregar_trabalho();
        designer.pausa_cafe();
        designer.novo_trabalho();
        
        System.out.println(designer);
        
    }
    
}
