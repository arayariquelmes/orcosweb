/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.usm.orcosWeb.beans;

import cl.usm.orcosEJB.dao.RangosDAOLocal;
import cl.usm.orcosEJB.dto.Rango;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
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
@Named(value = "rangosManagedBean")
@ViewScoped
public class RangosManagedBean implements Serializable {

    private String nombreRango;
    //inyeccion de dependencias
    @Inject
    private RangosDAOLocal rangosDAO;
    
    private List<Rango> rangos = new ArrayList<>();
    /**
     * Creates a new instance of RangosManagedBean
     */
    public RangosManagedBean() {
    }
    
    //se ejecuta justo cuando se termina de construir la clase
    //aqui ya ocurrió la inyección de dependencias
    @PostConstruct
    public void init(){
        this.rangos = rangosDAO.findAll();
    }

    public List<Rango> getRangos() {
        return rangos;
    }

    public void setRangos(List<Rango> rangos) {
        this.rangos = rangos;
    }

    
    
    
    public String getNombreRango() {
        return nombreRango;
    }

    public void setNombreRango(String nombreRango) {
        this.nombreRango = nombreRango;
    }
    
    public void registrar(ActionEvent e){
        
        Rango rango = new Rango();
        rango.setNombre(nombreRango);
        rangosDAO.add(rango);
        //recargando la lista
        this.rangos = rangosDAO.findAll();
        //envia un mensaje de exito, se esta cargando en p:messages
        FacesContext.getCurrentInstance().addMessage(null
                , new FacesMessage("Rango registrado exitosamente"));
    }

    
    
    
    
}
