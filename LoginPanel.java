package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPanel extends JPanel {
    private JLabel firstName;
    private JTextField firstNameField;
    private JLabel lastName;
    private JTextField lastNameField;
    private JLabel status;
    private JTextField statusField;
  //  private JLabel image;
    private JButton registerBtn;
    private ProfileListener profileListener;

    public LoginPanel(){
        firstName = new JLabel("First Name: ");
        firstNameField = new JTextField(10);
        lastName = new JLabel("Last Name: ");
        lastNameField = new JTextField(10);
        status = new JLabel("Status: ");
        statusField = new JTextField(10);
      //  image = new JLabel("Select an Image:");

        registerBtn = new JButton("Register");
        registerBtn.addActionListener(new registerBtnAction());

        //setLayout(new GridLayout());

        //add components onto this panel
        add(firstName);
        add(firstNameField);
        add(lastName);
        add(lastNameField);
        add(status);
        add(statusField);
    //    add(image);
        add(registerBtn);

    }

    private class registerBtnAction implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String firstName = firstNameField.getText();
            String lastName = lastNameField.getText();
            String status = statusField.getText();

            Profile pp = new Profile(firstName,lastName,status);
            profileListener.profileRegisterOccurred(pp);

        }
    }

    public void setProfileListener(ProfileListener listener){
        profileListener = listener;
    }


}
