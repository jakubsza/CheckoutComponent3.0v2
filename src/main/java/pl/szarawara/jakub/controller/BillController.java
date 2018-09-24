package pl.szarawara.jakub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.szarawara.jakub.bills.Bill;

@RestController
@RequestMapping("/bill")
public class BillController {

    @Autowired
    private Bill bill;

    @GetMapping("/{trolleyId}")
    public double getBill(@PathVariable int trolleyId) {
        return bill.getBill(trolleyId);
    }
}
