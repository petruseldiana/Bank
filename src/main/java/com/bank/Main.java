package com.bank;

import com.bank.configuration.JDBConnectionWrapper;
import com.bank.model.Client;
import com.bank.model.ClientAccount;
import com.bank.model.User;
import com.bank.repository.ActivityReportRepository;
import com.bank.repository.AdministratorRepository;
import com.bank.repository.EmployeeRepository;
import com.bank.repository.UserRepository;
import com.bank.repository.impl.ActivityReportRepositoryImpl;
import com.bank.repository.impl.AdministratorRepositoryImpl;
import com.bank.repository.impl.EmployeeRepositoryImpl;
import com.bank.repository.impl.UserRepositoryImpl;
import com.bank.service.*;
import com.bank.service.impl.*;
import com.bank.view.AdminView;
import com.bank.view.EmployeeView;
import com.bank.view.LoginView;

import javax.swing.*;
import java.util.Locale;

public class Main {
    private static LoginView loginView;
    private static AdminView adminView;
    private static EmployeeView employeeView;

    private static AdministratorRepository administratorRepository;
    private static EmployeeRepository employeeRepository;
    private static UserRepository userRepository;
    private static ActivityReportRepository activityReportRepository;

    private static AdministratorService administratorService;
    private static EmployeeService employeeService;
    private static UserService userService;
    private static ActivityReportService activityReportService;
    private static CurrentUser contextHolder;

    private static String employeeName;
    private static String employeeAddress;
    private static String employeePhone;
    private static String employeeEmail;
    private static String employeeProfession;
    private static String employeeUsername;
    private static String employeePassword;
    private static String employeeRole;

    private static String clientFirstName;
    private static String clientLastName;
    private static int clientCardID;
    private static String clientPnc;
    private static String clientAddress;
    private static String clientEmail;
    private static String clientPhone;

    private static String accountType;
    private static double accountAmountOfMoney;
    private static String accountCreationDate;

    private static long transferCardID;
    private static double transferAmountOfMoney;

    private static double payBillAmountOfMoney;

    public static void main(String[] args){

        //jdbc connector
        JDBConnectionWrapper jdbConnectionWrapper = new JDBConnectionWrapper("bank");

        //repositories
        administratorRepository = new AdministratorRepositoryImpl(jdbConnectionWrapper);
        employeeRepository = new EmployeeRepositoryImpl(jdbConnectionWrapper);
        userRepository = new UserRepositoryImpl(jdbConnectionWrapper);
        activityReportRepository = new ActivityReportRepositoryImpl(jdbConnectionWrapper);


        //services
        administratorService = new AdministratorServiceImpl(administratorRepository);
        employeeService = new EmployeeServiceImpl(employeeRepository);
        userService = new UserServiceImpl(userRepository);
        activityReportService = new ActivityReportServiceImpl(activityReportRepository);

        contextHolder = new CurrentUserImpl();

        //text fields
        openLoginView();

    }

    public static void openLoginView() {

        loginView = new LoginView(userService, contextHolder);
    }

    public static void openAdminView(){

        adminView = new AdminView();

        adminView.addLogoutActionListener(e -> {

            adminView.dispose();

            openLoginView();
        });

        adminView.addAddButtonActionListener(e -> {

            employeeName = adminView.getNamee();
            employeeAddress = adminView.getAddress();
            employeePhone = adminView.getPhone();
            employeeEmail = adminView.getEmail();
            employeeProfession = adminView.getProfession();
            employeeUsername = adminView.getUsername();
            employeePassword = adminView.getPassword();
            employeeRole = adminView.getRole();

            User user = new User(employeeName, employeeAddress,employeePhone,employeeEmail,employeeProfession,employeeUsername,employeePassword,employeeRole);

            if(administratorService.addEmployee(user) == true){
                JOptionPane.showMessageDialog(null,"Employee added with success.","INFO",JOptionPane.INFORMATION_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null,"Something went wrong, try again.","ERROR",JOptionPane.ERROR_MESSAGE);
            }
        });

        adminView.addDelButtonActionListener(e -> {

            employeeName = adminView.getNamee();

            int id = userService.getID(employeeName);

            if(administratorService.deleteEmployee(id) == true){
                JOptionPane.showMessageDialog(null,"Employee deleted with success.","INFO",JOptionPane.INFORMATION_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null,"Something went wrong, try again.","ERROR",JOptionPane.ERROR_MESSAGE);
            }
        });

        adminView.addUpdateButtonActionListener(e -> {

            employeeName = adminView.getNamee();
            employeeAddress = adminView.getAddress();
            employeePhone = adminView.getPhone();
            employeeEmail = adminView.getEmail();
            employeeProfession = adminView.getProfession();

            int id = userService.getID(employeeName);

            User user = new User(id,employeeName,employeeAddress,employeePhone,employeeEmail,employeeProfession);

            if(administratorService.updateEmployee(user) == true){
                JOptionPane.showMessageDialog(null,"Employee updated with success.","INFO",JOptionPane.INFORMATION_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null,"Something went wrong, try again.","ERROR",JOptionPane.ERROR_MESSAGE);
            }
        });

        adminView.addListButtonActionListener(e -> {

            employeeName = adminView.getNamee();

            User user = administratorService.getEmployee(employeeName);

            adminView.setAddress(user.getAddress());
            adminView.setPhone(user.getPhone());
            adminView.setEmail(user.getEmail());
            adminView.setProfession(user.getProfession());
            adminView.setUsername(user.getUsername());
            adminView.setPassword(user.getPassword());
            adminView.setRole(user.getRole());
        });
    }

