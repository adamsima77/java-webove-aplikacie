package sk_ukf.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @NotBlank(message = "Meno nesmie byť prázdne")
    @Size(min = 2, max = 50, message = "Meno musí mať 2 až 50 znakov")
    @Column(name = "first_name")
    private String firstName;

    @NotBlank(message = "Priezvisko nesmie byť prázdne")
    @Size(min = 2, max = 50, message = "Priezvisko musí mať 2 až 50 znakov")
    @Column(name = "last_name")
    private String lastName;

    @Column(name = "birth_date")
    private String birthDate;

    @NotBlank(message = "Email nesmie byť prázdny")
    @Size(max = 254, message = "Email môže mať najviac 254 znakov")
    @Pattern(
            regexp = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*"
                    + "|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]"
                    + "|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")"
                    + "@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?"
                    + "|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}"
                    + "(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?"
                    + "|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]"
                    + "|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])",
            flags = Pattern.Flag.CASE_INSENSITIVE,
            message = "Neplatný formát emailovej adresy"
    )
    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "phone")
    private String phone;

    @NotBlank(message = "Pracovná pozícia nesmie byť prázdna")
    @Column(name = "job_title")
    private String jobTitle;

    @NotNull(message = "Mzda nesmie byť prázdna")
    @Positive(message = "Mzda musí byť kladné číslo")
    @Column(name = "salary")
    private Integer salary;

    @Column(name = "full_time")
    private boolean fullTime;

    public Employee() {}

    public Employee(String firstName, String lastName, String email, String jobTitle, Integer salary, boolean fullTime) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.jobTitle = jobTitle;
        this.salary = salary;
        this.fullTime = fullTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public boolean isFullTime() {
        return fullTime;
    }

    public void setFullTime(boolean fullTime) {
        this.fullTime = fullTime;
    }
}