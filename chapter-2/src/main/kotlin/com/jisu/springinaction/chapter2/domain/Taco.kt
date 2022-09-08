package com.jisu.springinaction.chapter2.domain

import javax.validation.constraints.Size

data class Taco(
    @field:Size(min=5, message="Name must be at least 5 characters long")
    var name:String,
    @field:Size(min=1, message = "You must choose at least 1 ingredient")
    var ingredients:List<String>
    ) {
    companion object {
        fun of(name: String, ingredients: List<String>): Taco {
            return Taco(name, ingredients)
        }
        fun emptyInstance(): Taco{
            return Taco("", emptyList())
        }
    }
}