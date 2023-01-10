package com.mdma.whitelableservice.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import com.mdma.whitelableservice.service.*;
import com.mdma.whitelableservice.model.*;

import lombok.AllArgsConstructor;

@CrossOrigin
@RestController
@RequestMapping("api/whitelabel")
@AllArgsConstructor
public class WhitelabelController {

    private final WhitelabelService whitelabelService;

    @GetMapping("/all")
    public ResponseEntity<List<Whitelabel>> GetAllWhitelabels() {
        return whitelabelService.GetAllWhitelabels();
    }

    @PostMapping("/create")
    public ResponseEntity<String> createWhitelable(@RequestBody Whitelabel whitelable) {
        return whitelabelService.CreateWhitelabel(whitelable);
    }

    @GetMapping("/get/{restaurantId}")
    public Whitelabel getWhitelabelFromRestaurant(@PathVariable String restaurantId) {
        return whitelabelService.GetWhiteLabelWithRestaurantId(restaurantId);
    }

    @PutMapping("update")
    public ResponseEntity<String> updateWhitelabel(@RequestBody Whitelabel whitelabel) {
        return whitelabelService.UpdateWhitelabelByRestaurantId(whitelabel);
    }
}
