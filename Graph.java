package GUI;

import java.util.ArrayList;
import java.util.HashSet;

class UserNotFound extends Exception{
    public UserNotFound(String error){
        super(error);
    }
}

public class Graph<Profile> {

    private ArrayList<Profile> adjacencyList;
    private int profiles;

    //constructor
    public Graph()
    {
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



/*
    public void addEdge(Profile user, Profile friend){
        // add p2 to linkedlist of p1
        // add p1 to linkedlist of p2
        int userIndex = adjacencyList.indexOf(user);



    }
*/
    //removeVertex

    //createFriendship aka add edge


    //unfriend aka remove edge
}
