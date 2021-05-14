package com.example.taxmanagementrest.repository;
import com.example.taxmanagementrest.models.TaxPayment;
import io.swagger.annotations.Api;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * TAX INFORMATION REPOSITORY -
 * Creates a Paging and sorting Repository for the tax information entity.
 */

@Api(tags = "Address Entity")
@RepositoryRestResource(collectionResourceRel = "taxPayment", path ="taxPayment")
public interface TaxPaymentRepository extends PagingAndSortingRepository<TaxPayment, Integer> {
}