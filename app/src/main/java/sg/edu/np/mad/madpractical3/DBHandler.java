package sg.edu.np.mad.madpractical3;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBHandler extends SQLiteOpenHelper {

    public DBHandler(Context c){
        super(c, "users.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE User (Name TEXT, Description TEXT, Id INTEGER Primary key, Followed INTEGER)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS User");
        onCreate(db);
    }

    public void insertMsg(User user){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from User", null);
        if(cursor.moveToNext() == false){
            int i = 0;
            if(user.Followed == false){
                i = 0;
            }
            else{
                i = 1;
            }
            db.execSQL("Insert into User Values(\"" + user.Name + "\", \"" + user.Description + "\", \"" + user.Id + "\", \"" + i + "\")");
            /**
             * Insert into Message Values("Username", "Message", "DT)
             */
            db.close();
        }

        /*int i = 0;
        if(user.Followed == false){
            i = 0;
        }
        else{
            i = 1;
        }
        db.execSQL("Insert into User Values(\"" + user.Name + "\", \"" + user.Description + "\", \"" + user.Id + "\", \"" + i + "\")");
        *//**
         * Insert into Message Values("Username", "Message", "DT)
         *//*
        db.close();*/
    }

    public ArrayList<User> getUsers(){
        SQLiteDatabase db = this.getWritableDatabase();

        ArrayList<User> usersList = new ArrayList<>();

        /**
         * Select * from User
         */

        Cursor cursor = db.rawQuery("Select * from User", null);
        while(cursor.moveToNext()){
            String name = cursor.getString(0);
            String description = cursor.getString(1);
            Integer id = cursor.getInt(2);
            Integer temp = cursor.getInt(3);
            Boolean followed = false;
            if (temp == 1){
                followed = true;
            }
            else{
                followed = false;
            }
            User user = new User(name, description, id, followed);
            usersList.add(user);
        }

        cursor.close();
        return usersList;
    }

    public void updateUser(User user){
        SQLiteDatabase db = this.getWritableDatabase();
        Integer i = 0;
        if(user.Followed == false){
            i = 0;
        }
        else{
            i = 1;
        }

       /* String sql = "UPDATE User set Followed = i where Name = user.name";
        db.execSQL(sql);*/
        db.execSQL("Update User set Followed = " + i + " where Id = " + user.Id);
        db.close();
    }
}
