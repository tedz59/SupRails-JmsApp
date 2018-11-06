package com.supinfo.suprails.printer;

import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.QueueConnectionFactory;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.InitialContext;

public class SendMessageApplication {

    public static void main(String a[]) throws Exception {
        String msg = "Hello from remote JMS Client";

        System.out.println("==============================");
        System.out.println("Sending message to Queue");
        System.out.println("==============================");
        System.out.println();
        sendMessage2Queue(msg);
        System.out.println();
        System.out.println("==============================");
        System.exit(0);
    }

    private static void sendMessage2Queue(String msg) throws Exception {

        InitialContext cntxt = new InitialContext();
        System.out.println("Context Created");

        QueueConnectionFactory qFactory = (QueueConnectionFactory)cntxt.lookup("jms/suprailsConnectionFactory");

        Connection connection = qFactory.createConnection();
        System.out.println("Connection established with JMS Provide ");

        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        Queue queue = (Queue)cntxt.lookup("jms/suprailsQueue");

        MessageProducer mp = session.createProducer(queue);

        TextMessage message = session.createTextMessage();
        message.setJMSDeliveryMode(DeliveryMode.NON_PERSISTENT);
        message.setText(msg);

        mp.send(message);
        System.out.println("Message send: " + message);

        mp.close();
        session.close();
        cntxt.close();
    }

}