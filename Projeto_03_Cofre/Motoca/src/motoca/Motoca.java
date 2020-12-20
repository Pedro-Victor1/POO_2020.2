
package motoca;

class Pessoa{

    String nome;
    int idade;
    
    Pessoa(String nome, int idade){
    
        this.nome=nome;
        this.idade=idade;
    
    
    }
    
    public String toString(){
    
        return "Nome " + nome + " Idade: " + idade;
    
    }
    
}   

public class Motoca {
    
    int potencia;
    int tempo;
    Pessoa pass; //aqui fica guardada a pessoa
    
    Motoca(int potencia, int tempo){
        
        this.potencia=potencia;
        this.tempo=tempo;
        this.pass=null;
    
    }

    void comprarTempo(int a){
    
        this.tempo+=a;
        System.out.println("Adicinou" + tempo + "de tempo na moto");
        
    }
    
    void subir(Pessoa pessoa){
    
        if(pass!=null){
            
            System.out.println("Não da para subir");
        
        }
        
        this.pass=pessoa;
        System.out.println(pessoa.nome + "Subiu na moto");
    
    }
   
    Pessoa descer(){
    
        if(this.pass==null){
            
            System.out.println("Não tem ninguém na moto");
            return null;
            
        }
        
        Pessoa aux=pass;
        aux=null;
        return pass; 
    
    }
    
    void digirir(int tempo){
    
        if(this.pass==null){
            
            System.out.println("Não tem ninguém, como vai dirigir?");
            
        }
        else if(pass.idade>10){
            
            System.out.println("Muito grande");
        
        }
        else if(this.tempo<=tempo){
        
            this.tempo-=tempo;
            System.out.println("VocÊ andou por" + tempo + "minutos");
            
        }
    
    }
    
    String buzinar(int potencia){
        
        String pem="p";
        
        for(int i=0; i<potencia; i++){
        
            pem += "e";
        
           
        }
        
        return pem;
    
    }
    
 
    public static void main(String[] args){

        Motoca moto =  new Motoca(10, 5);
        moto.comprarTempo(10);
        moto.subir(new Pessoa("Jeff", 7));
        moto.descer();
        moto.subir(new Pessoa("Jana", 8));
        moto.digirir(4);
        
    }
}
