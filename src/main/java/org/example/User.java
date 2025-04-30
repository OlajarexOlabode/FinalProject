package org.example;

public abstract class User {
    private String username;

    public User(String username) {
        this.username = username;
    }

    public abstract void viewMenu(Menu menu);
}
