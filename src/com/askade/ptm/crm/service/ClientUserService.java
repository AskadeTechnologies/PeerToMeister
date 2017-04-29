package com.askade.ptm.crm.service;

import com.askade.ptm.crm.model.ClientUser;

import java.util.List;

/**
 * Created by AdrianIonita on 4/29/2017.
 */
public interface ClientUserService {

    /**
     * @param clientUser
     */
    public void addClientUser(ClientUser clientUser);

    /**
     * @return
     */
    public List<ClientUser> getAllClientUsers();

    /**
     * @param clientUser
     * @return
     */
    public ClientUser updateClientUser(ClientUser clientUser);

    /**
     * @param clientUserId
     * @return
     */
    public ClientUser getClientUser(int clientUserId);
}
