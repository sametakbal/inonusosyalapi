package com.inonusosyal.api.dao;

import com.inonusosyal.api.dao.interfaces.IGroupDao;
import com.inonusosyal.api.entity.Dto.GroupDto;
import com.inonusosyal.api.entity.Dto.UserDto;
import com.inonusosyal.api.entity.Group;
import com.inonusosyal.api.entity.User;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class GroupDao extends Dao implements IGroupDao {
    @Override
    public List<Group> get() {
        return null;
    }

    public Optional<Group> getById(UUID id) {
        return Optional.empty();
    }

    @Override
    public int add(Group group) {
        return 0;
    }

    @Override
    public int update(Group group) {
        return 0;
    }

    @Override
    public int remove(UUID id) {
        return 0;
    }

    @Override
    public List<GroupDto> getUserGroups(UUID userUuid) {
        String q = "select g.id,g.group_icon,g.title,g.description from groups g inner join group_users u on (u.user_id = ? and g.id = u.group_id)";
        List<GroupDto> groups = new ArrayList<>();
        try {
            PreparedStatement pst = this.getConn().prepareStatement(q);
            pst.setObject(1, userUuid);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                GroupDto tmp = new GroupDto(rs.getObject("id", java.util.UUID.class), rs.getString("group_icon"),
                        rs.getString("title"), rs.getString("description"));
                groups.add(tmp);
            }
            pst.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return groups;
    }
}
