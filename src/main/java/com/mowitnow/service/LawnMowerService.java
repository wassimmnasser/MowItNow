package com.mowitnow.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.mowitnow.model.LawnMower;
import com.mowitnow.model.MowRequest;

/**
 * author : Wassim MNASSER
 */
@Service
public class LawnMowerService {

	public List<String> mowLawnFromFile(String filePath) throws IOException {
		List<LawnMower> mowers = readMowersFromFile(filePath);
		System.out.println("Nombre de tondeuses lues à partir du fichier : " + mowers.size());
		
		for (LawnMower mower : mowers) {
			System.out.println("Tondeuse : x=" + mower.getInitialX() + ", y=" + mower.getInitialY() + ", direction="
					+ mower.getInitialDirection() + ", instructions=" + mower.getInstructions());
		}
		return mowLawn(new MowRequest(5, 5, mowers));
	}

	private List<LawnMower> readMowersFromFile(String filePath) throws IOException {
		List<LawnMower> mowers = new ArrayList<>();
		BufferedReader reader = new BufferedReader(new FileReader(filePath));

		// Lecture des positions initiales des tondeuses et de leurs instructions
		String line;
		while ((line = reader.readLine()) != null) {
			String[] parts = line.split(" ");
			if (parts.length == 4) {
				int initialX = Integer.parseInt(parts[0]);
				int initialY = Integer.parseInt(parts[1]);
				char initialDirection = parts[2].charAt(0);
				String instructions = parts[3];
				LawnMower mower = new LawnMower(null, initialX, initialY, initialDirection, instructions);
				mowers.add(mower);

				// Ajout des logs pour afficher les données extraites
				System.out.println("Tondeuse ajoutée : InitialX=" + initialX + ", InitialY=" + initialY
						+ ", InitialDirection=" + initialDirection + ", Instructions=" + instructions);
			} else {
				System.out.println("Erreur: Format de ligne incorrecte: " + line);
			}
		}

		reader.close();
		return mowers;
	}

	private List<String> mowLawn(MowRequest request) {
		List<String> finalPositions = new ArrayList<>();
		for (LawnMower mower : request.getMowers()) {
			int x = mower.getInitialX();
			int y = mower.getInitialY();
			char direction = mower.getInitialDirection();

			for (char instruction : mower.getInstructions().toCharArray()) {
				switch (instruction) {
				case 'D':
					direction = turnRight(direction);
					break;
				case 'G':
					direction = turnLeft(direction);
					break;
				case 'A':
					int[] newPos = moveForward(x, y, direction);
					x = newPos[0];
					y = newPos[1];
					break;
				}
			}
			finalPositions.add(x + " " + y + " " + direction);
		}
		return finalPositions;
	}

	private char turnRight(char direction) {
		switch (direction) {
		case 'N':
			return 'E';
		case 'E':
			return 'S';
		case 'S':
			return 'W';
		case 'W':
			return 'N';
		default:
			return direction;
		}
	}

	private char turnLeft(char direction) {
		switch (direction) {
		case 'N':
			return 'W';
		case 'E':
			return 'N';
		case 'S':
			return 'E';
		case 'W':
			return 'S';
		default:
			return direction;
		}
	}

	private int[] moveForward(int x, int y, char direction) {
		switch (direction) {
		case 'N':
			y++;
			break;
		case 'E':
			x++;
			break;
		case 'S':
			y--;
			break;
		case 'W':
			x--;
			break;
		}
		return new int[] { x, y };
	}

}
