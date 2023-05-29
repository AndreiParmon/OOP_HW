package lesson7.observer;

import java.util.Random;

public enum JobType {
    SENIOR("Старший специалист"), JUNIOR("Младший специалист"), STUDENT("Студент");
    private String type;

    public String getJobType() {
        return type;
    }

    JobType(String type) {
        this.type = type;
    }

    private static final Random random = new Random();

    public static JobType randomJobType(){
        JobType[] jobTypes = values();
        return jobTypes[random.nextInt(jobTypes.length)];
    }
}
