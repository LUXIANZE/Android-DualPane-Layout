package models;

import com.google.gson.Gson;

import java.io.InvalidClassException;

public class DataWrapper {
    public Names data;

    public static DataWrapper fromJSON(String json){
        return new Gson().fromJson(json, DataWrapper.class);
    }
    public String stringify(){
        return new Gson().toJson(this);
    }
    @Override
    public boolean equals(Object other){
        try{
            if (other.getClass() != DataWrapper.class){
                throw new InvalidClassException("");
            }
        }catch (InvalidClassException e){
            return false;
        }

        DataWrapper other_object = (DataWrapper) other;
        for(int i = 0; i < this.data.names.size(); i++){
            String first_obj = this.data.names.get(i);
            String second_obj = other_object.data.names.get(i);
            if (!first_obj.equalsIgnoreCase(second_obj)){
                return false;
            }
        }
        return true;
    }
}
