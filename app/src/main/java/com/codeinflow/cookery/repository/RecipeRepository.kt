package com.example.newsbreeze.repository

import android.content.ContentValues
import android.util.Log
import com.codeinflow.cookery.model.Recipe
import com.example.newsbreeze.database.RecipeDatabase
import com.google.firebase.firestore.FirebaseFirestore

class RecipesRepository(private val database: RecipeDatabase) {

    var db = FirebaseFirestore.getInstance();

    fun getAllRecipesFirebase() {
        db.collection("Recipes")
            .get()
            .addOnSuccessListener{ documents ->
                for (document in documents) {
                    Log.d(ContentValues.TAG, "${document.id} => ${document.data}")
                }
            }.addOnFailureListener{ exception ->
                Log.w(ContentValues.TAG, "Error getting documents: ", exception)
            }
    }

    fun getRoomNews() = database.getRecipeDao().getAllRecipesFromDatabase()

    suspend fun insertRoomArticle(recipe: Recipe) {
        Log.d("Add Room Data", recipe.toString())
        database.getRecipeDao().insertRecipeInDatabase(recipe)
    }

    suspend fun searchRoomNews(query: String) = database.getRecipeDao().searchRecipeInDatabase(query)

    suspend fun deleteRoomArticle(recipe: Recipe) =
        database.getRecipeDao().removeSavedRecipe(recipe)
}