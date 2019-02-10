package jmockit.examples.users.storage;

import jmockit.examples.users.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class UserInMemoryStoreImpl implements UserStore {
	private Map<String, User> users = new ConcurrentHashMap<String, User>();

	public User create(User user)
	throws Exception {
		System.out.println("UserInMemoryStoreImpl: Creating user");
		String userId = UserStoreHelper.getUniqueId();
		User clonedUser = user.clone();
		clonedUser.setId(userId);
		users.put(userId, clonedUser);
		return clonedUser.clone();
	}

	public User update(User user)
	throws Exception {
		System.out.println("UserInMemoryStoreImpl: Updating user");
		String userId = user.getId();
		User userById = this.findById(userId);
		if (userById == null) {
			throw new Exception("User not found, canno tbe updated");
		}
		return users.put(userId, user);
	}

	public User findById(String userId)
	throws Exception {
		User user = users.get(userId);
		return (user != null) ? user.clone() : null;
	}

	public List<User> fetchAll()
	throws Exception {
		List<User> resultUsers = new ArrayList<User>();
		for (User user: users.values()) {
			resultUsers.add(user.clone());
		}
		return resultUsers;
	}

	public void delete(String userId)
	throws Exception {
		User userById = this.findById(userId);
		if (userById != null) {
			users.remove(userId);
		}
	}
}
