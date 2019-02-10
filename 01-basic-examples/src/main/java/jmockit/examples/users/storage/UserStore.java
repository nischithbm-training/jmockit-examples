package jmockit.examples.users.storage;

import jmockit.examples.users.User;

import java.util.List;

public interface UserStore {
	/**
	 * Creates a user
	 * @param user
	 * @return
	 * @throws Exception
	 */
	User create(User user) throws Exception;

	/**
	 * Update a user
	 * @param user
	 * @return
	 * @throws Exception
	 */
	User update(User user) throws Exception;

	/**
	 * Find a user by userId
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	User findById(String userId) throws Exception;

	/**
	 * Fetch all users
	 * @return
	 * @throws Exception
	 */
	List<User> fetchAll() throws Exception;

	/**
	 * Delete a user by userId
	 * @param userId
	 * @throws Exception
	 */
	void delete(String userId) throws Exception;
}
