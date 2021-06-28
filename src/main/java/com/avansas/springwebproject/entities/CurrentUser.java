package com.avansas.springwebproject.entities;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class CurrentUser {
    public XUser xUser;

    public XUser getxUser() {
        return xUser;
    }
    public void setxUser(XUser xUser) {
        this.xUser = xUser;
    }
}
