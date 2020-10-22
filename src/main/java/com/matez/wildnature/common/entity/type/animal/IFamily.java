package com.matez.wildnature.common.entity.type.animal;

import net.minecraft.util.IStringSerializable;

public interface IFamily {

    public Gender getGender();

    public static enum Gender implements IStringSerializable {
        MALE("male"),
        FEMALE("female"),
        CHILD("child");

        private String gender = "";

        Gender(String gender){
            this.gender=gender;
        }

        @Override
        public String getName() {
            return gender;
        }
    }
}
