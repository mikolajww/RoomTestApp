package pl.mww.roomtestapp.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "students")
public class Student {
    @NonNull
    private String firstName;
    @NonNull
    private String lastName;
    @PrimaryKey
    @NonNull
    private String indexNo;

    public Student(String firstName, String lastName, String indexNo) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.indexNo = indexNo;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getIndexNo() {
        return indexNo;
    }

    @NonNull
    @Override
    public String toString() {
        return firstName + " " + lastName + ", " + indexNo;
    }
}
