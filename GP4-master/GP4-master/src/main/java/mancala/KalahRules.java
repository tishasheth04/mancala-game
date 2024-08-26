package mancala;
//import java.io.Serializable;
//import java.util.ArrayList;
//import java.util.List;

public class KalahRules extends GameRules {
    private static final long serialVersionUID = -5201804264702268819L;

    //private List<GameRules> data = new ArrayList<>();

    private final MancalaDataStructure data;// = getDataStructure();
    //private List<Pit> pitArrayList = new ArrayList<Pit>();
    //private List<Store> storeArrayList = new ArrayList<Store>();;
    private static final int PITPLAYER2 = 12; //fix this
    /*default */
    private static final int PITPLAYER1 = 6; 
    
    private static final int MIN = 1;
    private static final int MAX = 12;
    private int storeValue = 0;
    private int pitValue = 0;
    private int counter = 0;
    private int currentPlayer = 0;
    private int csTotal = 0;

    public KalahRules(){
        super();
        data = getDataStructure();
    }

    @Override
    public int moveStones(final int startPit, final int playerNum) throws InvalidMoveException{ //not done - hard
        if(playerNum == 2 && startPit < 7){

            throw new InvalidMoveException("That's an invalid move.");
        }
        if(playerNum == 1 && startPit > 6){
            throw new InvalidMoveException("That's an invalid move.");
        }
        //int storeValue = 0;
        if(startPit >= 1 && startPit <= 6){
           
            storeValue = data.getStoreCount(1);
        }else if (startPit >= 7 && startPit <= 12){
            storeValue = data.getStoreCount(2);
        }
        try {
            distributeStones(startPit);
            if(startPit >= 1 && startPit <= 6){
                storeValue = data.getStoreCount(1) - storeValue;
            }else if (startPit >= 7 && startPit <= 12){
                storeValue = data.getStoreCount(2) - storeValue;
            }
        } catch (Exception e) {
            e.getMessage();
        } 
        return storeValue;
    }

    @Override
    public int distributeStones(final int startPit) { 
          int numStones;
          //int counter;
          int valueOfStones = 0;
          //int currentPlayer = 0;
         pitValue = startPit;
          final int tots = 13;
          //int freeMove = 1;
          numStones = data.removeStones(startPit);
          //System.out.println("NUM stones: " + numStones);
          counter = numStones;
          if(startPit > 0 && startPit < 7){
            currentPlayer = 1;
          }else if(startPit > 6 && startPit < 13){
            currentPlayer = 2;
          }
          data.setIterator(startPit, currentPlayer, false);
          Countable currentSpot;
          for(int i = 0; i < numStones;i++){
            currentSpot = data.next();
            currentSpot.addStone();
            pitValue++;
            if(pitValue > tots){ //wrapping around
                pitValue = 1;
            }
            //if(!(i == numStones - 1) && !((pitValue == 13)  || pitValue == 7)){
                //freeMove = 0;
            //}
            //System.out.println(toString());
            counter--;
          }
        if(pitValue != tots){
          if(startPit >= 1 && startPit <= 6 && pitValue >= 1 && pitValue <= PITPLAYER1  && (data.getNumStones(pitValue) % 12) == 1 && counter == 0){
            valueOfStones += captureStones((pitValue - 1) % 12 + 1);
          }
          if(startPit >= 7 && startPit <= 13 && pitValue >= 7 && pitValue <= PITPLAYER2 && (data.getNumStones(pitValue) % 12) == 1 && counter == 0){      
            valueOfStones += captureStones((pitValue - 1) % 12 + 1);         
          }
        }
        //System.out.println("Pit num for 12 is: " + data.getNumStones(12) + " Pit num for 1 is: " + data.getNumStones(1));
        return numStones + valueOfStones;
    }

    @Override
    public int captureStones(final int stoppingPoint){
        
        //throws PitNotFoundException{ //done

        //System.out.println("ARGHHHHH STOPPING POINT ARRGGGHHH: " + stoppingPoint);
        final int stopPit = stoppingPoint;
        //final int min = 1;
        //final int max = 12;
        int subtract;
        int total;
        //int csTotal = 0;
        /* 
         if(stoppingPoint > 12 || stoppingPoint <= 0){
            throw new PitNotFoundException("That pit does not exist");
        }*/

        /* 
        if (stoppingPoint >= 1 && stoppingPoint <= 6){
            subtract = stoppingPoint - min;
            total = max - subtract; //checking opponent corresponding pit

            if(pitArrayList.get(total - 1).getStoneCount() != 0){
                csTotal = pitArrayList.get(total - 1).removeStones();
                storeArrayList.get(0).addStones(csTotal); 
            }
        }
        if(stoppingPoint >= 7 && stoppingPoint <= 12){
            subtract = max - stoppingPoint;
            total = min + subtract;

            if(pitArrayList.get(total - 1).getStoneCount() != 0){
                csTotal = pitArrayList.get(total - 1).removeStones(); 
                storeArrayList.get(1).addStones(csTotal);
            }
        }
        return csTotal; 
    }*/


    if (stopPit>= 1 && stopPit <= 6){
            subtract = stopPit - MIN;
            total = MAX - subtract; //checking opponent corresponding pit


            if(data.getNumStones(total) != 0){
                //System.out.println("IN CAPTURE wahoo!");
                csTotal = data.removeStones(total) + data.removeStones(stopPit);
                data.addToStore(1,csTotal);
                //storeArrayList.get(0).addStones(csTotal); 
            }
        }
        if(stopPit >= 7 && stopPit <= 12){
            subtract = MAX - stopPit;
            total = MIN + subtract;

            if(data.getNumStones(total) != 0){
                csTotal = data.removeStones(total) + data.removeStones(stopPit); // we are adding the one for the stone that landed as well. 
                data.addToStore(2,csTotal);
                //storeArrayList.get(1).addStones(csTotal);
            }
        }
       // System.out.println("CS TOTAL ARRRRRRHHHHHHHHH: " + csTotal);
        return csTotal;
    }
    
}
