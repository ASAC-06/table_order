package asac.hackathon.table_order.table_order.service;

import asac.hackathon.table_order.table_order.MenuResponseDto;
import asac.hackathon.table_order.table_order.entity.SellingItem;
import asac.hackathon.table_order.table_order.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository menuRepository;

    @Transactional
    public List<MenuResponseDto> findAll() {
        List<SellingItem> menus = menuRepository.findAll();
//        return menus.stream().map(MenuResponseDto::from).toList();
        return null;
    }


}
