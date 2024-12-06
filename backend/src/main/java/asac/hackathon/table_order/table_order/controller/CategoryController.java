package asac.hackathon.table_order.table_order.controller;

import asac.hackathon.table_order.table_order.controller.dto.CategoryRequestDto;
import asac.hackathon.table_order.table_order.controller.dto.CategoryResponseDto;
import asac.hackathon.table_order.table_order.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping("")
    public ResponseEntity<CategoryResponseDto> createCategory(@RequestBody CategoryRequestDto request) {
        CategoryResponseDto category = categoryService.categorySave(request);
        return ResponseEntity.ok(category);
    }

}
