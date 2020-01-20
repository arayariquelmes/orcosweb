/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.usm.orcosWeb.beans;

import cl.usm.orcosEJB.dao.GuerrerosDAOLocal;
import cl.usm.orcosEJB.dto.Guerrero;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

/**
 *
 * @author sarayar
 */
@Named(value = "verGuerrerosManagedBean")
@ViewScoped
public class VerGuerrerosManagedBean implements Serializable {

    @Inject
    private EditarGuerreroManagedBean editarBean;
    
    @Inject
    private GuerrerosDAOLocal guerrerosDAO;
    private List<Guerrero> guerreros;
    /**
     * Creates a new instance of VerGuerrerosManagedBean
     */
    public VerGuerrerosManagedBean() {
    }
    
    //TODO: Agregar despues un filtro por rango
    @PostConstruct
    public void init(){
        this.guerreros = this.guerrerosDAO.findAll();
    }

    public List<Guerrero> getGuerreros() {
        return guerreros;
    }

    public void setGuerreros(List<Guerrero> guerreros) {
        this.guerreros = guerreros;
    }
    
    public void editarGuerrero(Guerrero editado) throws IOException{
        //1. Asignar el guerrero seleccionado al que va a ser editado
        this.editarBean.setGuerreroEditado(editado);
        this.editarBean.setRangoSeleccionado(editado.getRango().getId());
        //2. Redirigir a editar_orco para el proceso de edición
        FacesContext.getCurrentInstance()
                .getExternalContext().redirect("editar_orco.xhtml");
    }
    
    public void eliminarGuerrero(Guerrero eliminado){
        //Eliminar de la bd
        this.guerrerosDAO.delete(eliminado.getId());
        //Mostrar mensaje guerrero eliminado
        FacesContext.getCurrentInstance()
                .addMessage(null
                        , new FacesMessage("Guerrero asesinado por la aparición"));
        //Recargar la lista
        this.guerreros = this.guerrerosDAO.findAll();
        
    }
    
}
