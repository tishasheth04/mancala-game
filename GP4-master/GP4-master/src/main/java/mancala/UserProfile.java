package mancala;

import java.io.Serializable;

public class UserProfile implements Serializable {
    private static final long serialVersionUID = 12345678;
    private String name = " ";
    private int numberOfKalah;
    private int numberOfAyo;
    private int numberOfKalahWon;
    private int numberOfAyoWon;
    
    public UserProfile(){
        numberOfAyo = 0;
        numberOfAyoWon = 0;
        numberOfKalah = 0;
        numberOfKalahWon = 0;

    }
    public String getNameOfPlayer(){
        return name;
    }
    public void setNameOfPlayer(final String nameOfPlayer){
        name = nameOfPlayer;
    }
    
    public int getNumberOfKalahPlayed(){
        return numberOfKalah;
    }
    public void setNumberOfKalahPlayed(final int kalahGames){
      numberOfKalah = kalahGames;
    }

    public int getNumberOfAyoPlayed(){
        return numberOfAyo;
    }
    public void setNumberOfAyoPlayed(final int ayoGames){
        numberOfAyo = ayoGames;
    }

    public int getNumberOfKalahWon(){
        return numberOfKalahWon;
    }
    public void setNumberOfKalahWon(final int gamesWonKalah){
        numberOfKalahWon = gamesWonKalah;
    }
    public int getNumberOfAyoWon(){
        return numberOfAyoWon;
    }
    public void setNumberOfAyoWon(final int gamesWonAyo){
            numberOfAyoWon = gamesWonAyo;
    }
    
}
