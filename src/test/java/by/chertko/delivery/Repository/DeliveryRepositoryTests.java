package by.chertko.delivery.Repository;

import by.chertko.delivery.Entity.Delivery;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DeliveryRepositoryTests {

    @Autowired
    private  DeliveryRepository deliveryRepository;

    @Test
    public void getUserByName() {
        List<Delivery> deliveries = deliveryRepository.findAll();
        System.out.println(deliveries);

        Assert.assertNotNull(deliveries);
    }
}
