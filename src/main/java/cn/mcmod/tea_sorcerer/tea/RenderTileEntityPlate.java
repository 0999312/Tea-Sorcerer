package cn.mcmod.tea_sorcerer.tea;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.Vector3f;
import net.minecraft.client.renderer.model.ItemCameraTransforms.TransformType;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.item.ItemStack;

@SuppressWarnings("deprecation")
public class RenderTileEntityPlate extends TileEntityRenderer<TileEntityPlate> {

    public RenderTileEntityPlate(TileEntityRendererDispatcher rendererDispatcherIn) {
		super(rendererDispatcherIn);
	}

	@Override
	public void render(TileEntityPlate te, float partialTicks, MatrixStack matrixStackIn,
			IRenderTypeBuffer bufferIn, int combinedLightIn, int combinedOverlayIn) {
    	if(!te.getInventory().getStackInSlot(0).isEmpty()){
    		ItemStack stack = te.getInventory().getStackInSlot(0);
    		matrixStackIn.push();
    		matrixStackIn.translate(0.5D,0.45D,0.5D);
    		matrixStackIn.scale(0.85F, 0.85F, 0.85F);
    		matrixStackIn.rotate(te.getBlockState().get(BlockPlate.HORIZONTAL_FACING).getRotation());
    		matrixStackIn.rotate(Vector3f.XP.rotationDegrees(270F));
    	    Minecraft.getInstance().getItemRenderer().renderItem(stack, TransformType.FIXED, combinedLightIn, combinedOverlayIn, matrixStackIn, bufferIn);
    	    matrixStackIn.pop();
    		
    	}
	}
}
