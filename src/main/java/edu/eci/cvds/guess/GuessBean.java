package edu.eci.cvds.guess;

import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import edu.eci.cvds.service.ConfigurationService;

@Component
@ManagedBean(name = "guessBean")
@SessionScoped

public class GuessBean implements Serializable{

    ConfigurationService configurationService;
    private int number;
    private int trys;
    private int prize;
    private String state;
    private int guessNumber;
    private ArrayList<Integer> numberList = new ArrayList<>();
    
    public GuessBean() {
        
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

    @Bean
    public CommandLineRunner premio(){
        return args -> {
            configurationService.addConfiguration(new Configuration("Premio","100"));
            configurationService.getAllConfigurations().forEach(configuration -> System.out.println(configuration));
            prize = Integer.valueOf(configurationService.getAllConfigurations().get(0).getValor());
        };
    }

    public void restart(){
        numberList.clear();
        setPrize(100000);
        setTrys(0);
        setState("Playing");
        setNumber((int)((Math.random()*(10-1))+1));
    }
}
