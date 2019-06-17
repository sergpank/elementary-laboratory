package dao;

import entity.Doc;
import entity.Pet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vaio on 17.06.19.
 */
public class DocDAO extends DAO<Doc> {
    public static final String SELECT_Pet_SQL = "SELECT * FROM visit WHERE doc_id = ?;";
    private List<Pet> getPets(Connection con,Integer id){
        List<Pet> petList = new ArrayList<>();
        try {
            PreparedStatement statement = con.prepareStatement(SELECT_Pet_SQL);
            statement.setLong(1,id);
            ResultSet resultSet = 

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public Doc create(Doc entity) {
        return null;
    }

    @Override
    public Doc read(long id) {
        return null;
    }

    @Override
    public List<Doc> readAll() {
        return null;
    }

    @Override
    public boolean update(Doc entity) {
        return false;
    }

    @Override
    public boolean delete(Doc entity) {
        return false;
    }
}
