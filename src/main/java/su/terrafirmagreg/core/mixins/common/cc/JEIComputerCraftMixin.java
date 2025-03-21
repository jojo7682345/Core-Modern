package su.terrafirmagreg.core.mixins.common.cc;

import dan200.computercraft.shared.integration.jei.JEIComputerCraft;
import mezz.jei.api.registration.IAdvancedRegistration;
import mezz.jei.api.registration.ISubtypeRegistration;
import mezz.jei.api.runtime.IJeiRuntime;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Pseudo
@Mixin(value = JEIComputerCraft.class, remap = false)
public abstract class JEIComputerCraftMixin {

    @Inject(method = "registerItemSubtypes", at = @At("HEAD"), remap = false, cancellable = true)
    private void tfg$RegisterItemSubtypes(ISubtypeRegistration subtypeRegistry, CallbackInfo ci) {
        ci.cancel();
    }

    @Inject(method = "registerAdvanced", at = @At("HEAD"), remap = false, cancellable = true)
    public void tfg$registerAdvanced(IAdvancedRegistration registry, CallbackInfo ci) {
        ci.cancel();
    }

    @Inject(method = "onRuntimeAvailable", at = @At("HEAD"), remap = false, cancellable = true)
    public void tfg$onRuntimeAvailable(IJeiRuntime runtime, CallbackInfo ci) {
        ci.cancel();
    }

}
