package pl.mww.roomtestapp.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import pl.mww.roomtestapp.dao.StudentDao;
import pl.mww.roomtestapp.model.Student;

@Database(entities = {Student.class}, version = 1)
public abstract class StudentDatabase extends RoomDatabase {
    public abstract StudentDao studentDao();

    private static volatile StudentDatabase INSTANCE;

    public static StudentDatabase getInstance(final Context context) {
        if(INSTANCE == null) {
            synchronized (StudentDatabase.class) {
                if(INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            StudentDatabase.class, "student_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
