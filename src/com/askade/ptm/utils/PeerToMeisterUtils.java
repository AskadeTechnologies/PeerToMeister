package com.askade.ptm.utils;

import java.util.Date;

/**
 * Created by AdrianIonita on 4/29/2017.
 */
public class PeerToMeisterUtils {

    public final static String ANONYMOUS = "anonymous";

    /**
     * @return
     */
    public static Date getCurrentDate() {
        Date currentDate = new Date(System.currentTimeMillis());
        return currentDate;
    }
}
