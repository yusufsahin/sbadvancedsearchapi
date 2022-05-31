package com.example.demo.enumerate;

public enum ProjectStatus {
    Initation(1), Planning(2), Execution(3), Monitor(4), Closed(5);

    private final int id;

    ProjectStatus(int id){
        this.id = id;
    }

    public static ProjectStatus getStatus(Integer id){
        if (id == null) {
            return null;

        }

        for(ProjectStatus projectStatus : ProjectStatus.values()){
            if (id.equals(projectStatus.getID())){
                return projectStatus;
            }
        }
        return null;
    }

    public int getID() {
        return id;
    }

}

