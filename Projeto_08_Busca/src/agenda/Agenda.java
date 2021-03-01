
package agenda;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Fone{
    private String label;
    private String number;
    
    public Fone(String serial){
    
        String array[]= serial.split(":");
        label=array[0];
        number=array[1];
    }
    
    static boolean validate(String number){        
        String validos = "0123456789()-";
        for(int i = 0; i < number.length(); i++){
            if(!validos.contains("" + number.charAt(i))){
                return false;
            }
        }
        return true;
    }
    
    Fone(String label, String number){
        this.label=label;
        this.number=number;        
    }
    
    
    String setLabel(String label){
        this.label=label;
        return label;
    }
    
    String setNumber(String number){    
        this.label=number;
        return number;
    }
    
    String getLabel(){
    
        return label;
    
    }
    
    String getNumber(){
    
        return number;
        
    }
    
    public String toString(){

        return   "[" +  label + "  " + number + "]";
    }
}

class Contato{
    private String name;
    private ArrayList<Fone>fones;
    Fone fon;
    
    public String getName(){
        return name;
    }
    
    public Contato(String name){
        this.name=name;
        fones=new ArrayList<>();
    }
    
    void addFone( String label, String number){
        if(!fon.validate(number)){
            throw new RuntimeException("fail: esse número não é válido");
        }
        fones.add(new Fone(label, number));        
    }
       
    void rmFone(int index){
       fones.remove(fones.get(index));      
    }
    
    public String toString(){
       
        String saida = "";
        for (int i = 0; i < fones.size(); i++) {
            Fone fone = fones.get(i);
            saida += "[" + i + ":" + fone + "]";
        }
        return getName() + " " + saida;
        
    }   
}

class ComparaPessoaPorNome implements Comparator <Contato>{
    
    public int compare(Contato c1, Contato c2) {
        
        return c1.getName().compareTo(c2.getName());
        //aqui vou comparar entre eles
    }
}

public class Agenda {
    private ArrayList<Contato>contatos;
    
    public Agenda(){
        contatos = new ArrayList<>();
    }
    
    private int procurarContato(String name){
        for(int i=0; i<contatos.size(); i++){
        Contato contato = contatos.get(i);
                if(contato != null && contato.getName().equals(name)){
                   return i;         
                }
        }
        return -1;
    }
    
    void addContato(String name, Fone fone){
        Contato contato=this.getContato(name); 
        if(contato==null){
            contato = new Contato(name);
            this.contatos.add(contato);
        }
        contato.addFone(fone.getLabel(), fone.getNumber());
    }
    
    void addContato(String name, List <Fone> fones){
        Contato contato=this.getContato(name); 
        if(contato== null){
             contato = new Contato(name);
            this.contatos.add(contato);
        }
            for(Fone fone : fones){
                
                contato.addFone(fone.getLabel(), fone.getNumber());
        }
    }
    
    boolean rmContato(String name){
        int aux=procurarContato(name);
            if(aux!=-1){            
                this.contatos.remove(aux);
                return true;
            }
        throw new RuntimeException("fail: esse contato não existe");
    }
    
    boolean rmFone(String name, int indice){
        Contato contato=this.getContato(name);
            if(contato!=null){            
                contato.rmFone(indice);
                return true;
            }
        throw new RuntimeException("fail: esse contato não existe");
    }
  
    ArrayList <Contato> getContatos(){
        for(int i=0; i<contatos.size(); i++){
            System.out.println( i + " " + contatos.get(i));

        }

        return contatos;
    }
    
    Contato getContato(String name){
        Contato contato;
        for(int i=0; i<contatos.size(); i++){
            contato = contatos.get(i);
                if(contatos != null && contato.getName().equals(name)){
                    return contato;
                }
                
               
            }
        return null;
    }
    
    ArrayList <Contato> procurar(String padrao){
        ArrayList<Contato> aux = new ArrayList<>();
        for(Contato c : contatos){
            if(c.toString().contains(padrao)){
                aux.add(c);
                System.out.println(aux);
            }
        }
        return aux;
    }
    
    public String toString(){
        String saida="";
        for(int i=0; i<contatos.size(); i++){
            Contato aux = contatos.get(i);
            saida+= "   " + aux;
        }  
        return saida;
    }
    
    public static void main(String[] args) {
       Agenda telefone = new Agenda();
        try (Scanner dados = new Scanner(System.in)) {
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
                        telefone.addContato((dd[1]), fones);
                        Collections.sort(telefone.getContatos(), new ComparaPessoaPorNome());
                    }else if(dd[0].equals("rmFone")){
                        telefone.rmFone(dd[1],Integer.parseInt(dd[2]));
                    }else if(dd[0].equals("getContatos")){
                        telefone.getContatos();
                    }else if(dd[0].equals("getContato")){
                        telefone.getContato(dd[1]);
                    }else if(dd[0].equals("procurar")){
                        telefone.procurar(dd[1]);
                    
                    }
                }catch(RuntimeException e){
                    System.out.println(e.getMessage());
                }
            }
        }
        System.out.println(telefone);
    }
    
}
