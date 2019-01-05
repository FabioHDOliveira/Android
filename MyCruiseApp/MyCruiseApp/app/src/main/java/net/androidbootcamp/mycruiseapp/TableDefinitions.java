package net.androidbootcamp.mycruiseapp;

public class TableDefinitions {

    public static final String SQL_CREATE_DEPT =
            "CREATE TABLE DEPARTMENT (roomid integer primary key, roomType text, MainGuest text )";

    public static final String SQL_DELETE_DEPT =
            "DROP TABLE IF EXISTS DEPARTMENT ";

    public static final String SQL_CREATE_EMP =
            "CREATE TABLE Guests (id integer primary key, fn text, ln text,  room_id integer," +
                    "FOREIGN KEY(room_id) REFERENCES DEPARTMENT(roomid) on delete cascade)";

    public static final String SQL_DELETE_EMP =
            "DROP TABLE IF EXISTS Guests ";


    public static final String SQL_CREATE_ACT =
            "CREATE TABLE BuyActivitiesTable (actid integer primary key, actname text, actticket text,  room_id integer," +
                    "FOREIGN KEY(room_id) REFERENCES DEPARTMENT(roomid) on delete cascade)";

    public static final String SQL_DELETE_ACT =
            "DROP TABLE IF EXISTS BuyActivitiesTable ";

}
