
import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class DataStore {
    private static final String FILE_PATH = "passwords.enc";

    public static void save(List<Credential> credentials, String masterPassword) throws Exception {
        StringBuilder sb = new StringBuilder();
        for (Credential c : credentials)
            sb.append(c.toCSV()).append("\n");
        String encrypted = CryptoUtils.encrypt(sb.toString(), masterPassword);
        try (FileWriter fw = new FileWriter(FILE_PATH)) {
            fw.write(encrypted);
        }
    }

    public static List<Credential> load(String masterPassword) throws Exception {
        File f = new File(FILE_PATH);
        if (!f.exists()) return new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(f));
        String encrypted = br.readLine();
        if (encrypted == null || encrypted.isEmpty()) return new ArrayList<>();
        String decrypted = CryptoUtils.decrypt(encrypted, masterPassword);
        List<Credential> creds = new ArrayList<>();
        for (String line : decrypted.split("\n")) {
            if (!line.trim().isEmpty())
                creds.add(Credential.fromCSV(line));
        }
        return creds;
    }
}
