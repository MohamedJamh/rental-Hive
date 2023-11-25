package com.rentalhive.service.impl;

import com.rentalhive.domain.Edocument;
import com.rentalhive.repository.ContractRepository;
import com.rentalhive.repository.EdocumentRepository;
import com.rentalhive.repository.OrganizationRepository;
import com.rentalhive.repository.UserRepository;
import com.rentalhive.service.EdocumentService;
import com.rentalhive.utils.CustomError;
import com.rentalhive.utils.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.apache.tomcat.util.codec.binary.Base64.isBase64;

@Service
public class EdocumentServiceImp implements EdocumentService {
    private EdocumentRepository edocumentRepository;
    private UserRepository userRepository;
    private OrganizationRepository organizationRepository;
    private ContractRepository contractRepository;


    @Autowired
    public EdocumentServiceImp(EdocumentRepository edocumentRepository, UserRepository userRepository, OrganizationRepository organizationRepository,ContractRepository contractRepository) {
        this.edocumentRepository = edocumentRepository;
        this.userRepository = userRepository;
        this.organizationRepository = organizationRepository;
        this.contractRepository = contractRepository;
    }

    @Override
    public Edocument save(Edocument edocument) throws ValidationException {
        if (edocument.getModelId() == null || !isBase64Encoded(edocument.getClasspath())) {
            throw new ValidationException(new CustomError("name", "Invalid id or path name"));
        }

        if ("USER".equals(edocument.getModelName())) {
            return validateAndSave(edocument, userRepository);
        } else if ("CONTRACT".equals(edocument.getModelName())) {
            return validateAndSave(edocument, contractRepository);
        } else if ("ORGANIZATION".equals(edocument.getModelName())) {
            return validateAndSave(edocument, organizationRepository);
        } else {
            throw new ValidationException(new CustomError("name", "Invalid model name"));
        }
    }

    @Override
    public List<Edocument> getAllEdocument() {
        return edocumentRepository.findAll();
    }

    private Edocument validateAndSave(Edocument edocument, JpaRepository<?, Long> repository) throws ValidationException {
        if (repository.findById(edocument.getModelId()).isPresent()) {
            return edocumentRepository.save(edocument);
        } else {
            throw new ValidationException(new CustomError("name", "Entity not found"));
        }
    }

    private boolean isBase64Encoded(String str) {
        return isBase64(str);
    }
}
