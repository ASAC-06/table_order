package asac.hackathon.table_order.table_order.repository;

import java.awt.Menu;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface MenuRepository extends JpaRepository<Menu/*entity Menu X*/, Long> {

    @Transactional
    List<Menu> findALl();


}
