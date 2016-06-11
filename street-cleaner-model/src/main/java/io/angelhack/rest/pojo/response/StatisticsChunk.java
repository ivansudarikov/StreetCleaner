package io.angelhack.rest.pojo.response;

/**
 * @author Ivan
 * @since 11.06.2016
 */
public class StatisticsChunk {
    private String phoneNumber;
    private String imageUrl;
    private String uploadedBy;
    private CallingStatus callingStatus;
    private String coordinates;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getUploadedBy() {
        return uploadedBy;
    }

    public void setUploadedBy(String uploadedBy) {
        this.uploadedBy = uploadedBy;
    }

    public CallingStatus getCallingStatus() {
        return callingStatus;
    }

    public void setCallingStatus(CallingStatus callingStatus) {
        this.callingStatus = callingStatus;
    }

    public String getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(String coordinates) {
        this.coordinates = coordinates;
    }
}
