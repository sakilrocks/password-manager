
public class Credential {
    private String site;
    private String username;
    private String password;


    public Credential(String site, String username, String password) {
        this.site = site;
        this.username = username;
        this.password = password;
    }


    @Override
    public String toString() {
        return String.format("site: %s\nusername: %s\npassword: %s\n", site, username, password);
    }

    public String toCSV() {
        return site + "," + username + "," + password;
    }

    public static Credential fromCSV(String csv) {
        String[] parts = csv.split(",");
        return new Credential(parts[0], parts[1], parts[2]);
    }
}
