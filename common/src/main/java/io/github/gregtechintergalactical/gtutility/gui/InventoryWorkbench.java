package io.github.gregtechintergalactical.gtutility.gui;

import io.github.gregtechintergalactical.gtutility.GTUtility;
import io.github.gregtechintergalactical.gtutility.data.SlotTypes;
import io.github.gregtechintergalactical.gtutility.network.MessageCraftingSync;
import muramasa.antimatter.Antimatter;
import muramasa.antimatter.AntimatterAPI;
import muramasa.antimatter.capability.machine.MachineItemHandler;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.CraftingContainer;
import net.minecraft.world.item.ItemStack;
import trinsdar.networkapi.api.INetwork;

import javax.annotation.Nonnull;

public class InventoryWorkbench extends CraftingContainer {
    private final int length;
    private final MachineItemHandler<?> projectTable;
    private final AbstractContainerMenu eventHandler;
    public InventoryWorkbench(AbstractContainerMenu eventHandlerIn, MachineItemHandler<?> table, int width, int height) {
        super(eventHandlerIn, width, height);
        this.length = width * height;
        this.projectTable = table;
        this.eventHandler = eventHandlerIn;
    }

    @Override
    public int getContainerSize() {
        return this.length;
    }

    @Override
    public ItemStack removeItemNoUpdate(int i) {
        ItemStack itemStack = getItem(i);
        if (!itemStack.isEmpty()) {
            setItem(i, ItemStack.EMPTY);
        }
        return itemStack;
    }

    @Override
    public void setItem(int slot, ItemStack stack) {
        this.projectTable.getHandler(SlotTypes.CRAFTING).setStackInSlot(slot, stack);
        eventHandler.slotsChanged(this);
    }

    @Override
    public void setChanged() {
        this.projectTable.getTile().setChanged();
        this.eventHandler.slotsChanged(this);
        if(AntimatterAPI.getSIDE().isClient())
            INetwork.getInstance().sendToServer(GTUtility.SYNC_ID, new MessageCraftingSync());
    }

    @Nonnull
    @Override
    public ItemStack getItem(int index) {
        return index >= this.getContainerSize() ? ItemStack.EMPTY : this.projectTable.getHandler(SlotTypes.CRAFTING).getStackInSlot(index);
    }

    @Nonnull
    @Override
    public ItemStack removeItem(int index, int count) {
        if(!this.getItem(index).isEmpty()) {
            ItemStack itemstack;

            if(this.getItem(index).getCount() <= count) {
                itemstack = this.getItem(index);
                this.setItem(index, ItemStack.EMPTY);
            } else {
                itemstack = this.getItem(index).split(count);

                if(this.getItem(index).getCount() == 0) {
                    this.setItem(index, ItemStack.EMPTY);
                }

            }
            this.eventHandler.slotsChanged(this);
            return itemstack;
        } else {
            return ItemStack.EMPTY;
        }
    }
}