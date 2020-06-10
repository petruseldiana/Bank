package com.bank.view;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;


public class AdminView extends JFrame {

    private static final String TITLE = "Admin view";

    private static final int WIDTH = 900;
    private static final int HEIGHT = 650;

    private JLabel label = new JLabel("ADMINISTRATOR");
    private JLabel nameLabel = new JLabel("Name:");
    private JLabel addressLabel = new JLabel("Address:");
    private JLabel phoneLabel = new JLabel("Phone:");
    private JLabel emailLabel = new JLabel("E-mail:");
    private JLabel professionLabel = new JLabel("Profession:");
    private JLabel usernameLabel = new JLabel("Username:");
    private JLabel passwordLabel = new JLabel("Password:");
    private JLabel roleLabel = new JLabel("Role:");
    private JLabel infoLabel = new JLabel("Choose a date:");

    private JTextField nameTextField = new JTextField();
    private JTextField addressTextField = new JTextField();
    private JTextField phoneTextField = new JTextField();
    private JTextField emailTextField = new JTextField();
    private JTextField professionTextField = new JTextField();
    private JTextField usernameTextField = new JTextField();
    private JTextField passwordTextField = new JTextField();
    private JTextField roleTextField = new JTextField();

    private JSeparator separator = new JSeparator();
    private JSeparator separator1 = new JSeparator();

    private JButton logoutButton = new JButton("Logout");
    private JButton addButton = new JButton("ADD");
    private JButton updateButton = new JButton("UPDATE");
    private JButton deleteButton = new JButton("DELETE");
    private JButton listButton = new JButton("LIST");
    private JButton getReportButton = new JButton("GET REPORT");

    private JDateChooser dateChooser = new JDateChooser();

    private JTable table = new JTable();
    private JScrollPane scrollPane = new JScrollPane();

    public AdminView() throws HeadlessException {
        super(TITLE);
        setVisible(true);
        initializeView();
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private void initializeView() {
        setLayout(null);

        separator.setBounds(30, 65, 800, 8);

        separator1.setBounds(420,65,8,500);
        separator1.setOrientation(SwingConstants.VERTICAL);

        label.setBounds(300,10,300,50);
        label.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC | Font.CENTER_BASELINE, 30));

