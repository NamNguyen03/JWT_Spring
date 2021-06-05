package com.namNguyen03.springSecurityJWT.models.Enum;

public enum EPermission {
	CONSUMER("consumer"),
    ADMIN_READ("admin:read"),
    ADMIN_WRITE("admin:write");

    private final String permission;

    EPermission(String permission) {
        this.permission = permission;
    }

    String getPermission(){
        return permission;
    }
}
