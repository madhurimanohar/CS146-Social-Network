

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class LoginPanel extends JPanel {
    private JLabel firstName;
    private JTextField firstNameField;
    private JLabel lastName;
    private JTextField lastNameField;
    private JLabel status;
    private JTextField statusField;
    private JButton registerBtn;
    private ProfileListener profileListener;
    
    // variables for the image upload
    private JButton button ;
    private JLabel label;

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
        
        // image upload
        button = new JButton("Browse");
        button.setBounds(500,150,100,40);
        label = new JLabel(); 
        label.setBounds(500, 10,100,100);
        add(button);
        add(label);

        registerBtn = new JButton("Register");
        registerBtn.setBounds(271, 36, 95, 29);
        registerBtn.addActionListener(new registerBtnAction());
        setLayout(null);

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
        
        
        // image upload 
        
        button.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
            
              JFileChooser file = new JFileChooser();
              file.setCurrentDirectory(new File(System.getProperty("user.home")));
              //filter the files
              FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images", "jpg","gif","png");
              file.addChoosableFileFilter(filter);
              int result = file.showSaveDialog(null);
               //if the user click on save in Jfilechooser
              if(result == JFileChooser.APPROVE_OPTION){
                  File selectedFile = file.getSelectedFile();
                  String path = selectedFile.getAbsolutePath();
                  label.setIcon(ResizeImage(path));
              }
               //if the user click on save in Jfilechooser


              else if(result == JFileChooser.CANCEL_OPTION){
                  System.out.println("No File Select");
              }
            }
        });
    }
    
    // image upload
    public ImageIcon ResizeImage(String ImagePath) {
        ImageIcon MyImage = new ImageIcon(ImagePath);
        Image img = MyImage.getImage();
        Image newImg = img.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;
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