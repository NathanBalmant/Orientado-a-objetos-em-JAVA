/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabpc2;

/**
 *
 * @author tinei
 */
public class Paciente {
    
    private String nome;
    private String nomeMae;
    private Enum sexo;
    private Anamnese anamneseDoPaciente;
    private Endereco end;
    private long numCNS ;
     private static long gerarnumCNS=-1 ;
    private String dataNascimento;
    
    public Paciente(String nome, String nomemae, Enum sexo,  String dataNasc) {
        gerarnumCNS++;
        this.nome = nome;
        this.nomeMae = nomemae;
        this.sexo = sexo;
        this.numCNS = gerarnumCNS;
        this.dataNascimento = dataNasc;
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getNomeMae() {
        return nomeMae;
    }
    
    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }
    
    public Enum getSexo() {
        return sexo;
    }
    
    public void setSexo(Enum sexo) {
        this.sexo = sexo;
    }
    
    public Anamnese getAnamneseDoPaciente() {
        return anamneseDoPaciente;
    }
    
    public void setAnamneseDoPaciente(Anamnese anamneseDoPaciente) {
        this.anamneseDoPaciente = anamneseDoPaciente;
    }
    
    public Endereco getEnd() {
        return end;
    }
    
    public void setEnd(Endereco end) {
        this.end = end;
    }
    
    public long getNumCNS() {
        return numCNS;
    }
    
    public void setNumCNS(long numCNS) {
        this.numCNS = numCNS;
    }
    
    public String getDataNascimento() {
        return dataNascimento;
    }
    
    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    
    public void adicionarEndereco(Paciente p, Endereco e) {
        if (end != null) {
            p.end.setCidade(p.end.getCidade());
            p.end.setLogradouro(p.end.getLogradouro());
            p.end.setNumero(p.end.getNumero());
            p.end.setUf(p.end.getUf());
        }
    }
    
}
