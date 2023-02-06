/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabpc2;

/**
 *
 * @author tinei
 */
public class Sistema {
    private static Sistema instance;
    
    private Sistema(){
        
    }

    

    public static Sistema getInstance(){
        if (instance == null){
            instance = new Sistema();
        }
        return instance;
    }
    
    private Usuario usuarios[] = new Usuario[10];
    private Paciente paciente[] = new Paciente[10];
    private Anamnese anamneses[] = new Anamnese[10];
    private Usuario u = new Usuario("", "", "", 0, Tipo.Medico);
    private Endereco end = new Endereco("", 0, "", "");
    private Paciente p = new Paciente("s", "q", Sexo.I,  "10/10/2010");
    private Anamnese a = new Anamnese("", "", "", 0);
    private Anamnese aBuscada = new Anamnese("", "", "", 0);
    
    boolean adicionarPaciente(Paciente p) {
        if (p != null) {
            for (int i = 0; i < paciente.length; i++) {
                if (paciente[i] != null && paciente[i].getNomeMae().equals(p.getNomeMae())) {
                    return false;
                }
                if (paciente[i] == null) {
                    paciente[i] = p;
                    return true;
                }
                
            }
            
            return true;
            
        } else {
            return false;
        }
        
    }
    
     boolean adicionarUsuario(Usuario u) {
        if (u != null) {

            for (int j = 0; j < anamneses.length; j++) {
                if (usuarios[j] != null && (u.getNomeLogin()).equals(usuarios[j].getNomeLogin()) && (u.getSenha()).equals(usuarios[j].getSenha())) {
                    return false;
                }
            }

            for (int i = 0; i < usuarios.length; i++) {
                if (usuarios[i] == null) {
                    usuarios[i] = u;
                    return true;
                }
            }
        }
        return false;
    }

    Usuario conferirlogin(String senha2, String login2) {

        for (int i = 0; i < usuarios.length; i++) {
            if (usuarios[i] != null) {
                if (usuarios[i].getNomeLogin().equals(login2) && usuarios[i].getSenha().equals(senha2) && usuarios[i].getTipo() == Tipo.Medico) {

                    return usuarios[i];

                }
            }
        }

        return null;

    }

    boolean getTipoUsuario(Usuario u) {
        if (u != null) {
            if (u.getTipo() == Tipo.Medico) {
                return true;
            }
        }
        return false;
    }
    
    boolean alterarPaciente(Paciente pAlterado) {
        if (pAlterado != null) {
            for (int i = 0; i < paciente.length; i++) {
                if (paciente[i].getNumCNS() == pAlterado.getNumCNS()) {
                    paciente[i].setNome(pAlterado.getNome());
                    paciente[i].setNomeMae(pAlterado.getNomeMae());
                    paciente[i].setSexo(pAlterado.getSexo());
                    paciente[i].setEnd(pAlterado.getEnd());
                   // paciente[i].getEnd().ge
                    // paciente[i].end.numero = pAlterado.end.numero;
                    // paciente[i].end.logradouro = pAlterado.end.logradouro;
                    // paciente[i].end.uf = pAlterado.end.uf;
                    paciente[i].setDataNascimento(pAlterado.getDataNascimento());
                    return true;
                }
            }
            return true;
        } else {
            return false;
        }
        
    }
    
    boolean alterarAnamnese(Anamnese aAlterada) {
        if (aAlterada != null) {
            for (int i = 0; i < anamneses.length; i++) {
                if (anamneses[i].getId() == aAlterada.getId()) {
                    anamneses[i].setDiagnostico(aAlterada.getDiagnostico());
                    anamneses[i].setMotivo(aAlterada.getMotivo());
                    anamneses[i].setRelato(aAlterada.getRelato());
                    
                    return true;
                }
            }
            return true;
        } else {
            return false;
        }
        
    }
    
    boolean adicionarAnamnese(Anamnese a) {
        if (a != null) {
            for (int i = 0; i < anamneses.length; i++) {
                if (anamneses[i] == null) {
                    anamneses[i] = a;
                    return true;
                }
                
            }
            
            return true;
            
        } else {
            return false;
        }
        
    }
    
    void adicionarAnamneseAopaciente(Paciente[] pacientes, Anamnese anamnese, long num, Sistema sist) {
        for (int i = 0; i < pacientes.length; i++) {
            if (pacientes[i] != null) {
                if (pacientes[i].getNumCNS() == num) {
                    pacientes[i].setAnamneseDoPaciente(anamnese);
                    anamnese.setId(pacientes[i].getNumCNS());
                    sist.adicionarAnamnese(anamnese);
                }
                
            }
            
        }
    }
    
    boolean excluirPaciente(long numCNS) {
        if (numCNS >= 0) {
            for (int i = 0; i < paciente.length; i++) {
                if (paciente[i] != null) {
                    if (paciente[i].getNumCNS() == numCNS && paciente[i].getAnamneseDoPaciente() != null) {
                        return false;
                    }
                    if (paciente[i].getNumCNS() == numCNS) {
                        paciente[i] = null;
                        return true;
                    }
                    
                }
                
            }
            return true;
        } else {
            return false;
        }
    }
    
    boolean excluirAnamnese(long id) {
        if (id >= 0) {
            for (int i = 0; i < anamneses.length; i++) {
                if (anamneses[i] != null) {
                    if (anamneses[i].getId() == id) {
                        anamneses[i] = null;
                        return true;
                    }
                } else {
                    return false;
                }
                
            }
        } else {
            return false;
        }
        return true;
    }
    
