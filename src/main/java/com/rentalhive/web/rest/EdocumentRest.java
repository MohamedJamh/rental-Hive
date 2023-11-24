package com.rentalhive.web.rest;

import com.rentalhive.domain.Edocument;
import com.rentalhive.dto.EdocumentDto;
import com.rentalhive.dto.RoleDto;
import com.rentalhive.mapper.EdocumentMapper;
import com.rentalhive.service.EdocumentService;
import com.rentalhive.utils.Response;
import com.rentalhive.utils.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/edocument")
public class EdocumentRest {
    private final EdocumentService edocumentService;

    @Autowired
    public EdocumentRest(EdocumentService edocumentService) {
        this.edocumentService = edocumentService;
    }

    @PostMapping
    public ResponseEntity<Response<EdocumentDto>> save(@Valid @RequestBody EdocumentDto edocumentDto)
    {
        Response<EdocumentDto> response = new Response<>();
        Edocument edocument = EdocumentMapper.toEdocument(edocumentDto);
        try {
            response.setResult(EdocumentMapper.toDto(edocumentService.save(edocument)));
            response.setMessage("Edocument has been added successfully");
            return new ResponseEntity<>(response,HttpStatus.OK);
        }catch (ValidationException e)
        {
            response.setMessage("Edocument has not been added");
            response.setErrors(List.of(e.getCustomError()));
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping
    public ResponseEntity<List<EdocumentDto>> getAllEdocument()
    {
        List<Edocument> edocuments = edocumentService.getAllEdocument();
        List<EdocumentDto> edocumentDtos = new ArrayList<>();

        for (Edocument edocument : edocuments)
        {
            EdocumentDto edocumentDto = EdocumentMapper.toDto(edocument);
            edocumentDtos.add(edocumentDto);
        }
        return new ResponseEntity<>(edocumentDtos,HttpStatus.OK);
    }
}
