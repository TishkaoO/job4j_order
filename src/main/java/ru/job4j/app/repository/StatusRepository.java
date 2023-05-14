package ru.job4j.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.job4j.app.model.StatusOrder;

import java.util.Optional;

@Repository
public interface StatusRepository extends JpaRepository<StatusOrder, Long> {

    @Query("SELECT s FROM StatusOrder s WHERE EXISTS (SELECT o FROM Order o "
            + "WHERE o.statusOrder = s AND o.numberOrder = :numberOrder)")
    Optional<StatusOrder> findByNumberOrder(@Param("numberOrder") int number);
}
