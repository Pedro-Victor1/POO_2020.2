
package lapiseira;


class Grafite{

    float calibre;
    String dureza;
    int tamanho;
    
    Grafite(float calibre, String dureza, int tamanho){
    
        this.calibre=calibre;
        this.dureza=dureza;
        this.tamanho=tamanho;
  
    }
    
    float desgastePorFolhas(){
    
        if(tamanho<0){
            
            System.out.println("Não tem grafite pra escrever");
          
            
        }
        else if(dureza=="HB"){
        
            tamanho-=1;
        
        }
        else if(dureza=="2B"){
        
            tamanho-=2;
        
        }
        else if(dureza == "4B"){
            
            tamanho-=4;
        
        }
        else{
            
            tamanho-=6;
            
        }
        
        return tamanho;
        
    }
    
    public String toString(){
    
        return " Calibre: " + this.calibre + " Dureza: " + this.dureza + " Tamanho:  " + this.tamanho;
    
    }

}


public class Lapiseira {

    float calibre;
    Grafite graf;
    float resultados;
    float quantidade;
    //boolean temGrafite;
    
    Lapiseira(float calibre){
        
        this.calibre=calibre;
        this.graf=null;
        
    }
    
    void inserir(Grafite graf){
        
        if(this.graf!=null){
            
            System.out.println("Já existe grafite");
            
            
        }
        else if(calibre != graf.calibre){
            
            System.out.println("Calibre não compatível");
            
            
        }
        
        else if(calibre == graf.calibre){
            
            System.out.println("Compatível com a lapiseira, grafite colocado com sucesso");
            //this.temGrafite=true;
            this.graf=graf;
            
        }
                   
    }
    
    Grafite remover(){
        
        if(graf==null){
            
            System.out.print("Não tem grafite pra remover");
        
        }
        
        this.graf=null;
        return graf;
        
    }

    void escrever(int folhas){
        
        
        if(graf==null){
            
            System.out.println(" Não tem grafite para escrever");
            return;
            
        }
        else if(graf.tamanho<folhas){
            
            graf.desgastePorFolhas();
            System.out.println("Só foram completas"  + folhas + "folhas");
            if(graf.tamanho<0){
                
                graf=null;
            
            }
            return;
            
        }
        else
            graf.desgastePorFolhas();
            System.out.println("Todas as folhas foram escritas");
            return;
            
        }

    
    
    public String toString(){
    
        return "Calibre:  " + calibre + "  Grafite  " + graf;
}

    public static void main(String[] args){
 
        
        Lapiseira compac = new Lapiseira(0.5f);
        compac.inserir(new Grafite(0.5f, "2B", 10));
        
        System.out.println(compac);
        compac.remover();
        compac.escrever(3);
        compac.inserir(new Grafite(0.5f, "6B", 4));
        for(int ii=0; ii<5; ii++){
            
            compac.escrever(4);
        
        }
        
        System.out.print(compac);
  
    }
    
}
