package io.viro.p2pfs.telnet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;


/**
 * Commander thead.
 */
public class P2PFSCommander implements Runnable {
    private P2PFSClient client;


    private static final Logger logger = LoggerFactory.getLogger(P2PFSCommander.class);

    public P2PFSCommander(P2PFSClient client) {
        this.client = client;
        init();
    }

    public void run() {

        logger.info(" Commander started on " +
                this.client.getNode().getCredentials().getHost() + " Waiting for commands...");

        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                logger.error(e.getMessage());
            }
            Scanner scanner = new Scanner(System.in);
            String command = scanner.nextLine();
            if (command.equals("-1")) {
                this.client.leave();
                logger.info("Node " + this.client.getNode().getCredentials().getHost() + " has gracefully left!");
                break;
            }
            logger.info("Node " + this.client.getNode().getCredentials().getHost() +
                    " received command line input");
        }
    }

    public void init() {
        try {
            new Thread(this).start();
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }


}
