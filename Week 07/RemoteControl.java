interface Switchable{
        void on();
        void off();
        default void toggle()
        {
            on();
        }
    }

class fan implements Switchable{
        public void on()
        {
            System.out.println("Fan is on.");
        }
        public void off()
        {
            System.out.println("Fan is off");
        }
}

class Light implements Switchable{
    public void on(){
        System.out.println("Light is on.");
    }
    public void off(){
        System.out.println("Light is off.");
    }
}

@FunctionalInterface 
interface permission
{
   boolean MyChoice(string device,int hours);
}

class RemoteControl{
    public static void main(String[] args)
    {
        Switchable[] devices = {new fan(), new Light()};
    for (Switchable device : devices)
    {
        device.toggle();
    }
    permission p1=new permission() {
        boolean MyChoice(string device,int hours){
            return hour>6;
        }
    };
}
}