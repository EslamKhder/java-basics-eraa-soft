package main.dp910.ex;

import java.util.List;

public class ItemControlService {

    private ItemService itemService;

    public ItemControlService(ItemService itemService) {
        this.itemService = itemService;
    }

    List<Object> getAllItems() {
        itemService.getAllItems();
    }

    Object selectItem(Long id) {
        itemService.selectItem();
    }

    boolean addItem(Object item) {
        itemService.addItem();
    }

    boolean updateItem(Object item) {
        itemService.updateItem();
    }

    boolean deleteItem(Long id) {
        itemService.deleteItem();
    }
}
