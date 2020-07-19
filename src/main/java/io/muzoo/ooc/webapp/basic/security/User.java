package io.muzoo.ooc.webapp.basic.security;

public class User {

    private String username;
    private String firstname;
    private String surname;
    private String password;


    public User(String username, String firstname, String surname, String password) {
        this.username = username;
        this.firstname = firstname;
        this.surname = surname;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSurname() {
        return surname;
    }

    public String getPassword() {
        return password;
    }
}


