package pl.szarawara.jakub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.szarawara.jakub.dataLoader.Loader;
import pl.szarawara.jakub.items.Item;

import java.util.Map;

@RestController
@RequestMapping("/items")
public class ItemsController {

    @Autowired
    private Loader loader;

    @GetMapping()
    public Map<String, Item> getItems() {
        return loader.getItems();
    }
}
