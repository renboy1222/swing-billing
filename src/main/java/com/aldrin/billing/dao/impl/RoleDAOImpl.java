/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aldrin.billing.dao.impl;

import com.aldrin.billing.dao.RoleDAO;
import com.aldrin.billing.model.Role;
import com.aldrin.billing.util.ComboBoxList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author ALDRIN B. C.
 */
public class RoleDAOImpl extends DBConnection implements RoleDAO {

    private ArrayList<ComboBoxList> list;

    @Override
    public void addRole(Role role) {
        try {
            getDBConn();
            java.sql.PreparedStatement ps = getCon().prepareStatement("INSERT INTO ROLE (ROLE,DESCRIPTION) VALUES  (?,?) ");
            ps.setString(1, role.getRole());
            ps.setString(2, role.getDescription());
            ps.execute();
            ps.close();
            closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateRole(Role role) {
        try {
            getDBConn();
            java.sql.PreparedStatement ps = getCon().prepareStatement("UPDATE ROLE SET ROLE =?, DESCRIPTION =? WHERE ROLE.ID = ?");
            ps.setString(1, role.getRole());
            ps.setString(2, role.getDescription());
            ps.setLong(3, role.getId());
            ps.execute();
            ps.close();
            closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteRole(Role role) {
        try {
            getDBConn();
            java.sql.PreparedStatement ps = getCon().prepareStatement("UPDATE ROLE SET DELETED =? WHERE ROLE.ID = ? ");
            ps.setBoolean(1, true);
            ps.setLong(2, role.getId());
            ps.execute();
            ps.close();
            closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<Role> selectRole() {
        ArrayList<Role> list = new ArrayList<>();
        try {
            String query = "SELECT * FROM ROLE WHERE ROLE.ACTIVE =TRUE  ORDER BY ROLE ASC ";
            getDBConn();
            Statement st = getCon().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                Role c = new Role();
                c.setId(rs.getLong("ID"));
                c.setRole(rs.getString("ROLE"));
                c.setDescription(rs.getString("DESCRIPTION"));
                list.add(c);
            }
            rs.close();
            st.close();
            closeConnection();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    @Override
    public void comboBoxRole() {
        this.setList(new ArrayList<ComboBoxList>());
        try {
            getDBConn();
            PreparedStatement statement;
            ResultSet rs;
            statement = getCon().prepareStatement("SELECT * FROM ROLE WHERE ROLE.ACTIVE=TRUE  ORDER BY ROLE ASC ");
            rs = statement.executeQuery();
            while (rs.next()) {
                Long idl = rs.getLong("ID");
                String namel = rs.getString("ROLE");
                this.getList().add(new ComboBoxList(idl, namel));
            }
            rs.close();
            statement.close();
            closeConnection();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * @return the list
     */
    public ArrayList<ComboBoxList> getList() {
        return list;
    }

    /**
     * @param list the list to set
     */
    public void setList(ArrayList<ComboBoxList> list) {
        this.list = list;
    }

}
