package com.example.taxmanagementrest.repository;

import com.example.taxmanagementrest.models.TaxInformationDTO;
import com.example.taxmanagementrest.services.TaxInformationDTOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

/**
 * TAX INFORMATION DETAILS REPOSITORY -
 * Creates a Repository for the TaxInformationDTO and maps the method for getting all the TaxInformation DTOs to /taxdetails.
 * and maps the method for getting a DTO by Id to /taxdetails/{id}
 */

@RestController
public class TaxInformationDetailsRepository
{
    @Autowired
    private TaxInformationDTOService taxInformationDTOService;

    @GetMapping("/taxdetails")
    public List<TaxInformationDTO> getAllTaxDetails()
    {
        return taxInformationDTOService.getAllTaxInformationDTO();
    }

    @GetMapping("/taxdetails/{id}")
    public TaxInformationDTO getPlatesById(@PathVariable("id") int taxid)
    {
        TaxInformationDTO taxInformationDTO = taxInformationDTOService.getTaxInformationDTOById(taxid);

        if(taxInformationDTO != null)
        {
            return taxInformationDTO;
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Tax ID not found");
    }
}
