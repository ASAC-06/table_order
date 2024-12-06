package asac.hackathon.table_order.table_order.repository;

import asac.hackathon.table_order.table_order.entity.OrderLineItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LineItemRepository extends JpaRepository<OrderLineItem, Long> {
}
