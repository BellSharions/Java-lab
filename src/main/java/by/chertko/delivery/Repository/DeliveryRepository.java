package by.chertko.delivery.Repository;

import by.chertko.delivery.Entity.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeliveryRepository extends JpaRepository<Delivery, Long> {
    List<Delivery> findAllByUserId(Long id);
    Delivery findByName(String name);
    void deleteDeliveryById(Long id);
}
