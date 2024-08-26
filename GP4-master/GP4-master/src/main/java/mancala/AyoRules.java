package mancala;
//import java.io.Serializable;
//import java.util.ArrayList;
//import java.util.List;

public class AyoRules extends GameRules {
    private static final long serialVersionUID = -3597256459383511311L;

    //private List<GameRules> data = new ArrayList<>();

    private final MancalaDataStructure data; //= getDataStructure();
    //private List<Pit> pitArrayList = new ArrayList<Pit>();
    //private final List<Store> storeArrayList = new ArrayList<Store>();
    private static final int PITPLAYER2 = 12; //fix this
    /*default */
    private static final int PITPLAYER1 = 6; 

    private static final int ONE = 1;

    private static final int MIN = 1;
    private static final int MAX = 12;
    private int counter = 0;
    private int storeValue = 0;
    private int pitValue = 0;
    private int currentPlayer = 0;
    private boolean wrap = false;
    private int csTotal = 0;

    public AyoRules(){
        super();
        data = getDataStructure();
        //super();  //dont know if i need this
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
        } catch (RuntimeException e) {
            storeValue = 0;
        } 
        return storeValue;
    }

    @Override
    public int distributeStones(final int startPit) {
        //final int one = 1; //check this
          int numStones;
          //boolean wrap = false;
          int countOfStones;
          int valueOfStones = 0;
          //int currentPlayer = 0;
          pitValue = startPit;
          numStones = data.removeStones(startPit);
          counter = numStones;
          if(startPit > 0 && startPit < 7){
            currentPlayer = 1;
          }else if(startPit > 6 && startPit < 13){
            currentPlayer = 2;
          }
          data.setIterator(startPit, currentPlayer, true);
          Countable currentSpot;
            for(int i = 0; i < numStones; i++){
                currentSpot = data.next();
                pitValue++;
                currentSpot.addStone();
                if(pitValue > PITPLAYER2){ 
                    pitValue = 1;
                }
                //System.out.println(toString());
                counter--;
            }
            countOfStones = data.getNumStones(pitValue - 1);
            //pitValue--;
            if(countOfStones != ONE){
            while(countOfStones != 0){
                //System.out.println("PIT VALUE IN WHILE BRAHHHHHH: " + pitValue);
                if(pitValue >= 1 && pitValue <= 6 && !wrap){
                    countOfStones = data.removeStones(pitValue);
                    //System.out.println("In if for pit value: " + pitValue);
                    //System.out.println("ARGHHHHHHCOUNT OF STONESD: " + countOfStones );
                }
                else{
                    countOfStones = data.removeStones(pitValue - 1);
                    //System.out.println("In else for pit value" + pitValue);
                    //System.out.println("ARGHHHHHHCOUNT OF STONEEEEE: " + countOfStones);
                }
                for(int k = 0; k <= countOfStones; k++){
                    currentSpot = data.next();
                    //if()
                    pitValue++;
                    currentSpot.addStone();
                    //System.out.println("PIT VALUE IN WHILE BRAHHHHHH: " + pitValue);
                if(pitValue >= 13 && countOfStones != 0){
                    //System.out.println("in the pit if");
                    pitValue = 1;
                    wrap = true;
                }
                if(k == countOfStones - ONE && pitValue == 12){
                    countOfStones = data.removeStones(pitValue -1);
                    //System.out.println("IN 17555555555555555555555555");
                }
                if(pitValue == startPit){
                    pitValue = pitValue + 1;
                }
                if(k == countOfStones - ONE&& data.getNumStones(pitValue - 1) == 1){
                    //System.out.println("IN !!!!");
                    countOfStones = 0;
                }
                if(k == countOfStones - ONE&& pitValue == 7){
                    countOfStones = 0;
                }
                //System.out.println(toString());
                //System.out.println("Count of stones: " + countOfStones);
                counter--;
                }
                if(data.getNumStones(pitValue) == ONE){
                    countOfStones = 0;
                }
                //System.out.println("stone count INSIDE WHILE: " + countOfStones);
            }
        }
            //counter = numStones;
          if(startPit >= 1 && startPit <= 6 && pitValue >= 1 && pitValue <= PITPLAYER1  && data.getNumStones(pitValue - 1) % 12 == 1 && counter == 0){
            //System.out.println("CAT SRONES 1");
            valueOfStones += captureStones((pitValue - 1) % 12 + 1);
         }
          if(startPit >= 7 && startPit <= 6 && pitValue >= 13 && pitValue <= PITPLAYER2 && data.getNumStones(pitValue - 1) % 12 == 1 && counter == 0){
            //System.out.println("CAT SRONEs 2");
            valueOfStones += captureStones((pitValue - 1) % 12 + 1);     
         }
        return numStones + valueOfStones;
    }

    @Override
    public int captureStones(final int stoppingPoint){
        //System.out.println("IN CAPTURE STONES");

       //final int MIN = 1;
       //final int MAX = 12;
    
        int subtract;
        int total;
        //int csTotal = 0;
        final int stopPit = stoppingPoint;
    if (stopPit >= 1 && stopPit <= 6){
            subtract = stopPit - MIN;
            total = MAX - subtract;
            if(data.getNumStones(total) != 0){
                csTotal = data.removeStones(total);
                data.addToStore(1,csTotal);
                //storeArrayList.get(0).addStones(csTotal); 
            }
        }
        if(stopPit >= 7 && stopPit <= 12){
            subtract = MAX - stopPit;
            total = MIN + subtract;
            if(data.getNumStones(total) != 0){
                csTotal = data.removeStones(total);
                data.addToStore(2,csTotal);
                //storeArrayList.get(1).addStones(csTotal);
            }
        }
        return csTotal;
    }
}
