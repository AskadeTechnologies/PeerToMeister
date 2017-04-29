package com.askade.ptm.crm.dao;

import com.askade.ptm.crm.model.AppUser;
import org.hibernate.SessionFactory;
import org.hibernate.procedure.ProcedureCall;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.ParameterMode;
import java.math.BigInteger;
import java.util.List;

/**
 * Created by AdrianIonita on 4/29/2017.
 */
@Repository
public class AppUserDaoImpl implements AppUserDao {

    @Autowired
    private SessionFactory sessionFactory;

    private final String sequenceName = "xxptm_users_s";

    /**
     * @param appUser
     */
    @Override
    public void addAppUser(AppUser appUser) {
        ProcedureCall pc = sessionFactory.getCurrentSession().createStoredProcedureCall(this.sequenceName);
        pc.registerParameter(1, BigInteger.class, ParameterMode.OUT);
        appUser.setUserId((BigInteger)pc.getOutputs().getOutputParameterValue(1));
        sessionFactory.getCurrentSession().saveOrUpdate(appUser);
    }

    /**
     * @return
     */
    @Override
    public List<AppUser> getAllAppUsers() {
        return sessionFactory.getCurrentSession().createQuery("from AppUser order by userId desc").list();
    }

    /**
     * @param appUser
     * @return
     */
    @Override
    public AppUser updateAppUser(AppUser appUser) {
        sessionFactory.getCurrentSession().update(appUser);
        return appUser;
    }

    /**
     * @param appUserId
     * @return
     */
    @Override
    public AppUser getAppUser(int appUserId) {
        return (AppUser) sessionFactory.getCurrentSession().get(AppUser.class, appUserId);
    }
}
