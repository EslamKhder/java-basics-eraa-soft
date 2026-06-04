package main.dp910.ex;

import java.util.List;

public interface ItemService {

    List<Object> getAllItems();

    Object selectItem(Long id);

    boolean addItem(Object item);

    boolean updateItem(Object item);

    boolean deleteItem(Long id);
}
