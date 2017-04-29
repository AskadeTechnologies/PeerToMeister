package com.askade.ptm.crm.controller;

import com.askade.ptm.crm.model.AppUser;
import com.askade.ptm.crm.service.AppUserService;
import com.askade.ptm.utils.JsonResponse;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by AdrianIonita on 4/29/2017.
 */
@Controller
public class AppUserController {
    private static final Logger logger = Logger.getLogger(AppUserController.class);

    public AppUserController() {
    }

    @Autowired
    private AppUserService appUserService;

    @RequestMapping(value = "/addNewAppUser", method = RequestMethod.POST)
    public @ResponseBody JsonResponse addNewAppUser(@RequestBody AppUser appUser){
        appUserService.addAppUser(appUser);
        return JsonResponse.forSuccess();
    }

    @RequestMapping(value = "/getAppUsers", method = RequestMethod.GET)
    public @ResponseBody JsonResponse getAppUsers(){
        return JsonResponse.forSuccess(appUserService.getAllAppUsers());
    }
}
