
package agendaa;

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
    }
    
    Fone(String serial){
     String array[]= serial.split(":");
        label=array[0];
        number=array[1];
    }
    
    static public boolean validate(String number){
        String validos = "0123456789()-";
        for(int i = 0; i < number.length(); i++){
            if(!validos.contains("" + number.charAt(i))){
                return false;
            }
        }
        return true;
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
    private String name;
    private boolean favorito;
    private ArrayList<Fone> fones;

    public Contato(String name){
        this.name=name;
        fones = new ArrayList<>();
    }
    
    boolean getFavorito(){
        return favorito;
    }
        
    public void addFone(String label, String number){
        if(!Fone.validate(number)){
            throw new RuntimeException("fail: esse número não é válido");
        }
        fones.add(new Fone(label, number));     
    }
    
    public void addFone(Fone fone){
        this.addFone(fone.getLabel(), fone.getNumber());
    }
    
    public void rmFone(int index){
           fones.remove(fones.get(index));      
    }
    
    public void setBookmark(boolean valor){
        this.favorito = valor;
    }
    
    public String toString(){
        String saida="";
        saida += " " + name + " : " + fones;
        return saida;
    }
}


public class Agendaa {

    Map <String, Contato> contatos;
    Map <String, Contato> bookmarks;

    public Agendaa(){
        contatos = new TreeMap<>();
        bookmarks = new TreeMap<>();
    }
    
    public void addContato(String name, List <Fone> fones){  //List <Fone> fones
        if(!contatos.containsKey(name)){
            contatos.put(name, new Contato(name));
        } 
        Contato contato = contatos.get(name);
        
        for(Fone fone : fones){
            contato.addFone(fone);
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
                return aux;
            }
        }
        return null;
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
    
    public void bookmark(String name){
        Contato contato = contatos.get(name);
        if(!contato.getFavorito()){
            contato.setBookmark(true);
            bookmarks.put(name, contato);
        }
    }
    
    public void unBookmark(String name){
        Contato contato = contatos.get(name);
        if(contato.getFavorito()){
            bookmarks.remove(name, contato);
            contato.setBookmark(false);
        }
    }
    
    ArrayList <Contato> getBookmarks(){
        return new ArrayList<Contato>(bookmarks.values()); 
    }
    
    public String toString(){
        String saida="";
        for(Contato contato : contatos.values()){
            if(!contato.getFavorito()){
                saida += " - " + contato; 
            }
            else{
                saida += " @ " + contato;
            }
        }
        return saida;
    }
    
    public static void main(String[] args) {
        Agendaa telefonica = new Agendaa();
        try (Scanner dados = new Scanner(System.in)){
            while(true){
                try{
                    String novodado = dados.nextLine();
                    String[] dd = novodado.split(" "); 
                    if(dd[0].equals("finalizar")){
                        break;
                    }else if(dd[0].equals("addContato")){
                        List<Fone> fones = new ArrayList<>(); 
                        for(int i=2; i<dd.length; i++){
                            fones.add(new Fone(dd[i]));
                        }
                        telefonica.addContato((dd[1]), fones);
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
                }catch(RuntimeException e){
                    System.out.println(e.getMessage());
                }   
            }
        }  
        System.out.println(telefonica);
    }                 
}
        

    