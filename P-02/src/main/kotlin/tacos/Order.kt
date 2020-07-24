package tacos

import lombok.Data

@Data
class Order {

    private val name: String ?= null
    private val street: String ?= null
    private val city: String ?= null
    private val state: String ?= null
    private val zip: String ?= null
    private val ccNumber: String ?= null
    private val ccExpiration: String ?= null
    private val ccCVV: String ?= null

}