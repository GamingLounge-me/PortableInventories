package me.gaminglounge.portableinventories;

import java.util.ArrayList;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.inventory.StonecuttingRecipe;

import me.gaminglounge.portableinventories.items.PortableInventoriItems;

public final class CraftingRecipe {

    public CraftingRecipe() {
        for (var mat : PortableInventoriItems.values()) {
            createRecipe(mat.item);
        }

        if (PortableInventories.INSTANCE.getConfig().getBoolean("stonecutterRecipe.enabled")) {
            stonecutterRecipies();
        }

        Bukkit.updateRecipes();
    }

    public void createRecipe(ItemStack mat) {
        ShapelessRecipe recipe = new ShapelessRecipe(
                new NamespacedKey("portableinventories", mat.getType().toString().toLowerCase()),
                mat);

        recipe.addIngredient(1, mat.getType());
        recipe.addIngredient(8, Material.DIAMOND);

        Bukkit.getServer().addRecipe(recipe);
    }

    public void stonecutterRecipies() {
        ArrayList<String> enabledRecipes = (ArrayList<String>) PortableInventories.INSTANCE.getConfig()
                .getStringList("stonecutterRecipe.recipies");

        for (String recipe : enabledRecipes) {
            String[] split = recipe.split(":");
            if (split.length != 3) {
                Bukkit.getLogger().warning("Invalid stonecutter recipe: " + recipe);
                continue;
            }

            Material input = Material.getMaterial(split[0]);
            Material output = Material.getMaterial(split[1]);
            int amount = Integer.parseInt(split[2]);

            if (input == null || output == null) {
                Bukkit.getLogger().warning("Invalid material in stonecutter recipe: " + split[0] + " or " + split[1] + " in recipe " + recipe);
                continue;
            }

            StonecuttingRecipe stonecuttingRecipe = new StonecuttingRecipe(
                    new NamespacedKey("portableinventories", recipe.replaceAll(":", "-").toLowerCase()),
                    new ItemStack(output, amount),
                    input);
            Bukkit.getServer().addRecipe(stonecuttingRecipe);
        }
    }

}
