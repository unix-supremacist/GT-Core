package io.github.gregtechintergalactical.gtcore.machine;

import io.github.gregtechintergalactical.gtcore.GTCore;
import muramasa.antimatter.machine.Tier;
import muramasa.antimatter.material.Material;
import muramasa.antimatter.texture.Texture;

import static muramasa.antimatter.machine.MachineFlag.ENERGY;

public class ChargingMachine extends MaterialMachine{
    public ChargingMachine(String domain, Material material, String suffix, boolean charge) {
        super(domain, material.getId() + (charge ? "_charging" : "") + "_" + suffix, material);
        if (charge) this.addFlags(ENERGY);
        this.setTiers(charge ? Tier.HV : Tier.NONE);
        this.baseTexture((m, t) -> new Texture[] {
                new Texture(GTCore.ID, "block/machine/base/" + suffix + "/bottom"),
                new Texture(GTCore.ID, "block/machine/base/" + suffix + "/top"),
                new Texture(GTCore.ID, "block/machine/base/" + suffix + "/back"),
                new Texture(GTCore.ID, "block/machine/base/" + suffix + "/front"),
                new Texture(GTCore.ID, "block/machine/base/" + suffix + "/side"),
                new Texture(GTCore.ID, "block/machine/base/" + suffix + "/side"),
        });
        this.overlayTexture((type, state, tier) -> new Texture[] {
                new Texture(GTCore.ID, "block/machine/overlay/" + (charge ? "charging_" : "") + suffix + "/bottom"),
                new Texture(GTCore.ID, "block/machine/overlay/" + (charge ? "charging_" : "") + suffix + "/top"),
                new Texture(GTCore.ID, "block/machine/overlay/" + (charge ? "charging_" : "") + suffix + "/back"),
                new Texture(GTCore.ID, "block/machine/overlay/" + (charge ? "charging_" : "") + suffix + "/front"),
                new Texture(GTCore.ID, "block/machine/overlay/" + (charge ? "charging_" : "") + suffix + "/side"),
                new Texture(GTCore.ID, "block/machine/overlay/" + (charge ? "charging_" : "") + suffix + "/side"),
        });
    }
}
