package workshop.pserson.controle;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import workshop.pserson.entity.PersonEntity;

public class PersonManager {
	/**
	 * javaPersonManage  
	 */
    public static void main(String[] args) {
    	if(args.length<1) {
    		System.out.println("성별 값을 입력하세요");
    		System.exit(0);
    	}

    	char gender = args[0].charAt(0);
    	System.out.println(gender);
    	
    	PersonManager pm = new PersonManager();

    	List<PersonEntity> persons = new ArrayList<>();
    	pm.fillPerson(persons);
    	pm.printTitleLine();
		pm.showPerson(persons);
    	pm.printTitleLine();
		pm.findByGender(persons, gender);
    	pm.printTitleLine();
    	Scanner scan = new Scanner(System.in);
    	System.out.print("성별을 입력하세요... ");
		pm.findByGender(persons, scan.next().charAt(0));
    	pm.printTitleLine();
		pm.showPerson(persons, "김하늘");
    	pm.printTitleLine();
		pm.showPerson(persons, "바비킴");
    }
	

	public PersonManager() {}
	
	public void fillPerson(List<PersonEntity> persons){
    	PersonEntity[] personEntityArray = {
    		new PersonEntity("이성호","7212121028102", "인천 계양구", "032-392-2932"),
    		new PersonEntity("김하늘","7302132363217", "서울 강동구", "02-362-1932"),
    		new PersonEntity("박영수","7503111233201", "서울 성북구", "02-887-1542"),
    		new PersonEntity("나인수","7312041038988", "대전 유성구", "032-384-2223"),
    		new PersonEntity("홍정수","7606221021341", "서울 양천구", "02-158-7333"),
    		new PersonEntity("이미숙","7502142021321", "서울 강서구", "02-323-1934"),
    		new PersonEntity("박성구","7402061023101", "서울 종로구", "02-308-0932"),
    		new PersonEntity("유성미","7103282025101", "서울 은평구", "02-452-0939"),
    		new PersonEntity("황재현","7806231031101", "인천 중구", "032-327-2202"),
    		new PersonEntity("최철수","7601211025101", "인천 계양구", "032-122-7832")
    	};
    	
		for(PersonEntity personEntity : personEntityArray) {
			persons.add(personEntity);
		}
	}
	
	public void showPerson(List<PersonEntity> persons) {
		this.printItemLine();
		persons.forEach(person -> {
			System.out.println(person.toString());
			this.printItemLine();
		});
	}
	
	public void findByGender(List<PersonEntity> persons, char gender) {
		int count = 0;
		for(PersonEntity person : persons) {
			count = person.getGender() == gender ? count+1 : count;
		}
		System.out.println("성별 : '"+gender+"'(은)는 "+count+"명 입니다.");
	}
	
	public void showPerson(List<PersonEntity> persons, String name) {
		for(PersonEntity person : persons) {
			if(name.equals(person.getName())) {
				System.out.println("'"+name+"' 으로 검색된 결과입니다.");
				this.printItemLine();
				System.out.println("[이름] " + person.getName());
				System.out.println("[성별] " + person.getGender());
				System.out.println("[전화번호] " + person.getPhone());
				System.out.println("[주소] " + person.getAddress());
				return;
			}
		}
		System.out.println("'"+name+"' 으로 검색된 결과가 없습니다.");
	}
	
	public void printTitleLine() {
		for(int i = 0 ; i < 60 ; i++) {
			System.out.print('=');
		}
		System.out.println();
	}

	public void printItemLine() {
		for(int i = 0 ; i < 60 ; i++) {
			System.out.print('-');
		}
		System.out.println();
	}
}
