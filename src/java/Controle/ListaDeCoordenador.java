/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import DAO.Coordenador;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Roberta
 */
public class ListaDeCoordenador {
        private ArrayList<Coordenador> ListaDeAdmin;
    
    public ListaDeCoordenador(){
        this.ListaDeAdmin = new ArrayList();
    }
    public void adicionarAdmin(Coordenador administrador){
        ListaDeAdmin.add(administrador);
    }
    public void adicionarTodosAdmin(ResultSet resultado) throws SQLException{
        while (resultado.next()){
            Coordenador administrador;
            administrador = new Coordenador(resultado.getInt("id"),resultado.getString("login"),resultado.getString("senha"),resultado.getString("nome"));
            this.adicionarAdmin(administrador);
            
            System.out.println("Entrou na lista de adm");
            
        }
    }
    public ArrayList<Coordenador> getListaDeAdmin(){
        return this.ListaDeAdmin;
    }
   
    public int getSize(){
        return this.ListaDeAdmin.size();
    }
    public Coordenador getCoordenador(int i){
        return this.ListaDeAdmin.get(i);
    }
    
}
