/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.websac.bean;

import br.com.websac.dao.ClienteDao;
import br.com.websac.entity.Cliente;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Frank
 */
@Named(value = "clienteBean")
@SessionScoped
public class ClienteBean implements Serializable {

    /**
     * Creates a new instance of ClienteBean
     */
    private Cliente cliente = new Cliente();
    private ClienteDao clienteDao = new ClienteDao();
    
    public String adicionarCliente(){
        clienteDao.salvar(cliente);
        return "Cliente";
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.cliente);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ClienteBean other = (ClienteBean) obj;
        if (!Objects.equals(this.cliente, other.cliente)) {
            return false;
        }
        return true;
    }
    
    public ClienteBean() {
    }
    
}
