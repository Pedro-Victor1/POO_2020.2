

package tamagochi;

import java.util.Scanner;

class Tamagochi {

    private int energy;
    private int energyMax;
    private int hungry;
    private int hungryMax;
    private int clean;
    private int cleanMax;
    private int diamantes;
    private int idade;
    private boolean vivo;
    
    Tamagochi(int energyMax, int hungryMax, int cleanMax){
    
        this.energyMax=energyMax;
        this.hungryMax=hungryMax;
        this.cleanMax=cleanMax;
        
        this.energy=this.energyMax;
        this.hungry=this.hungryMax;
        this.clean=this.cleanMax;

        this.diamantes=0;
        this.idade=0;
        this.vivo=true;
        
        
        
    }
    
    private void setEnergy(int value){
        
        this.energy=value;
        
        if(this.energy<=0){
        
            this.energy=0;
            this.vivo=false;
            System.out.println("Morreu por falta de energiia");
            return;
        }
        if(this.energy>this.energyMax){
            
            this.energy=this.energyMax;
        
        }
    }
    
    int getEnergy(){
        
        return this.energy;
    
    }
    
    private void setHungry(int value){
      
        this.hungry=value;
        
        if(this.hungry<=0){
        
            this.hungry=0;
            this.vivo=false;
            System.out.println("Morreu por falta de fome");
            return;
        }
        if(this.hungry>this.hungryMax){
            
            this.hungry=this.hungryMax;
        
        }
        
    
    }
    
    int getHungry(){
        
        return this.hungry;
    
    }

    private void setClean(int value){
        
        this.clean=value;
        
        if(this.clean<=0){
        
            this.clean=0;
            this.vivo=false;
            System.out.println("Morreu por falta de limpeza");
            return;
        }
                
        if(this.clean>this.cleanMax){
            this.clean=this.cleanMax;
            return;
        }  
        
    }
    
    int getClean(){
    
        return this.clean;
    
    }
    
    boolean vivoo(){
        
        if(vivo!=true){
            
            System.out.println("Você não pode interagir! morreu");
            return false;
            
        }
        
        return true;
        
    }
    
    void jogar(){
        
        if(!vivoo())
           return;

        System.out.println(" está se divertindo muito!");

        diamantes+=1;
        idade+=1;
        setEnergy(energy-2);
        setHungry(hungry-1);
        setClean(clean-3);
        
    
       
    }
    void banhar(){
        
        if(!vivoo())
            return;
        
        System.out.println(" está ficando muito cheirosinho!");

        idade+=2;
        setEnergy(this.energy-3);
        setHungry(this.hungry-1);
        setClean(this.cleanMax);
        

    
    }
    
    void comer(){
    
        if(!vivoo())
            return;
       
        System.out.println(" está ficando de barriga cheinha!");

        idade+=1;
        setEnergy(this.energy-1);
        setHungry(this.hungry+4);
        setClean(this.clean-2);
                
    
    }
    
    void dormir(int t){
        
        if(!vivoo())
            return;
        
        if(this.energy>this.energyMax-5){
            
            idade+=t;
            setEnergy(this.energyMax);
            System.out.println(" a mimir!");
      
        }
        else{
            
            System.out.println(" não quer dormir");
    
        }
    
    }
    
    public String toString(){
    
    
        return "Sua energia é: " + energy + "/ " + energyMax + " Sua fome é: " + hungry + "/" + hungryMax +  " Sua limpeza é: " + clean + "/" + cleanMax + " Seus diamantes " + diamantes; 
    
    }
    
    }


class Jogo{
        
    public void main(String[] args) {
    
     Scanner dad = new Scanner(System.in);
        
        
        Tamagochi luppy= new Tamagochi(0, 0, 0);
        
        System.out.println(luppy);
                    
        System.out.println("O que você quer fazer?" + "Jogar / Banhar / Comer / Brincar / Desligar");
         while(true){
            String novodado = dad.nextLine();
            String[] dd = novodado.split(" ");
            if(dd[0].equals("desligar")){
                break;
            }else if(dd[0].equals("parametros")){
                
                
                luppy=new Tamagochi(Integer.parseInt(dd[1]), Integer.parseInt(dd[2]), Integer.parseInt(dd[3]));
                
                
            }else if(dd[0].equals("jogar")){
                luppy.jogar();
                System.out.println(luppy);
            }else if(dd[0].equals("banhar")){
                luppy.banhar();
                System.out.println(luppy);

            }else if(dd[0].equals("comer")){
                luppy.comer();
                System.out.println(luppy);
            }else if(dd[0].equals("dormir")){
                
               luppy.dormir(Integer.parseInt(dd[1]));     
               
            }else{
                System.out.println("invalido");
            }
        }
        
        dad.close();
                
        System.out.println(luppy);
       
        }

    }

