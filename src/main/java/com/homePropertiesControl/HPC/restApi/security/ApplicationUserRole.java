package com.homePropertiesControl.HPC.restApi.security;

import com.google.common.collect.Sets;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

import static com.homePropertiesControl.HPC.restApi.security.ApplicationUserPermission.*;

public enum ApplicationUserRole {
    SENSOR(Sets.newHashSet(SENSOR_READ, SENSOR_WRITE)),
    ANDROID(Sets.newHashSet(ANDROID_READ, ANDROID_WRITE)),
    ADMIN(Sets.newHashSet(SENSOR_READ, SENSOR_WRITE, SENSOR_ADD, SENSOR_DELETE));

    private final Set<ApplicationUserPermission> permission;

    ApplicationUserRole(Set<ApplicationUserPermission> permission) {
        this.permission = permission;
    }

    public Set<ApplicationUserPermission> getPermission() {
        return permission;
    }

    public Set<SimpleGrantedAuthority> getGrantedAuthority(){
        Set<SimpleGrantedAuthority> permissions = getPermission().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
        permissions.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return permissions;
    }
}
