package org.example.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;
import org.aspectj.bridge.IMessage;
import org.jspecify.annotations.Nullable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "customer")

public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @NotBlank(message = "First name cannot be empty")
    @Size(min = 2, max = 50, message = "First name must be between 2–50 characters")
    private String firstName;
    @NotBlank(message = "Last name cannot be empty")
    @Size(min = 2, max = 50, message = "Last name must be between 2–50 characters")
    private String lastName;

    @Min(value = 1, message = "Age must be greater than 0")
    @Max(value = 120, message = "Age cannot exceed 120")
    private Integer age;

    @NotBlank(message = "Email cannot be empty")
    @Email(message = "Invalid email format")
    private String email;
}