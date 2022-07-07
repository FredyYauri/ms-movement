package com.proyecto.movement.msmovement.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@Document(collection = "movements")
public class Movement {
    @Id
    private Integer idMovement;
    private Integer idAccount;
    private String movementType;
    private Float movenmetValue;

}
