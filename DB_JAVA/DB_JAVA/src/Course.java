/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
public class Course {
    private String id;
    private String name;
    private String duration;
    private String seats;
    private String qualification;
    
    
    Course(String id,
    String name,
    String duration,
    String seats,
    String qualification){
        this.id=id;
        this.name=name;
        this.duration=duration;
        this.seats=seats;
        this.qualification=qualification;
        
        
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the duration
     */
    public String getDuration() {
        return duration;
    }

    /**
     * @param duration the duration to set
     */
    public void setDuration(String duration) {
        this.duration = duration;
    }

    /**
     * @return the seats
     */
    public String getSeats() {
        return seats;
    }

    /**
     * @param seats the seats to set
     */
    public void setSeats(String seats) {
        this.seats = seats;
    }

    /**
     * @return the qualification
     */
    public String getQualification() {
        return qualification;
    }

    /**
     * @param qualification the qualification to set
     */
    public void setQualification(String qualification) {
        this.qualification = qualification;
    }
    
}
