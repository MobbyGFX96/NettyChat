package server;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundMessageHandlerAdapter;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;

/**
 * Created by corey on 19/07/14.
 */
public class OutgoingMessageHandler extends ChannelInboundMessageHandlerAdapter<String> {

    private static final ChannelGroup channels = new DefaultChannelGroup();

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        Channel incoming = ctx.channel();
        for (Channel channel : channels) {
            channel.write("[Server] " + incoming.remoteAddress() + " has joined the chat.\n");
        }
        channels.add(ctx.channel());
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        Channel incoming = ctx.channel();
        for (Channel channel : channels) {
            channel.write("[Server] " + incoming.remoteAddress() + " has left the chat.\n");
        }
        channels.remove(ctx.channel());
    }

    @Override
    public void messageReceived(ChannelHandlerContext context, String message) throws Exception {
        Channel incomingMessage = context.channel();

        for (Channel channel : channels) {
            if (channel != incomingMessage) {
                channel.write("[" + incomingMessage.remoteAddress() + "] " + message + "\n");
            }
        }

    }
}
