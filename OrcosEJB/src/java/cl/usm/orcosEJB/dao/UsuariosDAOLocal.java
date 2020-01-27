/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.usm.orcosEJB.dao;

import cl.usm.orcosEJB.dto.Usuario;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author sarayar
 */
@Local
public interface UsuariosDAOLocal {
    
    void add(Usuario usuario);
    List<Usuario> findAll();
    Usuario findByCorreoYClave(String correo, String clave);
}
