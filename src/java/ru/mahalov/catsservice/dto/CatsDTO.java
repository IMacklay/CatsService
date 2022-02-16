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
    private Integer tail_length;

    @JsonProperty("whiskers_length")
    private Integer whiskers_length;

    public CatsDTO(CatsEntity catsEntity){
        name = catsEntity.getName();
        color = catsEntity.getColor();
        tail_length = catsEntity.getTailLength();
        whiskers_length = catsEntity.getWhiskersLength();
    }
}
