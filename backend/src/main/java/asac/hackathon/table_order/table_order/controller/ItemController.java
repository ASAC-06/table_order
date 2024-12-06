package asac.hackathon.table_order.table_order.controller;

import asac.hackathon.table_order.table_order.controller.dto.ItemResponseDto;
import asac.hackathon.table_order.table_order.controller.dto.SellingItemUpdateDto;
import asac.hackathon.table_order.table_order.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/items")
public class ItemController {

    private final ItemService itemService;

    @GetMapping("")
    public ResponseEntity<List<ItemResponseDto>> menus() {
        List<ItemResponseDto> menus = itemService.findAll();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(menus);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ItemResponseDto> updateItem(@PathVariable Long id, @RequestBody SellingItemUpdateDto itemUpdateDto) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(itemService.update(id, itemUpdateDto));
    }

}
