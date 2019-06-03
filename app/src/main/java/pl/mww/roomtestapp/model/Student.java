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

    private String last_update;

    private String classroom;

    public Student(String firstName, String lastName, String indexNo, String last_update, String classroom) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.indexNo = indexNo;
        this.last_update = last_update;
        this.classroom = classroom;
    }

    @Ignore
    public Student (String firstName, String lastName, String indexNo) {
        this(firstName, lastName, indexNo, "1", "no1");
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

    public String getLast_update() { return last_update; }

    public String getClassroom() {
        return classroom;
    }

    @NonNull
    @Override
    public String toString() {
        return firstName + " " + lastName + ", " + indexNo + ", " + last_update + ", " + classroom;
    }
}
