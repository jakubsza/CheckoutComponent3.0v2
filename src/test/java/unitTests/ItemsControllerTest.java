package unitTests;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.util.Assert;
import pl.szarawara.jakub.controller.ItemsController;
import pl.szarawara.jakub.dataLoader.Loader;
import pl.szarawara.jakub.items.Item;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ItemsControllerTest {

    @InjectMocks
    private static ItemsController itemsController;

    @Mock
    private Loader loader;

    @BeforeClass
    public static void setUpTests() {
        itemsController = new ItemsController();
    }

    @Test
    public void noItemsTest() {
        Assert.isTrue(itemsController.getItems().isEmpty());
    }

    private void setUpOneItem() {
        Map<String, Item> items = new HashMap<>();
        Item itemTest = new Item(40.0, 3, 70.0);
        items.put("Test", itemTest);
        when(loader.getItems()).thenReturn(items);
    }

    @Test
    public void oneItemTest() {
        setUpOneItem();
        assertEquals("Correct price", 40.0, itemsController.getItems().get("Test").getPrice(), 0);
        assertEquals("Correct special price", 70.0, itemsController.getItems().get("Test").getSpecialPrice(), 0);
        assertEquals("Correct unit", 3, itemsController.getItems().get("Test").getUnit());
    }

    @Test
    public void wrongItemNameTest() {
        Assert.isNull(itemsController.getItems().get("WrongNameItem"));
    }
}
