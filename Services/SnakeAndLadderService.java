package Services;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import Models.*;

public class SnakeAndLadderService {
    SnakeAndLadderBoard SLB;
    Queue<Player> trackPlayers;
    Integer sizeOfBoard;

    public SnakeAndLadderService(int sizeOfBoard){
        this.sizeOfBoard = sizeOfBoard;
        SLB = new SnakeAndLadderBoard(sizeOfBoard);
        trackPlayers = new LinkedList<Player>();
    }

    public void setPlayers(List<Player> allPlayers){
        Map<String,Integer> mp = new HashMap<String,Integer>();
        for(int i=0;i<allPlayers.size();i++){
            this.trackPlayers.add(allPlayers.get(i));
            mp.put(allPlayers.get(i).getId(), 0);
        }
        SLB.setPlayers(mp);
    }

    public void setSnakes(List<Snakes> allSnakePos){
        SLB.setSnakes(allSnakePos);
    }

    public void setLadders(List<Ladders> allLadderPos){
        SLB.setLadders(allLadderPos);
    }

    public int diceRoll(){
        return RollService.roll();
    }

    public void playDice(Map<String,Integer> mp, Player objPlayer){
        int roll = diceRoll();
        int oldPosition = mp.get(objPlayer.getId());
        int newPosition = roll + oldPosition;
        String name = objPlayer.getName();

        System.out.println(name+" had old position = "+ oldPosition + " , & new position = "+ newPosition);

        do{
            oldPosition = newPosition;
            for(Ladders laddersPos: SLB.getLadders())
            {
                if(laddersPos.getStart() == newPosition){
                    System.out.println(name+" has encountered ladder, old position = "+laddersPos.getStart()+" end position = "+laddersPos.getEnd());
                    newPosition = laddersPos.getEnd();
                }
            }

            for(Snakes snakesPos: SLB.getSnakes())
            {
                if(snakesPos.getStart() == newPosition){
                    System.out.println(name+" has encountered snake, old position = "+snakesPos.getStart()+" end position = "+snakesPos.getEnd());
                    newPosition = snakesPos.getEnd();
                }
            }
        } while (oldPosition!=newPosition);

        if(newPosition<=sizeOfBoard) {
            mp.put(objPlayer.getId(), newPosition);
            SLB.setPlayers(mp);
        }
    }

    public Boolean startGame(){
        Player objPlayer = trackPlayers.poll();
        Map<String,Integer> mp = SLB.getPlayers();
        int playersPos = mp.get(objPlayer.getId());
        if(playersPos == sizeOfBoard){
            System.out.println(objPlayer.getName() + " has won the game");
            return false;
        }else{
            playDice(mp, objPlayer);
            trackPlayers.add(objPlayer);
        } 
        return true;     
    }

    public void initiateGame(){
        while(startGame());
        return;
    }
}
