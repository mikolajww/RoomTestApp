package pl.mww.roomtestapp;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import pl.mww.roomtestapp.dao.StudentDao;
import pl.mww.roomtestapp.database.StudentDatabase;
import pl.mww.roomtestapp.model.Student;


public class MainActivity extends AppCompatActivity {

    private ListView list;
    private ArrayAdapter<String> adapter;
    StudentDatabase db;
    StudentDao studentDao;
    private int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = findViewById(R.id.listView1);


        db = StudentDatabase.getInstance(getApplicationContext());
        studentDao = db.studentDao();

        findViewById(R.id.add_students).setOnClickListener(v -> AsyncTask.execute(() -> {
            counter++;
            studentDao.insert(new Student("xd", "dx", String.valueOf(counter)));
            displayStudentList();
        }));

        findViewById(R.id.delete_students).setOnClickListener(v -> AsyncTask.execute(() -> {
            studentDao.deleteAll();
            System.out.println("Deleted all students");
            displayStudentList();
            counter = 0;
        }));
        findViewById(R.id.delete_student).setOnClickListener(v -> AsyncTask.execute(() -> {
            studentDao.deleteLastStudent();
            System.out.println("Deleted last student");
            displayStudentList();
            counter--;
        }));
    }
    public void displayStudentList() {
        final ArrayList<String> studentList = new ArrayList<>();
        for(Student s : studentDao.getAllStudents()) {
            System.out.println(s);
            studentList.add(s.toString());
        }
        adapter = new ArrayAdapter<>(this, R.layout.element, studentList);
        runOnUiThread(()->list.setAdapter(adapter));
    }
}
