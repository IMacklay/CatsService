package ru.mahalov.catsservice.dto;

import com.fasterxml.jackson.annotation.*;
import lombok.*;
import ru.mahalov.catsservice.entities.CatsEntity;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CatsDTO implements Serializable {
    private String name;
    private String color;

    @JsonProperty("tail_length")
    @JsonAlias("tail_length")
    private Integer tailLength;

    @JsonProperty("whiskers_length")
    private Integer whiskersLength;

    public CatsDTO(CatsEntity catsEntity){
        name = catsEntity.getName();
        color = catsEntity.getColor();
        tailLength = catsEntity.getTailLength();
        whiskersLength = catsEntity.getWhiskersLength();
    }
}
