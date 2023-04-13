package edu.eci.cvds.guess;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "CONFIGURATION")
public class Configuration {

    @Id
    @Column(name = "PROPIEDAD")
    private String id;
    @Column(name = "VALOR")
    private String valor;

    public Configuration(){
    }

    public Configuration(String id, String valor){
        this.id=id;
        this.valor=valor;
        
    }

    public String getId(){
        return id;
    }

    public String getValor(){
        return valor;
    }
    
    public void setId(String propiedad){
        this.id=propiedad;
    }
    
    public void setValor(String valor){
        this.valor=valor;
    }
}
