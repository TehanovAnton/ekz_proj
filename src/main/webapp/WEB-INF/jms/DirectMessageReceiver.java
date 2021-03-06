package jms;

import classes.KeyValueTable;

import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Hashtable;

public class DirectMessageReceiver implements MessageListener {
    public String name;

    private Context context;
    private ConnectionFactory fac;
    private Connection connection;
    private Session session;
    private Destination dest;
    private MessageConsumer consumer;
    private static String ConfiguredJmsObjectsFile = "file:\\C:\\Users\\Anton\\source\\repos\\pacei_NV_sovremenueTehnologiyVInternet\\экзамен\\ekz_proj\\imq_admin_objects";
    private static String JMSFactory = "MyConnectionFactory";
    private static String JMSDestinationQueue = "MyQueue";

    //Point to point
    public DirectMessageReceiver(){
        this.name = "p2p";
        try {
            Hashtable env = new Hashtable();
            env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.fscontext.RefFSContextFactory");
            env.put(Context.PROVIDER_URL, ConfiguredJmsObjectsFile);

            context = new InitialContext(env);
            fac = (ConnectionFactory) context.lookup(JMSFactory);
            connection = fac.createConnection();
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            dest = (Destination) context.lookup(JMSDestinationQueue);
            consumer = session.createConsumer(dest);
            consumer.setMessageListener(this);
            connection.start();

            Thread.sleep(30_000);
        } catch (NamingException | JMSException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //Pub\sub + filters
    public DirectMessageReceiver(String topic, String name, String filter){
        try {
            this.name = name;

            Hashtable env = new Hashtable();
            env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.fscontext.RefFSContextFactory");
            env.put(Context.PROVIDER_URL, "file:\\C:\\Users\\Anton\\source\\repos\\pacei_NV_sovremenueTehnologiyVInternet\\экзамен\\ekz_proj\\imq_admin_objects");

            context = new InitialContext(env);
            fac = (ConnectionFactory) context.lookup("MyConnectionFactory");
            connection = fac.createConnection();
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            dest = session.createTopic(topic);
            consumer = session.createConsumer(dest, "symbol='" + filter + "'");
            consumer.setMessageListener(this);
            connection.start();
        } catch (NamingException | JMSException e) {
            e.printStackTrace();
        }
    }

    public DirectMessageReceiver(int sessionMode){
        try {
            Hashtable env = new Hashtable();
            env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.fscontext.RefFSContextFactory");
            env.put(Context.PROVIDER_URL, "C:\\Users\\Anton\\source\\repos\\pacei_NV_sovremenueTehnologiyVInternet\\лабораторные\\Lab14(JMS_MOM)\\imq_admin_objects");

            context = new InitialContext(env);
            fac = (ConnectionFactory) context.lookup("MyCinnectionFactory");
            connection = fac.createConnection();
            session = connection.createSession(false, sessionMode);
            dest = (Destination) context.lookup("MyQueue");
            consumer = session.createConsumer(dest);
            consumer.setMessageListener(this);
            connection.start();

            Thread.sleep(30_000);
        } catch (NamingException | JMSException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void onMessage(Message msg) {
        try {
            if (msg instanceof ObjectMessage) {
                KeyValueTable inKv = (KeyValueTable) ((ObjectMessage) msg).getObject();
                System.out.println(name + " onMessage-p2p " + " received message: " + inKv.value);
            }
            else if (msg instanceof TextMessage) {
                String inTxt = ((TextMessage) msg).getText();
                System.out.println(name + " received message: " + inTxt);
            }

            if (session.getAcknowledgeMode() == Session.CLIENT_ACKNOWLEDGE) {
                msg.acknowledge();
                System.out.println("Message:acknowledge");
            }

        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
//        new DirectMessageReceiver();

        new DirectMessageReceiver("Topic1", "anton", "filter");
        new DirectMessageReceiver("Topic1", "andrew", "no filter");
//
//        new DirectMessageReceiver(Session.CLIENT_ACKNOWLEDGE);
    }
}