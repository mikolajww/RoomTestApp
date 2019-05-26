package pl.mww.roomtestapp.repository;

import android.app.Application;
import android.os.AsyncTask;

import pl.mww.roomtestapp.dao.StudentDao;
import pl.mww.roomtestapp.database.StudentDatabase;
import pl.mww.roomtestapp.model.Student;

public class StudentRepository {

    private StudentDao studentDao;

    StudentRepository(Application application) {
        StudentDatabase db = StudentDatabase.getInstance(application);
        studentDao = db.studentDao();
    }

    public void insert(Student student) {
        new insertAsyncTask(studentDao).execute(student);
    }


    private static class insertAsyncTask extends AsyncTask<Student, Void, Void> {

        private StudentDao asyncTaskDao;

        insertAsyncTask(StudentDao dao) {
            asyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Student... params) {
            asyncTaskDao.insert(params[0]);
            return null;
        }
    }
}
