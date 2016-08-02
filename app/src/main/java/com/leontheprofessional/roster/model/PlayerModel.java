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
    private float weight;
    private float weight_international;

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

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getWeight_international() {
        return weight_international;
    }

    public void setWeight_international(float weight_international) {
        this.weight_international = weight_international;
    }

    public static class Gender {
        public enum GenderType {Male, Female}

        private GenderType gender;

        public Gender(GenderType gender){
            this.gender = gender;
        }

        public Gender getGender(){
            return
        }



    }
}
