package pl.mww.roomtestapp.database;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

import pl.mww.roomtestapp.dao.StudentDao;
import pl.mww.roomtestapp.model.Student;

@Database(entities = {Student.class}, version = 2)
public abstract class StudentDatabase extends RoomDatabase {
    public abstract StudentDao studentDao();

    private static volatile StudentDatabase INSTANCE;

    static final Migration MIGRATION_1_2 = new Migration(1, 2) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
            database.execSQL("ALTER TABLE students ADD COLUMN email TEXT DEFAULT 'stary@email.pl' NOT NULL");
        }
    };

//Klasa database jest singletonem oraz jej metoda getInstance jest podwójnie sprawdzana,
// aby uniknąć przypadkowej podwójnej inicjalizacji przez wątki
    public static StudentDatabase getInstance(final Context context) {
        if(INSTANCE == null) {
            synchronized (StudentDatabase.class) {
                if(INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            StudentDatabase.class, "student_database")
                            .addMigrations(MIGRATION_1_2)
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
