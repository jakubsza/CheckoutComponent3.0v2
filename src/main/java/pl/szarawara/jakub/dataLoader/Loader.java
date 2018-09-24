package pl.szarawara.jakub.dataLoader;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import pl.szarawara.jakub.items.Item;

import java.util.HashMap;
import java.util.Map;

@Component
public class Loader implements ApplicationRunner {

    private Map<String, Item> items;

    public void run(ApplicationArguments applicationArguments) {
        Map<String, Item> items = new HashMap<>();
        Item itemA = new Item(40.0, 3, 70.0);
        Item itemB = new Item(10.0, 2, 15.0);
        Item itemC = new Item(30.0, 4, 60.0);
        Item itemD = new Item(25.0, 2, 40.0);
        items.put("A", itemA);
        items.put("B", itemB);
        items.put("C", itemC);
        items.put("D", itemD);
        this.items = items;
    }

    public Map<String, Item> getItems() {
        return items;
    }

}
