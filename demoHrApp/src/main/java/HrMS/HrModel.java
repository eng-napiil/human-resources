package HrMS;

import jakarta.persistence.*;

import lombok.*;

import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Employees")

public class HrModel {
    @Id
    private Long id;
    @Column(nullable = false, length = 50)
    private String name;
    @Column
    private String email;
    @Column
    private int phoneNumber;
    @Column
    private String department;
    @Column
    private double salary;
    @Column
    private String jobTitle;
    @Column
    private String gender;
    @Column
    private LocalDate hireDate;




}
