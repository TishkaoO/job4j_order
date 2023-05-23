package ru.job4j.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.job4j.app.entity.CardEntity;

@Repository
public interface CardRepository extends JpaRepository<CardEntity, Long> {
}
