package io.github.gregtechintergalactical.gtcore.datagen;

import io.github.gregtechintergalactical.gtcore.GTCore;
import io.github.gregtechintergalactical.gtcore.data.GTCoreBlocks;
import io.github.gregtechintergalactical.gtcore.data.GTCoreTags;
import muramasa.antimatter.AntimatterAPI;
import muramasa.antimatter.datagen.providers.AntimatterBlockTagProvider;
import muramasa.antimatter.datagen.providers.AntimatterItemTagProvider;
import muramasa.antimatter.util.TagUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

import static io.github.gregtechintergalactical.gtcore.data.GTCoreItems.*;
import static io.github.gregtechintergalactical.gtcore.data.GTCoreTags.*;

public class GTCoreItemTagProvider extends AntimatterItemTagProvider {
    public GTCoreItemTagProvider(String providerDomain, String providerName, boolean replace, AntimatterBlockTagProvider p) {
        super(providerDomain, providerName, replace, p);
    }

    @Override
    protected void processTags(String domain) {
        super.processTags(domain);
        this.copy(TagUtils.getBlockTag(new ResourceLocation(GTCore.ID, "rubber_logs")), GTCoreTags.RUBBER_LOGS);
        this.tag(ItemTags.LEAVES).add(GTCoreBlocks.RUBBER_LEAVES.asItem());
        this.tag(ItemTags.PLANKS).add(GTCoreBlocks.RUBBER_PLANKS.asItem());
        this.tag(ItemTags.SLABS).add(GTCoreBlocks.RUBBER_SLAB.asItem());
        this.tag(ItemTags.STAIRS).add(GTCoreBlocks.RUBBER_STAIRS.asItem());
        this.tag(ItemTags.SIGNS).add(GTCoreBlocks.RUBBER_SIGN.asItem());
        this.tag(ItemTags.WOODEN_BUTTONS).add(GTCoreBlocks.RUBBER_BUTTON.asItem());
        this.tag(ItemTags.WOODEN_DOORS).add(GTCoreBlocks.RUBBER_DOOR.asItem());
        this.tag(ItemTags.WOODEN_FENCES).add(GTCoreBlocks.RUBBER_FENCE.asItem());
        this.tag(ItemTags.WOODEN_PRESSURE_PLATES).add(GTCoreBlocks.RUBBER_PRESSURE_PLATE.asItem());
        this.tag(ItemTags.WOODEN_SLABS).add(GTCoreBlocks.RUBBER_SLAB.asItem());
        this.tag(ItemTags.WOODEN_STAIRS).add(GTCoreBlocks.RUBBER_STAIRS.asItem());
        this.tag(ItemTags.WOODEN_TRAPDOORS).add(GTCoreBlocks.RUBBER_TRAPDOOR.asItem());
        if (AntimatterAPI.isModLoaded("tfc")){
            this.tag(ItemTags.WOODEN_FENCES).add(AntimatterAPI.get(Item.class, "rubber_log_fence", GTCore.ID));
            this.tag(TagUtils.getItemTag(new ResourceLocation("tfc", "lumber"))).add(AntimatterAPI.get(Item.class, "rubber_lumber", GTCore.ID));
            this.tag(TagUtils.getItemTag(new ResourceLocation("tfc", "twigs"))).add(AntimatterAPI.get(Item.class, "rubber_twig", GTCore.ID));
            this.tag(TagUtils.getItemTag(new ResourceLocation("tfc", "fallen_leaves"))).add(AntimatterAPI.get(Item.class, "rubber_fallen_leaves", GTCore.ID));
            this.tag(TagUtils.getItemTag(new ResourceLocation("tfc", "firepit_fuel"))).addTag(GTCoreTags.RUBBER_LOGS);
            this.tag(TagUtils.getItemTag(new ResourceLocation("tfc", "firepit_logs"))).addTag(GTCoreTags.RUBBER_LOGS);
            this.tag(TagUtils.getItemTag(new ResourceLocation("tfc", "firepit_fuel"))).addTag(GTCoreTags.RUBBER_LOGS);
            this.tag(TagUtils.getItemTag(new ResourceLocation("tfc", "pit_kiln_logs"))).addTag(GTCoreTags.RUBBER_LOGS);
            this.tag(TagUtils.getItemTag(new ResourceLocation("tfc", "log_pile_logs"))).addTag(GTCoreTags.RUBBER_LOGS);

        }
        this.tag(CIRCUITS_BASIC).add(CircuitBasic);
        this.tag(CIRCUITS_GOOD).add(CircuitGood);
        this.tag(CIRCUITS_ADVANCED).add(CircuitAdv);
        this.tag(CIRCUITS_DATA).add(CircuitDataStorage);
        this.tag(CIRCUITS_ELITE).add(CircuitDataControl);
        this.tag(CIRCUITS_MASTER).add(CircuitEnergyFlow);
        this.tag(CIRCUITS_DATA_ORB).add(DataOrb);
        this.tag(BATTERIES_RE).add(BatteryRE);
        this.tag(BATTERIES_SMALL).add(BatterySmallSodium, BatterySmallCadmium, BatterySmallLithium);
        this.tag(BATTERIES_MEDIUM).add(BatteryMediumSodium, BatteryMediumCadmium, BatteryMediumLithium);
        this.tag(BATTERIES_LARGE).add(BatteryLargeSodium, BatteryLargeCadmium, BatteryLargeLithium, EnergyCrystal);
        this.tag(FIRESTARTER).add(Items.FLINT_AND_STEEL);
    }
}
