package com.askade.ptm.appconfig.controller;

import com.askade.ptm.appconfig.model.DocumentType;
import com.askade.ptm.appconfig.service.DocumentTypeService;
import com.askade.ptm.crm.model.ClientUser;
import com.askade.ptm.utils.JsonResponse;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by AdrianIonita on 5/1/2017.
 */
@Controller
public class ClientConfigController {
    private static final Logger logger = Logger.getLogger(ClientConfigController.class);

    @Autowired
    private DocumentTypeService documentTypeService;

    @RequestMapping(value = "/addNewDocumentType", method = RequestMethod.POST)
    public @ResponseBody JsonResponse addNewDocumentType(@RequestBody DocumentType documentType){
        documentTypeService.addDocumentType(documentType);
        return JsonResponse.forSuccess();
    }

    @RequestMapping(value = "/config/clients/getDocumentTypes", method = RequestMethod.GET)
    public @ResponseBody JsonResponse getDocumentTypes(){
        documentTypeService.getAllDocumentTypes();
        return JsonResponse.forSuccess();
    }


}