        nameLabel.setBounds(50, 100, 85, 25);
        nameLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
        addressLabel.setBounds(30, 135, 85, 25);
        addressLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
        phoneLabel.setBounds(42, 170, 85, 25);
        phoneLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
        emailLabel.setBounds(41, 205, 85, 25);
        emailLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
        professionLabel.setBounds(8, 240, 100, 25);
        professionLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
        usernameLabel.setBounds(15, 275, 100, 25);
        usernameLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
        passwordLabel.setBounds(15, 310, 100, 25);
        passwordLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
        roleLabel.setBounds(56, 345, 85, 25);
        roleLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
        infoLabel.setBounds(440,120,200,35);
        infoLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));

        nameTextField.setBounds(120, 100, 200, 25);
        nameTextField.setFont(new Font("Tahoma", Font.PLAIN, 15));
        addressTextField.setBounds(120, 135, 200, 25);
        addressTextField.setFont(new Font("Tahoma", Font.PLAIN, 15));
        phoneTextField.setBounds(120, 170, 200, 25);
        phoneTextField.setFont(new Font("Tahoma", Font.PLAIN, 15));
        emailTextField.setBounds(120, 205, 200, 25);
        emailTextField.setFont(new Font("Tahoma", Font.PLAIN, 15));
        professionTextField.setBounds(120, 240, 200, 25);
        professionTextField.setFont(new Font("Tahoma", Font.PLAIN, 15));
        usernameTextField.setBounds(120, 275, 200, 25);
        usernameTextField.setFont(new Font("Tahoma", Font.PLAIN, 15));
        passwordTextField.setBounds(120, 310, 200, 25);
        passwordTextField.setFont(new Font("Tahoma", Font.PLAIN, 15));
        roleTextField.setBounds(120, 345, 200, 25);
        roleTextField.setFont(new Font("Tahoma", Font.PLAIN, 15));

        logoutButton.setBounds(760,550,100,40);
        logoutButton.setBackground(new Color(0, 0, 0));
        logoutButton.setForeground(new Color(255, 255, 255));
        logoutButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));

        addButton.setBounds(30,410,150,50);
        addButton.setBackground(new Color(0, 0, 0));
        addButton.setForeground(new Color(255, 255, 255));
        addButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));

        deleteButton.setBounds(200,410,150,50);
        deleteButton.setBackground(new Color(0, 0, 0));
        deleteButton.setForeground(new Color(255, 255, 255));
        deleteButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));

        updateButton.setBounds(30,480,150,50);
        updateButton.setBackground(new Color(0, 0, 0));
        updateButton.setForeground(new Color(255, 255, 255));
        updateButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));

        getReportButton.setBounds(440,400,200,50);
        getReportButton.setBackground(new Color(0, 0, 0));
        getReportButton.setForeground(new Color(255, 255, 255));
        getReportButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));

        listButton.setBounds(200,480,150,50);
        listButton.setBackground(new Color(0, 0, 0));
        listButton.setForeground(new Color(255, 255, 255));
        listButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));

        dateChooser.setBounds(680,110,135,62);

        scrollPane.setEnabled(false);
        scrollPane.setBounds(440,200,380,200);
        scrollPane.setViewportView(table);

        add(label);
        add(logoutButton);
        add(nameLabel);
        add(separator);
        //employee info labels
        add(addressLabel);
        add(phoneLabel);
        add(emailLabel);
        add(professionLabel);
        add(usernameLabel);
        add(passwordLabel);
        add(roleLabel);
        //employee info text fields
        add(nameTextField);
        add(addressTextField);
        add(phoneTextField);
        add(emailTextField);
        add(professionTextField);
        add(usernameTextField);
        add(passwordTextField);
        add(roleTextField);
        //buttons
        add(addButton);
        add(deleteButton);
        add(updateButton);
        add(listButton);
        add(getReportButton);
        //calendar
        add(dateChooser);
        add(infoLabel);
        add(separator1);
        add(scrollPane);

}
    public void addLogoutActionListener(ActionListener listener) {
        logoutButton.addActionListener(listener);
    }

    public void addAddButtonActionListener(ActionListener listener){
        addButton.addActionListener(listener);
    }

    public void addDelButtonActionListener(ActionListener listener){
        deleteButton.addActionListener(listener);
    }

    public void addUpdateButtonActionListener(ActionListener listener){
        updateButton.addActionListener(listener);
    }

    public void addListButtonActionListener(ActionListener listener){
        listButton.addActionListener(listener);
    }

    public String getNamee(){
        return nameTextField.getText();
    }

    public String getAddress(){
        return addressTextField.getText();
    }

    public String getPhone(){
        return phoneTextField.getText();
    }

    public String getEmail(){
        return emailTextField.getText();
    }

    public String getProfession(){
        return professionTextField.getText();
    }

    public String getUsername(){
        return usernameTextField.getText();
    }

    public String getPassword(){
        return passwordTextField.getText();
    }

    public String getRole(){
        return roleTextField.getText();
    }

    public void setAddress(String address){
        addressTextField.setText(address);
    }

    public void setPhone(String phone){
        phoneTextField.setText(phone);
    }

    public void setEmail(String email){
        emailTextField.setText(email);
    }

    public void setProfession(String profession){
        professionTextField.setText(profession);
    }

    public void setUsername(String username){
        usernameTextField.setText(username);
    }

    public void setPassword(String password){
        passwordTextField.setText(password);
    }

    public void setRole(String role){
        roleTextField.setText(role);
    }
}
