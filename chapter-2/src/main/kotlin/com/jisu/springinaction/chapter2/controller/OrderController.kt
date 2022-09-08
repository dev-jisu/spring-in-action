package com.jisu.springinaction.chapter2.controller

import com.jisu.springinaction.chapter2.logger
import com.jisu.springinaction.chapter2.domain.Order
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.Errors
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import javax.validation.Valid

@Controller
@RequestMapping("/orders")
class OrderController {

    val log = logger()

    @GetMapping("/current")
    fun orderForm(model: Model): String {
        model.addAttribute("order", Order.emptyInstance())
        return "orderForm"
    }

    @PostMapping
    fun processOrder(@Valid order: Order, errors: Errors):String{
        if (errors.hasErrors()) {
            return "orderForm"
        }
        log.info("Order submitted: $order")
        return "redirect:/"
    }
}