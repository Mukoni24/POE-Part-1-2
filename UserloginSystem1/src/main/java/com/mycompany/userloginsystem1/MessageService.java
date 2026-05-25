/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.userloginsystem1;

/**
 *This class handles all message features in my QuickChat system.
 * This class is used to perform the following : 
 * - Create message IDs
 * - Create message hashes
 * - Check cellphone numbers 
 * - Check message length
 * - Send and store messages
 * - Display messages
 * - Save messages in a JSON file
 * 
 * @author Mukoni
 */
import java.io.FileWriter; 
import java.io.IOException; 
import java.util.ArrayList; 
import java.util.Random; 

public class MessageService { 
 
    // Variables used to store message information 
    private String messageID; 
    private String recipient; 
    private String message; 
    private String messageHash; 
    private int messageNumber; 
 
    // ArrayLists used to store sent and stored messages 
    public static ArrayList<MessageService> sentMessages   = new ArrayList<>(); 
    public static ArrayList<MessageService> storedMessages = new ArrayList<>(); 
 
    /**
    * Constructor used to create a message object 
    * @param messageNumber stores message number
    * @param recipient stores recipient cellphone number
    * @param message stores message text
    */
    public MessageService(int messageNumber, String recipient, String message) { 
    this.messageNumber = messageNumber; 
    this.recipient     = recipient; 
    this.message       = message; 
 
    generateMessageID(); 
    createMessageHash(); 
    } 
 
    //Generates a random 10- digit message ID 
    private void generateMessageID() { 
    Random random = new Random(); 
    long number = 1000000000L + (Math.abs(random.nextLong()) % 9000000000L); 
    messageID = String.valueOf(number); 
    } 
 
    //Checks if message ID is valid 
    public boolean checkMessageID() { 
    return messageID != null && messageID.length() == 10; 
    } 
 
    //Checks if cellphone number is correct 
    public String checkRecipientCell() { 
    if (recipient != null && recipient.matches("^\\+27[6-8][0-9]{8}$")) { 
    return "Cell phone number successfully captured."; 
    } else { 
    return "Cell phone number is incorrectly formatted or does not contain an " 
    + "international code. Please correct the number and try again."; 
    } 
    } 
 
    //Checks if message is under 250 characters 
    public String checkMessageLength() { 
    if (message != null && message.length() <= 250) { 
    return "Message ready to send."; 
    } else { 
    int exceeded = message.length() - 250; 
    return "Message exceeds 250 characters by " + exceeded 
    + ", please reduce the size."; 
    } 
    } 
 
    //Creates a message hash 
    public String createMessageHash() { 
 
     //Removes special characters 
     String cleanedMessage = message.replaceAll("[^a-zA-Z0-9 ]", ""); 
 
    //Splits message into words 
    String[] words = cleanedMessage.trim().split("\\s+"); 
 
    //Gets first word 
    String firstWord = words[0].toUpperCase(); 
 
    // Gets last word
    String lastWord = words.length > 1 
    ? words[words.length - 1].toUpperCase() 
    : ""; 
 
    //Creates message hash
    messageHash = messageID.substring(0, 2) 
    + ":" + messageNumber + ":" + firstWord + lastWord; 
 
    return messageHash; 
    } 
 
     //Sends, deletes, or stores messages
    public String sendMessage(int option) { 
    switch (option) { 
 
    case 1: 
    sentMessages.add(this); 
    return "Message successfully sent."; 
 
    case 2: 
    return "Press 0 to delete the message."; 
 
    case 3: 
    storedMessages.add(this); 
    storeMessage(); 
    return "Message successfully stored."; 
 
    default: 
    return "Invalid option."; 
    } 
    } 
 
    //Stores message in JSON file
    public void storeMessage() {

    try (FileWriter writer =new FileWriter("storedMessages.json", true)) {

    writer.write("{\n");
    writer.write("\"MessageID\": \"" + messageID + "\",\n");
    writer.write("\"MessageHash\": \"" + messageHash + "\",\n");
    writer.write("\"Recipient\": \"" + recipient + "\",\n");
    writer.write("\"Message\": \"" + message + "\"\n");
    writer.write("}\n\n");} catch (IOException e) {

    System.out.println("Error writing file: "+ e.getMessage());
     }
    }
  
    //Displays all sent messages 
    public static String printMessages() { 
 
    StringBuilder output = new StringBuilder(); 
 
    for (MessageService msg: sentMessages) { 
    output.append("\nMessage ID:").append(msg.messageID); 
    output.append("\nMessage Hash:").append(msg.messageHash); 
    output.append("\nRecipient:").append(msg.recipient); 
    output.append("\nMessage:").append(msg.message); 
    } 
    return output.toString(); 
    } 
 
    //Returns total sent messages 
    public static int returnTotalMessages() { 
    return sentMessages.size(); 
    } 
 
     //Displays message details
    public void displayMessageDetails() { 
    System.out.println("\nMessage Details"); 
    System.out.println("Message ID:" + messageID); 
    System.out.println("Message Hash:" + messageHash); 
    System.out.println("Recipient:" + recipient); 
    System.out.println("Message:" + message); 
    } 
 
   // Getter methods
    public String getMessageID()     { return messageID; } 
    public String getMessageHash()   { return messageHash; } 
    public String getRecipient()     { return recipient; } 
    public String getMessage()       { return message; } 
    public int    getMessageNumber() { return messageNumber; }
    }

    

