package com.senjie.dao;

import com.senjie.po.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PersonDao extends JpaRepository<Person, Long> {
    //    根据接口中定义方法名字，自动推导出，用户要进行操作
    public Person findByNameEquals(String name);

    public Person findByNameEqualsAndPasswordEquals(String name, String password);

    public List<Person> findByNameLike(String name);

    @Query("select p from Person p where p.name=:name and p.password=:password")
    public Person login(@Param("name") String name, @Param("password") String password);

    @Query(value = "SELECT * FROM tb_person WHERE LENGTH(PASSWORD)=6", nativeQuery = true)
    public Person getpasswordlength();
}
