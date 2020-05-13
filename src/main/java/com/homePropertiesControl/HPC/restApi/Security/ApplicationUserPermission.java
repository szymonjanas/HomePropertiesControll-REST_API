package com.homePropertiesControl.HPC.restApi.Security;

public enum ApplicationUserPermission {
    SENSOR_READ("sensor:read"),
    SENSOR_WRITE("sensor:write"),
    SENSOR_ADD("sensor:add"),
    SENSOR_DELETE("sensor:delete"),
    ANDROID_READ("android:read"),
    ANDROID_WRITE("android:write");

    private final String permission;

    ApplicationUserPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission(){
        return permission;
    }
}
