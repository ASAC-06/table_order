package asac.hackathon.table_order.table_order.controller;

import asac.hackathon.table_order.table_order.controller.dto.CategoryDto;
import asac.hackathon.table_order.table_order.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("")
    public ResponseEntity<List<CategoryDto>> categories() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(categoryService.findAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryDto> updateCategories(@PathVariable Long id, @RequestBody CategoryDto categoryDto) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(categoryService.updateCategory(id, categoryDto));

    }

}
