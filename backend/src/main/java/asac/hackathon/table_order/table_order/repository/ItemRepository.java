package asac.hackathon.table_order.table_order.repository;

import asac.hackathon.table_order.table_order.entity.SellingItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<SellingItem, Long> {

    @Transactional
    @Query(value = "SELECT selling.id, " +
            "selling.category_id as category_id, " +
            "category.name as category_name, " +
            "selling.name, " +
            "selling.price, " +
            "selling.description, " +
            "selling.profile_path, " +
            "selling.status, " +
            "selling.created_at, " +
            "selling.updated_at " +
            "FROM selling_item selling , item_category category " +
            "where selling.id = category.id " +
            "order by category.priority asc", nativeQuery = true)
    List<SellingItem> findAll();


}
