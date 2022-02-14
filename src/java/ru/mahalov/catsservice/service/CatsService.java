package ru.mahalov.catsservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mahalov.catsservice.dto.CatsDTO;
import ru.mahalov.catsservice.entities.CatsEntity;
import ru.mahalov.catsservice.repository.CatsEntityRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CatsService {

    @Autowired
    private CatsEntityRepository catsEntityRepository;

    public List<CatsDTO> getAllCats(){
        return catsEntityRepository.findAll().stream()
                .map(CatsDTO::new)
                .collect(Collectors.toList());
    }

    public void saveCat(CatsDTO catsDTO){
        catsEntityRepository.save(new CatsEntity(catsDTO));
    }

}
