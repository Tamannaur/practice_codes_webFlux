package com.app.solid;

//Dependency inversion principle
public class DExample {
    public static void main(String[] args) {
        Application application = new Application(new MongoDbConnection());
        application.startConnection();

        Application application2 = new Application(new MySqlConnection());
        application2.startConnection();
    }
}

interface DbConnection {
    void connect();
}
class MySqlConnection implements DbConnection {

    @Override
    public void connect() {
        System.out.println("MySql connection connect");
    }
}

class MongoDbConnection implements DbConnection {
    @Override
    public void connect() {
        System.out.println("MongoDB connection connect");
    }
}
class Application{
    DbConnection dbConnection;

    public Application(DbConnection dbConnection){
        this.dbConnection = dbConnection;
    }

    public void startConnection(){
        dbConnection.connect();
    }
}