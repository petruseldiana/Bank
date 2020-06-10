package com.bank.view;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Date;

public class EmployeeView extends JFrame {

    private static final String TITLE = "Employee view";

    private static final int WIDTH = 1100;
    private static final int HEIGHT = 650;

    private JLabel label = new JLabel("EMPLOYEE");
    private JLabel firstNameLabel = new JLabel("First Name:");
    private JLabel lastNameLabel = new JLabel("Last Name:");
    private JLabel cardIDLabel = new JLabel("Card ID:");
    private JLabel pncLabel = new JLabel("PNC:");
    private JLabel addressLabel = new JLabel("Address:");
    private JLabel emailLabel = new JLabel("E-mail:");
    private JLabel phoneLabel = new JLabel("Phone:");
    private JLabel clientInfoLabel = new JLabel("~ Client information ~");

    private JLabel accountInfoLabel = new JLabel("~ Account information ~");
    private JLabel typeLabel = new JLabel("Account type:");
    private JLabel amountOfMoneyLabel = new JLabel("Amount of money:");
    private JLabel dateLabel = new JLabel("Creation date:");

    private JLabel transferLabel = new JLabel("~ Transfer money ~");
    private JLabel money = new JLabel("Amount of money:");
    private JLabel transferAccount = new JLabel("Card ID transfer:");

    private JLabel billLabel = new JLabel("~ Pay bills ~");
    private JLabel moneyBill = new JLabel("Amount of money:");

    private JTextField firstNameTextField = new JTextField();
    private JTextField lastNameTextField = new JTextField();
    private JTextField cardIDTextField = new JTextField();
    private JTextField pncTextField = new JTextField();
    private JTextField addressTextField = new JTextField();
    private JTextField emailTextField = new JTextField();
    private JTextField phoneTextField = new JTextField();

    private JTextField typeTextField = new JTextField();
    private JTextField amountOfMoneyTextField = new JTextField();
    private JTextField dateTextField = new JTextField();

    private JTextField transferAccountTextField = new JTextField();
    private JTextField moneyTextField = new JTextField();

    private JTextField moneyBillTextField = new JTextField();

    private JSeparator separator = new JSeparator();
    private JSeparator separator1 = new JSeparator();
    private JSeparator separator2 = new JSeparator();
    private JSeparator separator3 = new JSeparator();

    private JButton logoutButton = new JButton("Logout");

    private JButton addButton = new JButton("ADD");
    private JButton updateButton = new JButton("UPDATE");
    private JButton listButton = new JButton("LIST");

    private JButton addAccountButton = new JButton("ADD");
    private JButton deleteAccountButton = new JButton("DELETE");
    private JButton updateAccountButton = new JButton("UPDATE");
    private JButton listAccountButton = new JButton("LIST");

    private JButton transferButton = new JButton("TRANSFER");

    private JButton payBillButton = new JButton("PAY");

    public EmployeeView() throws HeadlessException {
        super(TITLE);
        setVisible(true);
        initializeView();
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private void initializeView() {
        setLayout(null);

        separator.setBounds(20, 65, 1020, 8);

        separator1.setBounds(370,65,8,500);
        separator1.setOrientation(SwingConstants.VERTICAL);

        separator2.setBounds(370, 260, 670, 8);

        separator3.setBounds(750,260,8,300);
        separator3.setOrientation(SwingConstants.VERTICAL);

        billLabel.setBounds(910,300, 250,25);
        billLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC | Font.CENTER_BASELINE, 20));

