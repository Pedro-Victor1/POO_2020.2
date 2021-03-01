package contatostar;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

class Fone{
    private String label;
    private String number;
    
    public Fone(String label, String number){
        this.label=label;
        this.number=number;
        String validos = "0123456789()-";
        for(int i = 0; i < number.length(); i++){
            if(!validos.contains("" + number.charAt(i))){
                throw new RuntimeException("Fail: número invalido");
            }  
        }    
    }
    
    Fone(String serial){
     String array[]= serial.split(":");
        label=array[0];
        number=array[1];
             
    }
    
    public String getLabel(){
        return this.label;
    }
    
    public String getNumber(){
        return this.number;
    }
   
    public String toString(){
        return label + number;   
    }
}

class Contato{
    protected String name;
    protected ArrayList<Fone> fones;

    public Contato(String name, List <Fone> fones){
        this.name=name;
        this.fones = new ArrayList<>();
        if(fones != null){
            for(Fone fone : fones){
                this.fones.add(fone);
            }
        }
    }

    String getName(){
        return name;
    }
    
    public void addFone(String label, String number){
        fones.add(new Fone(label, number));     
    }
    
    public void addFone(Fone fone){
        this.addFone(fone.getLabel(), fone.getNumber());
    }
    
    public void rmFone(int index){
           fones.remove(fones.get(index));      
    }
    
    //muda no public to string pra saber se é favorito ou não
    public String toString(){
        String saida="";
        saida += " " + name + " : " + fones;
        return saida;
    }
}

class ContatoPlus extends Contato{
    private boolean favorito;

    public ContatoPlus(String name, List <Fone> fones) {
        super(name, fones);
    }
    
    @Override
    public String getName( ){
        return name;
    }
    
    public void setFavorito(boolean valor){
        this.favorito = valor;
    }

    boolean getFavorito(){
        return favorito;
    }
    
    public String toString(){
        String saida="";
        saida+= (this.favorito ? "@" : "-") + " " + name + " " + " " + fones;
        return saida;
    }
}

class Agenda{
    Map <String, Contato> contatos;

    public Agenda(){
        contatos = new TreeMap<>();
    }
    
    public void addContato(Contato contato, List <Fone> fones){
        if(!contatos.containsKey(contato.name)){
            contatos.put(contato.name, contato);
        }
        else{
            contato=this.getContato(contato.name); 
            for(Fone fone : fones){
                contato.addFone(fone.getLabel(), fone.getNumber());
            }
        }
    }
    
    public boolean rmContato(String name){
        Contato contato =  getContato(name);
        contatos.remove(name);
        return true;
    }
    
    ArrayList <Contato> procurar(String padrao){
        ArrayList<Contato> aux= new ArrayList<>();
        for(Contato contato: contatos.values()){
            if(contato.toString().contains(padrao)){
                aux.add(contato);
            }
        }
        return aux;
    }
    
    ArrayList <Contato> getContatos(){
        return new ArrayList<Contato>(contatos.values());        
    }

    Contato getContato(String name){
        Contato contato = contatos.get(name);
        if(contato == null){
            throw new RuntimeException("Fail: contato não existe");
        }   
        return contato;            
    }
    
    public String toString(){
        String saida="";
        for(Contato contato : contatos.values()){
            saida+=contato + "\n";
        }
        return saida;
    }
}    

class AgendaPlus extends Agenda{
    
    TreeMap<String, Contato> bookmarks;
    
    public AgendaPlus(){
        bookmarks = new TreeMap<>();    
    }
      
    public void bookmark(String name){
        Contato contato = this.getContato(name);
        if(contato instanceof ContatoPlus){
            ContatoPlus cp = (ContatoPlus) contato;
            if(cp.getFavorito()){
                bookmarks.put(name, contato);
            }
            else{
                bookmarks.put(name, contato);
                cp.setFavorito(true);
            }
        }
    }
    
    public void unBookmark(String name){
        Contato contato = this.getContato(name);
        ContatoPlus cp = (ContatoPlus) contato;
        if(cp.getFavorito()){
            bookmarks.remove(name, contato);
            cp.setFavorito(false);
        }
    }
    
    ArrayList <Contato> getBookmarks(){
        return new ArrayList<Contato>(bookmarks.values()); 
    }
}

public class Contatostar{
    public static void main(String[] args) {
        AgendaPlus telefonica = new AgendaPlus();
        try (Scanner dados = new Scanner(System.in)){
            while(true){
                try{
                    String novodado = dados.nextLine();
                    String[] dd = novodado.split(" "); 
                    if(dd[0].equals("finalizar")){
                        break;
                    }else if(dd[0].equals("addContato")){
                        List<Fone> fones = new ArrayList<>(); 
                        for(int i=2; i<dd.length-1; i++){
                            fones.add(new Fone(dd[i]));
                        } 
                        ContatoPlus contato = new ContatoPlus(dd[1], fones);
                        if(dd[dd.length-1].equals("sim")){
                           contato.setFavorito(true);
                        }
                        telefonica.addContato(contato, fones);
                        System.out.println(telefonica);
                    }else if(dd[0].equals("getContatos")){
                        System.out.println(telefonica);
                    }else if(dd[0].equals("getContato")){
                        System.out.print(telefonica.getContato(dd[1]));
                    }else if(dd[0].equals("rmContato")){
                        telefonica.rmContato(dd[1]);
                        System.out.print(telefonica);
                    }else if(dd[0].equals("procurar")){
                        System.out.print(telefonica.procurar(dd[1]));
                    }else if(dd[0].equals("bookmark")){
                        telefonica.bookmark(dd[1]);
                        System.out.print(telefonica);
                    }else if(dd[0].equals("unBookmark")){
                        telefonica.unBookmark(dd[1]);
                        System.out.print(telefonica);
                    }else if(dd[0].equals("getBookmarks")){
                        System.out.print(telefonica.getBookmarks());
                    }   
              }catch(ArrayIndexOutOfBoundsException e){
                    throw e;
                }catch(RuntimeException e){
                    System.out.println(e.getMessage());
                }  
            }
        }  
        System.out.println(telefonica);
    }
}

