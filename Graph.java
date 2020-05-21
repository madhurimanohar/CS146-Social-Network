import java.util.ArrayList;
import java.util.HashSet;

/**
 * 
 * @author madhurim, Eunice Oh
 *
 * @param <Profile>
 */
public class Graph<Profile> {

    private ArrayList<Profile> adjacencyList;
    private int profiles;

    //constructor
    public Graph() {
        adjacencyList = new ArrayList<Profile>();
    }

    //addVertex
    public void addVertex(Profile p) {
        if (!adjacencyList.contains(p)){
            adjacencyList.add(p);
            profiles++;
        }
    }

    // return vertex
    public Profile getVertex(int i){
        return adjacencyList.get(i);
    }

    // return count of vertices
    public int getNumOfProfiles(){ // returns number of profiles in graph
        return profiles;
    }

    public void removeVertex(Profile p){
        if(adjacencyList.contains(p)){
            adjacencyList.remove(p);
        }
    }
}

class UserNotFound extends Exception{
    public UserNotFound(String error){
        super(error);
    }
}