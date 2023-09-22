import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Models.*;
import Services.SnakeAndLadderService;

public class Main{
    public static void main(String[] args){
        SnakeAndLadderService objSnakeAndLadderService = new SnakeAndLadderService(150);

        // player initiation
        List<Player> objPlayers = new ArrayList<Player>();
        String [] playerNames = new String[]{"Krithish","Prathmesh","Aniket"};
        for(int pos = 0; pos < playerNames.length ; pos++){
            objPlayers.add(new Player(playerNames[pos]));
        }
        objSnakeAndLadderService.setPlayers(objPlayers);

        // set snakes position
        List<Snakes> objSnakes = new ArrayList<Snakes>();
        int [] start = new int[]{14,20,25,38,45,55,72,89,95};
        int [] end = new int[] {7,15,20,25,8,33,42,50,3};
        for(int pos = 0; pos < start.length ; pos++){
            objSnakes.add(new Snakes(start[pos], end[pos]));
        }
        objSnakeAndLadderService.setSnakes(objSnakes);

        // set ladder positions
        List<Ladders> objLadders = new ArrayList<Ladders>();
        start = new int[]{1,3,23,25,36,50,12};
        end = new int[] {4,12,34,45,57,90,99};
        for(int pos = 0; pos < start.length ; pos++){
            objLadders.add(new Ladders(start[pos], end[pos]));
        }
        objSnakeAndLadderService.setLadders(objLadders);

        // start game
        objSnakeAndLadderService.initiateGame();

    }
}