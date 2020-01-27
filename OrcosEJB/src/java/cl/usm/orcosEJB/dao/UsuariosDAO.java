/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.usm.orcosEJB.dao;

import cl.usm.orcosEJB.dto.Usuario;
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
public class UsuariosDAO implements UsuariosDAOLocal {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("OrcosEJBPU");
    
    @Override
    public void add(Usuario usuario) {
    
        EntityManager em = this.emf.createEntityManager();
        try{
            em.persist(usuario);
            em.flush();
        }catch(Exception ex){
            
        }finally{
            em.close();
        }
    }

    @Override
    public List<Usuario> findAll() {
    
        EntityManager em = this.emf.createEntityManager();
        try{
            return em.createNamedQuery("Usuario.findAll", Usuario.class)
                    .getResultList();
        }catch(Exception ex){
            return null;
        }finally{
            em.close();
        }
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public Usuario findByCorreoYClave(String correo, String clave) {
           EntityManager em = this.emf.createEntityManager();
        try{
            return em.createNamedQuery("Usuario.findByCorreoYClave", Usuario.class)
                    .setParameter("correo", correo)
                    .setParameter("clave", clave)
                    .getSingleResult();
        }catch(Exception ex){
            return null;
        }finally{
            em.close();
        }
    }
}
