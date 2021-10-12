package by.chertko.delivery.Dto;

import by.chertko.delivery.Entity.Delivery;
import lombok.Data;

import javax.validation.constraints.Null;
import java.util.Date;

@Data
public class DeliveryDto {
    @Null
    private Long id;

    private String name;
    private String description;
    private Date dateOfCreation;
    private Long userId;

    public static Delivery toDelivery(DeliveryDto deliveryDto){
        //Delivery delivery = new Delivery();
        //delivery.setId(DeliveryDto.getId());
        //delivery.setName(DeliveryDto.getName());
        //delivery.setDescription(DeliveryDto.getDescription());
        //delivery.setDateOfCreation(DeliveryDto.getDateOfCreation());

        return null;
    }

    public static DeliveryDto fromDelivery(Delivery delivery) {
        //DeliveryDto deliveryDto = new DeliveryDto();
        //deliveryDto.setId(Delivery.getId());
        //deliveryDto.setName(Delivery.getName());
        //deliveryDto.setDescription(Delivery.getDescription());
        //deliveryDto.setDateOfCreation(Delivery.getDateOfCreation());
        //deliveryDto.setUserId(Delivery.getUser().getId());

        return null;
    }
}
