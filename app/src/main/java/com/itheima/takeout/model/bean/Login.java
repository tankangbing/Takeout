package com.itheima.takeout.model.bean;

/**
 * @author admin
 */

public class Login {
    /**
     * error :
     * nickName : 鹳狸猿phone
     * phone : 1360****410
     * sex : 0
     * status : 0
     * token : 3ad40387-e916-425e-be4f-caf62ca007c1
     * username : admin2
     */
    private String error;
    private String nickName;
    private String phone;
    private int sex;
    private int status;
    private String token;
    private String username;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
