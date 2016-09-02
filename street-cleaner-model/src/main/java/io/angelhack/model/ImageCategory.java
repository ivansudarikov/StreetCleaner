package io.angelhack.model;

/**
 * Defines possible image categories.
 *
 * @author Ivan
 * @since 29.08.2016
 */
public enum ImageCategory {
    AVATAR("ava"), ORDER("order"), COMMENT("comment"), MESSAGE("message");

    private final String rawType;

    private ImageCategory(String rawType) {
        this.rawType = rawType;
    }

    /**
     * @return string representation, never {@code null}.
     */
    public String getRawType() {
        return rawType;
    }

    /**
     * Retrieves {@link ImageCategory} according given rawName.<p>
     * Current available:
     * <ul>
     * <li> {@code ava} - {@link ImageCategory#AVATAR}
     * <li> {@code order} - {@link ImageCategory#ORDER}
     * <li> {@code comment} - {@link ImageCategory#COMMENT}
     * <li> {@code message} - {@link ImageCategory#MESSAGE}
     * </ul>
     *
     * @param rawName raw representation, see above, could be {@code null}.
     * @return image type or {@code null} - if passed rawName is {@code null} or not registered.
     */
    public static ImageCategory getFromStringValue(String rawName) {
        for (ImageCategory type : values()) {
            if (type.getRawType().equalsIgnoreCase(rawName)) {
                return type;
            }
        }
        return null;
    }
}
