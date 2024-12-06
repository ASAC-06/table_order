package asac.hackathon.table_order.table_order.service;

import asac.hackathon.table_order.table_order.controller.dto.ItemResponseDto;
import asac.hackathon.table_order.table_order.entity.SellingItem;
import asac.hackathon.table_order.table_order.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    @Transactional
    public List<ItemResponseDto> findAll() {
        List<SellingItem> SellingItemList = itemRepository.findAll();
        return SellingItemList.stream().map(ItemResponseDto::from).toList();
    }


}
