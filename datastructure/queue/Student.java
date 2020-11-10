package datastructure.queue;

public class Student {
	
	private String name;
	private int rollno;
	private String address;
	
	Student(String name, int rollno, String address){
		this.name=name;
		this.rollno=rollno;
		this.address=address;
	}
	
	

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public int getRollno() {
		return rollno;
	}

	public void setRollno(int rollno) {
		this.rollno = rollno;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	@Override
    public String toString() {
        return "Employee{" +
                "firstName='" + name + '\'' +
                ", rollno='" + rollno + '\'' +
                ", address=" + address +
                '}';
    }

	public static void main(String[] args) {
		Student stud1=new Student("name1", 111, "city1");
		Student stud2=new Student("name2", 222, "city2");
		Student stud3=new Student("name3", 333, "city3");
		Student stud4=new Student("name4", 444, "city4");
		Student stud5=new Student("name5", 555, "city5");
		
		CircularQueue queue=new CircularQueue(5);
		//ArrayQueue queue=new ArrayQueue(5);
		queue.add(stud1);
		queue.add(stud2);
		queue.add(stud3);
		queue.add(stud4);
		//queue.add(stud5);
		
		queue.printQueue();
		
		queue.pop();
		queue.pop();
		
		//queue.printQueue();
		System.out.println("front: "+ queue.front + "back: "+queue.back);
		
		Student stud6=new Student("name6", 666, "city6");
		Student stud7=new Student("name7", 777, "city7");
		
		queue.add(stud6);
		queue.add(stud7);
		
		System.out.println("front: "+ queue.front + "back: "+queue.back);
		
		queue.printQueue();
		
		
		

	}

}
