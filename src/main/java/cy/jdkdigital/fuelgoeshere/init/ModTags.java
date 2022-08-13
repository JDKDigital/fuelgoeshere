package cy.jdkdigital.fuelgoeshere.init;

import cy.jdkdigital.fuelgoeshere.FuelGoesHere;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class ModTags
{
    public static final TagKey<Item> FORCED_FUELS = ItemTags.create(new ResourceLocation(FuelGoesHere.MODID, "forced_fuels"));
}
