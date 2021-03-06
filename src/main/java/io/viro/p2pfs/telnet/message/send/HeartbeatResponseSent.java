package io.viro.p2pfs.telnet.message.send;

import io.viro.p2pfs.Constant;
import io.viro.p2pfs.telnet.credentials.NodeCredentials;

/**
 * Send a Heartbeat response.
 */
public class HeartbeatResponseSent extends Message {

    private NodeCredentials sender;
    private int code;

    public HeartbeatResponseSent(NodeCredentials sender, NodeCredentials receiver, int code) {
        super(receiver);
        this.sender = sender;
        this.code = code;
    }

    @Override
    public String getMessage() {
        StringBuilder message = new StringBuilder(Constant.NODEOK);
        message.append(Constant.SEPARATOR).append(code)
                .append(Constant.SEPARATOR).append(sender.getHost())
                .append(Constant.SEPARATOR).append(sender.getPort());
        return message.toString();
    }

    public NodeCredentials getSender() {
        return sender;
    }
}
