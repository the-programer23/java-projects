package com.fabianpinzon;

public class Challenge9 {
    public static void main(String[] args) {
        Professor professor = new Professor();
        final Pupil pupil = new Pupil(professor);
        professor.setStudent(pupil);

        Thread professorThread = new Thread(professor::studyTime);
        Thread pupilThread = new Thread(pupil::handInAssignment);

        professorThread.start();
        pupilThread.start();
    }
}

class Professor{
    private Pupil pupil;


    public void setStudent(Pupil pupil){
        this.pupil = pupil;
    }

    public void studyTime(){
        synchronized(this){
            System.out.println("Tutor has arrived");

            try{
                //wait for pupil to arrive
                System.out.println("waiting...");
                //When wait is executed it releases the tutor lock
                this.wait();
            }catch (InterruptedException e){}
            synchronized(pupil){
                pupil.startStudy();
                System.out.println("Professor is studying with pupil");
            }
        }
    }

    public void getProgressReport(){
        System.out.println("Professor gave progress report");
    }

}

class Pupil {
    private Professor professor;

    public Pupil(Professor professor) {
        this.professor = professor;
    }

    public void startStudy(){
        System.out.println("Pupil is studying");
    }

    public void handInAssignment(){
        synchronized(professor){
            professor.getProgressReport();
            synchronized (this){
                System.out.println("Pupil handed in assignment");
                professor.notifyAll();
            }
        }
    }
}
