# password-manager

A secure Java CLI password manager that stores your credentials (website, username, password) in an *AES-256 encrypted file*.  
All data is protected by a master password, so only you can decrypt and view your saved credentials.

---

## Features

- AES-256 encryption for maximum security  
- Master password based access  
- Encrypted local storage (`passwords.enc`)  
- Stores data in encrypted JSON or text file

---

## Project Structure

```
password-manager/
├── src/
│ ├── Main.java               # entry point
│ ├── PasswordManager.java    # logic (add/view/delete)
│ ├── CryptoUtils.java        # handles AES encryption and decryption
│ ├── Credential.java         # represents a single login entry
│ └── DataStore.java          # loads and saves encrypted data to file
├── passwords.enc
└── README.md
```

---

## How It Works

- The user provides a master password at startup.
- The password is hashed (SHA-256) and used as the AES key.
- Credentials are stored in plaintext in memory, but AES-encrypted when saved to disk (passwords.enc).
- On the next startup, the same master password is required to decrypt the data.

---

### Compile and Run

```
javac src/*.java
java -cp src Main
```
