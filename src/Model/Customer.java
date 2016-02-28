package Model;

import java.util.Collection;
import java.util.Date;

/**
 * Created by Arthur on 26/02/2016.
 */
class Customer extends User {

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

    public void addEntry(Entry ent) {
    }

    public Collection<Entry> getEntries() {
        return null;
    }

    public void deleteEntry(Entry entry) {
    }

    public void addGoal(String name, String description, Date deadline, Activity activity) {
    }

    public Activity createActivity(String name, Date date, String place, ActivityCategory category, String description) {
        return null;
    }

}
