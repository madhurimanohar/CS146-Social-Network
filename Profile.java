package GUI;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

// Users can join, leave, create/modify/search profiles, add friends

public class Profile {

  //  private BufferedImage picture;
    private String firstName;
    private String lastName;
    private String status;
    private ArrayList<Profile> friendProfiles; //linked list portion

    public Profile(String first, String last, String status) {
     //   picture = new BufferedImage(100, 100, BufferedImage.TYPE_3BYTE_BGR);    // I'm not sure what to add here, can change
        firstName = first;
        lastName = last;
        this.status = status;
        friendProfiles = new ArrayList<>();
    }

    /** Returns the picture associated with the profile.
     @return The profile's picture. */
//    public BufferedImage getProfilePicture() {
//        return picture;
//
//    }

    /**Sets the picture associated with the profile to the given picture.
     @param newPicture The new picture associated with the profile. */
//    public void setProfilePicture(BufferedImage newPicture) {
//        newPicture = picture;
//
//    }

    /*** Sets the name associated with the profile to the given name.
     * @param firstName The first name for the profile.
     * @param lastName  The last name for the profile. */

    public void setName(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /** Returns the name associated with the profile.
     @return The profile's name. */
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    /** Sets the current status of the profile to the given string.
     @param stat The new status for the profile. */
    public void setStatus(String stat) {
        status = stat;
    }

    /** Returns the status associated with the profile.
     @return The profile's status. */
    public String getStatus() {
        return status;
    }

    /**Returns a list of all the person's friendProfiles on the social network.
     @return The list of friendProfiles. */
    public ArrayList<Profile> getFriends() {
        return friendProfiles;
    }

    /**Adds a friend to the profile's list of friendProfiles.
     @param p The profile to be added to the list.*/
    public void addFriend(Profile p) {
        friendProfiles.add(p);
        //p.getFriends().add(this);
    }

    /** Removes a friend from the profile's list of friendProfiles.
     @param p The profile to be removed from the list.
     @return True if the profile was removed. */
    public void removeFriend(Profile p) {
        friendProfiles.remove(p);
    }

    public String toString() {
        return "Name: " + getFirstName() +  " " + getLastName() + " \n" + "Status: " + getStatus();
        //+ " Profile Picture: " + getProfilePicture();

    }

    /** Displays the profile's information and friendProfiles. */
    public void display() {

        System.out.println(toString());

        System.out.println("My Friends: ");
        for(int i = 0; i < friendProfiles.size(); i++){
            System.out.println("------------------------------");
            System.out.println(friendProfiles.get(i).toString());
        }
    }

}

