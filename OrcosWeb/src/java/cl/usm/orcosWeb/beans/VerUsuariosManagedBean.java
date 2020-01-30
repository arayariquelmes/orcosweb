/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.usm.orcosWeb.beans;

import cl.usm.orcosEJB.dao.UsuariosDAOLocal;
import cl.usm.orcosEJB.dto.Usuario;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

/**
 *
 * @author sarayar
 */
@Named(value = "verUsuariosManagedBean")
@ViewScoped
public class VerUsuariosManagedBean implements Serializable{

    private List<Usuario> usuarios;
    @Inject
    private UsuariosDAOLocal usuariosDAO;
    /**
     * Creates a new instance of VerUsuariosManagedBean
     */
    public VerUsuariosManagedBean() {
    }
    
    @PostConstruct
    public void init(){
        this.usuarios = this.usuariosDAO.findAll();
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
    
    
}
