package com.mdma.whitelableservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.mdma.whitelableservice.model.Whitelabel;

@Repository
public interface WhitelabelRepository extends MongoRepository<Whitelabel, String> {
    Whitelabel findByRestaurantId(String id);
}
