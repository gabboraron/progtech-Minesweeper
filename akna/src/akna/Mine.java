package akna;

import java.util.Random;
import java.util.Vector;

/**
 *
 * @author Sándor
 */
class Mine {
    private Vector mines;
    private Vector route;
    
    
    public Mine() {
        mines =  new Vector();
        route =  new Vector();
        
        generateMines();
        fstStep();
    }

    /**
     * Add a new step to the path of player.
     * @param step coordinate
     */
    public void addNewStep(coordinate step) {
        route.add(step);
    }

    /**
     * Generate mines for the game.
     */
    private void generateMines() {
        int maxMineNr = 20;
        int nrOfMines = randInt(5,maxMineNr);
        for(int idx=0; idx<nrOfMines; ++idx){
            coordinate tmpCoord = new coordinate(randInt(1,4),randInt(1,4));
            mines.add(tmpCoord);
        }
        
        System.out.println("MINES: " + mines);
    }
    
    /**
     * Random number generator between min-max range.
     * @param min
     * @param max
     * @return 
     */
    public int randInt(int min, int max) {
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;

        return randomNum;
    }
    
    /**
     * Add the first step to 0,0.
     */
    private void fstStep(){
        route.add(new coordinate(0,0));
    }

    /**
     * Get the route vector with coordinates.
     * @return 
     */
    public Vector getRoute() {
        return route;
    }
    
    /**
     * Get if this coordinate is a mine. Return true if it is, false if it isn't
     * @param coord
     * @return 
     */
    public boolean isThisMine(coordinate coord){
        if(mines.contains(coord))
            return true;
        
        return false;
    }
    
    /**
     * Get if this coordinate is neighbor of the last one. Return true if yes, false if not.
     * @param coord
     * @return 
     */
    public boolean isThisNeighbor(coordinate coord){
        coordinate lastCoordinate = (coordinate) route.get(route.size()-1);
        
        if(((coord.x == lastCoordinate.x+1) || (coord.x == lastCoordinate.x-1)) && (coord.y == lastCoordinate.y))   //under/above int the column
            return true;
        
        if(((coord.y == lastCoordinate.y+1) || (coord.y == lastCoordinate.y-1)) && (coord.x == lastCoordinate.x))   //near in the row
            return true;
        
        return false;
    }
    
    /**
     * Check if is the game completed. Return true if yes, false if not.
     * @return 
     */
    public boolean isGameCompleted(){
        coordinate tmp = (coordinate) route.get(route.size()-1);
        if((tmp.x == 5) && (tmp.y == 5))
            return true;
        
        return false;
    }

    void reset() {
        route.removeAllElements();
        mines.removeAllElements();
        
        generateMines();
        fstStep();
    }
}
