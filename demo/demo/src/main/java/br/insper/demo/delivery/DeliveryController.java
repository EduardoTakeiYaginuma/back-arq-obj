package br.insper.demo.delivery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeliveryController {

    @Autowired
    private DeliveryService deliveryService;

    @PostMapping("/delivery")
    public Delivery saveDelivery(@RequestBody Delivery delivery) {
        return deliveryService.saveDelivery(delivery);
    }
    @GetMapping("/delivery")
    public List<Delivery> getDelivery(@RequestParam(required = false) String deliverymanCpf) {
        return deliveryService.listDelivery(deliverymanCpf);
    }
    @DeleteMapping("/delivery/{id}")
    public void deleteDelivery(@PathVariable String id){
        deliveryService.deleteDelevery(id);
    }

    @PutMapping("/delivery/{id}/deliveryman/{deliverymanCpf}")
    public void changeDeliveryStatus(@PathVariable Integer id, @PathVariable String deliverymanCpf, @RequestParam(required = true) String status){
        deliveryService.putDelivery(deliverymanCpf, status, id);
    }

}
