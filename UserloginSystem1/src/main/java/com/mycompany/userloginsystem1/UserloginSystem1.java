/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.userloginsystem1;

/**
 * This program combines:
 * 1. User Registration and Login System
 * 2. QuickChat Messaging System
 *
 * @author Mukoni
 */
import java.util.ArrayList;
import java.util.Scanner;

    //Part 1
    public class UserloginSystem1 {

    static Scanner input = new Scanner(System.in);

    // Check username
    public static boolean checkUsername(String username) {

    return username.contains("_")&& username.length() <= 5&& !username.contains(" ");
    }

    // Check password complexity
    public static boolean checkPasswordComplexity(String password) {

    boolean hasCapital = false;
    boolean hasNumber = false;
    boolean hasSpecial = false;

    // Password must be 8 characters or more
    if (password.length() >= 8) {

            
    for (int i = 0; i < password.length(); i++) {

    char c = password.charAt(i);

    // Check capital letter
    if (Character.isUpperCase(c)) {hasCapital = true;}

    // Check number
    if (Character.isDigit(c)) {hasNumber = true;}

    // Check special character
    if (!Character.isLetterOrDigit(c)) {hasSpecial = true;}}

    return hasCapital && hasNumber && hasSpecial;
    }

    return false;
    }

    // Check cellphone number
    public static boolean checkCellphoneNumber(String recipientCell) 
    
    {String regex = "^\\+27[6-8][0-9]{8}$";return recipientCell.matches(regex);}

    // Login validation
    public static boolean loginUser(String username,String password, String usernameLogin,String passwordLogin) {

     return username.equals(usernameLogin) && password.equals(passwordLogin);}

    // Return login message
    public static String returnLoginStatus(boolean loginStatus,String firstName,String lastName) {

    if (loginStatus) {

    return "Welcome " + firstName + " "+ lastName+ ", it is great to see you again.";

    } else {

    return "Username or password incorrect, please try again.";
     }
    }

    
    public static void main(String[] args) {

    String username = "";
    String password = "";
    String cellphone = "";
    String firstName = "";
    String lastName = "";

        
    boolean isRegistered = false;
    boolean isLoggedIn = false;

    int choice;


    do {

    System.out.println("\n========== LOGIN SYSTEM ==========");
    System.out.println("1. Register");
    System.out.println("2. Login");
    System.out.println("3. Exit");
    System.out.print("Choose option: ");
    while (!input.hasNextInt()) {

    System.out.println("Please enter a valid number.");
    input.next();
    }

    choice = input.nextInt();
    input.nextLine();

           
    if (choice == 1) {

    System.out.println("\n========== REGISTRATION ==========");

    System.out.print("Enter First Name: ");
    firstName = input.nextLine();

    System.out.print("Enter Last Name: ");
    lastName = input.nextLine();

    // Username validation
    do {

    System.out.print("Enter Username "+ "(must contain _ and max 5 characters): ");

    username = input.nextLine();

    if (checkUsername(username)) {

    System.out.println("Username successfully captured.");

    break;

    } else {

    System.out.println("Username is not correctly formatted; "+ "please ensure that your username "
    + "contains an underscore and is "+ "no more than five characters long.");
    }

    } while (true);

    // Password validation
    do {System.out.print("Enter Password "+ "(8 characters, capital letter, "+ "number and special character): ");
    password = input.nextLine();

    if (checkPasswordComplexity(password)) {

    System.out.println("Password successfully captured.");

    break;

    } else {

    System.out.println("Password is not correctly formatted; "+ "please ensure that the password "
    + "contains at least eight characters, "+ "a capital letter, a number, "+ "and a special character.");
    }

    } while (true);

    // Cellphone validation
    do {

    System.out.print("Enter Cellphone Number (+27 + 9 digits ): ");
                    
    cellphone = input.nextLine();

    if (checkCellphoneNumber(cellphone)) {

    System.out.println("Cellphone number successfully added.");

    break;

    } else {

    System.out.println("Cellphone number incorrectly formatted "
    + "or does not contain international code.");
    }

    } while (true);

    isRegistered = true;

    System.out.println("User has registered successfully.");}

    else if (choice == 2) {if (!isRegistered) {

    System.out.println("You must register first before logging in.");
    continue;
    }

    System.out.println("\n========== LOGIN ==========");

    System.out.print("Enter Username: ");
    String usernameLogin = input.nextLine();

    System.out.print("Enter Password: ");
    String passwordLogin = input.nextLine();

    boolean loginStatus = loginUser(username,password,usernameLogin,passwordLogin);

    System.out.println(returnLoginStatus(loginStatus,firstName,lastName));

    // Part2 
    if (loginStatus) {

    isLoggedIn = true;

    System.out.println("\n================================");
    System.out.println("      Welcome to QuickChat Connect    ");
    System.out.println("================================");
    System.out.println("Connect.Chat.Communicate");

    // Ask user how many messages to send
    int maxMessages = 0;

    while (maxMessages <= 0) {

    System.out.print("How many messages would you like to send? ");

    if (input.hasNextInt()) {
    maxMessages = input.nextInt();
    input.nextLine();

    if (maxMessages <= 0) {

    System.out.println("Please enter a number greater than 0.");
    }

    } else {

    input.nextLine();

    System.out.println("Invalid input. " + "Please enter a whole number.");}
    }

    // Store sent messages
    ArrayList<MessageService> sentMessages = new ArrayList<>();

    boolean running = true;

    while (running) {

    System.out.println("\n========= QUICKCHAT MENU =========");
    System.out.println("1) Send Messages");
    System.out.println("2) Show Recently Sent Messages");
    System.out.println("3) Quit");
    System.out.print("Select option: ");

    int option = -1;

    if (input.hasNextInt()) {

    option = input.nextInt();
    input.nextLine();

    } else {

    input.nextLine();

    System.out.println("Invalid option. "+ "Please enter 1, 2, or 3.");

    continue;
    }

    if (option == 1) {

    for (int i = 0; i < maxMessages; i++) {

    int messageNumber = i + 1;

    System.out.println("\n--- MESSAGE "+ messageNumber+ " of "+ maxMessages
    + " ---");
    System.out.print("Enter recipient number "+ "(+27 & 9 digits): ");

    String recipient = input.nextLine().trim();
    System.out.print("Enter message: ");

    String messageText= input.nextLine().trim();

    MessageService msg = new MessageService(messageNumber,recipient,messageText);

    // Recipient validation
    System.out.println(msg.checkRecipientCell());

    // Message length validation
    String lengthResult= msg.checkMessageLength();

    System.out.println(lengthResult);

    if (!lengthResult.equals("Message ready to send.")) {

    System.out.println("Message skipped. "+ "Please try again.");

    i--;
    continue;
    }

    // Display ID and hash
    System.out.println("Message ID: "+ msg.getMessageID());
    System.out.println("ID Valid: "+ msg.checkMessageID());
    System.out.println("Message Hash: "+ msg.getMessageHash());

    // Send menu
    System.out.println("\n1) Send Message");
    System.out.println("2) Disregard Message");
    System.out.println("3) Store Message");

    System.out.print("Select option: ");

    int sendOption = -1;

    if (input.hasNextInt()) {

    sendOption = input.nextInt();
    input.nextLine();

    } else {

    input.nextLine();

    System.out.println("Invalid input. "+ "Message disregarded.");

    continue;
    }

    String result= msg.sendMessage(sendOption);

    System.out.println(result);

    // Save sent messages
    if (sendOption == 1) {

    sentMessages.add(msg);
     System.out.println("Message Sent Successfully."); 
     msg.displayMessageDetails();
    }
    }

    }

    else if (option == 2) {

    if (sentMessages.isEmpty()) {System.out.println("No messages sent yet.");

    } else {

    System.out.println("\n====== SENT MESSAGES ======");

    System.out.println(MessageService.printMessages());
    }
    }

    else if (option == 3) {

    System.out.println("\nTotal Messages Sent: "+ MessageService.returnTotalMessages());

    System.out.println("Thank you for using QuickChatConnect . Goodbye!");

    running = false;
    }

    else {

    System.out.println("Invalid option. "+ "Please enter 1, 2, or 3.");
    }
    }
    }
    }

    else if (choice == 3) {

    System.out.println("Thank you for using QuickChat Connect Have a wonderful day."
            + "!");
    
    } else {

    System.out.println("Invalid choice!");}

    } while (choice != 3);

    input.close();
    }
}