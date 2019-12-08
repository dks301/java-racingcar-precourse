/*
 * User.java                      1.12.3   2019-12-08
 *
 * Copyright (c) 2019 Hyungju An.
 * All rights reserved.
 * Contact me for more information. a301dks@naver.com
 */

package com.precourse.racingcar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Race 클래스입니다.
 * 레이스의 정보를 입력받는 기능들이 있습니다.
 * 입력이 올바르지 않은 경우 예외처리를 하는 기능이 있습니다.
 *
 * @version 1.12.3            toString 메소드를 경주를 표현할수 있도록 수정
 * @date 2019-12-08
 * @author HyungjuAn
 */
public class Race {
	private static final int MINIMUM_LENGTH_CAR_NAME = 1;
	private static final int MAXIMUM_LENGTH_CAR_NAME = 5;
	private static final int MINIMUM_CARS = 2;
	private static final int MINIMUM_RACE = 1;
	private static final int SPLIT_LIMIT = -1;
	private static final String COMMA = ",";
	private static final String CAR_NAME_QUESTION = "경주할 자동차 이름을 입력하세요.\n"
		+ "(이름은 쉼표(,)를 기준으로 구분하며, 5자 이하만 가능합니다.)";
	private static final String INVALID_INPUT_PRINTING = "잘못 입력하셧습니다.";
	private static final String RACE_COUNT_QUESTION = "시도할 횟수는 몇회인가요?";

	private ArrayList<Car> carArrayList;
	private int raceCount;

	public Race() {
		carArrayList = new ArrayList<>();
		raceCount = MINIMUM_RACE;
	}

	public ArrayList<Car> getCarsInformation() throws IOException {
		ArrayList<Car> carList = new ArrayList<>();

		printCarNamesQuestion();
		readCarNames(carList);

		return carList;
	}

	private void printCarNamesQuestion() {
		System.out.println(CAR_NAME_QUESTION);
	}

	private void readCarNames(ArrayList<Car> carList) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String input = reader.readLine();

		if (!isRightCarNames(input)) {
			printInvalidInput();
			readCarNames(carList);
			return;
		}

		StringTokenizer tokenizer = new StringTokenizer(input, COMMA);
		while (tokenizer.hasMoreTokens()) {
			carList.add(new Car(tokenizer.nextToken()));
		}
	}

	private boolean isRightCarNames(String input) {
		boolean result = true;
		String[] carNames = input.split(COMMA, SPLIT_LIMIT);

		for (int i = 0; i < carNames.length; i++) {
			if (!isRightLengthName(carNames[i])) {
				result = false;
				break;
			}
		}
		if (!isRightNumberCars(carNames.length)) {
			result = false;
		}

		return result;
	}

	private boolean isRightLengthName(String carName) {
		boolean result = false;

		if ((carName.length() >= MINIMUM_LENGTH_CAR_NAME) && (carName.length() <= MAXIMUM_LENGTH_CAR_NAME)) {
			result = true;
		}

		return result;
	}

	private boolean isRightNumberCars(int carCount) {
		boolean result = true;

		if (carCount < MINIMUM_CARS) {
			result = false;
		}

		return result;
	}

	private void printInvalidInput() {
		System.out.println(INVALID_INPUT_PRINTING);
	}

	// public int getRaceCount() throws IOException {
	// 	int raceCount;
	//
	// 	printRaceCountQuestion();
	// 	raceCount = readRaceCount();
	//
	// 	return raceCount;
	// }

	private void printRaceCountQuestion() {
		System.out.println(RACE_COUNT_QUESTION);
	}

	private int readRaceCount() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String input = reader.readLine();

		if (!isInteger(input) || !isNaturalNumber(input)) {
			printInvalidInput();
			readRaceCount();
		}

		return Integer.parseInt(input);
	}

	private boolean isInteger(String input) {
		boolean result = true;

		try {
			Integer.parseInt(input);
		} catch (NumberFormatException e) {
			result = false;
		}

		return result;
	}

	private boolean isNaturalNumber(String input) {
		boolean result = true;

		if (Integer.parseInt(input) < MINIMUM_RACE) {
			result = false;
		}

		return result;
	}

	@Override
	protected final void finalize() throws Throwable {
	}

	/**
	 * 이 경주의 자동차 리스트와 레이스 횟수를 알려줍니다.
	 * 다음은 이 설명의 일반적인 형태이나,
	 * 상세 형식은 정해지지 않았으며 향후 변경될 수 있다.
	 * <p>
	 * "[pobi, hj]로 3회 경주."
	 *
	 * @return 클래스를 나타낼 수 있는 정보를 가진 문자열
	 */
	@Override
	public String toString() {
		return carArrayList.toString() + "로 " + raceCount + "회 경주";
	}

	/* Getter Methods */
	public ArrayList<Car> getCarArrayList() {
		return carArrayList;
	}

	public int getRaceCount() {
		return raceCount;
	}

	/* Setter Methods */
	public void setCarArrayList(ArrayList<Car> carArrayList) {
		this.carArrayList = carArrayList;
	}

	public void setRaceCount(int raceCount) {
		this.raceCount = raceCount;
	}
}
