package pl.sda.grocefy.product.service.impl;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import pl.sda.grocefy.product.dto.ShoppingListDTO;
import pl.sda.grocefy.product.dto.UserDTO;
import pl.sda.grocefy.product.entity.ShoppingListEntity;
import pl.sda.grocefy.product.exception.ListNotFoundException;
import pl.sda.grocefy.product.mapper.ShoppingListMapper;
import pl.sda.grocefy.product.repository.ShoppingListRepository;
import pl.sda.grocefy.product.service.ShoppingListService;
import pl.sda.grocefy.product.service.UserService;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShoppingListServiceImpl implements ShoppingListService {

    private final ShoppingListMapper mapper;
    private final ShoppingListRepository shoppingListRepository;
    private final UserService userService;

    public ShoppingListServiceImpl(ShoppingListMapper mapper, ShoppingListRepository shoppingListRepository, UserService userService) {
        this.mapper = mapper;
        this.shoppingListRepository = shoppingListRepository;
        this.userService = userService;
    }


    @Override
    public ShoppingListDTO findListByHash(String hash) throws ListNotFoundException {
        ShoppingListEntity byHash = shoppingListRepository.findByHash(hash);
        if (byHash == null) {
            throw new ListNotFoundException("Lista pod podanym adresem nie istnieje");
        }
        return mapper.mapToDTO(shoppingListRepository.findByHash(hash));
    }

    @Cascade(CascadeType.ALL)
    @Transactional
    @Override
    public void addList(ShoppingListDTO shoppingListDTO) {
        
        Long userId = userService.getUserId();
        shoppingListDTO.setOwnerId(userId);
        ShoppingListEntity shoppingListEntity = mapper.mapToEntity(shoppingListDTO);
        shoppingListRepository.save(shoppingListEntity);
    }

    @Override
    public List<ShoppingListDTO> getAll() {
        List<ShoppingListEntity> all = shoppingListRepository.findAll();
        return all.stream().map(mapper::mapToDTO).collect(Collectors.toList());
    }


    @Override
    public void deleteList(String hash) {
        shoppingListRepository.delete(shoppingListRepository.findByHash(hash));
    }

    @Override
    public List<ShoppingListDTO> getAllByUserId(Long userId) {

        List<ShoppingListEntity> allByUser = shoppingListRepository.findAllByOwnerId(userId);
        return allByUser.stream().map(mapper::mapToDTO).collect(Collectors.toList());
    }
}
