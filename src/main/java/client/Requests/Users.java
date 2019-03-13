package client.Requests;

public class Users {

    /**
     * Sends a request to log users into the system.
     * @param username the user to log in
     * @param password the password to authenticate the user
     * */
    public static void execLogin(String username, String password) {
        //Send over the username and password in the body of the request to the server.
        System.out.println("Logging " + username + " into the system.\nPassword:\t" + password);
    }

}
