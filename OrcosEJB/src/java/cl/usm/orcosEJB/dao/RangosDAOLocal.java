/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.usm.orcosEJB.dao;

import cl.usm.orcosEJB.dto.Rango;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author sarayar
 */
@Local
public interface RangosDAOLocal {
    public List<Rango> findAll();
    public void add(Rango r);
    public void delete(Long id);
    public Rango find(long id);
}
