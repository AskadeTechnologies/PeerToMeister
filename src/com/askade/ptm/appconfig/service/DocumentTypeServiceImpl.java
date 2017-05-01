package com.askade.ptm.appconfig.service;

import com.askade.ptm.appconfig.dao.DocumentTypeDao;
import com.askade.ptm.appconfig.model.DocumentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.List;

/**
 * Created by AdrianIonita on 5/1/2017.
 */
@Service
@Transactional
public class DocumentTypeServiceImpl implements DocumentTypeService{

    @Autowired
    private DocumentTypeDao documentTypeDao;

    @Override
    @Transactional
    public DocumentType findByCode(String code) {
        return documentTypeDao.findByCode(code);
    }

    @Override
    @Transactional
    public DocumentType findById(BigInteger documentId) {
        return documentTypeDao.findById(documentId);
    }

    @Override
    @Transactional
    public List<DocumentType> getAllDocumentTypes() {
        return documentTypeDao.getAllDocumentTypes();
    }

    @Override
    @Transactional
    public void addDocumentType(DocumentType documentType) {
        documentTypeDao.addDocumentType(documentType);
    }

    @Override
    @Transactional
    public void updateDocumentType(DocumentType documentType) {
        documentTypeDao.updateDocumentType(documentType);
    }
}
