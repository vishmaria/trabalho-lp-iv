/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.swing.JOptionPane;
import model.ConectaBanco;

/**
 *
 * @author Ave Maria
 */
public class Controller {

    
    String campo1, campo2;
    ConectaBanco cb =  new ConectaBanco();

    public Controller(String campo1, String campo2) {
        this.campo1 = campo1;
        this.campo2 = campo2;
    }
    
    
    public void enviaDados(){
        if (cb.validaDados(campo1, campo2)){
            
            String sql = "insert into ex(nome, email) values "
                    + "('"+campo1+"','"+campo2+"' )" ;
            
            cb.executaSql(sql);
            
            JOptionPane.showMessageDialog(null, "Dados inseridos com sucesso!");
            
        }
    }
    
    public void excluiDados(){
        
        
    }
    
    public void atualizaDados(){
        
    }
}
