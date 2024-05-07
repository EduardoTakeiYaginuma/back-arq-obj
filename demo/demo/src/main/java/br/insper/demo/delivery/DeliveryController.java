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
    public void deleteDelivery(@PathVariable Integer id){
        deliveryService.deleteDelevery(id);
    }

    @PutMapping("/delivery")
    public void putDelivery(@RequestParam(required = true) Integer idDelivery, @RequestBody Integer status ){
        deliveryService.putDelivery(idDelivery, status);
    }

}
