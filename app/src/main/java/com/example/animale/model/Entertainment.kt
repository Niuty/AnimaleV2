package com.example.animale.model

enum class Type(val key: Int) {
    AnimalEuropa(0),
    AnimalAfrica(1),
    AnimalAsia(2),
    AnimalAmerica(3),
    AnimalAustalia(4),

}

open class Entertainment (val type: Type)