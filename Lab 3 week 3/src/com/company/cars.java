package com.company;
import java.io.Serializable;

public class cars implements Serializable
{
        String registrationNum;
        String make;
        String manDate;
        Double price;

        public cars()
        {
            this.registrationNum = "";
            this.make = "";
            this.manDate = "";
            this.price = 0.0;
        }
        public cars (String registrationNum, String make, Double price)
        {
            this.registrationNum = registrationNum;
            this.make = make;
            this.price = price;
        }

    public String getRegistrationNum() {
        return registrationNum;
    }

    public void setRegistrationNum(String registrationNum) {
        this.registrationNum = registrationNum;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getManDate() {
        return manDate;
    }

    public void setManDate(String manDate) {
        this.manDate = manDate;
    }

    @Override
    public String toString() {
        return "cars{" +
                "registrationNum='" + registrationNum + '\'' +
                ", make='" + make + '\'' +
                ", manDate='" + manDate + '\'' +
                ", price=" + price +
                '}';
    }
}
