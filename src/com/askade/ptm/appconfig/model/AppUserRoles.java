package com.askade.ptm.appconfig.model;

import javax.persistence.*;

/**
 * Created by AdrianIonita on 4/29/2017.
 */
@Entity
@Table (name = "xxknl_app_user_roles")
public class AppUserRoles {
    private Integer userRoleId;
    private AppUser appUser;
    private String role;

    public AppUserRoles() {
    }

    @Id
    @GeneratedValue
    @Column (name = "user_role_id")
    public Integer getUserRoleId() {
        return userRoleId;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    public AppUser getAppUser() {
        return appUser;
    }

    @Column (name = "role")
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setUserRoleId(Integer userRoleId) {
        this.userRoleId = userRoleId;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }
}
