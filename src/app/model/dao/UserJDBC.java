package app.model.dao;

import app.model.Comment;
import app.model.Notification;
import app.model.User;

public class UserJDBC extends User {
	
	UserJDBC(){
		super();
	}
	
	@Override
	public Comment postComment(User from, String message) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteComment(Comment comment) {
		// TODO Auto-generated method stub

	}

	@Override
	public Notification notify(String content) {
		// TODO Auto-generated method stub
		return null;
	}

}
