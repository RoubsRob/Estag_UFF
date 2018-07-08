/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import DAO.Vaga;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Roberta
 */
public class ListaDeVaga {
    private ArrayList<Vaga> ListaDeVaga;
    
    public ListaDeVaga(){
        this.ListaDeVaga = new ArrayList();
    }
    public void adicionarVaga(Vaga vaga){
        ListaDeVaga.add(vaga);
    }
    public void adicionarTodosVaga(ResultSet resultado) throws SQLException{
        while (resultado.next()){
            Vaga vaga;
            vaga = new Vaga(resultado.getInt("id"),resultado.getInt("publicada"),resultado.getInt("area"));
            this.adicionarVaga(vaga);
            System.out.println("Entrou na lista de vagas");
            
        }
    }
   
    public ArrayList<Vaga> getListaDeVaga(){
        return this.ListaDeVaga;
    }
   
    public int getSize(){
        return this.ListaDeVaga.size();
    }
    public Vaga getVaga(int i){
        return this.ListaDeVaga.get(i);
    }
    
}


