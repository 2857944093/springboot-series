package com.czk.hope.entity.repository;


import com.czk.hope.entity.config.BaseRepository;
import com.czk.hope.entity.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaEntityInformationSupport;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author: Created by ChenZK
 * @Create: 2019/12/24 13:16
 */
@Repository
public interface UserRepository extends BaseRepository<Users, Integer> {

    @Query(nativeQuery = true, value = "select table_name tableName, engine, table_comment tableComment, create_time createTime from information_schema.tables\n" +
            "\t\twhere table_schema = (select database())\n" +
            "\t\torder by create_time desc")
    List<Map<String, String>> findTableAll();

    @Query(nativeQuery = true, value = "select column_name columnName, data_type dataType, column_comment columnComment, column_key columnKey, extra from information_schema.columns\n" +
            " \t\t\twhere table_name = ? and table_schema = (select database()) order by ordinal_position")
    List<Map<String, String>> findTableByTableName(String tableName);

}
