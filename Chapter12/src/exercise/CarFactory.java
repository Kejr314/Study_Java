package exercise;

import java.util.HashMap;

public class CarFactory {
	
	private static CarFactory instance = new CarFactory(); // 유일한 인스턴스
	// 자동차 객체를 관리할 맵
	// key : 자동차 이름(String), value : 해당 이름의 자동차 객체(Car)
	HashMap<String, Car> carMap = new HashMap<>(); // 자동차 객체를 관리할 맵
	
	// private 생성자 : 외부에서 직접 인스턴스 생성 불가
	private CarFactory() {}
	
	// 싱글톤 인스턴스 반환 메서드
	public static CarFactory getInstance() {
		if (instance == null)
			instance = new CarFactory();
		return instance;
	}
	
	public Car createCar(String name) {
		if(carMap.containsKey(name) ) {
			return carMap.get(name); // 이미 생성된 자동차 객체 반환
		}
		Car car = new Car(); // 새로운 자동차 객체 생성
		carMap.put(name, car); // 맵에 추가
		return car;
	}
	
}
