package com.ddona.service.model;

public class Laptop {
    private String cpu;
    private String ram;
    private String storage;
    private String main;
    private String power;
    private String vga;
    private String led;
    private String fan;


    private Laptop() {

    }

    public Laptop(Builder builder) {
        this.cpu = builder.cpu;
        this.fan = builder.fan;
        this.power = builder.power;
        this.vga = builder.vga;
        this.ram = builder.ram;
        this.main = builder.main;
        this.storage = builder.storage;
        this.led = builder.led;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "cpu='" + cpu + '\'' +
                ", ram='" + ram + '\'' +
                ", storage='" + storage + '\'' +
                ", main='" + main + '\'' +
                ", power='" + power + '\'' +
                ", vga='" + vga + '\'' +
                ", led='" + led + '\'' +
                ", fan='" + fan + '\'' +
                '}';
    }

    public static class Builder {
        private String cpu;
        private String ram;
        private String storage;
        private String main;
        private String power;
        private String vga;
        private String led;
        private String fan;

        public Builder(String cpu, String ram, String storage, String main, String power) {
            this.cpu = cpu;
            this.ram = ram;
            this.storage = storage;
            this.main = main;
            this.power = power;
        }

        public Laptop build() {
            return new Laptop(this);
        }

        public Builder setVga(String vga) {
            this.vga = vga;
            return this;
        }

        public Builder setLed(String led) {
            this.led = led;
            return this;
        }

        public Builder setFan(String fan) {
            this.fan = fan;
            return this;
        }


    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getStorage() {
        return storage;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public String getVga() {
        return vga;
    }

    public void setVga(String vga) {
        this.vga = vga;
    }

    public String getLed() {
        return led;
    }

    public void setLed(String led) {
        this.led = led;
    }

    public String getFan() {
        return fan;
    }

    public void setFan(String fan) {
        this.fan = fan;
    }
}
