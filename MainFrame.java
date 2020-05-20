package GUI;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private LoginPanel login;
    private ProfileManager proMan;

    public MainFrame(){
        super("Social Network");

        login = new LoginPanel();
        login.setProfileListener(new loginAction());
        setLayout(new BorderLayout());

        add(login, BorderLayout.CENTER);

        //setSize(600,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        Rectangle rectangle = new Rectangle(300,300,650,550);
        setBounds(rectangle);

        //create a profile manager
        proMan = new ProfileManager();

    }

    private class loginAction implements ProfileListener{

        @Override
        public void profileRegisterOccurred(Profile p) {
            String fname = p.getFirstName();
            String lname = p.getLastName();
            String status = p.getStatus();

            Profile profile = new Profile(fname,lname,status);

            proMan.addProfile(profile);
            proMan.display();

            //add the HomePanel onto the Main Frame
        }
    }

}
