package io.angelhack.rest.pojo;

public class UserVox {
    private String result;
    private String account_email;
    private Long account_id;
    private String api_key;
    private String account_name;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getAccount_email() {
        return account_email;
    }

    public void setAccount_email(String account_email) {
        this.account_email = account_email;
    }

    public Long getAccount_id() {
        return account_id;
    }

    public void setAccount_id(Long account_id) {
        this.account_id = account_id;
    }

    public String getApi_key() {
        return api_key;
    }

    public void setApi_key(String api_key) {
        this.api_key = api_key;
    }

    public String getAccount_name() {
        return account_name;
    }

    public void setAccount_name(String account_name) {
        this.account_name = account_name;
    }

    @Override
    public String toString() {
        return "io.angelhack.rest.pojo.UserVox{" +
                "result='" + result + '\'' +
                ", account_email='" + account_email + '\'' +
                ", account_id=" + account_id +
                ", api_key='" + api_key + '\'' +
                ", account_name='" + account_name + '\'' +
                '}';
    }
}
