package jmockit.examples.users;

import jmockit.examples.basicwithoutmocking.CommonUtil;
import jmockit.examples.mockingstaticmethods.ValidationUtil;
import jmockit.examples.users.storage.UserStore;

import java.util.List;

public class UserService {
	private UserStore userStore;

	public UserService(UserStore userStore) {
		this.userStore = userStore;
	}

	/**
	 * Creates a user if user.id is absent, else updates it
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public User save(User user)
	throws Exception {
		ValidationUtil.validateShouldNotBeEmpty(user, "user");
		ValidationUtil.validateStringShouldNotBeEmpty(user.getUserName(), "userName");
		ValidationUtil.validateStringShouldNotBeEmpty(user.getPassword(), "password");

		if (CommonUtil.isStringEmptyOrNull(user.getId())) {
			return userStore.create(user);
		}
		return userStore.update(user);
	}

	/**
	 * Find a user by userId
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public User findById(String userId)
	throws Exception {
		ValidationUtil.validateStringShouldNotBeEmpty(userId, "userId");
		return userStore.findById(userId);
	}

	/**
	 * Fetch all users
	 * @return
	 * @throws Exception
	 */
	public List<User> fetchAll()
	throws Exception {
		return userStore.fetchAll();
	}

	/**
	 * Delete a user by userId
	 * @param userId
	 * @throws Exception
	 */
	public void delete(String userId)
	throws Exception {
		ValidationUtil.validateStringShouldNotBeEmpty(userId, "userId");
		userStore.delete(userId);
	}
}
