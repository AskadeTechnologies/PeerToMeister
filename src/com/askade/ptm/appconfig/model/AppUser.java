package com.askade.ptm.appconfig.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by AdrianIonita on 4/29/2017.
 */
@Entity
@Table (name = "xxknl_app_users")
public class AppUser {

    private String userName;
    private String password;
    private boolean enabled;
    private Set<AppUserRoles> appUserRoles = new HashSet<AppUserRoles>(0);

    @Column(name = "user_name", unique = true, nullable = false)
    public String getUserName() {
        return userName;
    }

    @Column(name = "password", nullable = false)
    public String getPassword() {
        return password;
    }

    @Column(name = "enabled")
    public boolean isEnabled() {
        return enabled;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "xxknl_app_users")
    public Set<AppUserRoles> getAppUserRoles() {
        return appUserRoles;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public void setAppUserRoles(Set<AppUserRoles> appUserRoles) {
        this.appUserRoles = appUserRoles;
    }
}
