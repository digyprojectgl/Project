package Model;

/**
 * Created by Arthur on 26/02/2016.
 */
public class Admin extends User {
    @Override
    public Comment postComment(User from, String message) {
        return null;
    }

    @Override
    public void deleteComment(Comment comment) {

    }

    @Override
    public Notification notify(String content) {
        return null;
    }
}
