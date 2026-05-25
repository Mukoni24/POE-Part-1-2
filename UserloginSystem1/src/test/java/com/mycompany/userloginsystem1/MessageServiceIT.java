/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.userloginsystem1;

public class MessageServiceIT  {

    public static void main(String[] args) {

        // Create test object
        MessageService message =new MessageService(1,"+27831234567","Hello Angela");
        System.out.println("Message Testing");
        
        //Message ID Test
        System.out.println("\n MESSAGE ID TEST");
        if (message.checkMessageID()) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }

        //Recipient number test
        System.out.println("\n RECIPIENT NUMBER TEST ");
        String expectedRecipient = "Cell phone number successfully captured.";

        if (message.checkRecipientCell().equals(expectedRecipient)) {
        System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }

        //Message Length Test
        System.out.println("\n MESSAGE LENGTH TEST");
        
        if (message.checkMessageLength().equals("Message ready to send.")) {
        System.out.println("PASS");

        } else {

         System.out.println("FAIL");
        }

        //Message Hash Test 
        System.out.println("\n MESSAGE HASH Test");

        if (message.getMessageHash() != null && !message.getMessageHash().isEmpty()) {

        System.out.println("PASS");
        System.out.println("Hash : "+ message.getMessageHash());

        } else {

        System.out.println("FAIL");
        }

        //Send Message Test
        System.out.println("\n SEND MESSAGE TEST ");

        String sendResult = message.sendMessage(1);

        if (sendResult.equals("Message successfully sent.")) {

        System.out.println("PASS");

        } else {

        System.out.println("FAIL");
        }

        //Total send message Test
        System.out.println("\n TOTAL SENT MESSAGES TEST");

        if (MessageService.returnTotalMessages() == 1) {
        System.out.println("PASS");

        } else {

        System.out.println("FAIL");
        }

        //Store message Test
        System.out.println("\nTEST 7 : STORE MESSAGE");

        String storeResult = message.sendMessage(3);

        if (storeResult.equals("Message successfully stored.")) {

            System.out.println("PASS");

        } else {

            System.out.println("FAIL");
        }

        //Getters Test
        System.out.println("\n1"
                + " GETTERS");

        if (message.getRecipient().equals("+27831234567")&& message.getMessage()
        .equals("Hello Angela")&& message.getMessageNumber() == 1) {

        System.out.println("PASS");

        } else {

            System.out.println("FAIL");
        }

        //Print Messages
        System.out.println("\n PRINT MESSAGES");

        System.out.println(
                MessageService.printMessages()
        );

        //Unit Test completed
        System.out.println("\n TEST COMPLETED");
    }
}