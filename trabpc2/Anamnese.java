/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabpc2;

/**
 *
 * @author tinei
 */
public class Anamnese {

    private Paciente paciente;
    private String motivo;
    private String relato;
    private String diagnostico;
    private long id;

    public Anamnese(String motivo, String relato, String diagnostico, long id) {
        id++;
        this.motivo = motivo;
        this.relato = relato;
        this.diagnostico = diagnostico;
        this.id = id;

    }

 

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getRelato() {
        return relato;
    }

    public void setRelato(String relato) {
        this.relato = relato;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}