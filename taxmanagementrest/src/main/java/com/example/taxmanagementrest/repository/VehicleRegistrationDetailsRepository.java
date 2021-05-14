package com.example.taxmanagementrest.repository;
import com.example.taxmanagementrest.models.VehicleRegistrationDTO;
import com.example.taxmanagementrest.services.VehicleRegistrationDTOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

/**
 * VEHICLE REGISTRATION DETAILS REPOSITORY -
 * Creates a Repository for the VehicleRegistrationDTO and maps the method for getting all the VehicleRegistration DTOs to /registrationdetails.
 * and maps the method for getting a DTO by Id to /registrationdetails/{id}
 */

@RestController
public class VehicleRegistrationDetailsRepository
{
    @Autowired
    private VehicleRegistrationDTOService vehicleRegistrationDTOService;

    @GetMapping("/registrationdetails")
    public List<VehicleRegistrationDTO> getAllVehicleRegDetails()
    {
        return vehicleRegistrationDTOService.getAllVehicleRegistrationDTO();
    }

    @GetMapping("/registrationdetails/{id}")
    public VehicleRegistrationDTO getVehicleRegistrationDTOById(@PathVariable("id") int registrationid)
    {
        VehicleRegistrationDTO vehicleRegistrationDTO = vehicleRegistrationDTOService.getVehicleRegistrationDTOById(registrationid);

        if(vehicleRegistrationDTO != null)
        {
            return vehicleRegistrationDTO;
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Registration ID not found");
    }
}
