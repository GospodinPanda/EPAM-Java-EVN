package com.epam.task2.manager;

import java.util.ResourceBundle;

public class ResourceManager {
    private static final ResourceBundle resourceBundle = ResourceBundle.getBundle("regex");

    public ResourceManager() {
    }

    public static String getProperty(String key) {
        return resourceBundle.getString(key);
    }
}
