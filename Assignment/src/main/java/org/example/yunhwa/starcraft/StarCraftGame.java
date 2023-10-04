package org.example.yunhwa.starCraft;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class StarCraftGame {
    static final int RACE_COUNT = 3;
    Race userRace;
    Race computerRace;
    RaceUnitType userRaceUnitTypes;
    RaceUnitType computerRaceUnitTypes;
    List<Unit> userUnitList;
    List<Unit> computerUnitList;
    boolean isUserWin;


    public StarCraftGame() {
        this.userUnitList = new ArrayList<>();
        this.computerUnitList = new ArrayList<>();
        this.isUserWin = false;
    }


    public void runGame() {
        Scanner sc = new Scanner(System.in);
        setUserRace(sc);
        makeUserUnits();
        setComputerRace();
        makeComputerUnits();

        // 게임 시작
        chooseOnesArmyAndEnemyUntilEnd(sc);
        printGameResult();

        sc.close();
    }


    @SuppressWarnings("checkstyle:Indentation")
    public void setUserRace(Scanner sc) {

        System.out.println("User 님, 종족을 고를 차례입니다.");
        System.out.print("-> Terran, Protos, Zerg 중 택 1 해주세요 : ");
        String userRace = sc.nextLine().trim();
        System.out.println();

        if (!(userRace.equals("Terran") || userRace.equals("Protos") || userRace.equals("Zerg"))) {
            throw new IllegalArgumentException("잘못 입력하셨습니다. 입력 형식 보시고 대소문자 구분해서 다시 입력 부탁드립니다!");
        }

        if (userRace.equals("Terran")) {
            this.userRace = Terran.Terran;
            this.userRaceUnitTypes = new TerranUnitTypes();

        } else if (userRace.equals("Protos")) {
            this.userRace = Protos.Protos;
            this.userRaceUnitTypes = new ProtosUnitTypes();

        } else if (userRace.equals("Zerg")) {
            this.userRace = Zerg.Zerg;
            this.userRaceUnitTypes = new ZergUnitTypes();
        }

        String userRaceTypeName = this.userRaceUnitTypes.getClass().getSimpleName();
        String userRaceName = userRaceTypeName.substring(0, userRaceTypeName.length() - 9);
        System.out.println("=============================");
        System.out.println("User 의 종족 : " + userRaceName);
        System.out.println("-----------------------------");
    }

    public void setComputerRace() { // 2. Computer (적군) : race - Terran, Protos, Zerg 중 택 1은 랜덤으로 선택된다
        Random random = new Random();
        int randomIndex;
        do {
            randomIndex = random.nextInt(RACE_COUNT);

            switch (randomIndex) {
                case 0:
                    this.computerRace = Terran.Terran;
                    this.computerRaceUnitTypes = new TerranUnitTypes();
                    break;
                case 1:
                    this.computerRace = Protos.Protos;
                    this.computerRaceUnitTypes = new ProtosUnitTypes();
                    break;
                case 2:
                    this.computerRace = Zerg.Zerg;
                    this.computerRaceUnitTypes = new ZergUnitTypes();
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + randomIndex);
            }
        } while (userRace == computerRace);

        String computerRaceTypeName = this.computerRaceUnitTypes.getClass().getSimpleName();
        String computerRaceName = computerRaceTypeName.substring(0, computerRaceTypeName.length() - 9);
        System.out.println("=============================");
        System.out.println("Computer 의 종족 : " + computerRaceName);
        System.out.println("-----------------------------");
    }


    public void makeUserUnits() {
        this.userUnitList = makeRandomUnits(this.userUnitList, this.userRaceUnitTypes, this.userRaceUnitTypes.getMakeUnitCount());
    }

    public void makeComputerUnits() {
        this.computerUnitList = makeRandomUnits(this.computerUnitList, this.computerRaceUnitTypes, this.computerRaceUnitTypes.getMakeUnitCount());
    }

    // 내부 메서드
    private List<Unit> makeRandomUnits(List<Unit> thisUnitList, RaceUnitType thisRaceUnitTypes, int unitCount) {
        // 1. 모든 유닛들의 클래스를 리스트에 저장 : 인덱스로 각 유닛 클래스 접근 가능
        List<Field> thisUnitTypes = new ArrayList<>();
        for (Field field : thisRaceUnitTypes.getClass().getDeclaredFields()) {
            thisUnitTypes.add(field);
        }

        // 2. 인덱스 랜덤으로 받아 각 유닛 클래스 접근해서 unitCount 개만 생성자로 할당해주기
        Random random = new Random();
        int thisUnitTypeCount = thisRaceUnitTypes.getRaceUnitTypeCount();
        for (int i = 0; i < unitCount; i++) {
            int randomIndex = random.nextInt(thisUnitTypeCount);
            try {
                String thisRaceUnitTypesName = thisRaceUnitTypes.getClass().getSimpleName();
                String thisRaceName = thisRaceUnitTypesName.substring(0, thisRaceUnitTypesName.length() - 9);
                System.out.println(thisRaceName + ".get(" + i + ") : " + thisUnitTypes.get(randomIndex).getType().getSimpleName());

                Class<?> cls = thisUnitTypes.get(randomIndex).getType();
                Constructor<?> constructor = cls.getDeclaredConstructor();
                Unit unit = (Unit) constructor.newInstance();
                thisUnitList.add(unit);

            } catch (InstantiationException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            } catch (NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println();

        return thisUnitList;
    }


    // 적군 또는 아군 유닛들 전체 출력하는 메서드
    public void printAllUnits(String enemyOrFriendly, Race whosRace, List<Unit> unitsList) {
        int raceNameLength = 0;
        if (whosRace == Terran.Terran || whosRace == Protos.Protos) {
            raceNameLength = 6;
        } else if (whosRace == Zerg.Zerg) {
            raceNameLength = 4;
        }
        System.out.printf("%s: %s%n", enemyOrFriendly, whosRace.getClass().getName().substring(29, 29 + raceNameLength));
        System.out.println("-----------------------------");
        for (int i = 0; i < unitsList.size(); i++) {
            if (unitsList.get(i) != null) {
                System.out.printf("%d. ", i);
                unitsList.get(i).printCurrentDefensePower();
            }
        }
        System.out.println();
        System.out.println("=============================");

    }

    // 공격을 수행할 아군 유닛과 공격할 적군 유닛을 선택하세요: 게임 끝까지
    public void chooseOnesArmyAndEnemyUntilEnd(Scanner sc) {
        boolean isUserWin = false;
        boolean isUserEnd = false;
        boolean isComputerEnd = false;

        while (true) {
            // 한 번 돌기 전 적군 아군 출력해서 현황 확인
            System.out.println("=============================");
            printAllUnits("적군", this.computerRace, this.computerUnitList);
            printAllUnits("아군", this.userRace, this.userUnitList);

            // 유저 Turn
            System.out.printf("User 차례! 공격을 수행할 아군 유닛과 공격할 적군 유닛을 선택하세요: %n"); // 0 3

            int attackUnitIndex = sc.nextInt(); // 유저 입장에서는 유저 유닛
            int attackedUnitIndex = Integer.parseInt(sc.nextLine().trim()); // 유저 입장에서는 컴퓨터 유닛

            int currentDefensePower = this.computerUnitList.get(attackedUnitIndex).getDefensePower();
            this.computerUnitList.get(attackedUnitIndex).setDefensePower(currentDefensePower - this.userUnitList.get(attackUnitIndex).getAttackPower());
            String attackedUnitName = this.computerUnitList.get(attackedUnitIndex).getClass().getSimpleName();
            System.out.println("User 의 공격으로 Computer 의 " + attackedUnitIndex + " 번 유닛 " + attackedUnitName + " 의 방어력이 " + currentDefensePower + " 에서 " + this.computerUnitList.get(attackedUnitIndex).getDefensePower() + " 로 줄었습니다.");

            if (this.computerUnitList.get(attackedUnitIndex).getDefensePower() <= 0) {
                this.computerUnitList.set(attackedUnitIndex, null);
                System.out.println("Computer 의 " + attackedUnitIndex + " 번 유닛" + attackedUnitName + " 이 소멸되었습니다.");
            }

            // 적군의 모든 유닛이 파괴되었다면 유저 승리
            if (Collections.frequency(this.computerUnitList, null) == this.computerUnitList.size()) {
                isComputerEnd = true;
                isUserWin = true;
                break;
            }

            System.out.println();

            // 컴퓨터 Turn
            Random random = new Random();
            do {
                attackUnitIndex = random.nextInt(this.computerUnitList.size()); // 컴퓨터 입장에서는 컴퓨터 유닛
                attackedUnitIndex = random.nextInt(this.userUnitList.size()); // 컴퓨터 입장에서는 유저 유닛

            } while (this.computerUnitList.get(attackUnitIndex) == null || this.userUnitList.get(attackedUnitIndex) == null);

            System.out.printf("컴퓨터 차례! 공격을 수행할 아군 유닛과 공격할 적군 유닛을 선택한 결과: %d %d %n", attackUnitIndex, attackedUnitIndex); // 0 3

            currentDefensePower = this.userUnitList.get(attackedUnitIndex).getDefensePower();
            this.userUnitList.get(attackedUnitIndex).setDefensePower(currentDefensePower - this.computerUnitList.get(attackUnitIndex).getAttackPower());
            attackedUnitName = this.userUnitList.get(attackedUnitIndex).getClass().getSimpleName();
            System.out.println("Computer 의 공격으로 User 의 " + attackedUnitIndex + " 번 유닛 " + attackedUnitName + " 의 방어력이 " + currentDefensePower + " 에서 " + this.userUnitList.get(attackedUnitIndex).getDefensePower() + " 로 줄었습니다.");


            if (this.userUnitList.get(attackedUnitIndex).getDefensePower() <= 0) {
                this.userUnitList.set(attackedUnitIndex, null);
                System.out.println("User 의 " + attackedUnitIndex + " 번 유닛 " + attackedUnitName + " 이 소멸되었습니다.");
            }

            // 아군의 모든 유닛이 파괴되었다면 컴퓨터 승리
            if (Collections.frequency(this.userUnitList, null) == this.userUnitList.size()) {
                isUserEnd = true;
                break;
            }

            System.out.println();

        }

        if (isComputerEnd && !isUserEnd && isUserWin) {
            // 유저 승리
            this.isUserWin = true;
        }
        if (isUserEnd && !isComputerEnd && !isUserWin) {
            // 컴퓨터 승리
            this.isUserWin = false;
        }

    }

    public void printGameResult() {
        if (this.isUserWin) {
            System.out.println("\n====== 승리했습니다!! ======");
        } else {
            System.out.println("\n====== 패배했습니다... 다음 기회에...! ======");
        }
    }


}
