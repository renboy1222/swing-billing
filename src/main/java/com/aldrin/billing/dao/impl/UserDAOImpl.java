/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aldrin.billing.dao.impl;

import com.aldrin.billing.dao.UserDAO;
import com.aldrin.billing.model.Role;
import com.aldrin.billing.model.User;
import com.aldrin.billing.util.ComboBoxList;
import com.aldrin.billing.util.LoginUser;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;


/**
 *
 * @author ALDRIN B. C.
 */

public class UserDAOImpl extends DBConnection implements UserDAO {

    private ArrayList<ComboBoxList> list;

    @Override
    public void addUser(User user) {
        try {
            getDBConn();
            java.sql.PreparedStatement ps = getCon().prepareStatement("INSERT INTO USER (FIRSTNAME,SURNAME,USERNAME,PASSWORD,ROLE_ID,PHOTO) VALUES  (?,?,?,?,?,?) ");
            ps.setString(1, user.getFirstname());
            ps.setString(2, user.getSurname());
            ps.setString(3, user.getUsername());
            ps.setString(4, user.getPassword());
            ps.setLong(5, user.getRole().getId());
            ps.setBytes(6, user.getPhoto());
            ps.execute();
            ps.close();
            closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateUser(User user) {
        try {
            getDBConn();
            java.sql.PreparedStatement ps;
            if (user.getInActiveAt() != null) {
                ps = getCon().prepareStatement("UPDATE USER SET InActiveAt =? WHERE USER.ID = ?");
                ps.setTimestamp(1, user.getInActiveAt());
                ps.setLong(2, user.getId());
            }else if (user.getUpdatePassword().toString().length()==64) {
                ps = getCon().prepareStatement("UPDATE USER SET FIRSTNAME =?, SURNAME =?, USERNAME=?, ROLE_ID=?, PHOTO=? ,InActiveAt =? WHERE USER.ID = ?");
                ps.setString(1, user.getFirstname());
                ps.setString(2, user.getSurname());
                ps.setString(3, user.getUsername());
                ps.setLong(4, user.getRole().getId());
                ps.setBytes(5, user.getPhoto());
                ps.setTimestamp(6, user.getInActiveAt());
                ps.setLong(7, user.getId());
            }  else {
                user.setPassword(user.getUpdatePassword());
                ps = getCon().prepareStatement("UPDATE USER SET FIRSTNAME =?, SURNAME =?, USERNAME=?, PASSWORD=?,  ROLE_ID=?, PHOTO=?,InActiveAt =?  WHERE USER.ID = ?");
                ps.setString(1, user.getFirstname());
                ps.setString(2, user.getSurname());
                ps.setString(3, user.getUsername());
                ps.setString(4, user.getPassword());
                ps.setLong(5, user.getRole().getId());
                ps.setBytes(6, user.getPhoto());
                ps.setTimestamp(7, user.getInActiveAt());
                ps.setLong(8, user.getId());
            }

            ps.execute();
            ps.close();
            closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteUser(User user) {
        try {
            getDBConn();
            java.sql.PreparedStatement ps = getCon().prepareStatement("UPDATE USER SET ACTIVE =? WHERE USER.ID = ? ");
            ps.setBoolean(1, true);
            ps.setLong(2, user.getId());
            ps.execute();
            ps.close();
            closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<User> selectUser() {
        ArrayList<User> list = new ArrayList<>();
        try {
            String query = "SELECT \n"
                    + "    USER.ID, \n"
                    + "    USER.InActiveAt, \n"
                    + "    USER.FIRSTNAME, \n"
                    + "    USER.PASSWORD, \n"
                    + "    USER.SURNAME, \n"
                    + "    USER.USERNAME, \n"
                    + "    USER.ROLE_ID, \n"
                    + "    ROLE.ROLE \n"
                    + "FROM \n"
                    + "    USER \n"
                    + "INNER JOIN \n"
                    + "    ROLE \n"
                    + "ON \n"
                    + "    ( \n"
                    + "        USER.ROLE_ID = ROLE.ID)  ORDER BY ROLE.ROLE ASC";
            getDBConn();
            Statement st = getCon().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                User u = new User();
                Role r = new Role();
                r.setId(rs.getLong("ROLE_ID"));
                r.setRole(rs.getString("ROLE"));
                u.setId(rs.getLong("ID"));
                u.setRole(r);
                u.setFirstname(rs.getString("FIRSTNAME"));
                u.setSurname(rs.getString("SURNAME"));
                u.setUsername(rs.getString("USERNAME"));
                u.setPassword(rs.getString("PASSWORD"));
                u.setInActiveAt(rs.getTimestamp("InActiveAt"));

                list.add(u);
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
    public User findPhotoByUserId(User user) {
        User userPhoto = new User();
        Blob photo = null;
        try {
            getDBConn();
            PreparedStatement statement = getCon().prepareStatement("SELECT  PHOTO FROM USER  WHERE ID  =" + user.getId() + "");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {

                Blob picturel = rs.getBlob("PHOTO");
                photo = picturel;
                byte[] bytes = convertBlobToBytes(picturel);
                userPhoto.setPhoto(bytes);
            }
            rs.close();
            statement.close();
            closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Opss...", JOptionPane.ERROR_MESSAGE);
        }
        return userPhoto;
    }

    private static byte[] convertBlobToBytes(java.sql.Blob blob) throws IOException, SQLException {
        try (InputStream inputStream = blob.getBinaryStream()) {
            return convertInputStreamToBytes(inputStream);
        }
    }

    private static byte[] convertInputStreamToBytes(InputStream inputStream) throws IOException {
        byte[] buffer = new byte[1024];
        int bytesRead;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        while ((bytesRead = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, bytesRead);
        }
        return outputStream.toByteArray();
    }

    private static void writeBytesToFile(byte[] bytes, String filePath) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            fos.write(bytes);
        }
    }

    @Override
    public User loginUser(User user) {
        User userInfo = null;
        LoginUser loginUser = new LoginUser();
        loginUser.setUser(null);
        try {
            getDBConn();
            PreparedStatement statement = getCon().prepareStatement("SELECT \n"
                    + "    USER.FIRSTNAME, \n"
                    + "    USER.InActiveAt, \n"
                    + "    USER.ID, \n"
                    + "    USER.ROLE_ID, \n"
                    + "    ROLE.ROLE, \n"
                    + "    USER.PASSWORD, \n"
                    + "    USER.SURNAME, \n"
                    + "    USER.USERNAME ,USER.PHOTO\n"
                    + "FROM \n"
                    + "    USER \n"
                    + "INNER JOIN \n"
                    + "    ROLE \n"
                    + "ON \n"
                    + "    (USER.ROLE_ID = ROLE.ID) WHERE USER.USERNAME =BINARY? AND USER.PASSWORD =BINARY? AND USER.InActiveAt is null");
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                User ua = new User();

                Role r = new Role();
                Long userId = rs.getLong("ID");
                Long roleId = rs.getLong("ROLE_ID");
                String firstname = rs.getString("FIRSTNAME");
                String surname = rs.getString("SURNAME");
                String username = rs.getString("USERNAME");
                String password = rs.getString("PASSWORD");
                String role = rs.getString("ROLE");
                java.sql.Timestamp active = rs.getTimestamp("InActiveAt");
                Blob picturel = rs.getBlob("PHOTO");
                byte[] bytes = convertBlobToBytes(picturel);
                ua.setPhoto(bytes);
                r.setId(roleId);
                r.setRole(role);
                ua.setRole(r);
                ua.setId(userId);
                ua.setFirstname(firstname);
                ua.setSurname(surname);
                ua.setUsername(username);
                ua.setInActiveAt(active);
                userInfo = ua;
                loginUser.setPassword(password);
                loginUser.setUser(ua);
            }
            rs.close();
            statement.close();
            closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
//            JOptionPane.showMessageDialog(null, e.getMessage(), "Opss...", JOptionPane.ERROR_MESSAGE);
        }

        return userInfo;
    }

    @Override
    public Boolean changePassword(User user) {
        Boolean changePassword = false;
        try {
            getDBConn();
            java.sql.PreparedStatement ps = getCon().prepareStatement("UPDATE USER SET  PASSWORD=?  WHERE USER.ID = ?");
            ps.setString(1, user.getPassword());
            ps.setLong(2, user.getId());
            ps.execute();
            ps.close();
            closeConnection();
            changePassword = true;
            LoginUser loginUser = new LoginUser();
            loginUser.getUser().setPassword(user.getPassword());

        } catch (Exception e) {
            e.printStackTrace();
        }
        return changePassword;

    }

    @Override
    public void comboBoxUserAccountAdmin() {
        this.setList(new ArrayList<ComboBoxList>());
        try {
            getDBConn();
            PreparedStatement statement;
            ResultSet rs;
            statement = getCon().prepareStatement("SELECT \n"
                    + "  `id`,\n"
                    + "  `firstname`,\n"
                    + "  `surname` \n"
                    + "FROM\n"
                    + "  `user` WHERE user.`InActiveAt` IS NULL  ORDER BY `surname` ASC;");
            rs = statement.executeQuery();
            while (rs.next()) {
                Long idl = rs.getLong("ID");
                String firstname = rs.getString("firstname");
                String surname = rs.getString("surname");

                this.getList().add(new ComboBoxList(idl, surname + ", " + firstname));
            }
            rs.close();
            statement.close();
            closeConnection();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void comboBoxUserAccountUser() {
        this.setList(new ArrayList<ComboBoxList>());
        try {
            getDBConn();
            PreparedStatement statement;
            ResultSet rs;
            statement = getCon().prepareStatement("SELECT \n"
                    + "  `id`,\n"
                    + "  `firstname`,\n"
                    + "  `surname` \n"
                    + "FROM\n"
                    + "  `user` WHERE user.`InActiveAt` IS NULL  and user.id ="+new LoginUser().getUser().getId()+"  ORDER BY `surname` ASC;");
            rs = statement.executeQuery();
            while (rs.next()) {
                Long idl = rs.getLong("ID");
                String firstname = rs.getString("firstname");
                String surname = rs.getString("surname");

                this.getList().add(new ComboBoxList(idl, surname + ", " + firstname));
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
