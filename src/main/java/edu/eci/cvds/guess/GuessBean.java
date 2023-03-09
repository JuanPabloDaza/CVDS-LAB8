package edu.eci.cvds.guess;

import java.util.jar.Attributes.Name;

import javax.annotation.ManagedBean;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "guessBean")
@ApplicationScoped

public class GuessBean {
    private int number;
    private int trys;
    private int prize;
    private String state;


    public GuessBean() {

    }

    public int getNumber(){
        return number;
    }

    public int getTrys(){
        return trys;
    }

    public int getPrizes(){
        return prize;
    }

    public String getState(){
        return state;
    }

    public void setNumber(int number){
        this.number=number;
    }
    public void setTrys(int trys){
        this.trys=trys;
    }
    public void setprize(int prize){
        this.prize=prize;
    }
    public void setState(String state){
        this.state=state;
    }
}
