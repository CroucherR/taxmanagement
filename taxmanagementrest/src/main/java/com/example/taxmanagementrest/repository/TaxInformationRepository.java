package com.example.taxmanagementrest.repository;
import com.example.taxmanagementrest.models.TaxInformation;
import io.swagger.annotations.Api;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * TAX INFORMATION REPOSITORY -
 * Creates a Paging and sorting Repository for the tax information entity.
 */

@Api(tags = "Address Entity")
@RepositoryRestResource(collectionResourceRel = "taxInformation", path ="taxInformation")
public interface TaxInformationRepository extends PagingAndSortingRepository<TaxInformation,Integer> {
}
