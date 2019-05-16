package my.example.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import my.example.entities.User;

public class UserDaoMapImpl implements UserDao {
	
	private static Map<String, User> users = new HashMap<>();
	 
	@Override
	public User getUser(String uid) {
		return users.get(uid);
	}

	@Override
	public User addUser(User user) {
		Random random = new Random();
		user.setUid(String.valueOf(random.nextInt(100)));
		
		users.put(user.getUid(), user);
		return users.get(user.getUid());
	}

	@Override 
	public User updateUser(User user) {
		users.put(user.getUid(), user);
		return users.get(user.getUid());
	}

	@Override
	public void deleteUser(String uid) {
		users.remove(uid);
		return;

	}

	@Override
	public List<User> listUsers() {
		Collection<User> c = users.values();
        List<User> list = new ArrayList<>();
        list.addAll(c);
        return list;
	}

	@Override
	public List<User> findUsersByName(String name) {
		Collection<User> c = users.values();
		List<User> list = new ArrayList<>();
		
		for (User user : c) {
			if (user.getName().equals(name)){
				list.add(user);		
			}
		}
		return list;
	}

}
