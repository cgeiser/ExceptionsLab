package lab0;

import java.util.Date;

/**
 * In this challenge you need to address the probability that at some
 * point the arguments to method parameters may not be valid. 
 * <p>
 * For example, String arguments may be null or empty; other objects may be 
 * null; or primitive numbers may be out of acceptable range.
 * <p>
 * You need to validate ALL method parameters to make sure any and all 
 * arguments are valid. The only exception is when any argument is acceptable 
 * based on requirements. Fix the code below using if logic to validate
 * method arguments and throw IllegalArgumentException or a custom
 * exception if the validation fails.
 * 
 * @author  Jim Lombardo, jlombardo@wctc.edu
 * @version 1.00
 */
public class Employee {
    public static final int MAX_VACATION_DAYS = 28;
    private String firstName;
    private String lastName;
    private String ssn;
    private Date hireDate;
    private int daysVacation;

    public Employee() {
        firstName = "Unknown";
        lastName = "Unknown";
        ssn = "Unknown";
        hireDate = new Date();
        daysVacation = 0;
    }

    public Employee(String firstName, String lastName, String ssn,
            Date hireDate, int daysVacation) throws SsnFormatException {
        setFirstName(firstName);
        setLastName(lastName);
        setSsn(ssn);
        setHireDate(hireDate);
        setDaysVacation(daysVacation);
    }
    
    public int getDaysVacation() {
        return daysVacation;
    }

    public void setDaysVacation(int daysVacation) {
        if (daysVacation < 0) {
            throw new IllegalArgumentException("Vacation days must be a positive number.");
        }
        this.daysVacation = daysVacation;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName == null) {
            throw new IllegalArgumentException("firstName cannot be null.");
        }
        this.firstName = firstName;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        if (hireDate == null) {
            throw new IllegalArgumentException("hireDate cannot be null.");
        }
        this.hireDate = hireDate;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName == null) {
            throw new IllegalArgumentException("lastName cannot be null.");
        }
        this.lastName = lastName;
    }

    public final String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) throws SsnFormatException {
        if (ssn == null) {
            throw new IllegalArgumentException("SSN cannot be null.");
        }
        if (ssn.length() != 9 && ssn.length() != 11) {
            throw new SsnFormatException("Incorrect number of digits for SSN.");
        }
        this.ssn = ssn;
    }

    @Override
    public String toString() {
        return "Employee{" + "firstName=" + firstName + ", lastName="
                + lastName + ", ssn=" + ssn + ", hireDate=" + hireDate
                + ", daysVacation=" + daysVacation + '}';
    }
    
    
    public static void main(String[] args) throws SsnFormatException {
        Employee e = new Employee("Sam", "Gravel","443-25-6778",new Date(),-6);
        System.out.println(e);
    }
    
}
