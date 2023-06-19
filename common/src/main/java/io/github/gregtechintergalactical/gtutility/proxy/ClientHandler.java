package io.github.gregtechintergalactical.gtutility.proxy;

import io.github.gregtechintergalactical.gtutility.machine.BlockMachineMaterial;
import muramasa.antimatter.AntimatterAPI;
import muramasa.antimatter.client.ModelUtils;
import net.minecraft.client.renderer.RenderType;

public class ClientHandler {

    public static void init(){
        AntimatterAPI.runLaterClient(() -> {
            AntimatterAPI.all(BlockMachineMaterial.class, b -> ModelUtils.setRenderLayer(b, RenderType.cutout()));
        });
    }
}