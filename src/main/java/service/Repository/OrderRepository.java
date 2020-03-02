package service.Repository;

import org.springframework.data.repository.CrudRepository;
import service.Model.Order;

import java.util.List;

public interface OrderRepository extends CrudRepository<Order,Long> {
    List<Order> findAll();
}
