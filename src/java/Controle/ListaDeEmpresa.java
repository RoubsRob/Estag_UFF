/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import DAO.Empresa;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Roberta
 */
public class ListaDeEmpresa {
        private ArrayList<Empresa> ListaDeEmpresa;
    
    public ListaDeEmpresa(){
        this.ListaDeEmpresa = new ArrayList();
    }
    public void adicionarEmpresa(Empresa empresa){
        ListaDeEmpresa.add(empresa);
    }
    public void adicionarTodosEmpresa(ResultSet resultado) throws SQLException{
        while (resultado.next()){
            Empresa empresa;
            empresa = new Empresa(resultado.getInt("id"),resultado.getString("login"),resultado.getString("senha"),resultado.getString("nome"),resultado.getInt("cnpj"));
            this.adicionarEmpresa(empresa);
            System.out.println("Entrou na lista de empresas");
            
        }
    }
   
    public ArrayList<Empresa> getListaDeEmpresa(){
        return this.ListaDeEmpresa;
    }
   
    public int getSize(){
        return this.ListaDeEmpresa.size();
    }
    public Empresa getEmpresa(int i){
        return this.ListaDeEmpresa.get(i);
    }
    
}


