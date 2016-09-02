package io.angelhack.socialcall.images.attach;

import io.angelhack.model.ImageCategory;

/**
 * @author Ivan
 * @since 29.08.2016
 */
public interface AttachImageServicesFactory {

    AttachImageService getAttachImageService(ImageCategory imageCategory);
}
