package cy.jdkdigital.fuelgoeshere;

import com.mojang.logging.LogUtils;
import net.minecraftforge.fml.common.Mod;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(FuelGoesHere.MODID)
public class FuelGoesHere
{
    // Directly reference a slf4j logger
    public static final Logger LOGGER = LogUtils.getLogger();

    public static final String MODID = "fuelgoeshere";

    public FuelGoesHere()
    {
    }
}
