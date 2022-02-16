package ru.mahalov.catsservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.mahalov.catsservice.dto.CatsDTO;
import ru.mahalov.catsservice.service.CatsService;

import java.util.List;

@RestController
public class CatsController {

    @Autowired
    private CatsService catsService;

    @GetMapping("/cats")
    public ResponseEntity<List<CatsDTO>> getAllCats(){
        return new ResponseEntity<>(catsService.getAllCats(), HttpStatus.OK);
    }

    @PostMapping("/cat")
    public ResponseEntity<?> saveCat(CatsDTO catsDTO){
        catsService.saveCat(catsDTO);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
