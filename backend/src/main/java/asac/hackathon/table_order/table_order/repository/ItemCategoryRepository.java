package asac.hackathon.table_order.table_order.repository;

import asac.hackathon.table_order.table_order.entity.ItemCategory;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemCategoryRepository extends JpaRepository<ItemCategory,Long> {
    Optional<ItemCategory> findById(Long id);


}
