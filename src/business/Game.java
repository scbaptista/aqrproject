/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

/**
 *
 * @author alexandre
 */
public class Game {
    private int id;
    private String houseTeam;
    private String guestTeam;
    private float oddVictory;
    private float oddDraw;
    private float oddDefeat;
    private String date;
    private String timeBegin;
    private boolean status;
    private int goalsHT;
    private int goalsGT;
    private boolean ended;

    public Game(int id, String houseTeam, String guestTeam, float oddVictory, float oddDraw, float oddDefeat, String date, String timeBegin, boolean status, int goalsHT, int goalsGT, boolean ended) {
        this.id = id;
        this.houseTeam = houseTeam;
        this.guestTeam = guestTeam;
        this.oddVictory = oddVictory;
        this.oddDraw = oddDraw;
        this.oddDefeat = oddDefeat;
        this.date = date;
        this.timeBegin = timeBegin;
        this.status = status;
        this.goalsHT = goalsHT;
        this.goalsGT = goalsGT;
        this.ended = ended;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHouseTeam() {
        return houseTeam;
    }

    public void setHouseTeam(String houseTeam) {
        this.houseTeam = houseTeam;
    }

    public String getGuestTeam() {
        return guestTeam;
    }

    public void setGuestTeam(String guestTeam) {
        this.guestTeam = guestTeam;
    }

    public float getOddVictory() {
        return oddVictory;
    }

    public void setOddVictory(float oddVictory) {
        this.oddVictory = oddVictory;
    }

    public float getOddDraw() {
        return oddDraw;
    }

    public void setOddDraw(float oddDraw) {
        this.oddDraw = oddDraw;
    }

    public float getOddDefeat() {
        return oddDefeat;
    }

    public void setOddDefeat(float oddDefeat) {
        this.oddDefeat = oddDefeat;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTimeBegin() {
        return timeBegin;
    }

    public void setTimeBegin(String timeBegin) {
        this.timeBegin = timeBegin;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getGoalsHT() {
        return goalsHT;
    }

    public void setGoalsHT(int goalsHT) {
        this.goalsHT = goalsHT;
    }

    public int getGoalsGT() {
        return goalsGT;
    }

    public void setGoalsGT(int goalsGT) {
        this.goalsGT = goalsGT;
    }

    public boolean isEnded() {
        return ended;
    }

    public void setEnded(boolean ended) {
        this.ended = ended;
    }
    
    
}
