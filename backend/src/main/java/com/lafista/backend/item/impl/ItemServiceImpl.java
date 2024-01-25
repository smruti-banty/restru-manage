package com.lafista.backend.item.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.lafista.backend.item.dto.ItemDto;
import com.lafista.backend.item.model.Item;
import com.lafista.backend.item.repository.ItemRepository;
import com.lafista.backend.item.service.ItemService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {
    private final ItemRepository itemRepository;

    @Override
    public Item addItem(Item item) {
        System.out.println(item.getCategory());
        item.getCategory().getAllItems().add(item);
        return itemRepository.save(item);
    }

    @Override
    public Item delteItem(String itemId) {
        var item = getItemById(itemId);
        itemRepository.deleteById(itemId);
        return item;
    }

    @Override
    public Item updateItem(String categoryId, Item updatedItem) {
        var item = getItemById(categoryId);
        BeanUtils.copyProperties(updatedItem, item);
        return itemRepository.save(item);
    }

    @Override
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    @Override
    public Item getItemById(String itemId) {
        var item = itemRepository.findById(itemId);
        return item.orElseThrow(() -> new RuntimeException("Item not found"));
    }
}
