package ru.mahalov.catsservice.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import ru.mahalov.catsservice.dto.CatsDTO;

import javax.persistence.*;

@Entity
@Table(name = "cats", schema = "public", catalog = "catsdb")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class CatsEntity {

    @Id
    @Column(name = "name")
    private String name;

    @Column(name = "color")
    private String color;

    @Basic
    @Column(name = "tail_length")
    private Integer tailLength;

    @Basic
    @Column(name = "whiskers_length")
    private Integer whiskersLength;

    public CatsEntity(CatsDTO catsDTO){
        name = catsDTO.getName();
        color = catsDTO.getColor();
        tailLength = catsDTO.getTail_length();
        whiskersLength = getWhiskersLength();
    }
}
