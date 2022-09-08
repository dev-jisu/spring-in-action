package com.jisu.springinaction.chapter2.domain

data class Ingredient(
    val id: String,
    val name: String,
    val type: Type
) {
    enum class Type {
        WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
    }
    companion object {
        fun of(id: String, name: String, type: Type): Ingredient {
            return Ingredient(id, name, type)
        }
    }
}