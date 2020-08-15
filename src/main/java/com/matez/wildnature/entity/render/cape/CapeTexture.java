package com.matez.wildnature.entity.render.cape;

import com.matez.wildnature.event.capeBuffers.IImageBuffer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.NativeImage;
import net.minecraft.client.renderer.texture.SimpleTexture;
import net.minecraft.client.renderer.texture.TextureUtil;
import net.minecraft.resources.IResourceManager;
import net.minecraft.util.ResourceLocation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.annotation.Nullable;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.atomic.AtomicInteger;

public class CapeTexture extends SimpleTexture {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final AtomicInteger TEXTURE_CapeTexture_THREAD_ID = new AtomicInteger(0);
    private final String imageUrl;
    @Nullable
    private final IImageBuffer imageBuffer;
    @Nullable
    private NativeImage nativeImage;
    @Nullable
    private Thread imageThread;
    private boolean textureUploaded;


    public CapeTexture(String imageUrlIn, ResourceLocation textureResourceLocation, IImageBuffer imageBufferIn) {
        super(textureResourceLocation);
        this.imageUrl = imageUrlIn;
        this.imageBuffer = imageBufferIn;
    }

    private void checkTextureUploaded() {
        if (!this.textureUploaded && this.nativeImage != null) {
            if (this.textureLocation != null) {
                this.deleteGlTexture();
            }

            TextureUtil.prepareImage(super.getGlTextureId(), this.nativeImage.getWidth(), this.nativeImage.getHeight());
            this.nativeImage.uploadTextureSub(0, 0, 0, false);
            this.textureUploaded = true;
        }

    }

    public int getGlTextureId() {
        this.checkTextureUploaded();
        return super.getGlTextureId();
    }

    public void setNativeImage(NativeImage nativeImageIn) {
        this.nativeImage = nativeImageIn;
        if (this.imageBuffer != null) {
            this.imageBuffer.skinAvailable();
        }

    }

    public void loadTexture(IResourceManager resourceManager) throws IOException {
        if (this.nativeImage == null && this.textureLocation != null) {
            super.loadTexture(resourceManager);
        }

        if (this.imageThread == null) {
            this.loadTextureFromServer();
        }

    }

    protected void loadTextureFromServer() {
        if (this.imageUrl != null) {
            this.imageThread = new Thread("CapeTexture #" + TEXTURE_CapeTexture_THREAD_ID.incrementAndGet()) {
                public void run() {
                    HttpURLConnection httpurlconnection = null;
                    CapeTexture.LOGGER.debug("Downloading texture from {}", CapeTexture.this.imageUrl);

                    try {
                        httpurlconnection = (HttpURLConnection)(new URL(CapeTexture.this.imageUrl)).openConnection(Minecraft.getInstance().getProxy());
                        httpurlconnection.setDoInput(true);
                        httpurlconnection.setDoOutput(false);
                        httpurlconnection.connect();
                        if (httpurlconnection.getResponseCode() / 100 == 2) {
                            NativeImage nativeImage = NativeImage.read(httpurlconnection.getInputStream());
                            nativeImage = CapeTexture.this.imageBuffer.parseUserSkin(nativeImage);
                            CapeTexture.this.setNativeImage(nativeImage);
                            CapeTexture.LOGGER.debug("Image loaded in {}", nativeImage);
                            return;
                        }

                        return;
                    } catch (Exception var6) {
                        CapeTexture.LOGGER.error("Couldn't download texture", var6);
                    } finally {
                        if (httpurlconnection != null) {
                            CapeTexture.LOGGER.debug("Disconnected from {}", httpurlconnection.getURL().toString());
                            httpurlconnection.disconnect();
                        }

                    }

                }
            };
            this.imageThread.setDaemon(true);
            this.imageThread.start();
        }
    }
}
