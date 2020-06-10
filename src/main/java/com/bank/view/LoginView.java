package com.bank.view;

import com.bank.Main;
import com.bank.model.User;
import com.bank.service.CurrentUser;
import com.bank.service.UserService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginView extends JFrame {

    private static final String TITLE = "Login";

    private static final int WIDTH = 600;
    private static final int HEIGHT = 400;

    Image img1= new ImageIcon("img/bank.png").getImage();

    private JLabel usernameLabel = new JLabel("Username:");
    private JLabel passwordLabel = new JLabel("Password:");
    private JLabel imgLabel = new JLabel("");

    private JTextField usernameTextField = new JTextField();
    private JPasswordField passwordTextField = new JPasswordField();

    private JButton loginButton = new JButton("Login");

    private JSeparator separator = new JSeparator();

    private final UserService userService;
    private final CurrentUser contextHolder;

    public LoginView(UserService userService, CurrentUser contextHolder) throws HeadlessException {
        super(TITLE);
        setVisible(true);
        initializeView();
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        this.userService = userService;
        this.contextHolder = contextHolder;
    }
    private void initializeView() {
        setLayout(null);

        usernameLabel.setBounds(90, 182, 85, 25);
        usernameLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
        passwordLabel.setBounds(90, 242, 85, 25);
        passwordLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));

        imgLabel.setIcon(new ImageIcon(img1));
        imgLabel.setBounds(210, 5, 300, 155);

        usernameTextField.setBounds(190, 180, 250, 35);
        usernameTextField.setFont(new Font("Tahoma",Font.PLAIN, 15));
        passwordTextField.setBounds(190, 240, 250, 35);
        passwordTextField.setFont(new Font("Tahoma", Font.CENTER_BASELINE, 15));

        loginButton.setBounds(290, 290, 150, 35);
        loginButton.setBackground(new Color(0, 0, 0));
        loginButton.setForeground(new Color(255, 255, 255));
        loginButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));

        separator.setBounds(70, 170, 460, 8);

        add(usernameLabel);
        add(passwordLabel);
        add(usernameTextField);
        add(passwordTextField);
        add(loginButton);
        add(imgLabel);
        add(separator);

        loginButton.addActionListener(new LoginActionListener());
    }

    public void cleatInputs() {
        this.usernameTextField.setText("");
        this.passwordTextField.setText("");
    }

    public LoginView getOuter() {

        return LoginView.this;
    }

    private class LoginActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String username = usernameTextField.getText();
            String password = passwordTextField.getText();

            if(username.equals("") || password.equals("")){
                JOptionPane.showMessageDialog(null,"Username or password empty, try again!","WARNING",JOptionPane.WARNING_MESSAGE);
            }else{
                User currentUser = userService.login(username, password);
                if(currentUser != null) {
                    //successful login
                    contextHolder.setCurrentUser(currentUser);
                    getOuter().setVisible(false);
                    if(currentUser.getRole().equals("admin")) {
                        //admin
                        Main.openAdminView();
                    } else {
                        //employee
                        Main.openEmployeeView();
                    }
                } else {
                    cleatInputs();
                }
            }

        }
    }
}
