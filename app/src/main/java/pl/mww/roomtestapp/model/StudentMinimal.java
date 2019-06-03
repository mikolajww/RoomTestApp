package pl.mww.roomtestapp.model;

import androidx.annotation.NonNull;

public class StudentMinimal {
    private String indexNo;
    private String firstName;

    public StudentMinimal(String firstName, String indexNo) {
        this.firstName = firstName;
        this.indexNo = indexNo;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getIndexNo() {
        return indexNo;
    }

    @NonNull
    @Override
    public String toString() {
        return firstName + " " + indexNo;
    }

}
