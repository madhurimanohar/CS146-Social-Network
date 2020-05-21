import javax.swing.*;
import java.awt.*;

/**
 * 
 * @author madhurim, Eunice Oh
 *
 */
public class MainLoginFrame extends JFrame { 
    //MainLoginFrame components
    private LoginPanel login;
    private ProfilePanel myPro;
    private Profile user;

    public MainLoginFrame(){
        super("Social Network");    //title

        setLayout(new BorderLayout());  //border layout

        login = new LoginPanel();   //initializes login page

        myPro = new ProfilePanel();

        /**
         * variable login is registered with an instance of event handler listener class
         * login is an event source
         */
        login.setProfileListener(new loginAction());

        add(login, BorderLayout.CENTER);    //add login panel onto this frame

        setSize(650,550);   //size of 650 px by 550 px

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //not sure which operation this frame should have
        setVisible(true);   //this frame is visible

        //create a profile manager when an object of the frame is created
    }

    /**
     * an event listener inner class called loginAction
     */
    private class loginAction implements ProfileListener {

        //implements the method, which creates a new profiles and adds it to the ProfileManager
        //also sets the visibility of login page to false and a home page object is created
        @Override
        public void profileRegisterOccurred(Profile p) {
            //utilizing class Profile's methods
            String fname = p.getFirstName();
            String lname = p.getLastName();
            String status = p.getStatus();

            //creating new profile
            user = new Profile(fname,lname,status);

            //after registering, the login frame visibility is set to false
            login.setVisible(false);

            add(myPro, BorderLayout.WEST);

            String proName = login.getName();
            String proStatus = login.getStatus();
            myPro.printNameField(proName);
            myPro.printStatusField(proStatus);

            user.display();
        }
    }
}