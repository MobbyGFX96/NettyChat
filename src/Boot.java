import server.ChatServer;

/**
 * Created by corey on 19/07/14.
 */
public class Boot {

    public static void main(String[] args) {
        new ChatServer(43594).run();
    }

}
