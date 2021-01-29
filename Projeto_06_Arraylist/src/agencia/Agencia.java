package agencia;
import java.util.Scanner;
import java.util.ArrayList;

class Operacao{

    public int id;
    public String descricao;
    public float valor;
    public float saldo;
    
    public Operacao(int id, String descricao, float valor, float saldo){
    
        this.id=id;
        this.descricao=descricao;
        this.valor=valor;
        this.saldo=saldo;
    
    }

    public String toString(){
    
        return  "Seu ID" + id +  " Sua descricao:  " + descricao + " Seu valor: " + valor + "Seu saldo: " + saldo;
    
    }

}

public class Agencia {

    Operacao op;
    int nextId;
    private float saldo;
    private int numero;
    ArrayList <Operacao> extrato;
    
    public Agencia(int numero){
        
        this.numero=numero;
        this.nextId=0;
        extrato = new ArrayList<>();
        
    }
    
    public void setSaldo(float valor){   
        this.saldo=valor;
    }
    
    public float getSaldo(){   
        return saldo;
    }
    
    public void setNumero(int numero){
        
        if(numero==this.numero){
            
            System.out.println("Conta já existe! Crie outra");
            
            
        }
        else{
        
            this.numero=numero;
            
            
        }
    }
    
    public int getNumero(){
        return numero;
    }
    
    public void adicionarOperacao(String descricao, float valor){
        
        op = new Operacao(nextId, descricao, valor, getSaldo());
        nextId+=1;
        extrato.add(op);
     
    }
        
    //preciso entender isso aqui 
    public ArrayList<Operacao> getExtrato(){
    
        for(int i=0; i<extrato.size(); i++){
        
            System.out.println(extrato.get(i));
      
        }
        
        return extrato;
        
    }   
    
    //preciso entender isso aqui hermana
    public ArrayList<Operacao> getExtratoLast(int qtd){

       for(int i=extrato.size()-qtd; i<extrato.size(); i++){
           
           System.out.println(extrato.get(i));
           
       }
       
           return extrato;
           
    }
    
    public boolean depositar(float valor){
    
        if(valor>0){
        
            float aux=getSaldo();
            this.setSaldo(aux+valor);
            adicionarOperacao("deposito", valor);
            return true;
            
        }
        else{
        
            return false;
        
        }
        
    }
    
    public boolean sacar(float valor){
    
        if(getSaldo()>=valor){
        
            float aux=getSaldo();
            this.setSaldo(aux-valor);
            this.adicionarOperacao("saque", -valor);
            return true;
            
        }
        else{
            
            System.out.println("Não tem dinheiro suficiente");
            return false;
        
        }
    }
    
    public boolean tarifas(float valor){
    
        float aux=getSaldo();
        this.setSaldo(aux-valor);
        this.adicionarOperacao("tarifa", -valor);
        return true;
    
    }
    
    public void estornar(int indice){
    
        float auxValor=0;
            
            if(extrato.get(indice).descricao.equals("tarifa")){
                                 
               auxValor=extrato.get(indice).valor*-1;
               
                this.setSaldo((auxValor)+getSaldo());
                adicionarOperacao("estorno", auxValor);
                
                }else{
            
                System.out.println("O indice " + indice + "não é uma tarifa");
                
            }    
                  
    }
    
    public String toString(){
    
        return  "O numero da sua conta: " + numero + " Seu saldo: " + saldo;
    
    }
  
    public static void main(String[] args) {
        
       Agencia conta = new Agencia(0);
       
       Scanner dados = new Scanner(System.in);
         while(true){
            String novodado = dados.nextLine();
            String[] dd = novodado.split(" ");
            if(dd[0].equals("finalizar")){
                break;
            }else if(dd[0].equals("Conta")){
                
                conta.setNumero(Integer.parseInt(dd[1]));

                conta = new Agencia (Integer.parseInt(dd[1]));
                
                
            }else if(dd[0].equals("estornar")){
                conta.estornar(Integer.parseInt(dd[1]));
                conta.getExtrato();
            }
            else if(dd[0].equals("depositar")){
                conta.depositar(Integer.parseInt(dd[1]));
            }
            else if(dd[0].equals("sacar")){
                conta.sacar(Integer.parseInt(dd[1]));
            }
            else if(dd[0].equals("tarifa")){
                conta.tarifas(Integer.parseInt(dd[1]));
            }
            else if(dd[0].equals("extrato")){    
                conta.getExtrato();
            }
            else if(dd[0].equals("ultimoextrato")){
                System.out.println(conta.getExtratoLast(Integer.parseInt(dd[1])));
            
            }else if(dd[0].equals("Conta")){
                    
                    System.out.println(conta);
                        
                 }
            }
            
          
        } 
         
    
                             
    }
    



    
    