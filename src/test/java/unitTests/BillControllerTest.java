package unitTests;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.internal.util.reflection.Whitebox;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.util.Assert;
import pl.szarawara.jakub.bills.Bill;
import pl.szarawara.jakub.controller.BillController;
import pl.szarawara.jakub.dataLoader.Loader;
import pl.szarawara.jakub.items.Item;
import pl.szarawara.jakub.services.TrolleyService;
import pl.szarawara.jakub.trolley.Trolley;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BillControllerTest {

    @Mock
    private static BillController billController;

    @InjectMocks
    private Bill bill;

    @Mock
    private Loader loader;

    @Mock
    private TrolleyService trolleyService;

    @BeforeClass
    public static void setUpTests() {
        billController = new BillController();
    }

    @Test
    public void nullTrolleyTest() {
        when(billController.getBill(0)).thenReturn(0.0);
        assertEquals(0.0,billController.getBill(0),0);
    }

    private void setUpItems() {
        Map<String, Item> items = new HashMap<>();
        Item itemTestA = new Item(40.0, 3, 70.0);
        Item itemTestB = new Item(10.0, 2, 15.0);
        items.put("TestA", itemTestA);
        items.put("TestB", itemTestB);
        when(loader.getItems()).thenReturn(items);
    }

    private void setUpTrolley(){
        Map<Integer, Trolley> trolleyMap = new HashMap<>();
        Trolley testTrolleyA = new Trolley("TestA", 10);
        testTrolleyA.addItemQuantity("TestB", 3);
        trolleyMap.put(1,testTrolleyA);
        when(trolleyService.getTrolleyMap()).thenReturn(trolleyMap);
    }

    private void setReflection(){
        Whitebox.setInternalState(bill,"loader",loader);
        Whitebox.setInternalState(bill,"trolleyService",trolleyService);
    }

    @Test
    public void getBillWithTwoItems() {
        setUpItems();
        setUpTrolley();
        setReflection();
        assertEquals(275.0,bill.getBill(1),0);
    }
}
