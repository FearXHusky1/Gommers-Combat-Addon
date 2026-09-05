package com.gca.overwrite_contents.mixin.hbm;

import com.hbm.inventory.gui.GUITurretBase;
import com.hbm.tileentity.turret.TileEntityTurretBaseNT;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value = GUITurretBase.class, remap = false)
public interface AccessorGUITurretBase {
    @Accessor("turret")
    TileEntityTurretBaseNT getTurret();
}