package io.github.gregtechintergalactical.gtutility.machine;

import muramasa.antimatter.machine.types.Machine;
import muramasa.antimatter.material.Material;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.fluids.FluidStack;

import static muramasa.antimatter.Data.WRENCH_MATERIAL;
import static muramasa.antimatter.machine.MachineFlag.COVERABLE;

public class MaterialMachine extends Machine<MaterialMachine> {
    Material material;
    public MaterialMachine(String domain, String id, Material material) {
        super(domain, id);
        this.material = material;
        setItemBlockClass(() -> BlockMachineMaterial.class);
        setBlock((type, tier) -> {
            if (this instanceof DrumMachine) return new BlockMachineMaterial(type, tier, BlockBehaviour.Properties.of(WRENCH_MATERIAL).strength(1.0f, 10.0f));
            return new BlockMachineMaterial(type, tier);
        });
        setTile(BlockEntityMaterial::new);
        addFlags(COVERABLE);
        noCovers();
        allowFrontIO();
        frontCovers();
    }

    public Material getMaterial() {
        return material;
    }
}