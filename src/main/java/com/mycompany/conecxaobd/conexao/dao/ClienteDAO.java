/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.conecxaobd.conexao.dao;

import com.mycompany.conecxaobd.conexao.entidade.Cliente;
import com.mycompany.conecxaobd.conexao.ConexaoBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rrmat
 */
public class ClienteDAO {
    
    public static List<Cliente> getClientes() throws SQLException, ClassNotFoundException{
        List<Cliente> clientes = new ArrayList<>();
        
        String query = "Select * from cliente";
        Connection con;
        
        try {
        con = ConexaoBD.getConexao();
        PreparedStatement ps = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        
        while(rs.next()){
            String nome = rs.getString("nome");
            String email = rs.getString("email");
            String cpf = rs.getString("cpf");
            Cliente cliente = new Cliente(nome,email, cpf);
            clientes.add(cliente);
            
        }
        
        } catch (Exception e) {
        }
       
        
        
        return clientes;
    }
   
}
