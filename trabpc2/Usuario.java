/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabpc2;

/**
 *
 * @author tinei
 */
public class Usuario {

    private long id;
    private String nome;
    private String nomeLogin;
    private String senha;
    private Enum tipo;
    private static long geradorid;

    public Usuario(String nome, String nomelogin, String senha, long id, Enum tipo) {
        geradorid++;
        this.nome = nome;
        this.nomeLogin = nomelogin;
        this.senha = senha;
        this.id = id;
        this.tipo = tipo;
    }
    
    

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeLogin() {
        return nomeLogin;
    }

    public void setNomeLogin(String nomeLogin) {
        this.nomeLogin = nomeLogin;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Enum getTipo() {
        return tipo;
    }

    public void setTipo(Enum tipo) {
        this.tipo = tipo;
    }

}