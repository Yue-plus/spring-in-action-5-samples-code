package tacos.web

import lombok.extern.slf4j.Slf4j
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.Errors
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import tacos.Ingredient
import tacos.Taco
import java.util.stream.Collectors

@Slf4j
@Controller
@RequestMapping("/design")
class DesignTacoController {

    @ModelAttribute
    fun addIngredientsToModel(model: Model): String {
        val ingredients: List<Ingredient> = listOf(
                Ingredient("FLTO", "Flour Tortilla", Ingredient.Type.WRAP),
                Ingredient("COTO", "Corn Tortilla", Ingredient.Type.WRAP),
                Ingredient("GRBF", "Ground Beef", Ingredient.Type.PROTEIN),
                Ingredient("CARN", "Carnitas", Ingredient.Type.PROTEIN),
                Ingredient("TMTO", "Diced Tomatoes", Ingredient.Type.VEGGIES),
                Ingredient("LETC", "Lettuce", Ingredient.Type.VEGGIES),
                Ingredient("CHED", "Cheddar", Ingredient.Type.CHEESE),
                Ingredient("JACK", "Monterrey Jack", Ingredient.Type.CHEESE),
                Ingredient("SLSA", "Salsa", Ingredient.Type.SAUCE),
                Ingredient("SRCR", "Sour Cream", Ingredient.Type.SAUCE)
        )
        val types = Ingredient.Type.values()

        for (type in types) model.addAttribute(type.toString().toLowerCase(), filterByType(ingredients, type))
        model.addAttribute("design", Taco())
        return "design"
    }

    @GetMapping
    fun showDesignForm(model: Model): String {
        model.addAttribute("design", Taco())
        return "design"
    }

    @PostMapping
    fun processDesign(@ModelAttribute("design") design: Taco?, errors: Errors, model: Model?): String {
        if (errors.hasErrors()) { return "design" }
//        log("正在处理设计：" + design)
        return "redirect:/orders/current"
    }

    private fun filterByType(ingredient: List<Ingredient>, type: Ingredient.Type): List<Ingredient> {
        return ingredient
                .stream()
                .filter { x: Ingredient -> x.type == type }
                .collect(Collectors.toList())
    }

}