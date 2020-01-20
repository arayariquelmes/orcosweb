/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.usm.orcosEJB.dao;

import cl.usm.orcosEJB.dto.Guerrero;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author sarayar
 */
@Local
public interface GuerrerosDAOLocal {
    public List<Guerrero> findAll();
    public Guerrero add(Guerrero g);
    public void delete(long id);
    public void update(Guerrero g);
}
