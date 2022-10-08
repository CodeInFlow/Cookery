package com.example.newsbreeze.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.codeinflow.cookery.model.Recipe

@Dao
interface RecipeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRecipeInDatabase(recipe: Recipe): Long

    @Query("SELECT * FROM recipes")
    fun getAllRecipesFromDatabase(): LiveData<List<Recipe>>

    @Query("SELECT * FROM recipes WHERE TranslatedRecipeName LIKE :query")
    suspend fun searchRecipeInDatabase(query: String): List<Recipe>

    @Delete
    suspend fun removeSavedRecipe(recipe: Recipe)
}