    public static void openEmployeeView(){

        employeeView = new EmployeeView();

        employeeView.addLogoutActionListener(e ->{

            employeeView.dispose();

            openLoginView();
        });

        employeeView.addAddClientButtonActionListener(e -> {

            clientFirstName = employeeView.getFirstName();
            clientLastName = employeeView.getLastName();
            clientCardID = employeeView.getCardID();
            clientPnc = employeeView.getPnc();
            clientAddress = employeeView.getAddress();
            clientEmail = employeeView.getEmail();
            clientPhone = employeeView.getPhone();

            Client client = new Client(clientFirstName,clientLastName,clientCardID,clientPnc,clientAddress,clientEmail,clientPhone);

            if(employeeService.addClient(client) == true){
                JOptionPane.showMessageDialog(null,"Client added with success.","INFO",JOptionPane.INFORMATION_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null,"Something went wrong, try again.","ERROR",JOptionPane.ERROR_MESSAGE);
            }
        });

        employeeView.addUpdateClientButtonActionListener(e -> {

            clientFirstName = employeeView.getFirstName();
            clientLastName = employeeView.getLastName();

            int id = employeeRepository.giveMeID(clientFirstName,clientLastName);

            clientCardID = employeeView.getCardID();
            clientPnc = employeeView.getPnc();
            clientAddress = employeeView.getAddress();
            clientEmail = employeeView.getEmail();
            clientPhone = employeeView.getPhone();

            Client client = new Client(id,clientFirstName,clientLastName,clientCardID,clientPnc,clientAddress,clientEmail,clientPhone);

            if(employeeService.updateClient(client) == true){
                JOptionPane.showMessageDialog(null,"Client updated with success.","INFO",JOptionPane.INFORMATION_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null,"Something went wrong, try again.","ERROR",JOptionPane.ERROR_MESSAGE);
            }
        });

        employeeView.addListClientButtonActionListener(e -> {

            clientFirstName = employeeView.getFirstName();
            clientLastName = employeeView.getLastName();

            Client client = employeeService.listClient(clientFirstName,clientLastName);

            employeeView.setCardID(client.getIdCard());
            employeeView.setPnc(client.getPnc());
            employeeView.setAddress(client.getAddress());
            employeeView.setEmail(client.getEmail());
            employeeView.setPhone(client.getPhone());
        });

        employeeView.addAddAccountButtonActionListener(e -> {

            clientFirstName = employeeView.getFirstName();
            clientLastName = employeeView.getLastName();

            int idClient = employeeRepository.giveMeID(clientFirstName,clientLastName);

            accountType = employeeView.getTypee();
            accountAmountOfMoney = employeeView.getAmountOfMoney();
            accountCreationDate = employeeView.getDate();

            ClientAccount clientAccount = new ClientAccount(accountType,accountAmountOfMoney, accountCreationDate,idClient);

            if(employeeService.addClientAccount(clientAccount) == true){
                JOptionPane.showMessageDialog(null,"Client account added with success.","INFO",JOptionPane.INFORMATION_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null,"Something went wrong, try again.","ERROR",JOptionPane.ERROR_MESSAGE);
            }
        });

        employeeView.addDelAccountActionListener(e -> {

            clientFirstName = employeeView.getFirstName();
            clientLastName = employeeView.getLastName();

            int idClient = employeeRepository.giveMeID(clientFirstName,clientLastName);

            accountType = employeeView.getTypee();

            if(employeeService.deleteClientAccount(idClient,accountType) == true){
                JOptionPane.showMessageDialog(null,"Client account deleted with success.","INFO",JOptionPane.INFORMATION_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null,"Something went wrong, try again.","ERROR",JOptionPane.ERROR_MESSAGE);
            }
        });

        employeeView.addUpdateAccountButtonActionListener(e -> {

            clientFirstName = employeeView.getFirstName();
            clientLastName = employeeView.getLastName();

            int idClient = employeeRepository.giveMeID(clientFirstName,clientLastName);

            accountType = employeeView.getTypee();
            accountAmountOfMoney = employeeView.getAmountOfMoney();
            accountCreationDate = employeeView.getDate();

            ClientAccount clientAccount = new ClientAccount(accountType, accountAmountOfMoney, accountCreationDate, idClient);

            if(employeeService.updateClientAccount(clientAccount) == true){
                JOptionPane.showMessageDialog(null,"Client account updated with success.","INFO",JOptionPane.INFORMATION_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null,"Something went wrong, try again.","ERROR",JOptionPane.ERROR_MESSAGE);
            }
        });

        employeeView.addListAccountButtonActionListener(e -> {

            clientFirstName = employeeView.getFirstName();
            clientLastName = employeeView.getLastName();

            int idClient = employeeRepository.giveMeID(clientFirstName,clientLastName);

            accountType = employeeView.getTypee();

            ClientAccount clientAccount = employeeService.listClientAccount(idClient, accountType);

            employeeView.setTypee(clientAccount.getType());
            employeeView.setAmountOfMoney(clientAccount.getAmountOfMoney());
            employeeView.setDate(clientAccount.getCreationDate());
        });

        employeeView.addTransferButtonActionListener(e -> {

            clientFirstName = employeeView.getFirstName();
            clientLastName = employeeView.getLastName();

            int idClient = employeeRepository.giveMeID(clientFirstName,clientLastName);

            accountType = employeeView.getTypee();

            transferCardID = Long.valueOf(employeeView.getTransferAccount());
            int trId = employeeRepository.getIdByCardID(transferCardID, "personal");
            System.out.println("transfer id" + trId);
            transferAmountOfMoney = Double.valueOf(employeeView.getTransferMoney());

            ClientAccount clientAccount = employeeService.listClientAccount(idClient,accountType);  //contul din care transferam
            double newSum = clientAccount.getAmountOfMoney() - transferAmountOfMoney;
            System.out.println("my sum:" + newSum);
            ClientAccount clientAccount1 = new ClientAccount("personal",newSum,idClient);

            if(transferAmountOfMoney < clientAccount.getAmountOfMoney()) {
                employeeService.updateAmountOfMoney(clientAccount1);
                ClientAccount transferAccount = employeeService.listClientAccount(trId, "personal");
                double trSum = transferAccount.getAmountOfMoney() + transferAmountOfMoney;
                System.out.println("tr sum: " + trSum);
                ClientAccount transferAccount1 = new ClientAccount("personal", trSum,trId);
                if(employeeService.updateAmountOfMoney(transferAccount1) == true){
                    JOptionPane.showMessageDialog(null,"Transfer was made with success.","INFO",JOptionPane.INFORMATION_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(null,"Something went wrong, try again.","ERROR",JOptionPane.ERROR_MESSAGE);
                }
            }else{
                JOptionPane.showMessageDialog(null,"Client do not have enough money.","ERROR",JOptionPane.ERROR_MESSAGE);
            }


        });

        employeeView.addPayBillButtonActionListener(e -> {

            payBillAmountOfMoney = Double.valueOf(employeeView.getMoneyBill());

            clientFirstName = employeeView.getFirstName();
            clientLastName = employeeView.getLastName();

            int idClient = employeeRepository.giveMeID(clientFirstName,clientLastName);

            accountType = employeeView.getTypee();

            ClientAccount clientAccount = employeeService.listClientAccount(idClient,accountType);  //contul din care transferam
            double newSum = clientAccount.getAmountOfMoney() - payBillAmountOfMoney;
            ClientAccount clientAccount1 = new ClientAccount("personal",newSum,idClient);
            if(payBillAmountOfMoney < clientAccount.getAmountOfMoney()){
                if(employeeService.updateAmountOfMoney(clientAccount1) == true){
                    JOptionPane.showMessageDialog(null,"Bill paid with success.","INFO",JOptionPane.INFORMATION_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(null,"Something went wrong, try again.","ERROR",JOptionPane.ERROR_MESSAGE);
                }
            }else{
                JOptionPane.showMessageDialog(null,"Client do not have enough money.","ERROR",JOptionPane.ERROR_MESSAGE);
            }

        });
    }


}
