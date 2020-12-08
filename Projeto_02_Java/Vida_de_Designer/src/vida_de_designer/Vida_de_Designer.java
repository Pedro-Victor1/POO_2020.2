
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
            
            
                System.out.println("Preciso pausar para o café!");
                 
            
            }
            
        
        }
    
    
    
    void entregar(){
    
        if(trabalhos>0){
            
            System.out.println("Ufa, terminei um trabalho!");
            trabalhos-=1;
            dinheiro+=1;
        
        }

    }
    
    void alteracao(){
    
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
    
    void cafe(){
            
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
    
    void licenca(){
        
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
    
    void novo(){
        
        if(energia < 3 && trabalhos < 3 && estresse <2){
            
            System.out.println("Um novo trabalho! apareceu!");
            trabalhos+=1;
            
        }
        else{
                
                System.out.println("Um trabalho apareceu, mas tive que recusar pq tava um pouco cansado!");
                
        }
    }
    
    void upgrade(){
    
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
        
        
        //criando o meu designer e dando seus parÂmetros
        Vida_de_Designer designer = new Vida_de_Designer(energia, dinheiro, trabalhos, estresse);
        
        System.out.println("Digite o que o designer deve fazer: " + " trabalhar "+ " alterartrabalho " + " entregartrabalho " + " comer " + " cafe " + " descansar " + " upgradepc " + " comprarlicenca " +" novotrabalho ");
         
        while(true){
            String novodado = dados.nextLine();
            String[] dado = novodado.split(" ");
            if(dado[0].equals("fim")){
                break;
            }else if(dado[0].equals("trabalhar")){
                designer.trabalhar();
            }else if(dado[0].equals("entregartrabalho")){
                designer.entregar();
            }else if(dado[0].equals("alterartrabalho")){
                designer.alteracao();
            }else if(dado[0].equals("cafe")){
                designer.cafe();
            }else if(dado[0].equals("comer")){
                designer.comer();
            }else if(dado[0].equals("descansar")){
                designer.descansar();   
            }else if(dado[0].equals("upgradepc")){
                designer.upgrade();
            }else if(dado[0].equals("comprarlicenca")){
                designer.licenca();
            }else if(dado[0].equals("novo")){
                designer.novo();
            }else if(dado[0].equals("mostrar")){
                System.out.println(designer);
            }else{
                System.out.println("invalido");
            }
            
            
        }
        
        System.out.println(designer);
        
        dados.close();
        
    }
}
