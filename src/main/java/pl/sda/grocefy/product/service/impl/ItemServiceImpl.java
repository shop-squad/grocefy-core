package pl.sda.grocefy.product.service.impl;

import org.springframework.stereotype.Service;
import pl.sda.grocefy.product.dto.ItemDTO;
import pl.sda.grocefy.product.entity.ItemEntity;
import pl.sda.grocefy.product.mapper.ItemMapper;
import pl.sda.grocefy.product.repository.ItemRepository;
import pl.sda.grocefy.product.service.ItemService;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemServiceImpl implements ItemService {

    private final ItemRepository repository;
    private final ItemMapper itemMapper;

    public ItemServiceImpl(ItemRepository repository, ItemMapper itemMapper) {
        this.repository = repository;
        this.itemMapper = itemMapper;
    }


    @Override
    public void addItem(String hash, ItemDTO newItem) {
        repository.save(itemMapper.mapToEntity(newItem));
    }

    @Override
    public List<ItemDTO> findItemByListHash(String hash) {
        List<ItemEntity> allByHash = repository.findAllByHash(hash);
        return allByHash.stream().map(itemMapper::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public void removeItem(ItemDTO itemToRemove) {
        repository.deleteById(itemToRemove.getId());
    }

    @Override
    @Transactional
    public void deleteAllItemsByListHash(String hash) {
        repository.deleteAllByHash(hash);
    }
}
