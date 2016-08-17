package com.leontheprofessional.roster.model;

/**
 * Created by yangl on 8/2/2016.
 */
public class PlayerModel {

    private String firstName;
    private String lastName;
    private String nickName;
    private String height;
    private float height_international;
    private String weight;
    private float weight_international;
    private int gender;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public float getHeight_international() {
        return height_international;
    }

    public void setHeight_international(float height_international) {
        this.height_international = height_international;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public float getWeight_international() {
        return weight_international;
    }

    public void setWeight_international(float weight_international) {
        this.weight_international = weight_international;
    }

    public void setGender(String gender) {
        if (gender == "Unkown") this.gender = 0;
        else if (gender == "Male") this.gender = 1;
        else if (gender == "Female") this.gender = 2;
        else this.gender = 9;
    }

    public String getGender() {
        if (this.gender == 0) return "Unknown";
        else if (this.gender == 1) return "Male";
        else if (this.gender == 2) return "Female";
        else return "NotApplicable";
    }

    public enum GENDERTYPE {
        Unknown(0),
        Male(1),
        Female(2),
        NotApplicable(9);

        private int gender;

        GENDERTYPE(int gender) {
            this.gender = gender;
        }
    }
}
