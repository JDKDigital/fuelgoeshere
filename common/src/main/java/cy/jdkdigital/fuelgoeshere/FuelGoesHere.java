package cy.jdkdigital.fuelgoeshere;

public class FuelGoesHere {
  public static final String MOD_ID = "fuelgoeshere";

  public static void init() {}

  public static String makeStringId(String path) {
    return MOD_ID + ':' + path;
  }
}
