package asac.hackathon.table_order.table_order.service;

import asac.hackathon.table_order.table_order.controller.dto.ItemResponseDto;
import asac.hackathon.table_order.table_order.controller.dto.SellingItemRequestDto;
import asac.hackathon.table_order.table_order.entity.ItemCategory;
import asac.hackathon.table_order.table_order.entity.ItemEntityEnum;
import asac.hackathon.table_order.table_order.entity.SellingItem;
import asac.hackathon.table_order.table_order.repository.ItemCategoryRepository;
import asac.hackathon.table_order.table_order.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;
    private final ItemCategoryRepository itemCategoryRepository;

    @Transactional
    public List<ItemResponseDto> findAll() {
        List<SellingItem> SellingItemList = itemRepository.findAll();
        return SellingItemList.stream().map(ItemResponseDto::from).toList();
    }

    @Transactional
    public ItemResponseDto save(SellingItemRequestDto request) {
        ItemCategory itemCategory = itemCategoryRepository.findByName(
                request.getCategoryName())
            .orElseThrow(() -> new IllegalArgumentException("Invalid category ID"));

        SellingItem saveItem = itemRepository.save(SellingItem.from(
            itemCategory,
            request.getName(),
            request.getPrice(),
            request.getStatus(),
            request.getDescription(),
            request.getProfilePath()
            )
        );
        return ItemResponseDto.from(saveItem);

    }

}
