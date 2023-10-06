/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class ConectaBanco {
	private String url, usuario, senha;
	private Connection con;
	
	public ConectaBanco(){
		url = "jdbc:postgresql://localhost:5432/postgres";
		usuario = "postgres";
		senha = "maria";
		try {	
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection(url, usuario, senha);	
			System.out.println("Conexão realizada com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
        
        public boolean validaDados (String campo1, String campo2 ){
            
            if (!campo1.trim().equals("") && !campo2.trim().equals("")){
                
                return true;
                
            }
            
            JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
            
            return false;
        }
	
	public int executaSql(String sql){
		int res = 0;
		try{
			Statement s = con.createStatement();
			res = s.executeUpdate(sql);			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return res;
	}
       public ResultSet buscaDados(String sql){ 
		try{
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);
			return rs;
		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
       
       public void finalizaConexao(){
           try{
               con.close();
           }
           catch(Exception e){
               e.printStackTrace();
           }
       }
}


