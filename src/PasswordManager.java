
import java.util.*;


public class PasswordManager {
    private List<Credential> credentials;
    private String masterPassword;

    public PasswordManager(String masterPassword) throws Exception {
        this.masterPassword = masterPassword;
        this.credentials = DataStore.load(masterPassword);
    }

    public void addCredential(String site, String user, String pass) {
        credentials.add(new Credential(site, user, pass));
    }

    public void viewAll() {
        if (credentials.isEmpty()) {
            System.out.println("no credentials saved yet");
            return;
        }
        credentials.forEach(System.out::println);
    }

    public void deleteCredential(String site) {
        credentials.removeIf(c -> c.toString().contains(site));
    }

    public void save() throws Exception {
        DataStore.save(credentials, masterPassword);
    }
}
