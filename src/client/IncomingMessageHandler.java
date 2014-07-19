package client;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundMessageHandlerAdapter;

/**
 * Created by corey on 19/07/14.
 */
public class IncomingMessageHandler extends ChannelInboundMessageHandlerAdapter<String> {

    @Override
    public void messageReceived(ChannelHandlerContext context, String message) throws Exception {
        System.out.println(message);
    }

}
