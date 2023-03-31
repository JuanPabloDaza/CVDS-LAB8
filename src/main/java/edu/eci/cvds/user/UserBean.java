package edu.eci.cvds.user;

import javax.annotation.ManagedBean;
import org.springframework.stereotype.Component;

@Component
@ManagedBean
public class UserBean {
    private String name;

    public UserBean(){
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
    
}
