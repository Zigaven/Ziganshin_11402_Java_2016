package sample.connection;

import sample.entities.roles.Role;

import java.util.Base64;

/**
 * Created by ruslanzigansin on 26.05.16.
 */
public class ServerAuthentication {
    private static String loginPass;
    public static Role role;

    private ServerConnection server = new ServerConnection();

    static String getLoginPass() {
        return loginPass;
    }

    public boolean tryAuth(String login, String password) {
        save(login, password);

        try {
            Role role = server.getUserRole();
            ServerAuthentication.role = role;
            System.out.println(role);
            return true;
        } catch (CustomException e) {
            System.out.println(e.getStatusCode());
        } catch (Exception exc) {
            exc.printStackTrace();
        }

        return false;
    }

    private void save(String login, String password) {
        byte[] bytes = (login + ":" + password).getBytes();
        loginPass = "Basic " + Base64.getEncoder().encodeToString(bytes);;
    }
}
