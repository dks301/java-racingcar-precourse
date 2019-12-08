/*
 * RacingCarMain.java              1.0.0   2019-12-08
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
 * 자동차 경주를 진행하는 메인 클래스입니다.
 *
 * @version 1.0.0            Race 클래스에 있던 메소드들을 여기로 옮김
 * @date 2019-12-08
 * @author HyungjuAn
 */
public class RacingCarMain {
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

	public static void main(String[] args) throws IOException {

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

	public int getRaceCount() throws IOException {
		int raceCount;

		printRaceCountQuestion();
		raceCount = readRaceCount();

		return raceCount;
	}

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

	@Override
	public String toString() {
		return super.toString();
	}
}
