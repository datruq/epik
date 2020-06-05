package com.epik.user_ev.domains;

import com.sun.istack.NotNull;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
public class Ev {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Enumerated
    private MODEL model;

    @NotNull
    @Enumerated
    private BATTERY_CAPACITY batteryCapacity;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "ev")
    private Set<User> users;

    public void setModel(MODEL model) {
        this.model = model;
    }

    public void setBatteryCapacity(BATTERY_CAPACITY batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Long getId() {
        return id;
    }

    public MODEL getModel() {
        return model;
    }

    public BATTERY_CAPACITY getBatteryCapacity() {
        return batteryCapacity;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public enum MODEL {
        BUS(0),
        CAR(1),
        SCOOTER(2);

        private final int value;

        MODEL(int value) {
            this.value = value;
        }

        public static MODEL fromValue(int value) {
            switch (value) {
                case 0:
                    return BUS;
                case 1:
                    return CAR;
                case 2:
                    return SCOOTER;
                default:
                    return SCOOTER;
            }
        }
    }

    public enum BATTERY_CAPACITY {
        THIRTY_KWH(0),
        SEVENTY_KWH(1),
        TEN_KWH(2);

        private final int value;

        BATTERY_CAPACITY(int value) {
            this.value = value;
        }

        public static BATTERY_CAPACITY fromValue(int value) {
            switch (value) {
                case 0:
                    return THIRTY_KWH;
                case 1:
                    return SEVENTY_KWH;
                case 2:
                    return TEN_KWH;
                default:
                    return THIRTY_KWH;
            }
        }
    }

}
