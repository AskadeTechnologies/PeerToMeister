package com.askade.ptm.crm.service;

import com.askade.ptm.crm.dao.AppUserDao;
import com.askade.ptm.crm.model.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by AdrianIonita on 4/29/2017.
 */
@Service
@Transactional
public class AppUserServiceImpl implements AppUserService{

    @Autowired
    private AppUserDao appUserDao;
    /**
     * @param appUser
     */
    @Override
    @Transactional
    public void addAppUser(AppUser appUser) {
        appUserDao.addAppUser(appUser);
    }

    /**
     * @return
     */
    @Override
    @Transactional
    public List<AppUser> getAllAppUsers() {
        return appUserDao.getAllAppUsers();
    }

    /**
     * @param appUser
     * @return
     */
    @Override
    @Transactional
    public AppUser updateAppUser(AppUser appUser) {
        return appUserDao.updateAppUser(appUser);
    }

    /**
     * @param appUserId
     * @return
     */
    @Override
    public AppUser getAppUser(int appUserId) {
        return appUserDao.getAppUser(appUserId);
    }

    public void setAppUserDao(AppUserDao appUserDao) {
        this.appUserDao = appUserDao;
    }
}
