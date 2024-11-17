package org.sza.mapper;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import org.sza.domain.Account;

import java.util.List;

public interface AccountMapper {

    @Insert("insert into tbl_account(name, money) VALUES (#{name}, #{money})")
    void save(Account account);

    @Delete("delete from tbl_account where id = #{id}")
    void delete(Integer id);

    @Update("update tbl_account set `name` = #{name}, money = #{money}")
    void update(Account account);

    @Select("select * from tbl_account")
    List<Account> findAll();

    @Select("select * from tbl_account where id = #{id}")
    Account findById(Integer id);
}