package cy.jdkdigital.fuelgoeshere.fabric;

import cy.jdkdigital.fuelgoeshere.FuelGoesHere;
import net.fabricmc.api.ModInitializer;

public class FuelGoesHereFabric implements ModInitializer {
  @Override
  public void onInitialize() {
    FuelGoesHere.init();
  }
}
