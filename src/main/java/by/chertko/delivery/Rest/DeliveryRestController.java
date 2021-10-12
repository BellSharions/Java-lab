package by.chertko.delivery.Rest;

import by.chertko.delivery.Dto.DeliveryDto;
import by.chertko.delivery.Entity.Delivery;
import by.chertko.delivery.Logging.Loggable;
import by.chertko.delivery.Service.DeliveryService;
import by.chertko.delivery.Service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*")
@Controller
@RequestMapping(value = "/api/deliveries/")
public class DeliveryRestController {

    private final DeliveryService deliveryService;

    private final UserService userService;

    public DeliveryRestController(DeliveryService deliveryService, UserService userService) {
        this.deliveryService = deliveryService;
        this.userService = userService;
    }

    @Loggable
    @GetMapping(value = "list")
    public ResponseEntity<List<DeliveryDto>> getDeliveries(Principal principal) {
        //List<Delivery> deliveries = DeliveryService.findAllByUserId(userService.findByName(principal.getName()).getId());
        List<DeliveryDto> result = new ArrayList<>();

        //for (Delivery delivery : delivery) {
        //    result.add(DeliveryDto.fromDelivery(delivery));
        //}

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @Loggable
    @DeleteMapping(value = "{id}")
    public ResponseEntity<DeliveryDto> deleteDelivery(@PathVariable("id") Long id){
        //DeliveryService.deleteDeliveryById(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
