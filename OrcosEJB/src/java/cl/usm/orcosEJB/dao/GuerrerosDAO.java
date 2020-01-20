/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.usm.orcosEJB.dao;

import cl.usm.orcosEJB.dto.Guerrero;
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
public class GuerrerosDAO implements GuerrerosDAOLocal {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("OrcosEJBPU");
    
    @Override
    public List<Guerrero> findAll() {
    
        EntityManager em = emf.createEntityManager();
        try{
            return em.createNamedQuery("Guerrero.findAll", Guerrero.class)
                    .getResultList();
            
        }catch(Exception ex){
            System.out.println("ERROR " + ex);
            return null;
        }finally{
            em.close();
        }
    }

    @Override
    public Guerrero add(Guerrero g) {
        EntityManager em = emf.createEntityManager();
        try{
            //volver el objeto rango al contexto de persistencia
            g.setRango(em.merge(g.getRango()));
            em.persist(g);
            return g;
        }catch(Exception ex){
            return null;
        }finally{
            em.close();
        }
    }

    @Override
    public void delete(long id) {
        EntityManager em = emf.createEntityManager();
        try{
            em.remove(em.find(Guerrero.class,id));
        }catch(Exception ex){
            
        }finally{
            em.close();
        }
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public void update(Guerrero g) {
          EntityManager em = emf.createEntityManager();
        try{
            em.merge(g);
            em.flush();
        }catch(Exception ex){
            
        }finally{
            em.close();
        }
    }
}
