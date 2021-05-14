package com.example.taxmanagementrest.services;
import com.example.taxmanagementrest.models.TaxInformation;
import com.example.taxmanagementrest.models.TaxInformationDTO;
import com.example.taxmanagementrest.repository.TaxInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

/**
 * TAX INFORMATION DTO SERVICE -
 * Creates a service for the tax information DTO to allow the method creations for the converting of taxinformation data into the DTO
 * as well as methods to get all the DTOs and finding a DTO by ID.
 */

@Service
public class TaxInformationDTOService
{
    @Autowired
    private TaxInformationRepository taxInformationRepository;

    private TaxInformationDTO convertToTaxInformationDTO(TaxInformation taxInformation)
    {
        TaxInformationDTO taxInformationDTO = new TaxInformationDTO();
        taxInformationDTO.setTaxid(taxInformation.getTaxid());
        taxInformationDTO.setRegistrationid(taxInformation.getVehicleRegistration().getRegistrationid());
        taxInformationDTO.setRegistrationdate(taxInformation.getVehicleRegistration().getRegistrationdate());
        taxInformationDTO.setFirstname(taxInformation.getVehicleRegistration().getOwner().getFirstname());
        taxInformationDTO.setSecondname(taxInformation.getVehicleRegistration().getOwner().getSecondname());
        taxInformationDTO.setRegno(taxInformation.getVehicleRegistration().getVehicle().getRegno());
        taxInformationDTO.setMake(taxInformation.getVehicleRegistration().getVehicle().getMake());
        taxInformationDTO.setModel(taxInformation.getVehicleRegistration().getVehicle().getModel());
        taxInformationDTO.setYear(taxInformation.getVehicleRegistration().getVehicle().getYear());
        taxInformationDTO.setIsclassic(taxInformation.isIsclassic());
        taxInformationDTO.setValue(taxInformation.getVehicleRegistration().getVehicle().getValue());
        taxInformationDTO.setIsvalue(taxInformation.isIsvalue());
        taxInformationDTO.setEnginestats(taxInformation.getVehicleRegistration().getVehicle().getEnginestats());
        taxInformationDTO.setFueltype(taxInformation.getVehicleRegistration().getVehicle().getFueltype());
        taxInformationDTO.setEnginestatsband(taxInformation.getEnginestatsband());

        return taxInformationDTO;
    }

    public List<TaxInformationDTO> getAllTaxInformationDTO()
    {
        return ((List<TaxInformation>)taxInformationRepository.findAll()).stream().map(this::convertToTaxInformationDTO).collect(Collectors.toList());
    }

    public TaxInformationDTO getTaxInformationDTOById(int id)
    {
        List<TaxInformationDTO> taxInformationDTOList =getAllTaxInformationDTO();

        for(TaxInformationDTO taxInformationDTO : taxInformationDTOList)
        {
            if(taxInformationDTO.getTaxid() ==id)
            {
                return taxInformationDTO;
            }
        }
        return null;
    }

}
