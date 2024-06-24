package my.dsm.nested_doc;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(value = "building")
public class Building {
    @Id
    public String id;

    @Field(value = "buildingId")
    public Integer buildingId;

    @Field(value = "location")
    public Location location;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Integer buildingId) {
        this.buildingId = buildingId;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }


    public Building(Integer buildingId, Location location) {
        this.buildingId = buildingId;
        this.location = location;
    }

    public Building(Integer buildingId) {
        this.buildingId = buildingId;
    }

}