package com.example.taxmanagementrest.services;
import com.example.taxmanagementrest.models.VehicleRegistration;
import com.example.taxmanagementrest.models.VehicleRegistrationDTO;
import com.example.taxmanagementrest.repository.VehicleRegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

/**
 * VEHICLE REGISTRATION DTO SERVICE -
 * Creates a service for the vehicle registration DTO to allow the method creations for the converting of vehicle regostration data into the DTO
 * as well as methods to get all the DTOs and finding a DTO by ID.
 */

@Service
public class VehicleRegistrationDTOService
{
    @Autowired
    private VehicleRegistrationRepository vehicleRegistrationRepository;

    private VehicleRegistrationDTO convertToVehicleRegistrationDTO(VehicleRegistration vehicleRegistration)
    {
        VehicleRegistrationDTO vehicleRegistrationDTO = new VehicleRegistrationDTO();
        vehicleRegistrationDTO.setRegistrationid(vehicleRegistration.getRegistrationid());
        vehicleRegistrationDTO.setRegistrationdate(vehicleRegistration.getRegistrationdate());
        vehicleRegistrationDTO.setOwnerid(vehicleRegistration.getOwner().getOwnerid());
        vehicleRegistrationDTO.setFirstname(vehicleRegistration.getOwner().getFirstname());
        vehicleRegistrationDTO.setSecondname(vehicleRegistration.getOwner().getSecondname());
        vehicleRegistrationDTO.setVehicleid(vehicleRegistration.getVehicle().getVehicleid());
        vehicleRegistrationDTO.setRegno(vehicleRegistration.getVehicle().getRegno());
        vehicleRegistrationDTO.setMake(vehicleRegistration.getVehicle().getMake());
        vehicleRegistrationDTO.setModel(vehicleRegistration.getVehicle().getModel());

        return vehicleRegistrationDTO;
    }
    @Cacheable("vehicleRegDTOs")
    public List<VehicleRegistrationDTO> getAllVehicleRegistrationDTO()
    {
        //Calls findAll to get all vehiclereg entities from the vehiclereg repo, converts them into a list of vehicleDTOS
        return ((List<VehicleRegistration>)vehicleRegistrationRepository.findAll()).stream().map(this::convertToVehicleRegistrationDTO).collect(Collectors.toList());
    }

    @Cacheable("vehicleRegistrationDTO")
    public VehicleRegistrationDTO getVehicleRegistrationDTOById(int id)
    {
        List<VehicleRegistrationDTO> vehicleRegistrationDTOList =getAllVehicleRegistrationDTO();

        for(VehicleRegistrationDTO vehicleRegistrationDTO : vehicleRegistrationDTOList)
        {
            if(vehicleRegistrationDTO.getRegistrationid() ==id)
            {
                return vehicleRegistrationDTO;
            }
        }
        return null;
    }

}
