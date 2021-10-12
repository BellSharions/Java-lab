package by.chertko.delivery.Service.impl;

import by.chertko.delivery.Entity.Delivery;
import by.chertko.delivery.Logging.Loggable;
import by.chertko.delivery.Repository.DeliveryRepository;
import by.chertko.delivery.Service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DeliveryServiceImpl implements DeliveryService {
    private final DeliveryRepository deliveryRepository;

    @Autowired
    public DeliveryServiceImpl(DeliveryRepository deliveryRepository) {
        this.deliveryRepository = deliveryRepository;
    }

    @Override
    @Loggable
    public Delivery findByName(String name) {
        return deliveryRepository.findByName(name);
    }

    @Override
    @Loggable
    public List<Delivery> findAllByUserId(Long id) {
        return deliveryRepository.findAllByUserId(id);
    }

    @Override
    @Loggable
    @Transactional
    public void deleteDeliveryById(Long id) {
        deliveryRepository.deleteDeliveryById(id);
    }
}
