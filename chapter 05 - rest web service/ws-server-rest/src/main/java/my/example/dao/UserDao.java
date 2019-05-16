package my.example.dao;

import java.util.List;

import my.example.entities.User;

public interface UserDao {
	public User getUser(String uid);
    public User addUser(User user) ;
    public User updateUser(User user);
    public void deleteUser(String uid);
    public List<User> listUsers();
    public List<User> findUsersByName(String name); 
}
