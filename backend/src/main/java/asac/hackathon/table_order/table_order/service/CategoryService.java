package asac.hackathon.table_order.table_order.service;

import asac.hackathon.table_order.table_order.controller.dto.CategoryRequestDto;
import asac.hackathon.table_order.table_order.controller.dto.CategoryResponseDto;
import asac.hackathon.table_order.table_order.entity.ItemCategory;
import asac.hackathon.table_order.table_order.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryResponseDto categorySave(CategoryRequestDto requestDto){
        ItemCategory itemCategory = new ItemCategory();
        itemCategory.setName(requestDto.getName());
        itemCategory.setPriority(requestDto.getPriority() != null ? requestDto.getPriority() : 0);

        // 데이터 저장
        ItemCategory saveCategory = categoryRepository.save(itemCategory);

        // DTO 반환
        return new CategoryResponseDto(
            saveCategory.getId(),
            saveCategory.getName(),
            saveCategory.getPriority()
        );
    }




}
