package cl.usm.orcosEJB.dto;

import cl.usm.orcosEJB.dto.Guerrero;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-01-13T13:59:35")
@StaticMetamodel(Rango.class)
public class Rango_ { 

    public static volatile SingularAttribute<Rango, Long> id;
    public static volatile SingularAttribute<Rango, String> nombre;
    public static volatile ListAttribute<Rango, Guerrero> guerreros;

}