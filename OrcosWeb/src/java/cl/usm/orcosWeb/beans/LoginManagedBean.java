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
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

/**
 *
 * @author sarayar
 */
@Named(value = "loginManagedBean")
@SessionScoped
public class LoginManagedBean implements Serializable {

    @Inject
    private UsuariosDAOLocal usuariosDAO;
    private Usuario usuarioLogueado;
    private String usuario;
    private String clave;

    public Usuario getUsuarioLogueado() {
        return usuarioLogueado;
    }

    public void setUsuarioLogueado(Usuario usuarioLogueado) {
        this.usuarioLogueado = usuarioLogueado;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
    
    public void iniciarSesion(ActionEvent ev) throws IOException{
        String claveHash = PasswordUtils.generateSecurePassword(clave
                , UtilsConstants.SALT);
        this.usuarioLogueado = this.usuariosDAO.findByCorreoYClave(usuario
                , claveHash);
        //Si el usuario logueado no es nulo, el usuario existe, y si existe redirijo
        if(this.usuarioLogueado != null){
          //redirigir
            FacesContext.getCurrentInstance()
                    .getExternalContext()
                    .redirect("index.xhtml");
        } else {
            FacesContext.getCurrentInstance()
                    .addMessage(null
                            , new FacesMessage(FacesMessage.SEVERITY_ERROR
                                    , "Ingreso fallido"
                                    , "Credenciales incorrectas"));
        }
    }
    public void cerrarSesion(ActionEvent ev) throws IOException{
        this.usuarioLogueado = null;
        FacesContext.getCurrentInstance()
                .getExternalContext()
                .redirect("login.xhtml");
    }
    /**
     * Creates a new instance of LoginManagedBean
     */
    public LoginManagedBean() {
    }
    
}
