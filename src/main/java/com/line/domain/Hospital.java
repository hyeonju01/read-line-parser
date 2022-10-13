package com.line.domain;

public class Hospital {
    private String id;
    private String address;
    private String district;
    private String category;

    // [SQL] emergency_room (snake), [JAVA] emergencyRoom (camelCase)
    private Integer emergencyRoom;
    private String name;
    private String subdivision;

    public Hospital(String id) {
        this.id = id.replaceAll("\"", "");
    }

//    public Hospital(String id, String address) {
//        this.id = id;
//        this.address = address;
//    }

    public Hospital(String id, String address, String category, Integer emergencyRoom, String name, String subdivision) {
        this.id = id;
        this.address = address;
        this.category = category;
        this.emergencyRoom = emergencyRoom;
        this.name = name;
        this.subdivision = subdivision;
        this.district = getDistrict();
    }

    public String getSqlInsertQuery() {
        String sql = String.format("INSERT INTO `likelion_db`.`seoul_hospital`\n" +
                "(`id`,`address`,`district`,`category`,`emergency_room`,`name`,`subdivision`)\n" +
                "VALUES\n" +
                "(\"%s\",\n" +
                "\"%s\",\n" +
                "\"%s\",\n" +
                "\"%s\",\n" +
                "%d,\n" +
                "\"%s\",\n" +
                "\"%s\");", this.id, this.address, this.district, this.category, this.emergencyRoom,
                this.name, this.subdivision);

        return sql;
    }

    public String getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }


    public String getDistrict() {
        //address를 split하여 두 개 정도 뺄 것.
        String[] splitted = this.address.split(" ");
        return String.format("%s %s", splitted[0], splitted[1]);
    }

    public String getCategory() {
        return category;
    }

    public Integer getEmergencyRoom() {
        return emergencyRoom;
    }

    public String getName() {
        return name;
    }

    public String getSubdivision() {
        return subdivision;
    }
}
