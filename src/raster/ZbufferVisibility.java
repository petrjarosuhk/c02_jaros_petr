package raster;

import transforms.Col;

/*Řešení viditelnosti*/

public class ZbufferVisibility {
    private final ImageBuffer iBuffer;
    private final DepthBuffer dbuffer;

    public ZbufferVisibility(ImageBuffer iBuffer){
        this.iBuffer = iBuffer;
        this.dbuffer = new DepthBuffer(iBuffer.getWidth(), iBuffer.getHeight());
    }

    //jaký pixel se zobrazí v závislosti na velikosti z
    public void drawPixelWithTest(int x, int y, double z, Col color){
        if(z< dbuffer.getElement(x,y)){
            iBuffer.setElement(x,y,color);
            dbuffer.setElement(x,y,z);
        }
    }

    public ImageBuffer getiBuffer() {
        return iBuffer;
    }

    public DepthBuffer getDbuffer() {
        return dbuffer;
    }
}