    Paciente buscarPaciente(long numCNS) {
        if (numCNS >= 0) {
            for (int i = 0; i < paciente.length; i++) {
                if (paciente[i] != null) {
                    if (paciente[i].getNumCNS() == numCNS) {
                        
                        p.setNumCNS(paciente[i].getNumCNS());
                        p.setNomeMae(paciente[i].getNomeMae());
                        p.setSexo(paciente[i].getSexo());
                        p.setEnd(paciente[i].getEnd());
                        p.setNome(paciente[i].getNome());
                        p.setAnamneseDoPaciente(paciente[i].getAnamneseDoPaciente());
                        
                    }
                    
                }
                
            }
            
        }
        return p;
    }
    
    Anamnese buscarAnamnese(String nome) {
        if (nome != null) {
            for (int i = 0; i < paciente.length; i++) {
                if (paciente[i] != null) {
                    if (nome.equals(paciente[i].getNome())) {
                        
                        a.setDiagnostico(paciente[i].getAnamneseDoPaciente().getDiagnostico());
                        a.setId(paciente[i].getAnamneseDoPaciente().getId());
                        a.setMotivo(paciente[i].getAnamneseDoPaciente().getMotivo());
                        a.setRelato(paciente[i].getAnamneseDoPaciente().getRelato());
                        
                    }
                    
                }
                
            }
            
        }
        return a;
    }
    
    Anamnese buscarAnamnesePorNum(long num) {
        if (num >= 0) {
            for (int i = 0; i < paciente.length; i++) {
                if (paciente[i] != null) {
                    if (num == paciente[i].getNumCNS()) {
                        
                        aBuscada.setDiagnostico(paciente[i].getAnamneseDoPaciente().getDiagnostico());
                        aBuscada.setId(paciente[i].getAnamneseDoPaciente().getId());
                        aBuscada.setMotivo(paciente[i].getAnamneseDoPaciente().getMotivo());
                        aBuscada.setRelato(paciente[i].getAnamneseDoPaciente().getRelato());
                        
                    }
                    
                }
                
            }
            
        }
        return aBuscada;
    }
    
    Usuario[] listarUsuarios() {
        return usuarios;
    }
    
    Anamnese[] listarAnamnese() {
        return anamneses;
    }
    
    Paciente[] listarPacientes() {
        return paciente;
        
    }
    
    void init() {
        Paciente p1 = new Paciente("João", "Tânia", Sexo.M,  "15/09/2000");
        Endereco end = new Endereco("Rua 50", 5, "Timoteo", "MG");
        
        p1.setEnd(end);
        //p1.end.cidade = "Timoteo";
        //p1.end.logradouro = "Rua 50";
        //p1.end.numero = 5;
        //p1.end.uf = "MG";
        adicionarPaciente(p1);
        
        Paciente p2 = new Paciente("Maria", "Marta", Sexo.F,  "12/09/1999");
        Endereco end2 = new Endereco("Rua 30", 25, "São Paulo", "SP");
        
        p2.setEnd(end2);
        //p2.end.cidade = "São Paulo";
        //p2.end.logradouro = "Rua 30";
        //p2.end.numero = 25;
        //p2.end.uf = "SP";
        adicionarPaciente(p2);
        
        Paciente p3 = new Paciente("Paula", "Jessila", Sexo.F,  "22/10/2004");
        Endereco end3 = new Endereco("Rua da Paz", 556, "Manaus", "AM");
        
        p3.setEnd(end3);
        // p3.end.cidade = "Manaus";
        // p3.end.logradouro = "Rua da Paz";
        // p3.end.numero = 556;
        // p3.end.uf = "AM";
        adicionarPaciente(p3);
        
        Paciente p4 = new Paciente("Maria", "Cassandra", Sexo.I,  "20/08/2000");
        Endereco end4 = new Endereco("Rua do tiro", 157, "Rio de Janeiro", "RJ");
        
        p4.setEnd(end4);
        // p4.end.cidade = "Rio de Janeiro";
        //p4.end.logradouro = "Rua do tiro";
        //p4.end.numero = 157;
        //p4.end.uf = "RJ";
        adicionarPaciente(p4);
        
        Paciente p5 = new Paciente("Luke", "Idiene", Sexo.M,  "20/09/1975");
        Endereco end5 = new Endereco("Rua Fria", 788, "Porto Alegre", "RS");
        
        p5.setEnd(end5);
        //p5.end.cidade = "Porto Alegre";
        //p5.end.logradouro = "Rua Fria";
        //p5.end.numero = 788;
        //p5.end.uf = "RS";
        adicionarPaciente(p5);
        
        Anamnese a1 = new Anamnese("Caiu de Bike", "Bateu no poste", "Muito Ferido", 1);
        adicionarAnamneseAopaciente(paciente, a1, a1.getId(), this);
        
        Anamnese a2 = new Anamnese("Ralou joelho", "Caiu no chão", "Pouco Ferido", 2);
        adicionarAnamneseAopaciente(paciente, a2, a2.getId(), this);
        
        Anamnese a3 = new Anamnese("Dividiu a perna", "Jogou bola", "Estado grave", 3);
        adicionarAnamneseAopaciente(paciente, a3, a3.getId(), this);
        
        Usuario u1 = new Usuario("Geraldo", "Geraldo123", "157Geraldo", 20356, Tipo.Medico);
        adicionarUsuario(u1);
        
        Usuario u2 = new Usuario("Luiza", "LuizaPAP", "Amor", 200, Tipo.Atendente);
        adicionarUsuario(u2);
        
    }
}