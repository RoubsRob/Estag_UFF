/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author Roberta
 */
public class Coordenador {
    private int id;
    private String login;
    private String nome;
    private String senha;

    public Coordenador(int id,String login, String senha, String nome) {
        this.id = id;
        this.login = login;
        this.nome = nome;
        this.senha = senha;
    }
    
    public Coordenador(){
        
    }

    public Coordenador(String login, String senha){
        this.login = login;
        this.senha = senha;
        
    }
    
    
    public String getLogin() {
        return login;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    
    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
}
