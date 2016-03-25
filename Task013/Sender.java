package Task013;

/**
 * Created by ruslanzigansin on 25.03.16.
 */
public class Sender {
    public String getName() {
        return name;
    }

    private String name;

    public Sender(String name) {
        this.name = name;
    }

    public void sendEmail(String email) {
        System.out.println("I am sending email: " + email);
    }
}
