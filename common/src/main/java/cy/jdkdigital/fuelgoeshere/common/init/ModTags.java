package cy.jdkdigital.fuelgoeshere.common.init;

import cy.jdkdigital.fuelgoeshere.FuelGoesHere;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class ModTags {
  public static final TagKey<Item> FORCED_FUELS = ItemTags.bind(FuelGoesHere.makeStringId("forced_fuels"));
}
