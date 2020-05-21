/**
 *  An implementation of a profile manager on a simple 
 *  social network.
 * @author madhurim, Eunice Oh
 *
 */
public class ProfileManager {
    private Graph<Profile> allProfiles;

    /** Constructor for an instance of a profile manager. */
    public ProfileManager() {
        allProfiles = new Graph<Profile>();
    }

    /** Adds a profile to the social network.
     @param p  The profile to be added to the
     network. */
    public void addProfile(Profile p) {
        allProfiles.addVertex(p);

    }

    /** Removes a profile from the social network.
     @param p  The profile to be removed from the
     network. */
    public void removeProfile(Profile p) {
        allProfiles.removeVertex(p);
    }

    /** Creates a friendship between two users on the social network.
     @param a  The first profile in the friendship.
     @param b  The second profile in the friendship.
     */
    public void createFriendship(Profile a, Profile b) {
        if(!a.getFriends().contains(b) || !b.getFriends().contains(a)){
            a.getFriends().add(b);
            b.getFriends().add(a);
        }
    }

    /** Displays each profile's information and friends. */
    public void display() {
        Profile startPoint = allProfiles.getVertex(0);
        startPoint.display();
        for(int i = 1; i < allProfiles.getNumOfProfiles(); i++){
            System.out.println("Profile Information");
            startPoint = allProfiles.getVertex(i);
            startPoint.display();
        }
    }

    public Profile findProfile(String name){
        for(int i = 0; i < allProfiles.getNumOfProfiles(); i++){
            Profile start = allProfiles.getVertex(i);
            if(start.getFirstName().equals(name)){
                return start;
            }
        }
        return null;
    }
}