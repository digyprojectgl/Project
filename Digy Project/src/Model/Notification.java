package Model;

/**
 * Created by Arthur on 26/02/2016.
 */
public class Notification {
    private String content;
    private Object type;
    private java.util.Date dateNotification;
    private boolean isRead;
    private User receiver;

    public boolean readNotification() {
        return false;
    }
}
