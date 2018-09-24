package pl.szarawara.jakub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.szarawara.jakub.services.TrolleyService;

@RestController
@RequestMapping("/trolley")
public class TrolleyController {

    @Autowired
    private TrolleyService trolleyService;

    @PostMapping("/{trolleyId}/add/{itemName}/{quantity}")
    public void addItems(@PathVariable int trolleyId, @PathVariable String itemName, @PathVariable int quantity) {
        trolleyService.addTrolley(trolleyId, itemName, quantity);
    }
}
