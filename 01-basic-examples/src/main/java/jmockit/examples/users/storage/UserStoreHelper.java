package jmockit.examples.users.storage;

import java.util.UUID;

public class UserStoreHelper {
	public static String getUniqueId() {
		return UUID.randomUUID().toString();
	}
}
