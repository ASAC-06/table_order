package asac.hackathon.table_order.table_order.service;

import asac.hackathon.table_order.table_order.controller.dto.ItemResponseDto;
import asac.hackathon.table_order.table_order.controller.dto.SellingItemRequestDto;
import asac.hackathon.table_order.table_order.controller.dto.SellingItemUpdateDto;
import asac.hackathon.table_order.table_order.entity.ItemCategory;
import asac.hackathon.table_order.table_order.entity.SellingItem;
import asac.hackathon.table_order.table_order.repository.CategoryRepository;
import asac.hackathon.table_order.table_order.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;
    private final CategoryRepository categoryRepository;

    @Transactional
    public List<ItemResponseDto> findAll() {
        List<SellingItem> SellingItemList = itemRepository.findAll();
        return SellingItemList.stream().map(ItemResponseDto::from).toList();
    }

    @Transactional
    public ItemResponseDto save(SellingItemRequestDto request) {
        ItemCategory itemCategory = categoryRepository.findByName(
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

    @Transactional
    public ItemResponseDto update(Long id, SellingItemUpdateDto itemUpdateDto) {

        // id 로 정보를 받아옴.
        SellingItem sellingItem = itemRepository.findItemById(id);
        ItemCategory category = categoryRepository.findByCategoryId(sellingItem.getItemCategory().getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "category not found"));

        // 만약 카테고리 밸류가 다르면? 카테코리도 값 업데이트 해 준다. 해당 카테고리 밸류 찾아서.
        if (!category.getName().equals(itemUpdateDto.getCategoryName())) {
            sellingItem.setItemCategory(
                    categoryRepository.findByName(itemUpdateDto.getCategoryName())
                            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "존재하지 않는 카테고리 입니다."))
            );
        }

        sellingItem.updateForm(itemUpdateDto);
        return ItemResponseDto.from(sellingItem);
    }

}
