package main.java.utils;

public class LoggedUser {
	
	public static String loggedInUser;

	public static String getLoggedInUser() {
		return loggedInUser;
	}

	public static void setLoggedInUser(String loggedInUser) {
		LoggedUser.loggedInUser = loggedInUser;
	}
}
