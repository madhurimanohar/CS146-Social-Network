import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.*;
import java.awt.event.*;
import java.io.File;

/**
 * 
 * @author madhurim, Eunice Oh
 *
 */
public class ProfilePanel extends JPanel {
    private JLabel nameLabel;
    private JLabel statusLabel;
    private JLabel friendsLabel;
    private JButton leaveNetwork;
    private JButton modifyProfile;
    private String info;
    private JTextArea textArea;

    /* variables for the image upload */
    private JButton button ;
    private JLabel label;
    private JLabel lblNewLabel;
    private JLabel profilePic_3;
    private JTextField searchBar;

    public ProfilePanel() {
        nameLabel = new JLabel();
        nameLabel.setBounds(6, 21, 188, 17);

        statusLabel = new JLabel();
        statusLabel.setBounds(6, 38, 188, 17);

        friendsLabel = new JLabel("List of Friends: ");
        friendsLabel.setBounds(6, 271, 188, 17);

        /* Image upload things */
        button = new JButton("Browse");
        button.setBounds(6,200,188,17);
        label = new JLabel(); 
        label.setBounds(40, 70,120,120);
        add(button);
        add(label);

        //displaying a person's list of friends
        leaveNetwork = new JButton("Leave Network");
        leaveNetwork.setBounds(6, 385, 188, 17);
        leaveNetwork.addActionListener(new leaveBtnAction());
        modifyProfile = new JButton("Modify Profile");
        modifyProfile.setBounds(6, 429, 188, 17);
        modifyProfile.addActionListener(new modifyBtnAction());
        setPreferredSize(new Dimension(645, 463));
        setBorder(BorderFactory.createTitledBorder("My Profile"));
        setLayout(null);

        add(nameLabel);
        add(statusLabel);
        add(friendsLabel);
        add(leaveNetwork);
        add(modifyProfile);

        JTextArea listOfFriends = new JTextArea();
        listOfFriends.setText("Eunice Oh\nMadhuri Manohar\nKat Lin");
        listOfFriends.setBounds(6, 292, 188, 81);
        add(listOfFriends);
        
        lblNewLabel = new JLabel("<html>Name: Nelson Nguyen<br><br>Status: Offline<br><br>Their Friends: (Can't show --> Private)<html/>");
        lblNewLabel.setBounds(385, 48, 243, 81);
        add(lblNewLabel);
        
        JSeparator separator = new JSeparator();
        separator.setBackground(Color.GRAY);
        separator.setOrientation(SwingConstants.VERTICAL);
        separator.setBounds(206, 21, 12, 425);
        add(separator);
        
        JLabel lblnameEmilyOsmetstatus = new JLabel("<html>Name: Emily Osmet<br><br>Status: Online<br><br>Their Friends: (Can't show --> Private)<html/>");
        lblnameEmilyOsmetstatus.setBounds(385, 199, 243, 81);
        add(lblnameEmilyOsmetstatus);
        
        JLabel lblnameDashionDurnstatus = new JLabel("<html>Name: Dashion Durn<br><br>Status: Partying!<br><br>Their Friends: (Can't show --> Private)<html/>");
        lblnameDashionDurnstatus.setBounds(385, 342, 243, 81);
        add(lblnameDashionDurnstatus);
        
        JLabel profilePic_1 = new JLabel("");
        profilePic_1.setIcon(new ImageIcon("/Users/madhurim/Desktop/Git/CS146-Social-Network/man.png"));
        profilePic_1.setBounds(240, 48, 120, 90);
        add(profilePic_1);
        
        profilePic_3 = new JLabel("");
        profilePic_3.setIcon((new ImageIcon("/Users/madhurim/Desktop/Git/CS146-Social-Network/man.png")));
        profilePic_3.setBounds(240, 342, 120, 90);
        add(profilePic_3);
        
        JLabel profilePic_2 = new JLabel("");
        profilePic_2.setIcon(new ImageIcon("/Users/madhurim/Desktop/Git/CS146-Social-Network/woman.jpg"));
        profilePic_2.setBounds(240, 199, 120, 90);
        add(profilePic_2);
        
        searchBar = new JTextField();
        searchBar.setText("Search...");
        searchBar.setBounds(240, 12, 283, 26);
        add(searchBar);
        searchBar.setColumns(10);
        
        JButton searchButton = new JButton("Search");
        searchButton.setBounds(522, 9, 117, 29);
        add(searchButton);

        //add actionListeners to buttons exit and modify

        /* Image upload things */
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser file = new JFileChooser();
                file.setCurrentDirectory(new File(System.getProperty("user.home")));
                FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images", "jpg","gif","png");
                file.addChoosableFileFilter(filter);
                int result = file.showSaveDialog(null);
                if(result == JFileChooser.APPROVE_OPTION){
                    File selectedFile = file.getSelectedFile();
                    String path = selectedFile.getAbsolutePath();
                    label.setIcon(ResizeImage(path));
                }
                else if(result == JFileChooser.CANCEL_OPTION){
                    System.out.println("No File Select");
                }
            }
        });
    }

    /* Image upload things */
    public ImageIcon ResizeImage(String ImagePath) {
        ImageIcon MyImage = new ImageIcon(ImagePath);
        Image img = MyImage.getImage();
        Image newImg = img.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;
    }

    public ProfilePanel(JLabel name, JLabel status, JList friends){

    }

    public void printNameField(String text){
        nameLabel.setText("Name: " + text);
    }
    public void printStatusField(String text){
        statusLabel.setText("Status: " + text);
    }

    private class modifyBtnAction implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e)  {
            //open a dialog
            //accept input for status
            //get input for status
            //update status
            String response = JOptionPane.showInputDialog("Update Status:" );
            statusLabel.setText("Status: " + response);
        }
    }
    
    private class leaveBtnAction implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e)  {
            System.exit(0);
        }
    }
}