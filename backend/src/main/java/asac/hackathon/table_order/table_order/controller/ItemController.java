package asac.hackathon.table_order.table_order.controller;

import asac.hackathon.table_order.table_order.MenuResponseDto;
import asac.hackathon.table_order.table_order.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/items")
public class ItemController {

    private final ItemService menuService;

    @GetMapping("")
    public ResponseEntity<List<MenuResponseDto>> menus() {
        List<MenuResponseDto> menus = menuService.findAll();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(menus);
    }

}
