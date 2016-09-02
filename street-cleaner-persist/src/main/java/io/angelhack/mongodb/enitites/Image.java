package io.angelhack.mongodb.enitites;

import io.angelhack.model.ImageCategory;

/**
 * @author Ivan
 * @since 17.08.2016
 */
public class Image {

    private String uniqueId;
    private ImageCategory category;

    public String getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }

    public ImageCategory getCategory() {
        return category;
    }

    public void setCategory(ImageCategory category) {
        this.category = category;
    }
}
