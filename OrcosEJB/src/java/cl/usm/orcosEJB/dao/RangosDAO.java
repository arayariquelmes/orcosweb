/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.usm.orcosEJB.dao;

import cl.usm.orcosEJB.dto.Rango;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author sarayar
 */
@Stateless
public class RangosDAO implements RangosDAOLocal {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("OrcosEJBPU");
    
    @Override
    public List<Rango> findAll() {
    
        //Identico al patron DAO
        EntityManager em = emf.createEntityManager();
        try{
            return em.createNamedQuery("Rango.findAll", Rango.class).getResultList();
        }catch(Exception ex){
            return null;
        }finally{
            em.close();
        }
    }

    @Override
    public void add(Rango r) {
        EntityManager em = emf.createEntityManager();
        try{
            em.persist(r);
        }catch(Exception ex){
            
        }finally{
            em.close();
        }
    }

    @Override
    public void delete(Long id) {
        EntityManager em = emf.createEntityManager();
        try{
            em.remove(em.find(Rango.class, id));
        }catch(Exception ex){
            
        }finally{
            em.close();
        }
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public Rango find(long l) {
        EntityManager em = emf.createEntityManager();
        try{
            return em.find(Rango.class, l); //select * from rangos where id=? ,
        }catch(Exception ex){
            return null;
        } finally{
            em.close(); //los objetos asociados a ese em son detached, extraidos del contexto de persistencia
        }
    }
}
