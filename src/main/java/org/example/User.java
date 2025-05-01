package org.example;

public abstract class User {
    private String username;

    public User(String username) {
        this.username = username;
    }

    /**
     * abstract method to view menu
     * @param menu the menu to be viewed
     */
    public abstract void viewMenu(Menu menu);
}
