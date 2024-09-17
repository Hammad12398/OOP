package uk.ac.aston.oop.recipes.io.text;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import uk.ac.aston.oop.recipes.io.RecipeFormat;
import uk.ac.aston.oop.recipes.io.exceptions.RecipeLoadingException;
import uk.ac.aston.oop.recipes.io.exceptions.RecipeSavingException;
import uk.ac.aston.oop.recipes.model.Recipe;

public class TextRecipeFormat implements RecipeFormat {

    public static final String RECIPE_HEADER = "OOPRecipe 1.0";
    public static final String SEPARATOR_INSTRUCTIONS = "__INSTRUCTIONS__";

    @Override
    public String getExtension() {
        return "txt";
    }

    @Override
    public String getDescription() {
        return "Raw Text Files (*.txt)";
    }

    @Override
    public Recipe load(File f) throws RecipeLoadingException {
        try (LineNumberReader lnr = new LineNumberReader(new InputStreamReader(new FileInputStream(f), StandardCharsets.UTF_8))) {
            // Line numbers start at 0 by default - make them start at 1
            lnr.setLineNumber(1);
            checkHeader(lnr, f);

            Recipe r = new Recipe();
            readRecipeName(lnr, r);
            readIngredients(lnr, r);
            readInstructions(lnr, r);
            
            return r;
        } catch (IOException e) {
            throw new RecipeLoadingException("Error reading recipe file: " + f.getName(), e);
        }
    }

    private void readInstructions(LineNumberReader lnr, Recipe r) throws IOException, RecipeLoadingException {
        StringBuilder instructions = new StringBuilder();
        String line;
        while ((line = lnr.readLine()) != null) {
            instructions.append(line).append(System.lineSeparator());
        }
        r.setInstructions(instructions.toString());
    }

    private void readIngredients(LineNumberReader lnr, Recipe r) throws IOException, RecipeLoadingException {
        StringBuilder ingredients = new StringBuilder();
        String line;
        while ((line = lnr.readLine()) != null && !line.equals(SEPARATOR_INSTRUCTIONS)) {
            ingredients.append(line).append(System.lineSeparator());
        }
        if (line == null) { // Reached end-of-file without finding SEPARATOR_INSTRUCTIONS
            throw new RecipeLoadingException("Missing instructions separator in recipe file.");
        }
        r.setIngredients(ingredients.toString());
    }

    private void readRecipeName(LineNumberReader lnr, Recipe r) throws IOException, RecipeLoadingException {
        String name = lnr.readLine();
        if (name == null) {
            throw new RecipeLoadingException("Recipe file ended prematurely, missing recipe name.");
        }
        r.setName(name);
    }

    private void checkHeader(LineNumberReader lnr, File f) throws IOException, RecipeLoadingException {
        String header = lnr.readLine();
        if (!RECIPE_HEADER.equals(header)) {
            throw new RecipeLoadingException("File " + f.getName() + " does not have the correct recipe header.");
        }
    }

    @Override
    public void save(Recipe r, File f) throws RecipeSavingException {
        if (r.getIngredients().contains(SEPARATOR_INSTRUCTIONS) || r.getInstructions().contains(SEPARATOR_INSTRUCTIONS)) {
            throw new RecipeSavingException("Cannot safely store the recipe in this format due to reserved separator.");
        }

        try (PrintWriter pw = new PrintWriter(Files.newBufferedWriter(f.toPath(), StandardCharsets.UTF_8))) {
            pw.println(RECIPE_HEADER);
            pw.println(r.getName());
            pw.println(r.getIngredients());
            pw.println(SEPARATOR_INSTRUCTIONS);
            pw.println(r.getInstructions());
        } catch (IOException e) {
            throw new RecipeSavingException("Failed to save recipe to file: " + f.getName(), e);
        }
    }
}
