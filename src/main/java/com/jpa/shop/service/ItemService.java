package com.jpa.shop.service;


import com.jpa.shop.domain.item.Book;
import com.jpa.shop.domain.item.Item;
import com.jpa.shop.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;


    @Transactional
    public void saveItem(Item item){
        itemRepository.save(item);
    }

    @Transactional
    public void updateItem(Long ItemId, String name, int price, int stockQuantity){
        Item findItem = itemRepository.findOne(ItemId);
        findItem.setName(name);
        findItem.setPrice(price);
        findItem.setStockQuantity(stockQuantity);

    }
    public List<Item> findItems(){
        return itemRepository.findAll();
    }


    public Item findOne(Long itemId){
        return  itemRepository.findOne(itemId);
    }
}
