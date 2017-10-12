/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.websac.dao;

import br.com.websac.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Frank
 * @param <Entidade>
 */
public class GenericDao <Entidade> {
    public void salva(Entidade entidade){
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction transacao = null;
        
        try{
            
            transacao = sessao.beginTransaction();
            sessao.save(entidade);
            transacao.commit();
        }
        catch (RuntimeException e){
            if(transacao != null){
                transacao.rollback();
                
            }throw e;
        }finally{
            sessao.close();
        }
    }
}
