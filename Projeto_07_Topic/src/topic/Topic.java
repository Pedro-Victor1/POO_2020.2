
package topic;
import java.util.ArrayList;
import java.util.Scanner;

class Pass{
    private String name;
    private int idade;
    public int id;
   
    public Pass(String id, int idade){
        this.name=id;
        this.idade=idade;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
    
    }
    public int getIdade(){
        return idade;
    }
    public void setIdade(int idade){
 
    }
    public boolean preferencial(){
        if(getIdade()>60){
            return true;    
        }else{
        return false;
        }
    }
    
    public String toString(){
        return "Seu nome:  " + name + "Idade: " + idade;
    }
}

public class Topic {
   
    public ArrayList<Pass>cadeiras;
    Pass pass;
    public int qtdPrefer;

    public Topic(int tamTopic, int qtdPrefer){
        cadeiras=new ArrayList<>();
        this.qtdPrefer=qtdPrefer;
        //iniciando tudo nulo o array de vetor, ok!
        for(int i=0; i<tamTopic; i++){
            cadeiras.add(null);   
        }
    }
    
    public String toString(){
        String saida=" [ ";
        for(int i=0; i<qtdPrefer; i++){
            if(cadeiras.get(i)==null){
                saida+=" @ ";
            }
            else{
                saida += "=" + cadeiras.get(i);
                }
            }    
        for(int i=qtdPrefer; i<cadeiras.size(); i++){
            if(cadeiras.get(i)==null){
                saida+=" = ";
            }
            else{
                saida += "@" + cadeiras.get(i);
            }
        }
            return saida+=" ] ";
        }
    
    //verificando se tem cadeira vazia - ela vai receber tam e tam 2 e vai verificar, se for diferente de null ele retorna a psoição se não -1;
    int cadeiraVazia(int tam, int tam2){
        for(int i=tam; i<tam2; i++){
            if(cadeiras.get(i)==null){
                return i; 
            }             
        }
        return -1;           
    }    
    
    //verificando se existe uma pessoa com esse nome
    Pass procurarPessoa(String id){
        //aqui to pegando o negocio ne amor, choque de monstro
        //procurando no vetor
        for(int i=0; i<cadeiras.size(); i++){
            //pegando a posição
            pass = cadeiras.get(i);
            //se pass for diferente de null e pass.name for igual a ID ele tem pessoa
                if(pass != null && pass.getName().equals(id)){
                    return pass;         
                }
            }
        return null;
     }
   
    //verificando pra subir
    public void subir(Pass pass){
        int pos=-1;
        //verificando se a pessoa já não está dentro
        //primeiro preciso procurar se tem a pessoa na topic e assim chamo a func
        if(procurarPessoa(pass.getName())==null){
            if(pass.preferencial()){
                pos=this.cadeiraVazia(0, cadeiras.size());
            }
            else{
                pos=this.cadeiraVazia(this.qtdPrefer, cadeiras.size());
            if(pos==-1){
                pos=this.cadeiraVazia(0, this.qtdPrefer);
            }
            }
            if(pos==-1){    
                System.out.println("Lotado");
            }
            else{
                cadeiras.set(pos, pass);
                System.out.println("A " + pass.getName()+ " " + pass.getIdade() + " " + " Subiu");
            }    
        }
        else{
            
            System.out.println("Essa pessoa já tá na topic");
        
        }
    }
    
    Pass descer(String name){
        Pass aux = procurarPessoa(name);
            if(aux == null){
                System.out.println("Não existe essa pessoa");
            }
            else{ 
                cadeiras.remove(aux);
                cadeiras.add(null);
                System.out.println("A " + aux.getName() + " " + aux.getIdade() + " saiu da Topic");
            }
        return pass;
        }

    public static void main(String[] args) {
        
        Topic combi = new Topic(0, 0);
        
        Scanner dados = new Scanner(System.in);

         while(true){
            String novodado = dados.nextLine();
            String[] dd = novodado.split(" ");
            if(dd[0].equals("finalizar")){
                break;
            }else if(dd[0].equals("iniciar")){
                combi=new Topic(Integer.parseInt(dd[1]), Integer.parseInt(dd[2]));   
                System.out.println(combi);

            }else if(dd[0].equals("subir")){
                combi.subir(new Pass(dd[1], Integer.parseInt(dd[2])));
                System.out.println(combi);

            }else if(dd[0].equals("descer")){
                combi.descer(dd[1]);
                System.out.println(combi);
            }else{
                System.out.println("invalido"); 
            }
        }
                  
         dados.close();
        
    }    
}
