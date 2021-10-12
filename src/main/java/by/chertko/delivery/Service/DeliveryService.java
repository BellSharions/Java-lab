package by.chertko.delivery.Service;

import by.chertko.delivery.Entity.Delivery;

import java.util.List;

public interface DeliveryService {
    Delivery findByName(String name);
    List<Delivery> findAllByUserId(Long id);
    void deleteDeliveryById(Long id);
}
