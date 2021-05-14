package com.example.taxmanagementrest.repository;
import com.example.taxmanagementrest.models.VehicleRegistration;
import io.swagger.annotations.Api;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * VEHICLE REGISTRATION REPOSITORY -
 * Creates a Paging and sorting Repository for the vehicle registration entity.
 */

@Api(tags = "Address Entity")
@RepositoryRestResource(collectionResourceRel = "vehicleRegistration", path ="vehicleRegistration")
public interface VehicleRegistrationRepository extends PagingAndSortingRepository<VehicleRegistration, Integer> {
}