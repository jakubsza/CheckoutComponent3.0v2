package pl.szarawara.jakub.bills;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.szarawara.jakub.dataLoader.Loader;
import pl.szarawara.jakub.items.Item;
import pl.szarawara.jakub.services.TrolleyService;

import java.util.Map;

@Component
public class Bill {

    @Autowired
    public Loader loader;

    @Autowired
    public TrolleyService trolleyService;

    public double getBill(int trolleyId) {
        double totalPrice=0;
        Map<String, Integer> map = trolleyService.getTrolleyMap().get(trolleyId).getItemQuantityMap();
        Map<String, Item> items = loader.getItems();

        for(Map.Entry<String,Integer> entry: map.entrySet()){
            totalPrice+=items.get(entry.getKey()).getTotalPrice(entry.getValue());
        }
        return totalPrice;
    }

}
