package ru.mahalov.catsservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import ru.mahalov.catsservice.dto.CatsDTO;
import ru.mahalov.catsservice.entities.CatsEntity;

import java.util.List;

public interface CatsEntityRepository extends JpaRepository<CatsEntity, String> {

}