        moneyBill.setBounds(760,370,200,25);
        moneyBill.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));

        moneyBillTextField.setBounds(900,370,160,25);
        moneyBillTextField.setFont(new Font("Tahoma", Font.PLAIN, 15));

        payBillButton.setBounds(900,450,150,50);
        payBillButton.setBackground(new Color(0, 0, 0));
        payBillButton.setForeground(new Color(255, 255, 255));
        payBillButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));

        label.setBounds(450,10,300,50);
        label.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC | Font.CENTER_BASELINE, 30));

        transferLabel.setBounds(520,300, 250,25);
        transferLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC | Font.CENTER_BASELINE, 20));

        transferAccount.setBounds(400,370,200,25);
        transferAccount.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
        money.setBounds(390,405,200,25);
        money.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));

        transferAccountTextField.setBounds(530,370,200,25);
        transferAccountTextField.setFont(new Font("Tahoma", Font.PLAIN, 15));
        moneyTextField.setBounds(530,405,200,25);
        moneyTextField.setFont(new Font("Tahoma", Font.PLAIN, 15));

        transferButton.setBounds(530,450,150,50);
        transferButton.setBackground(new Color(0, 0, 0));
        transferButton.setForeground(new Color(255, 255, 255));
        transferButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));

        clientInfoLabel.setBounds(99,85,400,25);
        clientInfoLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC | Font.CENTER_BASELINE, 20));

        firstNameLabel.setBounds(21, 130, 85, 25);
        firstNameLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
        lastNameLabel.setBounds(23, 165, 85, 25);
        lastNameLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
        cardIDLabel.setBounds(40, 200, 85, 25);
        cardIDLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
        pncLabel.setBounds(60, 235, 85, 25);
        pncLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
        addressLabel.setBounds(33, 270, 100, 25);
        addressLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
        emailLabel.setBounds(48, 305, 100, 25);
        emailLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
        phoneLabel.setBounds(46, 340, 100, 25);
        phoneLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));

        firstNameTextField.setBounds(120, 130, 200, 25);
        firstNameTextField.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lastNameTextField.setBounds(120, 165, 200, 25);
        lastNameTextField.setFont(new Font("Tahoma", Font.PLAIN, 15));
        cardIDTextField.setBounds(120, 200, 200, 25);
        cardIDTextField.setFont(new Font("Tahoma", Font.PLAIN, 15));
        pncTextField.setBounds(120, 235, 200, 25);
        pncTextField.setFont(new Font("Tahoma", Font.PLAIN, 15));
        addressTextField.setBounds(120, 270, 200, 25);
        addressTextField.setFont(new Font("Tahoma", Font.PLAIN, 15));
        emailTextField.setBounds(120, 305, 200, 25);
        emailTextField.setFont(new Font("Tahoma", Font.PLAIN, 15));
        phoneTextField.setBounds(120, 340, 200, 25);
        phoneTextField.setFont(new Font("Tahoma", Font.PLAIN, 15));

        addButton.setBounds(30,430,150,50);
        addButton.setBackground(new Color(0, 0, 0));
        addButton.setForeground(new Color(255, 255, 255));
        addButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));

        updateButton.setBounds(200,430,150,50);
        updateButton.setBackground(new Color(0, 0, 0));
        updateButton.setForeground(new Color(255, 255, 255));
        updateButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));

        listButton.setBounds(130,500,150,50);
        listButton.setBackground(new Color(0, 0, 0));
        listButton.setForeground(new Color(255, 255, 255));
        listButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));

        accountInfoLabel.setBounds(500,85,400,25);
        accountInfoLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC | Font.CENTER_BASELINE, 20));

        typeLabel.setBounds(410, 130, 150, 25);
        typeLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
        amountOfMoneyLabel.setBounds(380, 165, 150, 25);
        amountOfMoneyLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
        dateLabel.setBounds(409, 200, 150, 25);
        dateLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));

        typeTextField.setBounds(520, 130, 200, 25);
        typeTextField.setFont(new Font("Tahoma", Font.PLAIN, 15));
        amountOfMoneyTextField.setBounds(520, 165, 200, 25);
        amountOfMoneyTextField.setFont(new Font("Tahoma", Font.PLAIN, 15));
        dateTextField.setBounds(520, 200, 200, 25);
        dateTextField.setFont(new Font("Tahoma", Font.PLAIN, 15));


        logoutButton.setBounds(950,550,100,40);
        logoutButton.setBackground(new Color(0, 0, 0));
        logoutButton.setForeground(new Color(255, 255, 255));
        logoutButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));


        addAccountButton.setBounds(740,130,150,50);
        addAccountButton.setBackground(new Color(0, 0, 0));
        addAccountButton.setForeground(new Color(255, 255, 255));
        addAccountButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));

        deleteAccountButton.setBounds(900,130,150,50);
        deleteAccountButton.setBackground(new Color(0, 0, 0));
        deleteAccountButton.setForeground(new Color(255, 255, 255));
        deleteAccountButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));

        updateAccountButton.setBounds(740,190,150,50);
        updateAccountButton.setBackground(new Color(0, 0, 0));
        updateAccountButton.setForeground(new Color(255, 255, 255));
        updateAccountButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));

        listAccountButton.setBounds(900,190,150,50);
        listAccountButton.setBackground(new Color(0, 0, 0));
        listAccountButton.setForeground(new Color(255, 255, 255));
        listAccountButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));

        add(label);
        add(logoutButton);
        add(separator);
        add(separator3);
        add(separator1);
        add(clientInfoLabel);
        //client info label
        add(firstNameLabel);
        add(lastNameLabel);
        add(cardIDLabel);
        add(pncLabel);
        add(addressLabel);
        add(emailLabel);
        add(phoneLabel);
        //client info text fields
        add(firstNameTextField);
        add(lastNameTextField);
        add(cardIDTextField);
        add(pncTextField);
        add(addressTextField);
        add(emailTextField);
        add(phoneTextField);
        //clint buttons
        add(addButton);
        add(updateButton);
        add(listButton);
        //account info label
        add(accountInfoLabel);
        add(separator2);
        add(typeLabel);
        add(amountOfMoneyLabel);
        add(dateLabel);
        //account text fields
        add(typeTextField);
        add(amountOfMoneyTextField);
        add(dateTextField);
        //account buttons
        add(addAccountButton);
        add(deleteAccountButton);
        add(updateAccountButton);
        add(listAccountButton);
        //transfer label
        add(transferLabel);
        add(transferAccount);
        add(money);
        //transfer text field
        add(transferAccountTextField);
        add(moneyTextField);
        //transfer button
        add(transferButton);
        //bill label
        add(billLabel);
        add(moneyBill);
        //bill text fields
        add(moneyBillTextField);
        //bill button
        add(payBillButton);
    }
    public void addLogoutActionListener(ActionListener listener) {
        logoutButton.addActionListener(listener);
    }

    public void addAddClientButtonActionListener(ActionListener listener){
        addButton.addActionListener(listener);
    }

    public void addUpdateClientButtonActionListener(ActionListener listener){
        updateButton.addActionListener(listener);
    }

    public void addListClientButtonActionListener(ActionListener listener){
        listButton.addActionListener(listener);
    }

    public void addAddAccountButtonActionListener(ActionListener listener){
        addAccountButton.addActionListener(listener);
    }

    public void addDelAccountActionListener(ActionListener listener){
        deleteAccountButton.addActionListener(listener);
    }

    public void addUpdateAccountButtonActionListener(ActionListener listener){
        updateAccountButton.addActionListener(listener);
    }

    public void addListAccountButtonActionListener(ActionListener listener){
        listAccountButton.addActionListener(listener);
    }

    public void addTransferButtonActionListener(ActionListener listener){
        transferButton.addActionListener(listener);
    }

    public void addPayBillButtonActionListener(ActionListener listener){
        payBillButton.addActionListener(listener);
    }

    public String getFirstName() {
        return firstNameTextField.getText();
    }

    public void serFirstName(String firstName){
        firstNameTextField.setText(firstName);
    }

    public String getLastName() {
        return lastNameTextField.getText();
    }

    public void setLastName(String lastName){
        lastNameTextField.setText(lastName);
    }

    public int getCardID() {
        return Integer.valueOf(cardIDTextField.getText());
    }

    public void setCardID(int cardID){
        cardIDTextField.setText(String.valueOf(cardID));
    }

    public String getPnc() {
        return pncTextField.getText();
    }

    public void setPnc(String pnc){
        pncTextField.setText(pnc);
    }

    public String getAddress() {
        return addressTextField.getText();
    }

    public void setAddress(String address){
        addressTextField.setText(address);
    }

    public String getEmail() {
        return emailTextField.getText();
    }

    public void setEmail(String email){
        emailTextField.setText(email);
    }

    public String getPhone() {
        return phoneTextField.getText();
    }

    public void setPhone(String phone){
        phoneTextField.setText(phone);
    }

    public String getTypee(){
        return typeTextField.getText();
    }

    public void setTypee(String typee){
        typeTextField.setText(typee);
    }

    public double getAmountOfMoney(){
        return Double.valueOf(amountOfMoneyTextField.getText());
    }

    public void setAmountOfMoney(double amountOfMoney){
        amountOfMoneyTextField.setText(String.valueOf(amountOfMoney));
    }

    public String getDate(){
        return dateTextField.getText();
    }

    public void setDate(String date){
        dateTextField.setText(date);
    }

    public String getTransferAccount(){
        return transferAccountTextField.getText();
    }

    public String getTransferMoney(){
        return moneyTextField.getText();
    }

    public String getMoneyBill(){
        return moneyBillTextField.getText();
    }
}
