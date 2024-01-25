package com.lafista.backend.item.controller;

import java.util.List;

import com.lafista.backend.item.dto.ItemResponseDto;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.lafista.backend.category.model.Category;
import com.lafista.backend.category.service.CategoryService;
import com.lafista.backend.item.dto.ItemDto;
import com.lafista.backend.item.model.Item;
import com.lafista.backend.item.service.ItemService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/item")
public class ItemController {
    private final ItemService itemService;
    private final CategoryService categoryService;

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public ItemResponseDto addItem(@RequestBody ItemDto itemDto) {
        var item = new Item();
        BeanUtils.copyProperties(itemDto, item);

        var category = categoryService.getCategoryById(itemDto.categoryId());
        item.setCategory(category);

        return itemService.addItem(item);
    }

    @GetMapping
    public List<Item> getAllItems() {
        return itemService.getAllItems();
    }

    @GetMapping("/{itemId}")
    public Item getItemById(@PathVariable String itemId) {
        return itemService.getItemById(itemId);
    }

    @DeleteMapping("/{itemId}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public Item deleteItem(@PathVariable String itemId) {
        return itemService.delteItem(itemId);
    }

    @PutMapping("/{itemId}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public Item updateItem(@PathVariable String itemId, @RequestBody ItemDto itemDto) {
        var item = new Item();
        BeanUtils.copyProperties(itemDto, item);
        return itemService.updateItem(itemId, item);
    }
}
