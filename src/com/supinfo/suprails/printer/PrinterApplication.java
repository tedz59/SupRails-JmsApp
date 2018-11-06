/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.supinfo.suprails.printer;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class PrinterApplication {

    public static void main(String[] args) throws NamingException, JMSException, InterruptedException {

        Context context = new InitialContext();

        ConnectionFactory connectionFactory = (ConnectionFactory) context.lookup("jms/suprailsConnectionFactory");
        
        Destination destination = (Destination) context.lookup("jms/suprailsQueue");
        Connection connection = connectionFactory.createConnection();
        
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        
        MessageConsumer consumer = session.createConsumer(destination);
        
        System.out.println("En attente de message...");
        
        consumer.setMessageListener((Message message) -> {
            TextMessage textMessage;
            
            try {
                textMessage = (TextMessage) message;
            } catch (ClassCastException e) {
                System.out.println("Invalid message received : " + e.getMessage());
                return;
            }
            
            try {
                System.out.println("Message received : " + textMessage.getText());
            } catch (JMSException ex) {
                System.out.println("Error wile reading message.");
            }
        });
        
        connection.start();

        while (true) {
            System.out.println("Waiting for message ...");
            Thread.sleep(5000);
        }
    }
    
}
