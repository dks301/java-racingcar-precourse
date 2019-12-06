/*
 * User.java                       1.7.0   2019-12-06
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
 * User 클래스입니다.
 * 사용자에 대한 입력과 출력을 하는 기능들이 있습니다.
 * 입력이 올바르지 않은 경우 예외처리를 하는 기능이 있습니다.
 *
 * @version 1.7.0            사용자가 입력한 레이스 횟수를 반환하는 기능 추가
 * @date 2019-12-06
 * @author HyungjuAn
 */
public class User {
	private static final int MINIMUM_LENGTH_CAR_NAME = 1;
	private static final int MAXIMUM_LENGTH_CAR_NAME = 5;
	private static final int MINIMUM_CARS = 2;
	private static final int SPLIT_LIMIT = -1;
	private static final String COMMA = ",";
	private static final String CAR_NAME_QUESTION = "경주할 자동차 이름을 입력하세요.\n"
		+ "(이름은 쉼표(,)를 기준으로 구분하며, 5자 이하만 가능합니다.)";

	public User() {
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

	public int getRaceCount() throws IOException {
		int raceCount = 0; // 임시

		// 사용자에게 시도할 횟수를 물어보는 기능
		// 사용자가 횟수를 입력하는 기능

		return raceCount;
	}

	@Override
	protected final void finalize() throws Throwable {
	}

	@Override
	public String toString() {
		return super.toString();
	}
}
