package com.university.lab567.model;

public enum Permission {
    ADMIN_READ("admin:read"),
    ADMIN_WRITE("admin:write");
    private final String permission;

    Permission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
