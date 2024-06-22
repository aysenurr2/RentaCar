package dao;

import core.Db;
import entity.Brand;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BrandDao {
    private final Connection con;

    public BrandDao() {
        try {
            this.con = Db.getInstance();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public ArrayList<Brand> findAll(){
        ArrayList<Brand> brandList = new ArrayList<>();
        String sql = "SELECT * FROM public.brand";
        try {
            ResultSet rs = this.con.createStatement().executeQuery(sql);
            while (rs.next()){
                brandList.add(this.match(rs));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return brandList;
    }

    public boolean save(Brand brand){
        String query = "INSERT INTO public.brand (brand_name) VALUES (?)";
        try {
            PreparedStatement pr = this.con.prepareStatement(query);
            pr.setString(1,brand.getName());

        }catch (SQLException e){
            e.printStackTrace();
        }
        return true;
    }

    public Brand match(ResultSet rs) throws SQLException{
        Brand obj = new Brand();
        obj.setId(rs.getInt("brand_id"));
        obj.setName(rs.getString("brand_name"));
        return obj;
    }
}
