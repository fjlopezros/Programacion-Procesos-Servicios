package trimestre1.repaso.hilosRepaso;

class Prioridad extends Thread {

    String name;

    public Prioridad(String name) {
        super();
        this.name = name;
    }
    public void run() {
        int count = 0;
        while (count <= 100) {
            try {
                sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name+":" + count++);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Prioridad thread1 = new Prioridad("thread1");
        thread1.setPriority(10);
        Prioridad thread2 = new Prioridad("thread2");
        thread2.setPriority(1);

        if(thread1.getPriority() > thread2.getPriority()){
            thread1.start();
            sleep(1000);
            thread2.start();
        }else{
            thread2.start();
            sleep(1000);
            thread1.start();
        }
    }
}