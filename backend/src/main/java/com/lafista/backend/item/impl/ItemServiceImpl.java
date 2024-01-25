package com.lafista.backend.item.impl;

import java.util.List;

import com.lafista.backend.item.dto.ItemResponseDto;
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
    public ItemResponseDto addItem(Item item) {
        System.out.println(item.getCategory());
        item.getCategory().getAllItems().add(item);
        itemRepository.save(item);

        var dto = new ItemResponseDto(item.getItemId(),
                item.getItemName(), item.getItemPrice(),
                item.getCategory().getCategoryId(), item.getCategory().getCategoryName());


        return dto;
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
