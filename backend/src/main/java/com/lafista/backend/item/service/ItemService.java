package com.lafista.backend.item.service;

import java.util.List;

import com.lafista.backend.item.dto.ItemDto;
import com.lafista.backend.item.dto.ItemResponseDto;
import com.lafista.backend.item.model.Item;

public interface ItemService {
    ItemResponseDto addItem(Item item);

    Item delteItem(String itemId);

    Item updateItem(String categoryId, Item updatedItem);

    List<Item> getAllItems();

    Item getItemById(String itemId);
}
