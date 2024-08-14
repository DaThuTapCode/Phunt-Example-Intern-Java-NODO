package week1.day2example.oop.inheritance;

import java.time.LocalDate;

/**
 * Created by Trong Phu on 07/08/2024 09:18:40
 *
 * @author Trong Phu
 */
public class Pet extends Animal{

    private LocalDate dayOfBirth;

    public Pet(String name, LocalDate dayOfBirth) {
        super(name);
        this.dayOfBirth  = dayOfBirth;
    }

    public LocalDate getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(LocalDate dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }
}
