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
        //Get whitelabel that needs update
        var whitelabelToUpdate = repository.findByRestaurantId(whitelabel.getRestaurantId());

        //Check if this whitelabel is present
        if (whitelabelToUpdate != null) {
            //Save new instance of whitelabel in database and check if it is the same as the send restaurant in the body
            if (repository.save(whitelabel) == whitelabel) {
                //Remove old instance of whitelabel, so it won't be doubled
                repository.delete(whitelabelToUpdate);
                //Give response back with call
                return new ResponseEntity<>("whitelabel has been updated", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Whitelabel failed to update", HttpStatus.BAD_REQUEST);
            }
        } else {
            //Whitelabel not found so give back message
            return new ResponseEntity<>("Whitelabel has not been updated: Whitelabel not found", HttpStatus.BAD_REQUEST);
        }
    }

}
