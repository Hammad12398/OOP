package uk.ac.aston.oop.recipes.io.json;

import java.io.*;
import java.nio.charset.StandardCharsets;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import uk.ac.aston.oop.recipes.io.RecipeFormat;
import uk.ac.aston.oop.recipes.io.exceptions.RecipeLoadingException;
import uk.ac.aston.oop.recipes.io.exceptions.RecipeSavingException;
import uk.ac.aston.oop.recipes.model.Recipe;

public class JSONRecipeFormat implements RecipeFormat {

    @Override
    public String getExtension() {
        return "json";
    }

    @Override
    public String getDescription() {
        return "JSON Files (*.json)";
    }

    @Override
    public Recipe load(File f) throws RecipeLoadingException {
        try (Reader reader = new BufferedReader(new InputStreamReader(new FileInputStream(f), StandardCharsets.UTF_8))) {
            Gson gson = new Gson();
            return gson.fromJson(reader, Recipe.class);
        } catch (IOException e) {
            throw new RecipeLoadingException("Failed to load recipe from file: " + f.getName(), e);
        }
    }

    @Override
    public void save(Recipe r, File f) throws RecipeSavingException {
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(f), StandardCharsets.UTF_8))) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(r, writer);
        } catch (IOException e) {
            throw new RecipeSavingException("Failed to save recipe to file: " + f.getName(), e);
        }
    }

}
