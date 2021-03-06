package pl.mww.roomtestapp.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import java.util.List;

import pl.mww.roomtestapp.model.Student;
import pl.mww.roomtestapp.model.StudentMinimal;

@Dao
public interface StudentDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Student student);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Student> students);

    @Query("DELETE FROM students")
    void deleteAll();

    @Query("SELECT * FROM students ORDER BY indexNo ASC")
    List<Student> getAllStudents();

    @Query("SELECT indexNo FROM students ORDER BY indexNo DESC LIMIT 1")
    int getLastIndex();

    @Query("DELETE  FROM students WHERE indexNo=(SELECT MAX(indexNo) FROM students)")
    void deleteLastStudent();

    @Delete
    void deleteStudents(Student... students);

    @Update
    public void updateUsers(Student... students);

    @Transaction
    default void replaceData(List<Student> students)  {
        deleteAll();
        insertAll(students);
    }

    @Query("SELECT firstName, indexNo FROM students")
    List<StudentMinimal> getAllStudentsMinimal();

}
