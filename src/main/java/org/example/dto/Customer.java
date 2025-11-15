package org.example.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Customer {

    private Long id;
    private String firstName;
    private String lastName;
    private  Integer age;
    private String email;

}
