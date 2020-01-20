/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.usm.orcosWeb.beans;

import cl.usm.orcosEJB.dao.GuerrerosDAOLocal;
import cl.usm.orcosEJB.dao.RangosDAOLocal;
import cl.usm.orcosEJB.dto.Guerrero;
import cl.usm.orcosEJB.dto.Rango;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

/**
 *
 * @author sarayar
 */
@Named(value = "editarGuerreroManagedBean")
@SessionScoped
public class EditarGuerreroManagedBean implements Serializable {

    private Guerrero guerreroEditado;
    private long rangoSeleccionado;
    private List<Rango> rangos;
    @Inject
    private RangosDAOLocal rangosDAO;
    
    @Inject
    private GuerrerosDAOLocal guerrerosDAO;
    /**
     * Creates a new instance of EditarGuerreroManagedBean
     */
    public EditarGuerreroManagedBean() {
    }
    
    @PostConstruct
    public void init(){
        this.rangos = rangosDAO.findAll();
    }
    
    public void actualizar(ActionEvent ev) throws IOException{
        //0. Actualizar rango (el RANGO ES UNA ENTIDAD RELACIONADA)
        this.guerreroEditado.setRango(this.rangosDAO.find(rangoSeleccionado));
        //1.Actualizar la BD
        this.guerrerosDAO.update(guerreroEditado);
        //2. Redirigir al Ver
        FacesContext.getCurrentInstance()
                .getExternalContext()
                .redirect("ver_tropas.xhtml");
    }

    public Guerrero getGuerreroEditado() {
        return guerreroEditado;
    }

    public void setGuerreroEditado(Guerrero guerreroEditado) {
        this.guerreroEditado = guerreroEditado;
    }

    public long getRangoSeleccionado() {
        return rangoSeleccionado;
    }

    public void setRangoSeleccionado(long rangoSeleccionado) {
        this.rangoSeleccionado = rangoSeleccionado;
    }

    public List<Rango> getRangos() {
        return rangos;
    }

    public void setRangos(List<Rango> rangos) {
        this.rangos = rangos;
    }
    
    
    
}
