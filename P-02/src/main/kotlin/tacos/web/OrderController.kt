package tacos.web

import lombok.extern.slf4j.Slf4j
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.Errors
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import tacos.Order

@Slf4j
@Controller
@RequestMapping("/orders")
class OrderController {

    @GetMapping("/current")
    fun orderForm(model: Model): String {
        model.addAttribute("order", Order())
        return "orderForm"
    }

    @PostMapping
    fun processOrder(order: Order?, errors: Errors): String {
        if (errors.hasErrors()) { return "orderForm" }
//        log("订单已提交：" + $order)
        return "redirect:/"
    }

}