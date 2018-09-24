package pl.szarawara.jakub.trolley;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class Trolley {

    private Map<String, Integer> itemQuantityMap = new HashMap();

    public Trolley() {

    }

    public Trolley(String itemName, int quantity) {
        itemQuantityMap.put(itemName, quantity);
    }

    public void addItemQuantity(String itemName, int quantity) {
        if(itemQuantityMap.containsKey(itemName)) {
            itemQuantityMap.put(itemName, itemQuantityMap.get(itemName)+quantity);
        }else {
            itemQuantityMap.put(itemName, quantity);
        }
    }

    public Map<String, Integer> getItemQuantityMap() {
        return itemQuantityMap;
    }

}
