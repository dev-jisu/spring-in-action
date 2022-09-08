package com.jisu.springinaction.chapter2.controller

import com.jisu.springinaction.chapter2.domain.Ingredient
import com.jisu.springinaction.chapter2.domain.Ingredient.Type
import com.jisu.springinaction.chapter2.domain.Taco
import com.jisu.springinaction.chapter2.logger
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.Errors
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import javax.validation.Valid

@Controller
@RequestMapping("/design")
class DesignTacoController {
    val log = logger()

    @GetMapping
    fun showDesignForm(model:Model): String{
        val ingredients: List<Ingredient> = arrayListOf(
            Ingredient.of("FLTO", "Flour Tortilla", Type.WRAP),
            Ingredient.of("COTO", "Corn Tortilla", Type.WRAP),
            Ingredient.of("GRBF", "Ground Beef", Type.PROTEIN),
            Ingredient.of("CARN", "Carnitas", Type.PROTEIN),
            Ingredient.of("TMTO", "Diced Tomatoes", Type.VEGGIES),
            Ingredient.of("LETC", "Lettuce", Type.VEGGIES),
            Ingredient.of("CHED", "Cheddar", Type.CHEESE),
            Ingredient.of("JACK", "Monterrey Jack", Type.CHEESE),
            Ingredient.of("SLSA", "Salsa", Type.SAUCE),
            Ingredient.of("SRCR", "Sour Cream", Type.SAUCE),
        )
        val types:Array<Type> = Type.values()
        for (type in types){
            model.addAttribute(type.toString().lowercase(),filterByType(ingredients, type))
        }
        model.addAttribute("taco", Taco.emptyInstance())
        return "design"
    }

    @PostMapping
    fun processDesign(@Valid design:Taco, errors:Errors):String{
        if(errors.hasErrors()){
            return "design"
        }
        log.info("Processing design: $design")
        return "redirect:/orders/current"
    }

    fun filterByType(ingredients:List<Ingredient>, type:Type):List<Ingredient>{
        return ingredients.filter { x -> x.type == type }
    }
}