package com.example.taxmanagementrest.repository;
import com.example.taxmanagementrest.models.Vehicle;
import io.swagger.annotations.Api;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 * VEHICLE REPOSITORY -
 * Creates a CRUD Repository for the vehicle entity.
 */

@Api(tags = "Address Entity")
@RepositoryRestResource(collectionResourceRel = "vehicle", path ="vehicle")
@CrossOrigin
public interface VehicleRepository extends CrudRepository<Vehicle, Integer> {
}