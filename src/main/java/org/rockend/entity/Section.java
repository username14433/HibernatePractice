package org.rockend.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "sections")
public class Section {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "section_type", nullable = false, length = 50)
    private String sectionType;

    @ManyToMany
    @JoinTable(
            name = "students_sections",
            joinColumns = @JoinColumn(name = "section_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    private List<Student> students;
}
