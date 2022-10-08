package com.codeinflow.cookery.model

import android.os.Parcelable
import androidx.room.Entity
import kotlinx.parcelize.Parcelize

@Entity(
    tableName = "recipes"
)
@Parcelize
data class Recipe(
    val CookTimeInMins: String,
    val Course: String,
    val Cuisine: String,
    val Diet: String,
    val Ingredients: String,
    val Instructions: String,
    val PrepTimeInMins: String,
    val RecipeName: String,
    val Servings: String,
    val Srno: String,
    val TotalTimeInMins: String,
    val TranslatedIngredients: String,
    val TranslatedInstructions: String,
    val TranslatedRecipeName: String,
    val URL: String
): Parcelable