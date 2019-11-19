package com.example.restaurant;

public class Restaurant {
    String Rname;
    String Raddress;
    String Rlocation;
    String Telenum;



        public String getRname() {
            return Rname;
        }

        public void setRname(String Rname) {
            this.Rname = Rname;
        }

        public String getRaddress() {
            return Raddress;
        }

        public void setRaddress(String Raddress) {
            this.Raddress = Raddress;
        }

        public String getRlocation() {
            return Rlocation;
        }

        public void setRlocation(String Rlocation) {
            this.Rlocation = Rlocation;
        }

        public String getTelenum() {
            return Telenum;
        }

        public void setTelenum(String Telenum) {
            this.Telenum = Telenum;
        }

        public Restaurant(String Rname, String Raddress, String Rlocation, String Telenum) {
            this.Rname = Rname;
            this.Raddress = Raddress;
            this.Rlocation = Rlocation;
            this.Telenum = Telenum;
        }
    }