package ru.job4j.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.job4j.app.model.Order;

import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query("SELECT o FROM Order o JOIN o.customer c JOIN c.cards cd WHERE cd.number = :cardNumber")
    Optional<Order> findByCardNumber(@Param("cardNumber") String cardNumber);
}
