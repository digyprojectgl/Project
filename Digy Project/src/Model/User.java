package Model;

/**
 * Created by Arthur on 26/02/2016.
 */
public abstract class User {
    public String userID;
    public String password;
    public String name;
    private String adress;
    private String tel;
    private String email;

    public abstract Comment postComment(User from, String message);

    public abstract void deleteComment(Comment comment);

    public abstract Notification notify(String content);
}
