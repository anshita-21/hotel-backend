package com.AgilePeople.project.controller;

//import lombok.AllArgsConstructor;
import com.AgilePeople.project.entity.Checkout;
import com.AgilePeople.project.service.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // returns the data directly in a format like JSON
//@AllArgsConstructor
@RequestMapping("api/checkout") //routed to the appropriate method

public class CheckoutController {
    @Autowired //creats objects
    private CheckoutService checkoutService;

    // build create Register REST API
    @PostMapping
    public Checkout createCheckout(@RequestBody Checkout checkout) {
        Checkout savedCheckout = checkoutService.createCheckout(checkout);
        return savedCheckout;
    }

    // build get register by id REST API
    // http://localhost:8080/api/register/1
    @GetMapping("{id}")
    public Checkout getCheckoutById(@PathVariable("id") Long checkoutId) {
        Checkout checkout = checkoutService.getCheckoutById(checkoutId);
        return checkout;
    }

    // Build Get All registers REST API
    // http://localhost:8080/api/checkout
    @GetMapping
    public List<Checkout> getAllCheckout() {
        List<Checkout> checkout = checkoutService.getAllCheckout();
        return checkout;
    }

    // Build Update register REST API
    @PutMapping("{id}")
    // http://localhost:8080/api/checkout/1
    public Checkout updateCheckout(@PathVariable("id") Long checkoutId,
                                   @RequestBody Checkout checkout) {
        checkout.setId(checkoutId);
        Checkout updatedCheckout = checkoutService.updateCheckout(checkout);
        return updatedCheckout;
    }

    // Build Delete register REST API
    @DeleteMapping("{id}")
    public String deleteCheckout(@PathVariable("id") Long checkoutId) {
        checkoutService.deleteCheckout(checkoutId);
        return "register successfully deleted!";
    }
}
