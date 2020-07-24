package tacos

import lombok.Data
import lombok.RequiredArgsConstructor

@Data
@RequiredArgsConstructor
class Ingredient(FLTO: String, Flour_Tortilla: String, warp: Ingredient.Type) {

    private val id: String ?= null
    private val name: String ?= null
    val type: Type ?= null

    enum class Type {
        WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
    }

}