import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * 
 * @author madhurim, Eunice Oh
 *
 */
public class LoginPanel extends JPanel {
    private JLabel firstName;
    private JTextField firstNameField;
    private JLabel lastName;
    private JTextField lastNameField;
    private JLabel status;
    private JTextField statusField;
    private JButton registerBtn;
    private ProfileListener profileListener;

    public LoginPanel(){
        firstName = new JLabel("First Name: ");
        firstName.setBounds(12, 10, 76, 16);
        firstNameField = new JTextField(10);
        firstNameField.setBounds(93, 5, 130, 26);
        lastName = new JLabel("Last Name: ");
        lastName.setBounds(228, 10, 74, 16);
        lastNameField = new JTextField(10);
        lastNameField.setBounds(307, 5, 130, 26);
        status = new JLabel("Status: ");
        status.setBounds(84, 42, 47, 16);
        statusField = new JTextField(10);
        statusField.setBounds(136, 37, 130, 26);

        registerBtn = new JButton("Register");
        registerBtn.setBounds(271, 36, 95, 29);
        registerBtn.addActionListener(new registerBtnAction());
        setLayout(null);

        setLayout(new FlowLayout(FlowLayout.CENTER,10,60));

        add(firstName);
        add(firstNameField);

        add(lastName);
        add(lastNameField);

        add(status);
        add(statusField);

        add(registerBtn);
    }

    public void setProfileListener(ProfileListener listener){
        profileListener = listener;
    }

    public String getName(){
        return firstNameField.getText() + " " + lastNameField.getText();
    }

    public String getStatus(){
        return statusField.getText();
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
}