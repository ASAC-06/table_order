package asac.hackathon.table_order.table_order.service;

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
