package asac.hackathon.table_order.table_order.repository;

import asac.hackathon.table_order.table_order.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long>{

}


