package com.mini.model.db.dic;

public class DIC_REPOSITORY {
    private int repository_type;
    private String repository_type_name;
    private int freeuse1;
    private String freeuse2;

    public int getRepository_type() {
        return repository_type;
    }

    public void setRepository_type(int repository_type) {
        this.repository_type = repository_type;
    }

    public String getRepository_type_name() {
        return repository_type_name;
    }

    public void setRepository_type_name(String repository_type_name) {
        this.repository_type_name = repository_type_name;
    }

    public int getFreeuse1() {
        return freeuse1;
    }

    public void setFreeuse1(int freeuse1) {
        this.freeuse1 = freeuse1;
    }

    public String getFreeuse2() {
        return freeuse2;
    }

    public void setFreeuse2(String freeuse2) {
        this.freeuse2 = freeuse2;
    }
}
