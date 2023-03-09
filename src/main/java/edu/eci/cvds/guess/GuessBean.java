package edu.eci.cvds.guess;

import java.util.ArrayList;
import java.util.jar.Attributes.Name;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "guessBean")
@SessionScoped

public class GuessBean {
    private int number;
    private int trys;
    private int prize;
    private String state;
    private int guessNumber;
    private ArrayList<Integer> numberList = new ArrayList<>();


    public GuessBean() {
        prize=100000;
        trys=0;
        state="Playing";
        number=(int)((Math.random()*(10-1))+1);
    }

    public int getNumber(){
        return number;
    }

    public int getGuessNumber(){
        return guessNumber;
    }

    public int getTrys(){
        return trys;
    }

    public int getPrize(){
        return prize;
    }

    public String getState(){
        return state;
    }

    public ArrayList<Integer> getNumberList(){
        return numberList;
    }

    public void setNumber(int number){
        this.number=number;
    }

    public void setGuessNumber(int guessNumber){
        this.guessNumber=guessNumber;
    }
    public void setTrys(int trys){
        this.trys=trys;
    }
    public void setPrize(int prize){
        this.prize=prize;
    }
    public void setState(String state){
        this.state=state;
    }

    public void guess(){
        if(guessNumber==number && !getState().equals("Loser")){
            setState("Winner");

        }
        else if(!getState().equals("Loser")){
            numberList.add(guessNumber);
            setTrys(getTrys()+1);
            setPrize(getPrize()-10000);
            if(getPrize()<1){
                setState("Loser");
            }
            
        }
    }
    public void restart(){
        numberList.clear();
        setPrize(100000);
        setTrys(0);
        setState("Playing");
        setNumber((int)((Math.random()*(10-1))+1));
    }
}
