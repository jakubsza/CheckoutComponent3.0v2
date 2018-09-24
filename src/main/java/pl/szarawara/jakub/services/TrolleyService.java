package pl.szarawara.jakub.services;

import org.springframework.stereotype.Component;
import pl.szarawara.jakub.trolley.Trolley;

import java.util.HashMap;
import java.util.Map;

@Component
public class TrolleyService {

    private Map<Integer, Trolley> trolleyMap = new HashMap<>();

    public void addTrolley(int trolleyId, String itemName, int quantity) {
        if (trolleyMap.containsKey(trolleyId)) {
            trolleyMap.get(trolleyId).addItemQuantity(itemName, quantity);
        } else {
            trolleyMap.put(trolleyId, new Trolley(itemName, quantity));
        }
    }

    public Map<Integer, Trolley> getTrolleyMap() {
        return trolleyMap;
    }
}
