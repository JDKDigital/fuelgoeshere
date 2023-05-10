package cy.jdkdigital.fuelgoeshere.forge;

import cy.jdkdigital.fuelgoeshere.FuelGoesHere;
import net.minecraftforge.fml.common.Mod;

@Mod(FuelGoesHere.MOD_ID)
public class FuelGoesHereForge {
  public FuelGoesHereForge() {
    FuelGoesHere.init();
  }
}
