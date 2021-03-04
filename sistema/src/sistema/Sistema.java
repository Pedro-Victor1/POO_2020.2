
package sistema;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

class Paciente{
    String id;
    Map<String, Medico> medicos;
    
    public Paciente(String id){
        this.id = id;
        this.medicos = new TreeMap<>();
    }

    void addMedico(String id, Medico medico){
        if(!medicos.containsKey(id)){
            
            this.medicos.put(medico.id, medico);
            medico.addPaciente(this.id, this);
        }
        return;
    }
    
    void rmMedico(String id){
        if(!medicos.containsKey(id)){
            return;
        }
        Medico medico = medicos.remove(id);
        medico.rmPaciente(this.id);
    }
    
    public String toString(){
        String saida = "Paciente " + id + "[ ";
        for(Medico medico : medicos.values())
            saida += medico.id + " ";
        return saida + "]";
    }
}

class Medico extends Paciente{
    Map<String, Paciente> pacientes;
    
    public Medico(String id){
        super(id);
        this.pacientes = new TreeMap<>();
    }
    
    void addPaciente(String id, Paciente paciente){
        if(!pacientes.containsKey(id)){
            this.pacientes.put(paciente.id, paciente);
            paciente.addMedico(this.id, this);
        }
        
        return;
    }    
    void rmPaciente(String idPaciente){
        if(pacientes.containsKey(idPaciente)){
            Paciente paciente = pacientes.remove(idPaciente);
            paciente.rmMedico(this.id);
        }
    }
    
    public String toString(){
        String saida = "Medico " + id + "[ ";
        for(Paciente paciente : pacientes.values())
            saida += paciente.id + " ";
        return saida + "]";
    }
}

public class Sistema {
    Map<String, Medico> medicos;
    Map<String, Paciente> pacientes;

    public Sistema(){
        this.medicos = new TreeMap<>();
        this.pacientes = new TreeMap<>();
    }
    
    Medico getMedico(String id){
        Medico medico = medicos.get(id);
        if(medico == null){
            throw new RuntimeException("Medico não existe");
        }    
        return medico;
    }
    
    Paciente getPaciente(String id){
        Paciente paciente = pacientes.get(id);
        if(paciente == null){
            throw new RuntimeException("Paciente não existe");
        }
        return paciente;
    }
    
    void addMedico(Medico idMedico){
        if(this.medicos.containsKey(idMedico.id)){  
            throw new RuntimeException ("Medico já existe");
        }
        this.medicos.put(idMedico.id, idMedico);
        this.pacientes.put(idMedico.id, idMedico);

    }
    
    void addPaciente(Paciente idPaciente){
 	if(this.pacientes.containsKey(idPaciente.id)){
            throw new RuntimeException ("Paciente já existe");
        }
        pacientes.put(idPaciente.id, idPaciente);
    }
    
    void vincular(String idPaciente, String idMedico){
        if (idPaciente.equals(idMedico)){ 
            throw new RuntimeException("O médico não pode se consultar com ele mesmo");
        }
	getPaciente(idPaciente).addMedico(idMedico, getMedico(idMedico));
    }
    
    void desvincular(String idPaciente, String idMedico){
	getPaciente(idPaciente).rmMedico(idMedico);
    }
    
    void rmMedico(String idMedico){
        Medico medico = getMedico(idMedico);
        ArrayList<String> pacient = new ArrayList<>(medicos.keySet());
        for(Paciente paciente : medico.pacientes.values()){
            medico.rmPaciente(idMedico);
            paciente.rmMedico(idMedico);
        }
        medicos.remove(idMedico);
        pacientes.remove(idMedico);
    }
    
    void rmPaciente(String idPaciente){
        Paciente paciente = getPaciente(idPaciente);
        ArrayList<String> medic = new ArrayList<>(pacientes.keySet());
        for(Medico medico : paciente.medicos.values()){
            paciente.rmMedico(idPaciente);
            medico.rmPaciente(idPaciente);
        }
        pacientes.remove(idPaciente);
        
    }
    
    public String toString(){
        String saida="";
        saida+= " Pacientes: " + pacientes + "\n" + " Medicos: " + medicos;
        return saida;
    }

    public static void main(String[] args) {
         
         Sistema sistema = new Sistema();
         try (Scanner dados = new Scanner(System.in)) {
            while(true){
                try{
                    String novodado = dados.nextLine();
                    String[] dd = novodado.split(" "); 
                    if(dd[0].equals("finalizar")){
                        break;
                    }else if(dd[0].equals("addMedico")){
                        sistema.addMedico(new Medico(dd[1]));
                        System.out.println(sistema);
                    }else if(dd[0].equals("addPaciente")){
                        sistema.addPaciente(new Paciente(dd[1]));
                        System.out.println(sistema);
                    }else if(dd[0].equals("vincular")){
                        sistema.vincular(dd[1], dd[2]);
                        System.out.println(sistema);
                    }else if(dd[0].equals("desvincular")){
                        sistema.desvincular(dd[1], dd[2]);
                        System.out.println(sistema);
                    }else if(dd[0].equals("rmMedico")){
                        sistema.rmMedico(dd[1]);
                        System.out.println(sistema);
                    }else if(dd[0].equals("rmPaciente")){
                        sistema.rmPaciente(dd[1]);
                        System.out.println(sistema);
                    }
                }catch(RuntimeException e){
                    System.out.println(e.getMessage());
                }
            }
        }
         System.out.println(sistema);
    }    
}

    
