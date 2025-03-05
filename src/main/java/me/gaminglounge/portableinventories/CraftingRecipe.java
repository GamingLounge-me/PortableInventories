package me.gaminglounge.portableinventories;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapelessRecipe;

import me.gaminglounge.portableinventories.items.PortableInventoriItems;

public final class CraftingRecipe {

    public CraftingRecipe() {
        for (var mat : PortableInventoriItems.values()) {
            createRecipe(mat.item);
        }
    }

    public void createRecipe(ItemStack mat) {
        ShapelessRecipe recipe = new ShapelessRecipe(
                new NamespacedKey("portableinventories", mat.getType().toString().toLowerCase()),
                mat);

        recipe.addIngredient(1, mat.getType());
        recipe.addIngredient(8, Material.DIAMOND);

        Bukkit.getServer().addRecipe(recipe);
        Bukkit.updateRecipes();
    }

}
