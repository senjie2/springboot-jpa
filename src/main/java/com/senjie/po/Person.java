package com.senjie.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_person")
public class Person {
    @Id
    @GeneratedValue
    private  Long id;
    @Column(name = "name",nullable = false,length = 20)
    private  String name;
    @Column(nullable =false,length = 20)
    private  String password;
    @Column(length = 4,nullable = false)
    private Integer age;
}
