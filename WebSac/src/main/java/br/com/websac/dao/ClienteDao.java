/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.websac.dao;

import br.com.websac.entity.Cliente;
import br.com.websac.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Frank
 */
public class ClienteDao {

    private Session sessao;
    private Transaction trans;

    public void salvar(Cliente c) {
        try {

            sessao = HibernateUtil.getSessionFactory().openSession();
            trans = sessao.beginTransaction();

            Cliente cliente = new Cliente();
            cliente.setNome(c.getNome());
            cliente.setIdade(c.getIdade());

            sessao.save(cliente);
            trans.commit();
        } catch (HibernateException e) {
        } finally {
            sessao.close();
        }
    }
}
