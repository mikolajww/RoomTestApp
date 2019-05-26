package pl.mww.roomtestapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Button;

import pl.mww.roomtestapp.dao.StudentDao;
import pl.mww.roomtestapp.database.StudentDatabase;
import pl.mww.roomtestapp.model.Student;

public class MainActivity extends AppCompatActivity {

    StudentDatabase db;
    StudentDao studentDao;
    private int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = StudentDatabase.getInstance(getApplicationContext());
        studentDao = db.studentDao();

        findViewById(R.id.add_students).setOnClickListener(v -> {
            AsyncTask.execute(() -> {
                counter++;
                studentDao.insert(new Student("xd", "dx", String.valueOf(counter)));

                for(Student s : studentDao.getAllStudents()) {
                    System.out.println(s);
                }
            });
        });

        findViewById(R.id.delete_students).setOnClickListener(v -> AsyncTask.execute(() -> {
            studentDao.deleteAll();
            counter = 0;
        }));
    }
}
