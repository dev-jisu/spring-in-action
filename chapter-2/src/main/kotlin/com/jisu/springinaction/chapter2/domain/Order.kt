package com.jisu.springinaction.chapter2.domain

import org.hibernate.validator.constraints.CreditCardNumber
import javax.validation.constraints.Digits
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Pattern
import javax.validation.constraints.Size

data class Order(
    @field:NotBlank(message = "Name is required")
    var deliveryName: String,

    @field:NotBlank(message = "Street is required")
    var deliveryStreet: String,

    @field:NotBlank(message = "City is required")
    var deliveryCity: String,

    @field:NotBlank(message = "State is required")
    var deliveryState: String,

    @field:NotBlank(message = "Zip code is required")
    var deliveryZip: String,

    @field:CreditCardNumber(message = "Not a valid credit card number")
    var ccNumber: String,

    @field:Pattern(regexp = "^(0[1-9]|1[0-2])([\\/])([1-9][0-9])$",
        message = "Must be formatted MM/YY")
    var ccExpiration: String,

    @field:Digits(integer = 3, fraction = 0, message = "Invalid CVV")
    var ccCVV: String,
) {
    companion object {
        fun emptyInstance(
            deliveryName: String,
            deliveryStreet: String,
            deliveryCity: String,
            deliveryState: String,
            deliveryZip: String,
            ccNumber: String,
            ccExpiration: String,
            ccCVV: String,
        ): Order {
            return Order(
                deliveryName,
                deliveryStreet,
                deliveryCity,
                deliveryState,
                deliveryZip,
                ccNumber,
                ccExpiration,
                ccCVV
            )
        }

        fun emptyInstance(): Order {
            return Order("", "", "", "", "", "", "", "")
        }
    }
}