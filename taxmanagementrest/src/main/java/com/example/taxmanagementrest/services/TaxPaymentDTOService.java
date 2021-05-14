package com.example.taxmanagementrest.services;
import com.example.taxmanagementrest.models.TaxPayment;
import com.example.taxmanagementrest.models.TaxPaymentDTO;
import com.example.taxmanagementrest.repository.TaxPaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

/**
 * TAX PAYMENT DTO SERVICE -
 * Creates a service for the tax payment DTO to allow the method creations for the converting of taxpayment data into the DTO
 * as well as methods to get all the DTOs and finding a DTO by ID.
 */

@Service
public class TaxPaymentDTOService
{
    @Autowired
    private TaxPaymentRepository taxPaymentRepository;

    private TaxPaymentDTO convertToTaxPaymentDTO(TaxPayment taxPayment)
    {
        TaxPaymentDTO taxPaymentDTO = new TaxPaymentDTO();
        taxPaymentDTO.setPaymentid(taxPayment.getPaymentid());
        taxPaymentDTO.setTaxid(taxPayment.getTaxInformation().getVehicleRegistration().getRegistrationid());
        taxPaymentDTO.setEnginestatsband(taxPayment.getTaxInformation().getEnginestatsband());
        taxPaymentDTO.setIsclassic(taxPayment.getTaxInformation().isIsclassic());
        taxPaymentDTO.setIsvalue(taxPayment.getTaxInformation().isIsvalue());
        taxPaymentDTO.setCost(taxPayment.getCost());
        taxPaymentDTO.setPaymentmethod(taxPayment.getPaymentmethod());
        taxPaymentDTO.setPaymentdate(taxPayment.getPaymentdate());

        return taxPaymentDTO;
    }

    @Cacheable("taxPaymentDTOs")
    public List<TaxPaymentDTO> getAllTaxPaymentDTO()
    {
        //Calls findAll to get all taxpayment entities from the taxpayment repo, converts them into a list of taxpayemntDTOs
        return ((List<TaxPayment>)taxPaymentRepository.findAll()).stream().map(this::convertToTaxPaymentDTO).collect(Collectors.toList());
    }

    @Cacheable("taxPaymentDTO")
    public TaxPaymentDTO getTaxPaymentDTOById(int id)
    {
        List<TaxPaymentDTO> taxPaymentDTOList =getAllTaxPaymentDTO();

        for(TaxPaymentDTO taxPaymentDTO : taxPaymentDTOList)
        {
            if(taxPaymentDTO.getPaymentid() ==id)
            {
                return taxPaymentDTO;
            }
        }
        return null;
    }


}
