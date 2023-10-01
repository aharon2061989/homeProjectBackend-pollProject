package com.PollSystem.userProject;

public class UserProjectResponse {
    private Long id;
    private boolean registered;

    public UserProjectResponse() {}

    public UserProjectResponse(Long id, boolean registered) {
        this.id = id;
        this.registered = registered;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isRegistered() {
        return registered;
    }

    public void setRegistered(boolean registered) {
        this.registered = registered;
    }
}
