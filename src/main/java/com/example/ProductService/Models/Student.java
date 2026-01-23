package com.example.ProductService.Models;


import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Student extends BaseModel {

    private String name;


    @ManyToMany
    private List<Courses> courses;


}
