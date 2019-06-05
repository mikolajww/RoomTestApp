package pl.mww.roomtestapp.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
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
    @NonNull
    private String email;

    public Student(String firstName, String lastName, String indexNo, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.indexNo = indexNo;
        this.email = email;
    }

    @Ignore
    public Student (String firstName, String lastName, String indexNo) {
        this(firstName, lastName, indexNo, "przykladowy@email.pl");
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

    public String getEmail() {
        return email;
    }

    @NonNull
    @Override
    public String toString() {
        return firstName + " " + lastName + ", " + indexNo + ", " + email;
    }
}
