package com.example.taxmanagementrest.repository;
import com.example.taxmanagementrest.models.TaxPaymentDTO;
import com.example.taxmanagementrest.services.TaxPaymentDTOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

/**
 * TAX PAYMENT DETAILS REPOSITORY -
 * Creates a Repository for the TaxPaymentDTO and maps the method for getting all the TaxPayment DTOs to /paymentdetails.
 * and maps the method for getting a DTO by Id to /paymentdetails/{id}
 */

@RestController
public class TaxPaymentDetailsRepository
{
    @Autowired
    private TaxPaymentDTOService taxPaymentDTOService;

    @GetMapping("/paymentdetails")
    public List<TaxPaymentDTO> getAllTaxPaymentDetails()
    {
        return taxPaymentDTOService.getAllTaxPaymentDTO();
    }

    @GetMapping("/paymentdetails/{id}")
    public TaxPaymentDTO getTaxPaymentDetailsById(@PathVariable("id") int paymentid)
    {
        TaxPaymentDTO taxPaymentDTO = taxPaymentDTOService.getTaxPaymentDTOById(paymentid);

        if(taxPaymentDTO != null)
        {
            return taxPaymentDTO;
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Payment ID not found");
    }
}
