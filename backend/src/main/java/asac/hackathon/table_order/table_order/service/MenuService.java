package asac.hackathon.table_order.table_order.service;

import asac.hackathon.table_order.table_order.MenuResponseDto;
import asac.hackathon.table_order.table_order.repository.MenuRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MenuService {

    private final MenuRepository menuRepository;

    @Transactional
    public List<MenuResponseDto> findAll() {
//        List<Menu> menus = menuRepository.findAll();
//        return menus.stream().map(MenuResponseDto::from).toList();
        return null;
    }


}
