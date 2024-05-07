package br.insper.demo.delivery;

import br.insper.demo.delivery.Delivery;
import br.insper.demo.delivery.DeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class DeliveryService {
    @Autowired
    private DeliveryRepository deliveryRepository;

    public Delivery saveDelivery(Delivery delivery) {
        if (delivery.getOrigin() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Origin information missing");
        }
        if (delivery.getDestination() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Destination information missing");
        }
        if (delivery.getTravelHours() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Travel hours information missing");
        }
        if (delivery.getTravelKm() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Travel km information missing");
        }
        if (delivery.getTotalPrice() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Total price information missing");
        }
        if (delivery.getDeliveryManId() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Deliveryman information missing");
        }
        if (delivery.getStatus().equals("CONFIRMADO") || delivery.getStatus().equals("ERRO") || delivery.getStatus().equals("FINALIZADO")){
            return deliveryRepository.save(delivery);
        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Status information invalid");


    }

    public List<Delivery> listDelivery(Integer idDeliveryMan){
        if (idDeliveryMan != null){
            return deliveryRepository.findByDeliveryManId(idDeliveryMan);
        }
        return deliveryRepository.findAll();
    }

    public void deleteDelevery(Integer idDelivery) {
        Optional deliveryList = deliveryRepository.findById(idDelivery);
        if (!deliveryList.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Delivery not found");
        }
        deliveryRepository.deleteById(idDelivery);

    }
}
