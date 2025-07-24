package com.example.springtutor.service;

import com.example.springtutor.model.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ItemServiceTest {

	//TODO: SpringBoot:Practical 4 - Unit Testing continue
	//Complete the TODO below
	
    private ItemService itemService;
    private ItemServiceAnalysis ItemServiceAnalysis;

    @BeforeEach
    void setUp() {
        itemService = new ItemService();
        ItemServiceAnalysis = new ItemServiceAnalysis();
    }

    @Test
    void testCreateItem() {
        Item item = itemService.createItem("Test Value");
        assertNotNull(item);
        assertEquals("Test Value", item.value());
        assertTrue(item.id() > 0);
    }

    @Test
    void testCreateItemWithProvidedId_Success() {
        Optional<Item> optionalItem = itemService.createItemWithProvidedId(100L, "Manual ID Item");
        assertTrue(optionalItem.isPresent());
     // TODO: complete the optionalItem.get().id() is equal to 100L above
        assertEquals(optionalItem.get().id(), 100L);
    }

    @Test
    void testGetItemById() {
        Item created = itemService.createItem("Lookup");
        Optional<Item> fetched = itemService.getItemById(created.id());
     // TODO: complete the assert result above
        assertNotNull(fetched);
        assertTrue(fetched.get().id() > 0);
        assertEquals(fetched.get().id(), created.id());
    }

    @Test
    void testGetAllItems() {
        itemService.createItem("One");
        itemService.createItem("Two");
        List<Item> items = itemService.getAllItems();
        assertEquals(3, items.size());
    }

    @Test
    void testUpdateItem_Success() {
        Item created = itemService.createItem("Before");
        Optional<Item> updated = itemService.updateItem(created.id(), "After");
        assertTrue(updated.isPresent());
        assertEquals("After", updated.get().value());
    }

    @Test
    void testDeleteItem_Success() {
        Item created = itemService.createItem("Delete Me");
        boolean result = itemService.deleteItem(created.id());
        // TODO: complete the assert result above
        assertNotNull(created);
        assertTrue(result);
    }

    @Test
    void testDeleteItem_NotFound() {
        boolean result = itemService.deleteItem(12345L);
     // TODO: complete the assert result above
        assertFalse(result);
    }
    
    @Test
    void testGetAllItemByDemo() {
        itemService.createItem("demo");
        itemService.createItem("notdemo");
    	List<Item> items = ItemServiceAnalysis.getAllItemsByDemo();
    	assertEquals(1, items.size());
    }
}
