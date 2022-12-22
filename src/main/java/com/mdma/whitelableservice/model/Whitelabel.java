package com.mdma.whitelableservice.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Whitelabel {

    @Id
    private String id;
    private String restaurantId;

    private String backgroundColour;
    private String primaryColour;
    private String textColour;
    private String imageString;
}
