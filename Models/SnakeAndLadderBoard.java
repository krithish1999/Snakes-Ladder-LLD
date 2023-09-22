package Models;

import java.util.*;

public class SnakeAndLadderBoard{
    Map<String,Integer> players;
    List<Ladders> ladders;
    List<Snakes> snakes;
    Integer size;

    public SnakeAndLadderBoard(int size){
        this.size = size;
        players = new HashMap<String,Integer>();
        ladders = new ArrayList<Ladders>();
        snakes = new ArrayList<Snakes>();
    }

    public Map<String, Integer> getPlayers() {
        return players;
    }

    public void setPlayers(Map<String, Integer> players) {
        this.players = players;
    }

    public List<Ladders> getLadders() {
        return ladders;
    }

    public void setLadders(List<Ladders> ladders) {
        this.ladders = ladders;
    }

    public List<Snakes> getSnakes() {
        return snakes;
    }

    public void setSnakes(List<Snakes> snakes) {
        this.snakes = snakes;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
    
}