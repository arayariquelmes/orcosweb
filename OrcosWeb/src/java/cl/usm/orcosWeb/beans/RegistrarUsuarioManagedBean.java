/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.usm.orcosWeb.beans;

import cl.usm.orcosEJB.dao.UsuariosDAOLocal;
import cl.usm.orcosEJB.dto.Usuario;
import cl.usm.orcosWeb.utils.PasswordUtils;
import cl.usm.orcosWeb.utils.UtilsConstants;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

/**
 *
 * @author sarayar
 */
@Named(value = "registrarUsuarioManagedBean")
@ViewScoped
public class RegistrarUsuarioManagedBean implements Serializable {

    @Inject
    private UsuariosDAOLocal usuariosDAO;
    
    private String nombre;
    private String clave;
    private String correo;

    public void registrar(ActionEvent e){
        String hash = PasswordUtils.generateSecurePassword(clave
                , UtilsConstants.SALT);
        Usuario usuario = new Usuario();
        usuario.setNombre(nombre);
        usuario.setCorreo(correo);
        usuario.setClave(hash);
        usuario.setEstado(1);
        usuariosDAO.add(usuario);
        FacesContext.getCurrentInstance().addMessage(null
                ,new FacesMessage("Usuario Registrado exitosamente") );
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    /**
     * Creates a new instance of RegistrarUsuarioManagedBean
     */
    public RegistrarUsuarioManagedBean() {
    }
    
}
