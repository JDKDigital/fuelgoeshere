package cy.jdkdigital.fuelgoeshere.mixin;

import cy.jdkdigital.fuelgoeshere.init.ModTags;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractFurnaceMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.RecipeBookMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Debug;
import org.spongepowered.asm.mixin.Mixin;

@Debug(export = true)
@Mixin(value = AbstractFurnaceMenu.class)
abstract public class MixinAbstractFurnaceMenu extends RecipeBookMenu<Container>
{
    public MixinAbstractFurnaceMenu(MenuType<?> menuType, int containerId) {
        super(menuType, containerId);
    }

    public ItemStack quickMoveStack(Player player, int slotIndex) {
        AbstractFurnaceMenu that = (AbstractFurnaceMenu) (Object) this;
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = that.slots.get(slotIndex);
        if (slot != null && slot.hasItem()) {
            ItemStack movedItemStack = slot.getItem();
            itemstack = movedItemStack.copy();
            if (slotIndex == 2) {
                if (!this.moveItemStackTo(movedItemStack, 3, 39, true)) {
                    return ItemStack.EMPTY;
                }

                slot.onQuickCraft(movedItemStack, itemstack);
            } else if (slotIndex != 1 && slotIndex != 0) {
                ItemStack fuelItemstack = that.slots.get(1).getItem();
                if (that.isFuel(movedItemStack) && movedItemStack.is(ModTags.FORCED_FUELS) && (fuelItemstack.isEmpty() || (fuelItemstack.getItem().equals(movedItemStack.getItem()) && fuelItemstack.getCount() < fuelItemstack.getMaxStackSize()))) {
                    if (!this.moveItemStackTo(movedItemStack, 1, 2, false)) {
                        return ItemStack.EMPTY;
                    }
                } else if (that.canSmelt(movedItemStack)) {
                    if (!this.moveItemStackTo(movedItemStack, 0, 1, false)) {
                        return ItemStack.EMPTY;
                    }
                } else if (that.isFuel(movedItemStack)) {
                    if (!this.moveItemStackTo(movedItemStack, 1, 2, false)) {
                        return ItemStack.EMPTY;
                    }
                } else if (slotIndex >= 3 && slotIndex < 30) {
                    if (!this.moveItemStackTo(movedItemStack, 30, 39, false)) {
                        return ItemStack.EMPTY;
                    }
                } else if (slotIndex >= 30 && slotIndex < 39 && !this.moveItemStackTo(movedItemStack, 3, 30, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.moveItemStackTo(movedItemStack, 3, 39, false)) {
                return ItemStack.EMPTY;
            }

            if (movedItemStack.isEmpty()) {
                slot.set(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }

            if (movedItemStack.getCount() == itemstack.getCount()) {
                return ItemStack.EMPTY;
            }

            slot.onTake(player, movedItemStack);
        }

        return itemstack;
    }
}
