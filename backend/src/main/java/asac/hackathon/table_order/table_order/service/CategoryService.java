package asac.hackathon.table_order.table_order.service;


import asac.hackathon.table_order.table_order.controller.dto.CategoryRequestDto;
import asac.hackathon.table_order.table_order.controller.dto.CategoryResponseDto;


import asac.hackathon.table_order.table_order.controller.dto.CategoryDto;
import asac.hackathon.table_order.table_order.entity.ItemCategory;
import asac.hackathon.table_order.table_order.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


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

    @Transactional
    public List<CategoryDto> findAll() {

        return categoryRepository.findAllByOrderByPriority().stream()
                .map(CategoryDto::from)
                .toList();

    }

    @Transactional
    public CategoryDto updateCategory(Long id, CategoryDto categoryDto) {

        ItemCategory category = categoryRepository.findByCategoryId(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "찾을 수 없는 카테고리 입니다."));

        category.updateForm(categoryDto);

        return CategoryDto.from(category);
    }

}
