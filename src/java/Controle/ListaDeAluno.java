/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import DAO.Aluno;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Roberta
 */

public class ListaDeAluno {
        private ArrayList<Aluno> ListaDeAluno;
    
    public ListaDeAluno(){
        this.ListaDeAluno = new ArrayList();
    }
    public void adicionarAluno(Aluno aluno){
        ListaDeAluno.add(aluno);
    }
    public void adicionarTodosAluno(ResultSet resultado) throws SQLException{
        while (resultado.next()){
            Aluno aluno;
            aluno = new Aluno(resultado.getInt("id"),resultado.getString("login"),resultado.getString("senha"),resultado.getString("nome"),resultado.getInt("cargaHoraria"),resultado.getString("matricula"));
            this.adicionarAluno(aluno);
            System.out.println("Entrou na lista de alunos");
            
        }
    }
   
    public ArrayList<Aluno> getListaDeAluno(){
        return this.ListaDeAluno;
    }
   
    public int getSize(){
        return this.ListaDeAluno.size();
    }
    public Aluno getAluno(int i){
        return this.ListaDeAluno.get(i);
    }
    
}


