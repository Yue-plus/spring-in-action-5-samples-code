package tacos

import lombok.Data

@Data
class Taco {

    private val name: String ?= null
    private val ingredient: MutableList<String> ?= null

}