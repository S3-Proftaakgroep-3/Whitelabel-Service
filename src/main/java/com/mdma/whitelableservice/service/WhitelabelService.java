package com.mdma.whitelableservice.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mdma.whitelableservice.model.Whitelabel;
import com.mdma.whitelableservice.repository.WhitelabelRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class WhitelabelService {
    private final WhitelabelRepository repository;

    public ResponseEntity<List<Whitelabel>> GetAllWhitelabels() {
        return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
    };

    public ResponseEntity<String> CreateWhitelabel(Whitelabel whitelabel) {
        if (repository.save(whitelabel) == whitelabel)
            return new ResponseEntity<>("Whitelable has been saved", HttpStatus.OK);
        else
            return new ResponseEntity<>("Whitelable has not been saved", HttpStatus.BAD_REQUEST);

    }

    public Whitelabel GetWhiteLabelWithRestaurantId(String id) {
        return repository.findByRestaurantId(id);
    }

    public ResponseEntity<String> UpdateWhitelabelByRestaurantId(Whitelabel whitelabel) {
        if (repository.findByRestaurantId(whitelabel.getRestaurantId()) != null) {
            if (repository.save(whitelabel) == whitelabel) {
                return new ResponseEntity<>("whitelabel has been saved", HttpStatus.OK);
            } else
                return new ResponseEntity<>("Whitelabel failed to update", HttpStatus.BAD_REQUEST);

        } else {
            return new ResponseEntity<>("Whitelabel has not been updated: Whitelabel not found",
                    HttpStatus.BAD_REQUEST);
        }
    }

}
