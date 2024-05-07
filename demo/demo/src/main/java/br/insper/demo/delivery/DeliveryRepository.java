package br.insper.demo.delivery;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;
import java.util.Optional;

public interface DeliveryRepository extends JpaRepository<Delivery, Integer> {
    List<Delivery> findByDeliverymanCpf(String deliverymanCpf);

    Optional<Delivery> findById(Integer id);


}
