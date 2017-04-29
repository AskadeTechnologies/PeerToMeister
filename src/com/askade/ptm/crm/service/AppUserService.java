package com.askade.ptm.crm.service;

import com.askade.ptm.crm.model.AppUser;

import java.util.List;

/**
 * Created by AdrianIonita on 4/29/2017.
 */
public interface AppUserService {

    /**
     * @param appUser
     */
    public void addAppUser(AppUser appUser);

    /**
     * @return
     */
    public List<AppUser> getAllAppUsers();

    /**
     * @param appUser
     * @return
     */
    public AppUser updateAppUser(AppUser appUser);

    /**
     * @param appUserId
     * @return
     */
    public AppUser getAppUser(int appUserId);
}
