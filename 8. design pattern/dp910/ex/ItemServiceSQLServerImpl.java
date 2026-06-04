package main.dp910.ex;

import java.util.List;

public class ItemServiceSQLServerImpl implements ItemService{
    public ItemServiceSQLServerImpl(String dataSource) {
    }

    @Override
    public List<Object> getAllItems() {
        return null;
    }

    @Override
    public Object selectItem(Long id) {
        return null;
    }

    @Override
    public boolean addItem(Object item) {
        return false;
    }

    @Override
    public boolean updateItem(Object item) {
        return false;
    }

    @Override
    public boolean deleteItem(Long id) {
        return false;
    }
}
