package com.example.taxmanagementrest.repository;
import io.swagger.annotations.Api;
import com.example.taxmanagementrest.models.Owner;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 * OWNER REPOSITORY -
 * Creates a CRUD Repository for the owner entity.
 */

@Api(tags = "Address Entity")
@RepositoryRestResource(collectionResourceRel = "owner", path ="owner")
@CrossOrigin
public interface OwnerRepository extends CrudRepository<Owner, Integer> {
}