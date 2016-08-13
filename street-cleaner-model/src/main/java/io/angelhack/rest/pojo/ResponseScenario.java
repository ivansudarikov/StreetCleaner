package io.angelhack.rest.pojo;

public class ResponseScenario {

    private String result;
    private String media_session_access_url;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getMedia_session_access_url() {
        return media_session_access_url;
    }

    public void setMedia_session_access_url(String media_session_access_url) {
        this.media_session_access_url = media_session_access_url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ResponseScenario that = (ResponseScenario) o;

        if (result != null ? !result.equals(that.result) : that.result != null) return false;
        return !(media_session_access_url != null ? !media_session_access_url.equals(that.media_session_access_url) : that.media_session_access_url != null);

    }

    @Override
    public int hashCode() {
        int result1 = result != null ? result.hashCode() : 0;
        result1 = 31 * result1 + (media_session_access_url != null ? media_session_access_url.hashCode() : 0);
        return result1;
    }

    @Override
    public String toString() {
        return "ResponseScenario{" +
                "result='" + result + '\'' +
                ", media_session_access_url='" + media_session_access_url + '\'' +
                '}';
    }
}
